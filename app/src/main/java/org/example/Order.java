package org.example;

import java.util.List;

public class Order {
    private Customer customer;
    private List<Item> items;

    public Order(Customer customer, List<Item> items) {
        this.customer = customer;
        this.items = items;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Item> getItems() {
        return items;
    }
}
