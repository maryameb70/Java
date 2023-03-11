package ir.mapsa.maryamebrahimzadepayment.services;

import ir.mapsa.maryamebrahimzadepayment.dto.TransferDto;
import ir.mapsa.maryamebrahimzadepayment.exceptions.ServiceException;
import ir.mapsa.maryamebrahimzadepayment.models.Customer;
import ir.mapsa.maryamebrahimzadepayment.models.Transaction;
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

    @Transactional(rollbackFor = ServiceException.class)
    @Override
    public void transfer(TransferDto dto) throws ServiceException {
        Customer sender = customerService.withdraw(dto.getSource(), dto.getAmount());
        if (sender == null) {
            throw new ServiceException("your_balance_is_not_enough");
        }
        Customer receiver = customerService.deposit(dto.getDestination(), dto.getAmount());
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
    public Boolean resolve(TransferDto dto) {
        return !dto.getDestination().startsWith("IR") && dto.getSource().startsWith("5859");
    }
}
