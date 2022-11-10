package com.bankingapp.domains;

public class Customer {
    private Long customerId;
    private String customerName;
    private String customerUsername;
    private String customerPassword;
    private Long accountId;

    public Customer(Long customerId, String customerName, String customerUsername, String customerPassword, Long accountId) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerUsername = customerUsername;
        this.customerPassword = customerPassword;
        this.accountId = accountId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
