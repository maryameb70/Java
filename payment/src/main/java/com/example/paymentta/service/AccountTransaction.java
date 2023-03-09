package com.example.paymentta.service;

import com.example.paymentta.dto.AccountDto;
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

public class AccountTransaction implements BaseTransaction<AccountDto>{
    @Autowired
    private CustomerService customerService;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private NotificationSender notificationSender;

    @Transactional(rollbackFor = ServiceException.class)
    public void resolveTransaction(AccountDto dto) throws ServiceException {

        Customer sender = customerService.withdraw(dto.getSendAccountNumber(), dto.getAmount());

        if (sender == null) {
            throw new ServiceException(" your balance is not enough");
        }

        Customer receiver = customerService.deposit(dto.getReceiverAccountNumber(), dto.getAmount());

        if (receiver == null) {
            throw new ServiceException("receiver card number is not valid ");
        }
        Transaction trxEntity= new Transaction();
        trxEntity.setReceiver(receiver);
        trxEntity.setSender(sender);
        trxEntity.setDate(new Date());
        trxEntity.setAmount(dto.getAmount());

        transactionRepository.save(trxEntity);

        notificationSender.send(NotificationType.EMAIL, new NotificationText("kasr ", sender.getCardNumber(), dto.getAmount(), trxEntity.getDate()));
        notificationSender.send(NotificationType.SMS, new NotificationText("plus", receiver.getCardNumber(), dto.getAmount(), trxEntity.getDate()));



    }



    public void getTransactions(String carNumber, String cardNumber2, Date start, Date end) {


//        List<Transaction> transactions = transactionRepository.findBySenderCardNumberOrRecieverCardNumberAndDateBetween(carNumber, cardNumber2, start, end);

//        System.out.println(transactions);
    }
}
