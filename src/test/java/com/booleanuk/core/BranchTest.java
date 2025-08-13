package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class BranchTest {

    @Test
    public void createSavingsAccountForUser() {
        Branch testBranch = new Branch("oslo");
        User testCustomer = new Customer("Trond Giske");

        testBranch.createSavingsAccountForUser(testCustomer.getUUID());
        testBranch.getAccountsForCustomerID(testCustomer.getUUID());
    }

    @Test
    public void createCurrentAccountForUser() {
        Branch testBranch = new Branch("oslo");
        User testCustomer = new Customer("Trond Giske");

        testBranch.createCurrentAccountForUser(testCustomer.getUUID());

        assertNotNull(testBranch.getAccountsForCustomerID(testCustomer.getUUID()));
    }

    @Test
    public void getAccountsForCustomerID() {
        Branch testBranch = new Branch("oslo");
        User testCustomer = new Customer("Trond Giske");
        UUID testUserUUID = testCustomer.getUUID();

        testBranch.createCurrentAccountForUser(testUserUUID);

        assertNotNull(testBranch.getAccountsForCustomerID(testUserUUID));
    }

    @Test
    public void getAccountsForAccountID() {
        Branch testBranch = new Branch("oslo");
        User testCustomer = new Customer("Trond Giske");
        UUID testUserUUID = testCustomer.getUUID();

        testBranch.createCurrentAccountForUser(testUserUUID);

        List<Account> testAccount = testBranch.getAccountsForCustomerID(testUserUUID);
        UUID testAccountUUID = testAccount.getFirst().getId();

        assertNotNull(testBranch.getAccountsForAccountID(testAccountUUID));
    }

    @Test void testEverything() {
        Branch testBranch = new Branch("oslo");
        User testCustomer = new Customer("Trond Giske");
        UUID testUserUUID = testCustomer.getUUID();

        testBranch.createCurrentAccountForUser(testUserUUID);
        CurrentAccount testAccount = (CurrentAccount) testBranch.getAccountsForCustomerID(testUserUUID).getFirst();

        testAccount.addTransaction(1000);
        testAccount.addTransaction(2000);
        testAccount.addTransaction(-500);

        testAccount.printAccountStatement();

        assertEquals(2500, testAccount.calculateBalance());


    }
}
