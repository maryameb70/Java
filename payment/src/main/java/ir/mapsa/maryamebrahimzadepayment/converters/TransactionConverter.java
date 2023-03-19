package ir.mapsa.maryamebrahimzadepayment.converters;

import ir.mapsa.maryamebrahimzadepayment.dto.TransactionDto;
import ir.mapsa.maryamebrahimzadepayment.models.Transaction;
import ir.mapsa.maryamebrahimzadepayment.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionConverter implements BaseConverter<TransactionDto, Transaction> {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Transaction convertDto(TransactionDto d) {
        Transaction e = new Transaction();
        e.setId(d.getId());
        e.setVersion(d.getVersion());
        e.setDate(d.getDate());
        e.setSender(customerRepository.findByCardNumber(d.getSource()));
        e.setReceiver(customerRepository.findByCardNumber(d.getDestination()));
        e.setAmount(d.getAmount());
        e.setTransactionId(d.getTransactionId());
        return e;
    }

    @Override
    public TransactionDto convertEntity(Transaction e) {
        TransactionDto d = new TransactionDto();
        d.setId(e.getId());
        d.setVersion(e.getVersion());
        d.setDate(e.getDate());
        d.setSource(e.getSender().getCardNumber());
        d.setDestination(e.getReceiver().getCardNumber());
        d.setAmount(e.getAmount());
        d.setTransactionId(e.getTransactionId());
        return d;
    }
}
