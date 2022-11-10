package com.bankingapp.domains;

import com.bankingapp.exceptions.AmountException;
import com.bankingapp.repositories.DataSource;

public class Account {
    private int accountId;
    private String type;
    private Double balance;

    public Account(int accountId, String type, Double balance) {
        this.accountId = accountId;
        this.type = type;
        this.balance = balance;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) throws AmountException {

        if(amount < 1){
            throw new AmountException("The minimum deposit is 1.00");
        }
        else {
            double newBalance = balance + amount;
            setBalance(newBalance);
            DataSource.updateAccountBalance(accountId, newBalance);
        }

    }

    public void withdraw(double amount) throws AmountException {

        if(amount < 0){
            throw new AmountException("The withdrawal amount must be greater than 0.");
        }
        else if(amount > getBalance()){
            throw new AmountException("You do not have sufficient funds for this withdrawal.");
        }
        else {
            double newBalance = balance - amount;
            setBalance(newBalance);
            DataSource.updateAccountBalance(accountId, newBalance);
        }
    }
}
