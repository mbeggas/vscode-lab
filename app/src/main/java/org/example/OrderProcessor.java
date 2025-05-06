package org.example;

import java.io.PrintStream;
import java.util.Objects;

public class OrderProcessor {
    private final PrintStream output;

    // Default constructor uses System.out
    public OrderProcessor() {
        this(System.out);
    }

    // Constructor with dependency injection for output stream
    public OrderProcessor(PrintStream output) {
        this.output = Objects.requireNonNull(output, "Output stream cannot be null");
    }

    public void printOrderSummary(Order order) {
        validateOrder(order);
        double totalPrice = calculateTotalPrice(order);
        printSummary(order, totalPrice);
    }

    private void validateOrder(Order order) {
        Objects.requireNonNull(order, "Order cannot be null");
        Objects.requireNonNull(order.getCustomer(), "Order customer cannot be null");
        if (order.getItems() == null) {
            throw new IllegalArgumentException("Order items cannot be null");
        }
    }

    private double calculateTotalPrice(Order order) {
        double subtotal = calculateSubtotal(order.getItems());
        return applyDiscount(subtotal, order.getCustomer());
    }

    private double calculateSubtotal(List<Item> items) {
        return items.stream()
                   .mapToDouble(Item::getTotalPrice)
                   .sum();
    }

    private double applyDiscount(double subtotal, Customer customer) {
        return customer.isMember() ? subtotal * 0.9 : subtotal;
    }

    private void printSummary(Order order, double totalPrice) {
        output.println("Order Summary:");
        output.println("Customer: " + order.getCustomer().getName());
        printItems(order.getItems());
        printTotal(totalPrice);
    }

    private void printItems(List<Item> items) {
        output.println("Items:");
        items.forEach(item -> output.printf("  - %s: %d x $%.2f = $%.2f%n",
            item.getName(),
            item.getQuantity(),
            item.getPrice(),
            item.getTotalPrice()));
    }

    private void printTotal(double totalPrice) {
        output.printf("Total Price: $%.2f%n", totalPrice);
    }
}