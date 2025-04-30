package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class OrderProcessorTest {
    private OrderProcessor orderProcessor;
    private OrderProcessor.Customer memberCustomer;
    private OrderProcessor.Customer nonMemberCustomer;
    private OrderProcessor.Item item1;
    private OrderProcessor.Item item2;

    @BeforeEach
    void setUp() {
        orderProcessor = new OrderProcessor();
        memberCustomer = new OrderProcessor.Customer("Jane Smith", true);
        nonMemberCustomer = new OrderProcessor.Customer("John Doe", false);
        item1 = new OrderProcessor.Item("Book", 10.0, 2);
        item2 = new OrderProcessor.Item("Pen", 2.0, 3);
    }

    @Test
    void testPrintOrderSummaryForNonMember() {
        List<OrderProcessor.Item> items = Arrays.asList(item1, item2);
        OrderProcessor.Order order = new OrderProcessor.Order(nonMemberCustomer, items);
        assertDoesNotThrow(() -> orderProcessor.printOrderSummary(order));
    }

    @Test
    void testPrintOrderSummaryForMember() {
        List<OrderProcessor.Item> items = Arrays.asList(item1, item2);
        OrderProcessor.Order order = new OrderProcessor.Order(memberCustomer, items);
        assertDoesNotThrow(() -> orderProcessor.printOrderSummary(order));
    }

    @Test
    void testPrintOrderSummaryWithEmptyItems() {
        OrderProcessor.Order order = new OrderProcessor.Order(nonMemberCustomer, Arrays.asList());
        assertDoesNotThrow(() -> orderProcessor.printOrderSummary(order));
    }

    @Test
    void testPrintOrderSummaryWithSingleItem() {
        OrderProcessor.Order order = new OrderProcessor.Order(memberCustomer, Arrays.asList(item1));
        assertDoesNotThrow(() -> orderProcessor.printOrderSummary(order));
    }

    @Test
    void testOrderProcessorWithCustomCalculationService() {
        OrderProcessor.CalculationService customService = new OrderProcessor.CalculationService();
        OrderProcessor processor = new OrderProcessor(customService);

        List<OrderProcessor.Item> items = Arrays.asList(item1, item2);
        OrderProcessor.Order order = new OrderProcessor.Order(memberCustomer, items);

        assertDoesNotThrow(() -> processor.printOrderSummary(order));
    }
}
