package ir.mapsa.maryamebrahimzadepayment.repository;

import ir.mapsa.maryamebrahimzadepayment.dto.Customer;

import java.sql.Connection;
import java.sql.SQLException;

public interface BaseRepository<T> {

    void add(T entity, Connection connection) throws SQLException;

    void update(T entity, Connection connection) throws SQLException;
}
