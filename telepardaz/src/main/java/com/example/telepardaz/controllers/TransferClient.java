package com.example.telepardaz.controllers;

import com.example.telepardaz.dto.transfer.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="bank" ,url = "192.168.43.87:8081")
public interface TransferClient {
    @PostMapping("/bank/payment")
    PaymentMessage doTransferPayment(PaymentDto payment);

    @PostMapping("/bank/account")
    PaymentMessage doTransferAccount(AccountDto account);

    @PostMapping("/bank/card")
    PaymentMessage doTransferCard(CardDto card);
}
