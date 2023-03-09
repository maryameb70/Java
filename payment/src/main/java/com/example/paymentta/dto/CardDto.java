package com.example.paymentta.dto;

import lombok.Data;

@Data
public class CardDto extends BaseTransactionDto{
    private String receiverCardNumber;
    private String sendCardNumber;
}
