package org.example;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class OrderProcessorTest {

    @Test
    void TPOSFNM() {
        Customer customer = new Customer("John Doe", false);
        List<Item> items = Arrays.asList(
                new Item("Laptop", 1000, 1),
                new Item("Mouse", 30, 2));
        Order order = new Order(customer, items);
        OrderProcessor processor = new OrderProcessor();

        assertDoesNotThrow(() -> processor.printOrderSummary(order));
    }

    @Test
    void TPOSFM() {
        Customer customer = new Customer("Jane Smith", true);
        List<Item> items = Arrays.asList(
                new Item("Keyboard", 50, 1),
                new Item("Monitor", 200, 1));
        Order order = new Order(customer, items);
        OrderProcessor processor = new OrderProcessor();

        assertDoesNotThrow(() -> processor.printOrderSummary(order));
    }

    @Test
    void TPOSWEI() {
        Customer customer = new Customer("Empty Cart", false);
        List<Item> items = Arrays.asList();
        Order order = new Order(customer, items);
        OrderProcessor processor = new OrderProcessor();

        assertDoesNotThrow(() -> processor.printOrderSummary(order));
    }

    @Test
    void TPOSWSI() {
        Customer customer = new Customer("Single Item", true);
        List<Item> items = Arrays.asList(
                new Item("Headphones", 80, 1));
        Order order = new Order(customer, items);
        OrderProcessor processor = new OrderProcessor();

        assertDoesNotThrow(() -> processor.printOrderSummary(order));
    }
}