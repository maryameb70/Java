package com.example.paymentta.dto;

import lombok.Data;

@Data
public class AccountDto extends BaseTransactionDto{
    private String receiverAccountNumber;
    private String sendAccountNumber;
}
