package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class OrderProcessorTest {

    @Test
    public void testPrintOrderSummary_forMemberCustomer() {
        // Set up order data
        Customer customer = new Customer();
        setPrivateField(customer, "name", "Alice");
        setPrivateField(customer, "isMember", true);

        Item item1 = new Item();
        setPrivateField(item1, "name", "Pen");
        setPrivateField(item1, "price", 1.50);
        setPrivateField(item1, "quantity", 2);

        Item item2 = new Item();
        setPrivateField(item2, "name", "Notebook");
        setPrivateField(item2, "price", 3.00);
        setPrivateField(item2, "quantity", 1);

        Order order = new Order();
        setPrivateField(order, "customer", customer);
        setPrivateField(order, "items", Arrays.asList(item1, item2));

        // Capture console output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Run method
        OrderProcessor processor = new OrderProcessor();
        processor.printOrderSummary(order);

        // Restore System.out
        System.setOut(System.out);

        // Assert output contains expected values
        String output = outContent.toString();
        assertTrue(output.contains("Customer: Alice"));
        assertTrue(output.contains("Pen"));
        assertTrue(output.contains("Notebook"));
        assertTrue(output.contains("Total Price: $5.40")); // (1.5*2 + 3.0*1) * 0.9 = 5.40
    }

    // Helper to set private fields via reflection
    private void setPrivateField(Object obj, String fieldName, Object value) {
        try {
            var field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            throw new RuntimeException("Failed to set private field", e);
        }
    }
}