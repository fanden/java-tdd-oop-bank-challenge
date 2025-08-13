package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

    @Test
    public void addTransaction() {
        Branch testBranch = new Branch("oslo");
        User testCustomer = new Customer("Trond Giske");
        UUID testUserUUID = testCustomer.getUUID();

        testBranch.createCurrentAccountForUser(testUserUUID);
        Account testAccount = testBranch.getAccountsForCustomerID(testUserUUID).getFirst();
        testAccount.addTransaction(1000.99);
        Transaction testTransaction = testAccount.getTransactions().getFirst();

        assertEquals(1000.99, testTransaction.getAmount());
    }

    @Test
    public void calculateBalance() {
        Branch testBranch = new Branch("oslo");
        User testCustomer = new Customer("Trond Giske");
        UUID testUserUUID = testCustomer.getUUID();

        testBranch.createCurrentAccountForUser(testUserUUID);
        Account testAccount = testBranch.getAccountsForCustomerID(testUserUUID).getFirst();
        testAccount.addTransaction(1000.99);
        testAccount.addTransaction(1000.99);

        assertEquals(2001.98, testAccount.calculateBalance());
    }
}
