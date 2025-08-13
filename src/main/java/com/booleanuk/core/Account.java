package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Account {
    private UUID id;
    private UUID CustomerUUID;
    private List<Transaction> transactions;
    private AccountType accountType;

    public Account(UUID CustomerUUID, AccountType accountType) {
        this.id = UUID.randomUUID();
        this.CustomerUUID = CustomerUUID;
        this.transactions = new ArrayList<Transaction>();
        this.accountType = accountType;
    }

    public void addTransaction(double amount) {
        this.transactions.add(new Transaction(amount));
    }

    public double calculateBalance() {
        return transactions.stream().mapToDouble(Transaction::getAmount).sum();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getCustomerUUID() {
        return CustomerUUID;
    }

    public void setCustomerUUID(UUID customerUUID) {
        CustomerUUID = customerUUID;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", CustomerUUID=" + CustomerUUID +
                ", transactions=" + transactions +
                ", accountType=" + accountType +
               '}';
    }
}
