package ir.mapsa.maryamebrahimzadepayment14011205.service;

import ir.mapsa.maryamebrahimzadepayment14011205.dto.Customer;
import ir.mapsa.maryamebrahimzadepayment14011205.repository.CustomerRepository;
import ir.mapsa.maryamebrahimzadepayment14011205.dto.Transaction;
import ir.mapsa.maryamebrahimzadepayment14011205.repository.util.HandleConnection;

import java.sql.*;

public class TransactionService {
//    private Connection getConnection() throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        return DriverManager.getConnection("jdbc:mysql://localhost:3306/payment", "root", "root");
//    }

    public void resolveTransaction(Transaction transaction) {
        try (Connection connection = HandleConnection.getConnection()) {
            connection.setAutoCommit(false);
            Boolean isWithdraw = withdraw(transaction.getSenderCardNumber(), transaction.getAmount(), connection);
            if (!isWithdraw) {
                return;
            }
            Boolean isDeposit = deposit(transaction.getRecieverCardNumber(), transaction.getAmount());
            if (!isDeposit) {
                connection.rollback();
                return;
            }
            saveTransaction(transaction, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void saveTransaction(Transaction transaction, Connection connection) throws SQLException {
        connection.rollback();
        String insertTransaction = "insert into transaction (date, senderCardNumber, recieverCardNumber, amount,transactionId) values (?,?,?,?,?);";
        try (PreparedStatement statement = connection.prepareStatement(insertTransaction)) {
            statement.setDate(1, (Date) transaction.getDate());
            statement.setString(2, transaction.getSenderCardNumber());
            statement.setString(3, transaction.getRecieverCardNumber());
            statement.setLong(4, transaction.getAmount());
            statement.setString(5, transaction.getTransactionId());
            statement.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
        }
    }

    private synchronized Boolean withdraw(String cardNumber, Long amount, Connection connection) throws SQLException {
        try {
            CustomerRepository customerRepository = new CustomerRepository();
            Customer customer = customerRepository.getCustomerByCardNumber(cardNumber, connection);
            if (customer.getBalance() == null) {
                return false;
            }

            if (customer.getBalance() >= amount) {
                System.out.println(customer.getFirstName() + " withdrawn " + amount);
                customer.setBalance(customer.getBalance() - amount);
                System.out.println("Balance after withdrawal: " + customer.getBalance());
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
//                System.out.println(customer.getFirstName() + " you can not withdraw " + amount);
//                System.out.println("your balance is: " + customer.getBalance());
        }
        return false;
    }

    private synchronized Boolean deposit(String cardNumber, Long amount, Connection connection) throws SQLException {
        try {
            CustomerRepository customerRepository = new CustomerRepository();
            Customer customer = customerRepository.getCustomerByCardNumber(cardNumber, connection);
            customer.setBalance(customer.getBalance() + amount);
            System.out.println("Balance after deposit: " + customer.getBalance());
            //update balance
            return true;
        } catch (SQLException e) {
            System.out.println("deposit exception" + e);
            throw e;
        }
        return false;
    }

}

}
