package com.bankingapp.repositories;

import com.bankingapp.domains.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcConnection {

    public static Connection connect() {
        String dbFile = "";
        Connection connection = null;

        try {
            connection = DriverManager.getConnection();
            System.out.println("We're connected!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static Customer getCustomer(String customerUsername) {
        String sql = "select * from customers where customerUsername = ?";  // ? used as placeholder to stop SQL injection
        try(Connection connection = connect()) {
            PreparedStatement statement = connection.prepareStatement(sql);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        connect();
    }
}
