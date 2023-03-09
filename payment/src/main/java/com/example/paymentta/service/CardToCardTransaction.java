package com.example.paymentta.service;

import com.example.paymentta.dto.BaseTransactionDto;
import com.example.paymentta.dto.CardDto;
import com.example.paymentta.entity.Customer;
import com.example.paymentta.entity.Transaction;
import com.example.paymentta.exceptions.ServiceException;
import com.example.paymentta.repository.TransactionRepository;
import com.example.paymentta.service.notifications.NotificationSender;
import com.example.paymentta.service.notifications.NotificationText;
import com.example.paymentta.service.notifications.NotificationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service

public class CardToCardTransaction implements BaseTransaction<CardDto> {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private NotificationSender notificationSender;

    @Transactional(rollbackFor = ServiceException.class)
    public void resolveTransaction(CardDto d) throws ServiceException {

        Customer sender = customerService.withdraw(d.getSendCardNumber(), d.getAmount());

        if (sender == null) {
            throw new ServiceException(" your balance is not enough");
        }

        Customer receiver = customerService.deposit(d.getReceiverCardNumber(), d.getAmount());

        if (receiver == null) {
            throw new ServiceException("receiver card number is not valid ");
        }
        Transaction trxEntity= new Transaction();
        trxEntity.setReceiver(receiver);
        trxEntity.setSender(sender);
        trxEntity.setDate(new Date());
        trxEntity.setAmount(d.getAmount());

        transactionRepository.save(trxEntity);

        notificationSender.send(NotificationType.EMAIL, new NotificationText("kasr ", sender.getCardNumber(), d.getAmount(), trxEntity.getDate()));
        notificationSender.send(NotificationType.SMS, new NotificationText("plus", receiver.getCardNumber(), d.getAmount(), trxEntity.getDate()));
    }

    public void getTransactions(String carNumber, String cardNumber2, Date start, Date end) {


//        List<Transaction> transactions = transactionRepository.findBySenderCardNumberOrRecieverCardNumberAndDateBetween(carNumber, cardNumber2, start, end);

//        System.out.println(transactions);
    }
}
