package org.example;

import java.util.List;

public class OrderProcessor {
    public void printOrderSummary(Order order) {
        double totalPrice = calculateTotalPrice(order);
        totalPrice = applyDiscount(order, totalPrice);
        printOrderDetails(order, totalPrice);
    }

    private double calculateTotalPrice(Order order) {
        double total = 0;
        for (Item item : order.getItems()) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }

    private double applyDiscount(Order order, double totalPrice) {
        return order.getCustomer().isMember() ? totalPrice * 0.9 : totalPrice;
    }

    private void printOrderDetails(Order order, double totalPrice) {
        System.out.println("Order Summary:"); // تصحيح: إزالة x:
        System.out.println("Customer: " + order.getCustomer().getName());
        System.out.println("Items:");
        for (Item item : order.getItems()) {
            System.out.printf("  - %s: %d x $%.2f = $%.2f%n",
                item.getName(), item.getQuantity(), item.getPrice(),
                item.getQuantity() * item.getPrice());
        }
        System.out.printf("Total Price: $%.2f%n", totalPrice);
    }
}