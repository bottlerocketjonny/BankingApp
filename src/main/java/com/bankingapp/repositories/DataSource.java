package com.bankingapp.repositories;

import com.bankingapp.domains.Account;
import com.bankingapp.domains.Customer;

import java.sql.*;

public class DataSource {

    public static Connection connect() {
        String dbFile = "jdbc:sqlite:data/bank.db";
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(dbFile);
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

    public static Account getAccount(int accountId) {
        String sql = "select * from accounts where id = ?";
        Account account = null;

        try(Connection connection = connect()) {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, accountId);
            try(ResultSet resultSet = statement.executeQuery()) {
                account = new Account(
                        resultSet.getInt("id"),
                        resultSet.getString("type"),
                        resultSet.getDouble("balance"));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return account;
     }

     public static void updateAccountBalance(int accountId, double balance) {
        String sql = "update account set balance = ? where id = ?";
        try(
                Connection connection = connect();
                PreparedStatement statement = connection.prepareStatement(sql);
                ){
            statement.setDouble(1, balance);
            statement.setInt(2, accountId);

            statement.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
     }
}
