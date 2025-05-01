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
            totalPrice *= 0.9; // خصم 10% للأعضاء
        }

        return totalPrice;
    }

    private void printSummary(Order order, double totalPrice) {
        System.out.println("Order Summary:");
        System.out.println("Customer: " + order.getCustomer().getName());
        System.out.println("Items:");
        for (Item item : order.getItems()) {
            System.out.printf("  - %s: %d x $%.2f = $%.2f%n",
                    item.getName(),
                    item.getQuantity(),
                    item.getPrice(),
                    item.getQuantity() * item.getPrice());
        }
        System.out.printf("Total Price: $%.2f%n", totalPrice);
    }
}
