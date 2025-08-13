package com.booleanuk.core;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
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

    public void printAccountStatement() {

        final String rowFmt = "%-15s||%15s||%15s||%15s%n";
        System.out.printf(rowFmt,"date", "credit", "debit", "balance");

        // Date Innskudd Utrekk Balanse
        double balance = 0;

        for (Transaction transaction : transactions) {
            String transactionDate =  transaction.getDate().toString();
            double amount = transaction.getAmount();
            String credit = "";
            String debit = "";

            if(amount <= 0) {
                debit = Double.toString(
                        Math.abs(amount));
            }
            else{
                credit = Double.toString(
                        amount);
            }

            balance = balance + amount;

            System.out.printf(rowFmt,transactionDate, credit, debit, balance);

        }
    }
}

