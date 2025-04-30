package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class OrderProcessorTest {
    @Test
    public void testPrintOrderSummary() {
        Order order = new Order();
        order.setCustomer(new Customer("John", true));
        order.setItems(Arrays.asList(
            new Item("Book", 10.0, 2),
            new Item("Pen", 5.0, 2)
        ));

        OrderProcessor processor = new OrderProcessor();
        processor.printOrderSummary(order); 
    }
}