package com.example;

public class Customer {
    private String name;
    private boolean member;

    public Customer(String name, boolean isMember) {
        this.name = name;
        this.member = isMember;
    }

    public String getName() {
        return name;
    }

    public boolean isMember() {
        return member;
    }
}