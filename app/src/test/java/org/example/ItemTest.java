package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {

    @Test
    public void testGetName() {
        Item item = new Item("Laptop", 1200.0, 1);
        assertEquals("Laptop", item.getName());
    }

    @Test
    public void testGetPrice() {
        Item item = new Item("Laptop", 1200.0, 1);
        assertEquals(1200.0, item.getPrice());
    }

    @Test
    public void testGetQuantity() {
        Item item = new Item("Laptop", 1200.0, 3);
        assertEquals(3, item.getQuantity());
    }
}
