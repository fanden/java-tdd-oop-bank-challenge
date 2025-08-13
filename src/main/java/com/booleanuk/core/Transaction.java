package com.booleanuk.core;

import java.time.LocalDate;
import java.util.UUID;

public class Transaction {
    private double amount;
    private LocalDate date;
    private UUID id;

    public Transaction(double amount) {
        this.date = LocalDate.now();
        this.amount = amount;
        this.id = UUID.randomUUID();
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("Transaction{amount=%-15s, date=%-15s, id=%-15s}", amount, date, id);
        //return String.format("%-15s  %-15s  %-15s, "date",  "amount",  "id");
    }
}
