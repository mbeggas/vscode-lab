package org.example;

public class OrderProcessor {

    public void printOrderSummary(Order order) {
        double totalPrice = calculateTotalPrice(order);
        printSummary(order, totalPrice);
    }

    private double calculateTotalPrice(Order order) {
        double totalPrice = 0;
        for (Item item : order.getItems()) {
            totalPrice += item.getPrice() * item.getQuantity();
        }

        if (order.getCustomer().isMember()) {
            totalPrice *= 0.9; // 10% discount for members
        }

        return totalPrice;
    }

    private void printSummary(Order order, double totalPrice) {
        System.out.println("the Order Summary:");
        System.out.println("the Customer: " + order.getCustomer().getName());
        System.out.println("the Items:");
        for (Item item : order.getItems()) {
            System.out.printf("  - %s: %d x $%.2f = $%.2f%n",
                    item.getName(),
                    item.getQuantity(),
                    item.getPrice(),
                    item.getQuantity() * item.getPrice());
        }
        System.out.printf("the Total Price: $%.2f%n", totalPrice);
    }
}