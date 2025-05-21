import java.util.List;

public class OrderProcessor {
    public void printOrderSummary(Order order) {
        double totalPrice = 0;
        for (Item item : order.getItems()) {
            totalPrice += item.getPrice() * item.getQuantity();
        }

        if (order.getCustomer().isMember()) {
            totalPrice *= 0.9;
        }

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
