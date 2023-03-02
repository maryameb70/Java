package ir.mapsa.maryamebrahimzadepayment.repository;

import ir.mapsa.maryamebrahimzadepayment.dto.Customer;
import ir.mapsa.maryamebrahimzadepayment.dto.Notify;

import java.sql.*;

public class CustomerRepository implements BaseRepository<Customer> {


    @Override
    public void add(Customer customer, Connection connection) throws SQLException {
        executeUpdateQuery("insert into customer (card_number, first_name, last_name, age, balance, customer_id,phone, email) values (?,?,?,?,?,?,?,?);", customer,connection);
    }

    @Override
    public void update(Customer customer, Connection connection) throws SQLException {
        executeUpdateQuery("update customer set card_number=?, first_name=?, last_name=?, age=?, balance=?, customer_id=?,phone=?, email=? where id=?;", customer, connection);
    }

    private void executeUpdateQuery(String query, Customer customer, Connection connection) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, customer.getCardNumber());
            statement.setString(2, customer.getFirstName());
            statement.setString(3, customer.getLastName());
            statement.setInt(4, customer.getAge());
            statement.setLong(5, customer.getBalance());
            statement.setString(6, customer.getCustomerId());
            statement.setString(7,customer.getPhone());
            statement.setString(8,customer.getEmail());
            if (customer.getId() != null) {
                statement.setLong(9, customer.getId());
            }
            statement.executeUpdate();
        }
    }

    public Customer getCustomerByCardNumber(String cardNumber, Connection connection) throws SQLException {
        if (isValidCardNumber(cardNumber)) {
            try (PreparedStatement statement = connection.prepareStatement("select * from customer where card_number=?;")) {
                statement.setString(1, cardNumber);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return getCustomer(resultSet);
                    } else {
                        return null;
                    }
                }
            }
        }
        return null;
    }

    private static Customer getCustomer(ResultSet resultSet) throws SQLException {
        Customer customer = new Customer();
        customer.setId(resultSet.getLong("id"));
        customer.setCardNumber(resultSet.getString("card_number"));
        customer.setFirstName(resultSet.getString("first_name"));
        customer.setLastName(resultSet.getString("last_name"));
        customer.setAge(resultSet.getInt("age"));
        customer.setBalance(resultSet.getLong("balance"));
        customer.setCustomerId(resultSet.getString("customer_id"));
        customer.setPhone(resultSet.getString("phone"));
        customer.setEmail(resultSet.getString("email"));
        return customer;
    }

    private Boolean isValidCardNumber(String cardNumber) {
        if (cardNumber.length() != 16) {
            throw new IllegalArgumentException("Your CarNumber is incorrect");
        }
        return true;
    }


}

