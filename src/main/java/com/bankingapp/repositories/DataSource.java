package com.bankingapp.repositories;

import com.bankingapp.domains.Customer;

import java.sql.*;

public class DataSource {

    public static Connection connect() {
        String dbFile = "jdbc:sqlite:data/bank.db";
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(dbFile);
            System.out.println("We're connected to the database!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static Customer getCustomer(String username) {
        String sql = "select * from customers where username = ?";  // ? used as placeholder to stop SQL injection
        Customer customer = null;

        try(Connection connection = connect()) {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, username);           // inject into sql statement
            try(ResultSet resultSet = statement.executeQuery()) {
                customer = new Customer(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getInt("account_id"));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return customer;
    }

    public static void main(String[] args) {
        Customer customer = getCustomer("twest8o@friendfeed.com");
        System.out.println(customer.getName());
    }
}
