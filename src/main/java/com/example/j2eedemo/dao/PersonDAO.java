package com.example.j2eedemo.dao;

import com.example.j2eedemo.model.Person;
import java.sql.*;
import java.util.*;

public class PersonDAO {
    private final String URL = "jdbc:h2:./data/j2ee-demo;DB_CLOSE_DELAY=-1";
    private final String USER = "sa";
    private final String PASS = "";

    public PersonDAO() {
        try (Connection c = getConn(); Statement s = c.createStatement()) {
            s.execute(
                    "CREATE TABLE IF NOT EXISTS person (id IDENTITY PRIMARY KEY, name VARCHAR(100), email VARCHAR(100))");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection getConn() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public List<Person> findAll() {
        List<Person> out = new ArrayList<>();
        try (Connection c = getConn(); PreparedStatement p = c.prepareStatement("SELECT id, name, email FROM person")) {
            ResultSet rs = p.executeQuery();
            while (rs.next())
                out.add(new Person(rs.getLong("id"), rs.getString("name"), rs.getString("email")));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return out;
    }

    public void create(Person person) {
        try (Connection c = getConn();
                PreparedStatement p = c.prepareStatement("INSERT INTO person (name,email) VALUES (?,?)")) {
            p.setString(1, person.getName());
            p.setString(2, person.getEmail());
            p.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(long id) {
        try (Connection c = getConn(); PreparedStatement p = c.prepareStatement("DELETE FROM person WHERE id=?")) {
            p.setLong(1, id);
            p.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
