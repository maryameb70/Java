package ir.mapsa.maryamebrahimzadepayment.services;

import ir.mapsa.maryamebrahimzadepayment.dto.TransactionDto;
import ir.mapsa.maryamebrahimzadepayment.models.TransactionType;
import org.springframework.stereotype.Service;
@Service
public class C2cTransfer implements BaseTransfer {
    public Boolean resolve(TransactionDto dto) {
        return dto.getType().equals(TransactionType.CARDTOCARD);
    }
}
