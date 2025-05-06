package com.example.refactoring;

public class Customer {
    private final String name;
    private final boolean isMember;

    public Customer(String name, boolean isMember) {
        this.name = name;
        this.isMember = isMember;
    }

    public String getName() {
        return name;
    }

    public boolean isMember() {
        return isMember;
    }
}