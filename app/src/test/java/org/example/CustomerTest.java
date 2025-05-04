package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    @Test
    public void testGetName() {
        Customer customer = new Customer("John", true);
        assertEquals("John", customer.getName());
    }

    @Test
    public void testIsMember() {
        Customer customer = new Customer("Alice", false);
        assertFalse(customer.isMember());
        
        customer = new Customer("Bob", true);
        assertTrue(customer.isMember());
    }
}
