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
public class C2cTransfer implements BaseTransfer {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private NotificationSender notificationSender;
    @Autowired
    private TransactionConverter transactionConverter;

    @Transactional(rollbackFor = ServiceException.class)
    @Override
    public void transfer(TransactionDto dto) throws ServiceException {
        Customer sender = customerService.withdraw(transactionConverter.convertCard(dto.getSource()), dto.getAmount());
        if (sender == null) {
            throw new ServiceException("your_balance_is_not_enough");
        }
        Customer receiver = customerService.deposit(transactionConverter.convertCard(dto.getDestination()), dto.getAmount());
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
        Customer cReceiver=transactionConverter.convertCard(dto.getDestination());
        Customer cSender=transactionConverter.convertCard(dto.getSource());
        return !cReceiver.getCardNumber().startsWith("IR") && cSender.getCardNumber().startsWith("5859");
    }

    public TransactionType getType(){
        return TransactionType.CARDTOCARD;
    }
}
