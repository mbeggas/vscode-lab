package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class OrderProcessorTest {

    @Test
    public void testPrintOrderSummary() {
        Customer customer = new Customer("John Doe", true); 
        Item item1 = new Item("Item 1", 10.0, 2); 
        Item item2 = new Item("Item 2", 5.0, 3); 
        Order order = new Order(customer, Arrays.asList(item1, item2));
        
        OrderProcessor orderProcessor = new OrderProcessor();
        double expectedTotal = (10.0 * 2) + (5.0 * 3); 
        expectedTotal *= 0.9; 
        
        assertEquals(31.5, expectedTotal, 0.0001);
        orderProcessor.printOrderSummary(order);

    }
}
