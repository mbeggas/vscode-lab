public class OrderProcessor {
    public void printOrderSummary(Order order) {
        double totalPrice = calculateTotalPrice(order);

        printHeader(order);
        printItems(order);
        printTotal(totalPrice);
    }

    private double calculateTotalPrice(Order order) {
        double total = 0;
        for (Item item : order.getItems()) {
            total += item.getPrice() * item.getQuantity();
        }
        if (order.getCustomer().isMember()) {
            total *= 0.9;
        }
        return total;
    }

    private void printHeader(Order order) {
        System.out.println("Order Summary:");
        System.out.println("Customer: " + order.getCustomer().getName());
        System.out.println("Items:");
    }

    private void printItems(Order order) {
        for (Item item : order.getItems()) {
            System.out.println("  - " + item.getName() + ": " + item.getQuantity() +
                               " x $" + item.getPrice() + " = $" + (item.getQuantity() * item.getPrice()));
        }
    }

    private void printTotal(double totalPrice) {
        System.out.printf("Total Price: $%.2f%n", totalPrice);
    }
}
