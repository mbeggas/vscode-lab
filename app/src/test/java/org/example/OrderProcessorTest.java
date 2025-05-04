package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

class OrderProcessorTest {
    @Test
    void testPrintOrderSummary() {
        Customer customer = new Customer("Alice", true);
        Item item1 = new Item("Book", 10.0, 2);
        Item item2 = new Item("Pen", 2.0, 5);
        Order order = new Order(customer, List.of(item1, item2));

        OrderProcessor processor = new OrderProcessor();
        processor.printOrderSummary(order);
    }
}
