package org.example;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {

        Customer customer = new Customer("Rade", true);

        Item item1 = new Item("Book", 10.0, 2);
        Item item2 = new Item("Pen", 2.5, 4);
        List<Item> items = Arrays.asList(item1, item2);

        Order order = new Order(customer, items);

        OrderProcessor processor = new OrderProcessor();
        processor.printOrderSummary(order);
    }
}
