package ir.mapsa.maryamebrahimzadepayment14011205;

import ir.mapsa.maryamebrahimzadepayment14011205.dto.Customer;
import ir.mapsa.maryamebrahimzadepayment14011205.repository.CustomerRepository;
import ir.mapsa.maryamebrahimzadepayment14011205.dto.Transaction;
import ir.mapsa.maryamebrahimzadepayment14011205.service.TransactionService;

import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
        Date date = new java.sql.Date(new java.util.Date().getTime());
        Transaction transaction = new Transaction();
        CustomerRepository customerRepository = new CustomerRepository();
        TransactionService transactionService = new TransactionService();
        Long amount = 2000L;
        Customer sender = customerRepository.findCustomerByCardNumber("3714496353984312");
        Customer receiver = customerRepository.findCustomerByCardNumber("3643893643893645");
        transaction.setSenderCardNumber(sender.getCardNumber());
        transaction.setRecieverCardNumber(receiver.getCardNumber());
        transaction.setDate(date);
        transaction.setAmount(amount);
        transactionService.resolveTransaction(transaction);
    }
}
