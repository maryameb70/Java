package com.example.paymentta.dto;

import com.example.paymentta.entity.TransactionType;
import lombok.Data;

import java.util.Date;

@Data
public abstract class BaseTransactionDto {
    private Date date;
    private Long amount;
}
