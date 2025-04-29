package org.example;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // 1. أنشئ زبون (عضو)
        Customer customer = new Customer("Ali", true);

        // 2. أنشئ بعض المنتجات
        Item item1 = new Item("Book", 10.0, 2);
        Item item2 = new Item("Pen", 2.5, 4);
        List<Item> items = Arrays.asList(item1, item2);

        // 3. أنشئ الطلب
        Order order = new Order(customer, items);

        // 4. استخدم OrderProcessor لطباعة الملخص
        OrderProcessor processor = new OrderProcessor();
        processor.printOrderSummary(order);
    }
}
