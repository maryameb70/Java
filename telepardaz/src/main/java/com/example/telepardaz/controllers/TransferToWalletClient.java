package com.example.telepardaz.controllers;

import com.example.telepardaz.dto.transfer.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="wallet" ,url = "192.168.43.87:8080")
public interface TransferToWalletClient {

    @PostMapping("/wallet/deposit")
    PaymentMessage doTransferWallet(WalletDto wallet);

    @PostMapping("/wallet/transactions/tracking")
    PaymentMessage doTransferTransaction(String trackingId);

    @PostMapping("/wallet/toWallet")
    PaymentMessage doTransferWalletToWallet(WalletToWalletDto wallet);
}
