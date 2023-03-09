package com.example.paymentta.entity;

import lombok.Data;

@Data
public class CardToCardData {
    private String receiverCardNumber;
    private String sendCardNumber;
    private Long amount;
}
