package com.booleanuk.core;

import org.junit.jupiter.api.Test;

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
    public void GetAccountsForCustomerID() {
        Branch testBranch = new Branch("oslo");
        User testCustomer = new Customer("Trond Giske");
        UUID testUserUUID = testCustomer.getUUID();

        testBranch.createCurrentAccountForUser(testUserUUID);

        assertNotNull(testBranch.getAccountsForCustomerID(testUserUUID);
    }
}
