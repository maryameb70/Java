package com.example.telepardaz.controllers;

import com.example.telepardaz.dto.transfer.WalletDto;
import com.example.telepardaz.services.TransferService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckTimeoutTransfer {
    @Autowired
    private TransferService transferService;

    @AfterThrowing(value = "execution(* com.example.telepardaz.services.TransferService.transfer(..))", throwing = "exception")
    public void checkTimedOutTransactions(JoinPoint jp, Exception exception) throws Exception {
        Signature signature = jp.getSignature();
        WalletDto[] objects = (WalletDto[]) jp.getArgs();
        transferService.retryDeposit(objects[0]);
    }
}
