package ir.mapsa.maryamebrahimzadepayment.services;

import ir.mapsa.maryamebrahimzadepayment.dto.TransferDto;
import ir.mapsa.maryamebrahimzadepayment.exceptions.ServiceException;
import org.springframework.stereotype.Service;

public interface BaseTransfer {
    void transfer(TransferDto dto)throws ServiceException;
    Boolean resolve(TransferDto dto);
}
