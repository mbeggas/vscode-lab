package org.example;

public class Customer {
    private final String name;
    private final boolean member;

    public Customer(String name, boolean member) {
        this.name = name;
        this.member = member;
    }

    public String getName() {
        return name;
    }

    public boolean isMember() {
        return member;
    }

    @Override
    public String toString() {
        return name + (member ? " (Member)" : "");
    }
}
