package ir.mapsa.maryamebrahimzadepayment.services;

import ir.mapsa.maryamebrahimzadepayment.converters.TransactionConverter;
import ir.mapsa.maryamebrahimzadepayment.dto.TransactionDto;
import ir.mapsa.maryamebrahimzadepayment.exceptions.ServiceException;
import ir.mapsa.maryamebrahimzadepayment.models.Customer;
import ir.mapsa.maryamebrahimzadepayment.models.Transaction;
import ir.mapsa.maryamebrahimzadepayment.models.TransactionType;
import ir.mapsa.maryamebrahimzadepayment.repositories.TransactionRepository;
import ir.mapsa.maryamebrahimzadepayment.services.notifications.NotificationSender;
import ir.mapsa.maryamebrahimzadepayment.services.notifications.NotificationText;
import ir.mapsa.maryamebrahimzadepayment.services.notifications.NotificationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class AccountNumberTransfer implements BaseTransfer {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private NotificationSender notificationSender;

    @Transactional(rollbackFor = ServiceException.class)
    @Override
    public void transfer(TransactionDto dto) throws ServiceException {
        Customer sender = customerService.withdraw(customerService.convertCard(dto.getSource()), dto.getAmount());
        if (sender == null) {
            throw new ServiceException("your_balance_is_not_enough");
        }

        Customer receiver = customerService.deposit(customerService.convertCard(dto.getDestination()), dto.getAmount());
        if (receiver == null) {
            throw new ServiceException("receiver_is_not_valid");
        }
        Transaction trxEntity = new Transaction();
        trxEntity.setReceiver(receiver);
        trxEntity.setSender(sender);
        trxEntity.setDate(new Date());
        trxEntity.setAmount(dto.getAmount());
        transactionRepository.save(trxEntity);

        notificationSender.send(NotificationType.EMAIL, new NotificationText("kasr ", sender.getCardNumber(), dto.getAmount(), trxEntity.getDate()));
        notificationSender.send(NotificationType.SMS, new NotificationText("plus", receiver.getCardNumber(), dto.getAmount(), trxEntity.getDate()));

    }

    @Override
    public Boolean resolve(TransactionDto dto) {
        // you can use type in your transaction dto and based on that decide to resolve the transaction:
        //return dto.getType.equals("account");
        Customer cReceiver=customerService.convertCard(dto.getDestination());
        Customer cSender=customerService.convertCard(dto.getSource());
        return !cReceiver.getCardNumber().startsWith("IR") && !cSender.getCardNumber().startsWith("5859");
    }

    @Override
    public TransactionType getType() {
        return TransactionType.ACCOUNTNUMBER;
    }
}
