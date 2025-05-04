package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class OrderTest {

    @Test
    public void testOrder() {
        // إنشاء بيانات لاختبارها
        Customer customer = new Customer("Alice", false);
        Item item1 = new Item("Phone", 300.00, 1);
        Item item2 = new Item("Charger", 20.00, 2);
        List<Item> items = List.of(item1, item2);

        // إنشاء الكائن
        Order order = new Order(customer, items);

        // اختبار إذا كانت القيم صحيحة
        assertEquals("Alice", order.getCustomer().getName());
        assertEquals(2, order.getItems().size());
        assertEquals("Phone", order.getItems().get(0).getName());
    }
}
