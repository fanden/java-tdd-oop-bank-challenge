package com.booleanuk.core;

import java.util.UUID;

public abstract class User {
    private UUID uuid;
    private String name;

    public User(String name) {
        this.uuid = java.util.UUID.randomUUID();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getUUID() {
        return uuid;
    }

    public void setUUID(UUID uuid) {
        this.uuid = uuid;
    }
}
