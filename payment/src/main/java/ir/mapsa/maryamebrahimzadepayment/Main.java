package ir.mapsa.maryamebrahimzadepayment;

import ir.mapsa.maryamebrahimzadepayment.dto.Customer;
import ir.mapsa.maryamebrahimzadepayment.dto.Notify;
import ir.mapsa.maryamebrahimzadepayment.dto.Transaction;
import ir.mapsa.maryamebrahimzadepayment.repository.CustomerRepository;
import ir.mapsa.maryamebrahimzadepayment.repository.util.HandleConnection;
import ir.mapsa.maryamebrahimzadepayment.service.TransactionService;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args)throws SQLException {
        try (Connection connection = HandleConnection.getConnection()) {
            System.out.println("Customer added");
            Customer customer = new Customer();
            CustomerRepository customerRepository = new CustomerRepository();
            customer.setCustomerId("123456");
            customer.setAge(31);
            customer.setFirstName("maryam");
            customer.setLastName("ebrahimzade");
            customer.setCardNumber("5859831048450950");
            customer.setBalance(8000000L);
            customer.setPhone("09139278592");
            customer.setEmail("ma.ebrahimzadeh@gmail.com");
            customer.setNotify(Notify.EMAIL);
            customerRepository.add(customer,connection);
            customer = new Customer();
            customer.setCustomerId("145632");
            customer.setAge(25);
            customer.setFirstName("zahra");
            customer.setLastName("amiri");
            customer.setCardNumber("6104337960029542");
            customer.setBalance(20000000L);
            customer.setPhone("09920862127");
            customer.setEmail("maryamebz1399@gmail.com");
            customer.setNotify(Notify.EMAIL);
            customerRepository.add(customer,connection);
        }

        System.out.println("The transaction was registered");
        TransactionService transactionService = new TransactionService();
        Transaction transaction = new Transaction();
        transaction.setAmount(5000L);
        transaction.setTransactionId("110");
        transaction.setSenderCardNumber("5859831048450950");
        transaction.setReceiverCardNumber("6104337960029542");
        transaction.setDate(new java.sql.Date(System.currentTimeMillis()));
        transactionService.resolveTransaction(transaction);



    }
}
