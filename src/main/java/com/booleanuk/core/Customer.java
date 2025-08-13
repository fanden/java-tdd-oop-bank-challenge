package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Customer extends User {

    private List<UUID> accountUUIDs;
    public Customer(String name) {
        super(name);
        this.accountUUIDs = new ArrayList<UUID>();
    }

    public List<UUID> getAccountUUIDs() {
        return accountUUIDs;
    }

    public void addAccount(UUID accountUUID) {
        this.accountUUIDs.add(accountUUID);
    }
}
