package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

// تعريف بسيط للكلاسات كمساعد للاختبار، فقط لو ما عندك صلاحية تعدل الأصل
class TestCustomer extends Customer {
    public TestCustomer(String name, boolean isMember) {
        try {
            var nameField = Customer.class.getDeclaredField("name");
            nameField.setAccessible(true);
            nameField.set(this, name);

            var memberField = Customer.class.getDeclaredField("isMember");
            memberField.setAccessible(true);
            memberField.set(this, isMember);
        } catch (Exception ignored) {}
    }
}

class TestItem extends Item {
    public TestItem(String name, double price, int quantity) {
        try {
            var nameField = Item.class.getDeclaredField("name");
            nameField.setAccessible(true);
            nameField.set(this, name);

            var priceField = Item.class.getDeclaredField("price");
            priceField.setAccessible(true);
            priceField.set(this, price);

            var quantityField = Item.class.getDeclaredField("quantity");
            quantityField.setAccessible(true);
            quantityField.set(this, quantity);
        } catch (Exception ignored) {}
    }
}

class TestOrder extends Order {
    public TestOrder(Customer customer, List<Item> items) {
        try {
            var customerField = Order.class.getDeclaredField("customer");
            customerField.setAccessible(true);
            customerField.set(this, customer);

            var itemsField = Order.class.getDeclaredField("items");
            itemsField.setAccessible(true);
            itemsField.set(this, items);
        } catch (Exception ignored) {}
    }
}

public class OrderProcessorTest {

    @Test
    void testPrintOrderSummaryForMember() {
        Customer customer = new TestCustomer("Ali", true);
        Item item1 = new TestItem("Book", 10.0, 2);
        Item item2 = new TestItem("Pen", 2.5, 4);
        Order order = new TestOrder(customer, List.of(item1, item2));

        OrderProcessor processor = new OrderProcessor();
        processor.printOrderSummary(order);
    }

    @Test
    void testPrintOrderSummaryForNonMember() {
        Customer customer = new TestCustomer("Sara", false);
        Item item1 = new TestItem("Notebook", 8.0, 3);
        Order order = new TestOrder(customer, List.of(item1));

        OrderProcessor processor = new OrderProcessor();
        processor.printOrderSummary(order);
    }
}
