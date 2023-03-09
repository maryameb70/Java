package com.example.paymentta.entity;

import lombok.Data;

@Data
public class AccountNumberData {
    private String receiverAccountNumber;
    private String sendAccountNumber;
    private Long amount;
}
