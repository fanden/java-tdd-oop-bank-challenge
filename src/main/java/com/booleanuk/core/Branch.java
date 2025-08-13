package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Branch {
    private List<Account> accounts;
    private UUID id;
    private String name;

    public Branch(String name) {
        this.name = name;
        this.accounts = new ArrayList<Account>();
        this.id = UUID.randomUUID();
    }

    public void createSavingsAccountForUser(UUID customerId) {
        this.accounts.add(new SavingsAccount(customerId));
    }

    public void createCurrentAccountForUser(UUID customerId) {
        this.accounts.add(new CurrentAccount(customerId));
    }

    public List<Account> getAccountsForCustomerID(UUID customerId) {
        return this.accounts.stream()
                .filter(account -> account.getCustomerUUID().equals(customerId))
                .toList();
    }

    public List<Account> getAccountsForAccountID(UUID accountID) {
        return this.accounts.stream()
                .filter(account -> account.getId().equals(accountID))
                .toList();
    }
}