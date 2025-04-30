package org.example;

public class Customer {
    private String name;
    private boolean isMember;

    // Constructor
    public Customer(String name, boolean isMember) {
        this.name = name;
        this.isMember = isMember;
    }

    // Getters
    public String getName() { return name; }
    public boolean isMember() { return isMember; }
}