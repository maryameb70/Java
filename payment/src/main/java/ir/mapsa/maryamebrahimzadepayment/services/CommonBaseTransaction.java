package ir.mapsa.maryamebrahimzadepayment.services;

import ir.mapsa.maryamebrahimzadepayment.dto.TransactionDto;
import ir.mapsa.maryamebrahimzadepayment.exceptions.ServiceException;
import ir.mapsa.maryamebrahimzadepayment.models.Customer;
import ir.mapsa.maryamebrahimzadepayment.models.Transaction;
import ir.mapsa.maryamebrahimzadepayment.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public abstract class CommonBaseTransaction extends AbstractService<TransactionRepository, Transaction> implements BaseTransaction{
    @Autowired
    protected CustomerService customerService;

    protected Transaction saveTransaction(TransactionDto dto, Customer cSender, Customer cReceiver) {
        Transaction trxEntity = new Transaction();
        trxEntity.setReceiver(cReceiver);
        trxEntity.setSender(cSender);
        trxEntity.setDate(new Date());
        trxEntity.setAmount(dto.getAmount());
        repository.save(trxEntity);
        return trxEntity;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void resolveTransaction(Customer sender, Customer receiver, Long amount) throws ServiceException {
        customerService.withdraw(sender, amount);
        customerService.deposit(receiver, amount);
    }


}
