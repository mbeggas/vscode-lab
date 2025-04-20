package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class OrderProcessorTest {

    private OrderProcessor processor;
    private Customer memberCustomer;
    private Customer guestCustomer;
    private Item itemA;
    private Item itemB;

    @BeforeEach
    void setUp() {
        processor = new OrderProcessor();
        memberCustomer = new Customer("Alice", true);
        guestCustomer  = new Customer("Bob", false);
        itemA = new Item("Widget", 10.0, 2);
        itemB = new Item("Gadget", 5.0, 4);
    }

    @Test
    void testPrintOrderSummaryForGuest() {
        Order order = new Order(guestCustomer, Arrays.asList(itemA, itemB));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        processor.printOrderSummary(order);

        String s = out.toString();
        assertTrue(s.contains("Order Summary:"));
        assertTrue(s.contains("Customer: Bob"));
        assertTrue(s.contains("Widget"));
        assertTrue(s.contains("Gadget"));
        assertTrue(s.contains("Total Price: $40.00"));
    }

    @Test
    void testPrintOrderSummaryForMember() {
        Order order = new Order(memberCustomer, Arrays.asList(itemA, itemB));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        processor.printOrderSummary(order);

        String s = out.toString();
        assertTrue(s.contains("Customer: Alice"));
        assertTrue(s.contains("Total Price: $36.00"));
    }
}