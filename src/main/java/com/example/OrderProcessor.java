package com.example;

import java.util.List;

public class OrderProcessor {

    public void printOrderSummary(Order order) {
        double totalPrice = calculateTotalPrice(order.getItems());
        totalPrice = applyMemberDiscount(totalPrice, order.getCustomer().isMember());

        System.out.println("Order Summary:");
        System.out.println("Customer: " + order.getCustomer().getName());
        System.out.println("Items:");
        for (Item item : order.getItems()) {
            double lineTotal = item.getQuantity() * item.getPrice();
            System.out.println(
                "  - " + item.getName()
                + ": " + item.getQuantity()
                + " x $" + item.getPrice()
                + " = $" + lineTotal
            );
        }
        System.out.printf("Total Price: $%.2f%n", totalPrice);
    }

    private double calculateTotalPrice(List<Item> items) {
        double total = 0;
        for (Item item : items) {
            total += item.getQuantity() * item.getPrice();
        }
        return total;
    }

    private double applyMemberDiscount(double price, boolean isMember) {
        if (isMember) {
            return price * 0.9; // خصم 10% للأعضاء
        }
        return price;
    }
}