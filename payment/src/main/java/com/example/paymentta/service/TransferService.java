package com.example.paymentta.service;

import com.example.paymentta.dto.AccountDto;
import com.example.paymentta.dto.CardDto;
import com.example.paymentta.entity.TransactionType;
import com.example.paymentta.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferService {
    @Autowired
    private CardToCardTransaction cardToCard;
    @Autowired
    private AccountTransaction accountNumber;

    public void cardToCard(CardDto cDto) throws ServiceException {
        cardToCard.resolveTransaction(cDto);
    }

    public void accountNumber(AccountDto aDto) throws ServiceException {
        accountNumber.resolveTransaction(aDto);
    }
}
