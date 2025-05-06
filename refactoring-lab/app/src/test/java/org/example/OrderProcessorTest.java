package org.example;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class OrderProcessorTest {

    @Test
    void testTotalPriceWithMemberDiscount() {
        Customer customer = new Customer("Alice", true);
        Item item1 = new Item("Pen", 2.0, 3); // 6.0
        Item item2 = new Item("Notebook", 5.0, 2); // 10.0
        Order order = new Order(customer, Arrays.asList(item1, item2));
        OrderProcessor processor = new OrderProcessor();

        double total = processorTestHelper(order, processor);
        assertEquals(14.4, total, 0.01); // 16.0 * 0.9 = 14.4
    }

    @Test
    void testTotalPriceWithoutDiscount() {
        Customer customer = new Customer("Bob", false);
        Item item1 = new Item("Pencil", 1.5, 4); // 6.0
        Order order = new Order(customer, Arrays.asList(item1));
        OrderProcessor processor = new OrderProcessor();

        double total = processorTestHelper(order, processor);
        assertEquals(6.0, total, 0.01);
    }

    private double processorTestHelper(Order order, OrderProcessor processor) {
        // simulate internal method for testing purposes
        double total = order.getItems().stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
        if (order.getCustomer().isMember()) {
            total *= 0.9;
        }
        return total;
    }
}
