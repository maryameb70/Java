package ir.mapsa.maryamebrahimzadepayment.services;

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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional(readOnly = true)
public class AccountTransactionService extends CommonBaseTransaction {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private NotificationSender notificationSender;
    @Autowired
    private TransactionRepository repository;

    @Transactional
    public void transfer(TransactionDto dto) throws ServiceException {
        Customer cSender = customerService.findByAccountNumber(dto.getSource());
        if (cSender == null) {
            throw new ServiceException("sender_is_not_valid");
        }
        Customer cReceiver = customerService.findByAccountNumber(dto.getDestination());
        if (cReceiver == null) {
            throw new ServiceException("receiver_is_not_valid");
        }
        resolveTransaction(cSender, cReceiver, dto.getAmount());

        Transaction trxEntity = saveTransaction(dto, cSender, cReceiver);

        notificationSender.send(NotificationType.EMAIL, new NotificationText("kasr ", cSender.getCardNumber(), dto.getAmount(), trxEntity.getDate()));
        notificationSender.send(NotificationType.SMS, new NotificationText("plus", cReceiver.getCardNumber(), dto.getAmount(), trxEntity.getDate()));
    }


    public Boolean resolve(TransactionDto dto) {
        return dto.getType().equals(TransactionType.ACCOUNTNUMBER);
    }
}
