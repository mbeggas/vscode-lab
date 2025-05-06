package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class AppTest {

    @Test
    public void testCalculator() {
        Calculator calculator = new Calculator();
        
        // Test calculation of ratio
        double result = calculator.calculateRatio(10, 5);
        assertEquals(0.3, result, 0.001);

    }

    @Test
    public void testOrderProcessor() {
        Customer customer = new Customer("Alice", true);
        Item item1 = new Item("Pen", 2.0, 3);  // $6.0
        Item item2 = new Item("Notebook", 5.0, 2); // $10.0
        Order order = new Order(customer, Arrays.asList(item1, item2));
        
        OrderProcessor processor = new OrderProcessor();
        processor.printOrderSummary(order);

    }
}
