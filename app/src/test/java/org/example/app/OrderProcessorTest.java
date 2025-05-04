package org.example.app;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class OrderProcessorTest {

    @Test
    public void testPrintOrderSummary() {
        Customer customer = new Customer("Ali", true);
        List<Item> items = Arrays.asList(
                new Item("Book", 10.0, 2),
                new Item("Pen", 2.0, 5)
        );
        Order order = new Order(customer, items);
        OrderProcessor processor = new OrderProcessor();

        // هذا الاختبار فقط يشغل الدالة ويطبع، لا يتحقق من الناتج
        // سنحتاج إلى إعادة تصميم الكود لاختبار الناتج لاحقًا إن أردنا
        processor.printOrderSummary(order);
    }
}
