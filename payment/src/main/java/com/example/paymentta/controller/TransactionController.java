package com.example.paymentta.controller;

import com.example.paymentta.dto.AccountDto;
import com.example.paymentta.dto.BaseTransactionDto;
import com.example.paymentta.dto.CardDto;
import com.example.paymentta.entity.TransactionType;
import com.example.paymentta.exceptions.ServiceException;
import com.example.paymentta.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transfer")
public class TransactionController {
    @Autowired
    private TransferService transferService;

    @PostMapping("/card")
    public void transactionCardToCard(@RequestBody CardDto trx ) throws ServiceException {
        transferService.cardToCard(trx);
    }

    @PostMapping("/account")
    public void transactionAccountNumber(@RequestBody AccountDto trx ) throws ServiceException {
        transferService.accountNumber(trx);
    }

    @PostMapping("/get")
    public void getTrx(@RequestBody BaseTransactionDto trx) {

//        transactionService.getTransactions(trx.getReceiver().getCardNumber(),
//                trx.getSender().getCardNumber(),
//                trx.getDate(),
//                trx.getDate());
    }


}
