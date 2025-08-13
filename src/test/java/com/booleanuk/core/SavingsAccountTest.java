package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SavingsAccountTest {

    @Test
    public void testSavingsAccount() {
        // Didn't get around to implement interest rate
        // The class should behave the same way that current account works, with the accountType field set to 'SAVINGS'

        Branch testBranch = new Branch("oslo");
        User testCustomer = new Customer("Trond Giske");
        UUID testUserUUID = testCustomer.getUUID();

        testBranch.createSavingsAccountForUser(testUserUUID);
        SavingsAccount testAccount = (SavingsAccount) testBranch.getAccountsForCustomerID(testUserUUID).getFirst();

        assertEquals(AccountType.SAVINGS, testAccount.getAccountType());
    }
}
