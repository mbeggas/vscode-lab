package org.example.app;

import java.util.List;

class Customer {
    private String name;
    private boolean isMember;

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

class Item {
    private String name;
    private double price;
    private int quantity;

    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}

class Order {
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

public class OrderProcessor {
    public void printOrderSummary(Order order) {
        // حساب السعر الإجمالي
        double totalPrice = 0;
        for (Item item : order.getItems()) {
            totalPrice += item.getPrice() * item.getQuantity();
        }

        // تطبيق الخصم
        if (order.getCustomer().isMember()) {
            totalPrice *= 0.9; // خصم 10% للأعضاء
        }

        // طباعة الملخص
        System.out.println("Order Summary:");
        System.out.println("Customer: " + order.getCustomer().getName());
        System.out.println("Items:");
        for (Item item : order.getItems()) {
            System.out.println("  - " + item.getName() + ": " + item.getQuantity() + " x $" + item.getPrice() + " = $" + (item.getQuantity() * item.getPrice()));
        }
        System.out.printf("Total Price: $%.2f%n", totalPrice);
    }
}
