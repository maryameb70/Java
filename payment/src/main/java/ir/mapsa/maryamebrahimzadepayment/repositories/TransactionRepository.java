package ir.mapsa.maryamebrahimzadepayment.repositories;

import ir.mapsa.maryamebrahimzadepayment.dto.Transaction;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionRepository implements BaseRepository<Transaction> {
    @Override
    public void add(Transaction transaction, Connection connection) throws SQLException {
        executeUpdateQuery("insert into transaction (date, sender_card_number, receiver_card_number, amount, transaction_id) values (?,?,?,?,?);", transaction, connection);
    }

    @Override
    public void update(Transaction transaction, Connection connection) throws SQLException {
    }

    private static void executeUpdateQuery(String query, Transaction transaction, Connection connection) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDate(1, (Date) transaction.getDate());
            statement.setString(2, transaction.getSenderCardNumber());
            statement.setString(3, transaction.getReceiverCardNumber());
            statement.setLong(4, transaction.getAmount());
            statement.setString(5, transaction.getTransactionId());
            statement.executeUpdate();
        }
    }
}
