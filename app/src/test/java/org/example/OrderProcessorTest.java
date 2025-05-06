package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class OrderProcessorTest {
    private OrderProcessor processor;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        processor = new OrderProcessor(new PrintStream(outputStream));
    }

    @Test
    void testPrintOrderSummaryForMember() {
        Customer customer = createTestCustomer("Ali", true);
        List<Item> items = List.of(
            createTestItem("Book", 10.0, 2),
            createTestItem("Pen", 2.5, 4)
        );
        Order order = createTestOrder(customer, items);

        processor.printOrderSummary(order);
        
        String output = outputStream.toString();
        assertTrue(output.contains("Customer: Ali"));
        assertTrue(output.contains("Book: 2 x $10.00 = $20.00"));
        assertTrue(output.contains("Pen: 4 x $2.50 = $10.00"));
        assertTrue(output.contains("Total Price: $27.00")); // 30 with 10% discount
    }

    @Test
    void testPrintOrderSummaryForNonMember() {
        Customer customer = createTestCustomer("Sara", false);
        List<Item> items = List.of(
            createTestItem("Notebook", 8.0, 3)
        );
        Order order = createTestOrder(customer, items);

        processor.printOrderSummary(order);
        
        String output = outputStream.toString();
        assertTrue(output.contains("Customer: Sara"));
        assertTrue(output.contains("Notebook: 3 x $8.00 = $24.00"));
        assertTrue(output.contains("Total Price: $24.00")); // No discount
    }

    @Test
    void testEmptyOrder() {
        Customer customer = createTestCustomer("Empty", true);
        Order order = createTestOrder(customer, List.of());

        processor.printOrderSummary(order);
        
        String output = outputStream.toString();
        assertTrue(output.contains("Customer: Empty"));
        assertTrue(output.contains("Total Price: $0.00"));
    }

    @Test
    void testOrderWithZeroPriceItem() {
        Customer customer = createTestCustomer("Zero", false);
        List<Item> items = List.of(
            createTestItem("Free Item", 0.0, 5)
        );
        Order order = createTestOrder(customer, items);

        processor.printOrderSummary(order);
        
        String output = outputStream.toString();
        assertTrue(output.contains("Free Item: 5 x $0.00 = $0.00"));
        assertTrue(output.contains("Total Price: $0.00"));
    }

    // Test helper methods
    private Customer createTestCustomer(String name, boolean isMember) {
        return new TestCustomer(name, isMember);
    }

    private Item createTestItem(String name, double price, int quantity) {
        return new TestItem(name, price, quantity);
    }

    private Order createTestOrder(Customer customer, List<Item> items) {
        return new TestOrder(customer, items);
    }
}