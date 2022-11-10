package com.bankingapp.domains;

public class Account {
    private Long accountId;
    private String accountType;
    private Double accountBalance;

    public Account(Long accountId, String accountType, Double accountBalance) {
        this.accountId = accountId;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }
}
