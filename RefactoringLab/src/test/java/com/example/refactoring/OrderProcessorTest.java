package com.example.refactoring;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class OrderProcessorTest {

    @Test
    public void testPrintOrderSummary() {
        Customer customer = new Customer("Alice", true);
        List<Item> items = Arrays.asList(
            new Item("Apple", 1.0, 5),
            new Item("Banana", 0.5, 10)
        );
        Order order = new Order(customer, items);
        OrderProcessor processor = new OrderProcessor();
        processor.printOrderSummary(order);
    }
}