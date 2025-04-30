package org.example;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Customer customer;
    private List<Item> items;

    // Constructor
    
public Order() {
    this.customer = null;
    this.items = new ArrayList<>(); 
}

    // Setter Methods
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    // Getter Methods
    public Customer getCustomer() {
        return customer;
    }

    public List<Item> getItems() {
        return items;
    }
}