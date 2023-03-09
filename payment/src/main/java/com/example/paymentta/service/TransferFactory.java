package com.example.paymentta.service;

import com.example.paymentta.entity.TransactionType;

public class TransferFactory {
    public static BaseTransaction createNotification(TransactionType type) {
        if (type == null) {
            return null;
        }
        return switch (type) {
            case CARDTOCARD -> new CardToCardTransaction();
            case ACCOUNTNUMBER -> new AccountTransaction();
            default -> throw new IllegalArgumentException("Unknown chanel");
        };
    }
}
