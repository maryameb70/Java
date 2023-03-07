package ir.mapsa.maryamebrahimzadepayment.repositories;

import java.sql.Connection;
import java.sql.SQLException;

public interface BaseRepository<T> {

    void add(T entity, Connection connection) throws SQLException;

    void update(T entity, Connection connection) throws SQLException;
}
