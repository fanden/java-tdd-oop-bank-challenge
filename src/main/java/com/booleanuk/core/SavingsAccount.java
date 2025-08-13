package com.booleanuk.core;

import java.util.UUID;

public class SavingsAccount extends Account {
    private float interestRate;
    private static final AccountType accountType = AccountType.SAVINGS;

    public SavingsAccount(UUID CustomerUUID) {
        super(CustomerUUID, accountType);
        this.interestRate = 0;
    }
}
