package com.bankingapp.domains;

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
}
