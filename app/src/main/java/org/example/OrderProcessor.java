package org.example;

public class OrderProcessor {

    public String buildOrderSummary(Order order) {
        StringBuilder sb = new StringBuilder();
        double totalPrice = calculateTotalPrice(order);

        sb.append("Order Summary:\n");
        sb.append("Customer: ").append(order.getCustomer().getName()).append("\n");
        sb.append("Items:\n");
        for (Item item : order.getItems()) {
            double itemTotal = item.getQuantity() * item.getPrice();
            sb.append(String.format("  - %s: %d x $%.2f = $%.2f\n",
                    item.getName(), item.getQuantity(), item.getPrice(), itemTotal));
        }
        sb.append(String.format("Total Price: $%.2f\n", totalPrice));

        return sb.toString();
    }

    public void printOrderSummary(Order order) {
        System.out.print(buildOrderSummary(order));
    }

    private double calculateTotalPrice(Order order) {
        double totalPrice = 0;
        for (Item item : order.getItems()) {
            totalPrice += item.getPrice() * item.getQuantity();
        }
        if (order.getCustomer().isMember()) {
            totalPrice *= 0.9;
        }
        return totalPrice;
    }
}
