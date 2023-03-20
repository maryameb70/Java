package ir.mapsa.maryamebrahimzadepayment.services;

import ir.mapsa.maryamebrahimzadepayment.dto.TransactionDto;
import ir.mapsa.maryamebrahimzadepayment.models.TransactionType;
import org.springframework.stereotype.Service;

@Service
public class AccountTransfer implements BaseTransfer {
    @Override
    public Boolean resolve(TransactionDto dto) {
        return dto.getType().equals(TransactionType.ACCOUNTNUMBER);
    }
}
