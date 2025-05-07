package org.example;

public class OrderProcessor {

    public void printOrderSummary(Order order) {
        double totalPrice = calculateTotalPrice(order);
        totalPrice = applyDiscountIfMember(order, totalPrice);
        printSummary(order, totalPrice);
    }

    private double calculateTotalPrice(Order order) {
        double total = 0;
        for (Item item : order.getItems()) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }

    private double applyDiscountIfMember(Order order, double totalPrice) {
        if (order.getCustomer().isMember()) {
            return totalPrice * 0.9;
        }
        return totalPrice;
    }

    private void printSummary(Order order, double totalPrice) {
        System.out.println("Order Summary:");
        System.out.println("Customer: " + order.getCustomer().getName());
        System.out.println("Items:");
        for (Item item : order.getItems()) {
            System.out.println("  - " + item.getName() + ": " +
                item.getQuantity() + " x $" + item.getPrice() +
                " = $" + (item.getQuantity() * item.getPrice()));
        }
        System.out.printf("Total Price: $%.2f%n", totalPrice);
    }
}
