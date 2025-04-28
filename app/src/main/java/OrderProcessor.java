public class OrderProcessor {

    public void printOrderSummary(Order order) {
        double calculatedTotalPrice = calculateTotalPrice(order);
        double discountedTotalPrice = applyDiscount(order, calculatedTotalPrice);
        printSummary(order, discountedTotalPrice);
    }

    private double calculateTotalPrice(Order order) {
        double total = 0;
        for (Item currentItem : order.getItems()) {
            total += currentItem.getPrice() * currentItem.getQuantity();
        }
        return total;
    }

    private double applyDiscount(Order order, double total) {
        if (order.getCustomer().isMember()) {
            return total * 0.9; // 10% discount for members
        }
        return total;
    }

    private void printSummary(Order order, double totalPrice) {
        System.out.println("Order Summary:");
        System.out.println("Customer: " + order.getCustomer().getName());
        System.out.println("Items:");
        for (Item currentItem : order.getItems()) {
            System.out.printf("  - %s: %d x $%.2f = $%.2f%n",
                currentItem.getName(), currentItem.getQuantity(), currentItem.getPrice(),
                currentItem.getQuantity() * currentItem.getPrice());
        }
        System.out.printf("Total Price: $%.2f%n", totalPrice);
    }
}
