package ir.mapsa.maryamebrahimzadepayment14011205.repository;

import ir.mapsa.maryamebrahimzadepayment14011205.dto.Customer;

import java.sql.*;

public class CustomerRepository extends Customer {
    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/payment", "root", "root");
    }

    public Boolean isValidCardNumber(String cardNumber) {
        if (cardNumber.length() != 16) {
            throw new IllegalArgumentException("incorrect card number");
        }
        return true;
    }

    private void executeUpdateQuery(String query, Customer customer) throws SQLException {
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, customer.getCardNumber());
                statement.setString(2, customer.getFirstName());
                statement.setString(3, customer.getLastName());
                statement.setInt(4, customer.getAge());
                statement.setLong(5, customer.getBalance());
                statement.setString(6, customer.getCustomerId());
                if (customer.getId() != null) {
                    statement.setLong(7, customer.getId());
                }
                statement.executeUpdate();
        }
    }

    public void add(Customer customer,Connection connection) throws SQLException {
        executeUpdateQuery("insert into " +
                "customer(card_number, first_name, last_name, age, balance, customer_id)" +
                " values (?, ?, ?, ?, ?, ?)", customer);
    }


    public Customer getCustomer(ResultSet resultSet) throws SQLException {
        Customer customer = new Customer();
        customer.setFirstName(resultSet.getString("firstName"));
        customer.setLastName(resultSet.getString("lastName"));
        customer.setAge(resultSet.getInt("age"));
        customer.setCardNumber(resultSet.getString("cardNumber"));
        customer.setBalance(resultSet.getLong("balance"));
        return customer;
    }

    public Customer getCustomerByCardNumber(String cardNumber, Connection connection) throws SQLException {
       if(isValidCardNumber(cardNumber)) {
           try (PreparedStatement statement = connection.prepareStatement("select * from customer where cardNumber=?;")) {
               statement.setString(1, cardNumber);
               try (ResultSet resultSet = statement.executeQuery()) {
                   if (resultSet.next()) {
                       return getCustomer(resultSet);
                   }
               }
           }
       }
       return null;
    }

}
