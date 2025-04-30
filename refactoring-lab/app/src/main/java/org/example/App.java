package org.example;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        // Demonstrate Calculator
        Calculator calculator = new Calculator();
        double result = calculator.calculateRatio(10, 5);
        calculator.printResult(result);

        // Demonstrate OrderProcessor
        Customer customer = new Customer("Alice", true);
        Item item1 = new Item("Pen", 2.0, 3);       // $6.0
        Item item2 = new Item("Notebook", 5.0, 2);  // $10.0
        Order order = new Order(customer, Arrays.asList(item1, item2));

        OrderProcessor processor = new OrderProcessor();
        processor.printOrderSummary(order);
    }
}
