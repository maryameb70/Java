package ir.mapsa.maryamebrahimzadepayment.service;

import ir.mapsa.maryamebrahimzadepayment.dto.Customer;
import ir.mapsa.maryamebrahimzadepayment.dto.Transaction;
import ir.mapsa.maryamebrahimzadepayment.repository.CustomerRepository;
import ir.mapsa.maryamebrahimzadepayment.repository.TransactionRepository;
import ir.mapsa.maryamebrahimzadepayment.repository.util.HandleConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionService {
    public void resolveTransaction(Transaction transaction) {
        try (Connection connection = HandleConnection.getConnection()) {
            connection.setAutoCommit(false);
            Boolean isOkWithdraw = withdraw(transaction.getSenderCardNumber(), transaction.getAmount(), connection);
            if (!isOkWithdraw) {
                return;
            }
            Boolean isOkDeposit = deposit(transaction.getReceiverCardNumber(), transaction.getAmount(), connection);
            if (!isOkDeposit) {
                connection.rollback();
                return;
            }
            saveTransaction(transaction, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void saveTransaction(Transaction transaction, Connection connection) throws SQLException {
        try {
            TransactionRepository transactionRepository = new TransactionRepository();
            transactionRepository.add(transaction,connection);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
        }
    }

    private Boolean withdraw(String cardNumber, Long amount, Connection connection) throws SQLException {
        try {
            CustomerRepository customerRepository = new CustomerRepository();
            Customer customer = customerRepository.getCustomerByCardNumber(cardNumber,connection);
            if (customer.getBalance() == null) {
                return false;
            }
            if (customer.getBalance() >= amount) {
                customer.setBalance(customer.getBalance() - amount);
                customerRepository.update(customer,connection);
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.out.println("withdraw exception" + e);
            throw e;
        }
    }

    private Boolean deposit(String cardNumber, Long amount, Connection connection) throws SQLException {
        try {
            CustomerRepository customerRepository = new CustomerRepository();
            Customer customer = customerRepository.getCustomerByCardNumber(cardNumber,connection);
            customer.setBalance(customer.getBalance() + amount);
            customerRepository.update(customer,connection);
            return true;
        } catch (SQLException e) {
            System.out.println("deposit exception" + e);
            throw e;
        }
    }
}
