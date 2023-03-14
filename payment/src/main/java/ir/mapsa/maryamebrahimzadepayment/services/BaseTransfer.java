package ir.mapsa.maryamebrahimzadepayment.services;

import ir.mapsa.maryamebrahimzadepayment.dto.TransactionDto;
import ir.mapsa.maryamebrahimzadepayment.exceptions.ServiceException;
import ir.mapsa.maryamebrahimzadepayment.models.TransactionType;

public interface BaseTransfer {
    void transfer(TransactionDto dto) throws ServiceException;

    Boolean resolve(TransactionDto dto);

    TransactionType getType();

}
