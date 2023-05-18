package com.example.telepardaz.mappers;

import com.example.telepardaz.dto.TransactionDto;
import com.example.telepardaz.models.Transaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper extends BaseMapper<TransactionDto, Transaction> {
}
