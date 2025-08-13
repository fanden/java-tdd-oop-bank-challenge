package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class CurrentAccountTest {

    @Test
    public void testOverdraftLimit() {
        Branch testBranch = new Branch("oslo");
        User testCustomer = new Customer("Trond Giske");
        UUID testUserUUID = testCustomer.getUUID();

        testBranch.createCurrentAccountForUser(testUserUUID);
        CurrentAccount testAccount = (CurrentAccount) testBranch.getAccountsForCustomerID(testUserUUID).getFirst();

        testAccount.setOverdraftLimit(222);
        assertEquals(222, testAccount.getOverdraftLimit());

        testAccount.setOverdraftApproved(true);
        assertTrue(testAccount.isOverdraftApproved());

        testAccount.setOverdraftLimit(333);
        assertFalse(testAccount.isOverdraftApproved());
    }
}
