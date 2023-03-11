package ir.mapsa.maryamebrahimzadepayment.converters;

import ir.mapsa.maryamebrahimzadepayment.models.Transaction;
import ir.mapsa.maryamebrahimzadepayment.dto.TransactionDto;
import org.springframework.stereotype.Service;

@Service
public class TransactionConverter implements BaseConverter<TransactionDto,Transaction> {
    @Override
    public Transaction convertDto(TransactionDto d) {
        Transaction e = new Transaction();
        e.setId(d.getId());
        e.setDate(d.getDate());
        e.setSender(d.getSender());
        e.setReceiver(d.getReceiver());
        e.setAmount(d.getAmount());
        e.setTransactionId(d.getTransactionId());
        return e;
    }

    @Override
    public TransactionDto convertEntity(Transaction e) {
        TransactionDto d = new TransactionDto();
        d.setId(e.getId());
        d.setDate(e.getDate());
        d.setSender(e.getSender());
        d.setReceiver(e.getReceiver());
        d.setAmount(e.getAmount());
        d.setTransactionId(e.getTransactionId());
        return d;
    }
}
