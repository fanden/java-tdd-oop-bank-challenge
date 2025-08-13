package com.booleanuk.core;

import java.util.UUID;
import com.booleanuk.core.AccountType;

public class CurrentAccount extends Account {
    private static final AccountType accountType = AccountType.CURRENT;
    private double overdraftLimit;
    private boolean overdraftApproved;

    public CurrentAccount(UUID CustomerUUID) {
        super(CustomerUUID, accountType);
        this.overdraftLimit = 0;
        this.overdraftApproved = false;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftApproved = false;
        this.overdraftLimit = overdraftLimit;
    }

    public boolean isOverdraftApproved() {
        return overdraftApproved;
    }

    public void setOverdraftApproved(boolean overdraftApproved) {
        this.overdraftApproved = overdraftApproved;
    }
}
