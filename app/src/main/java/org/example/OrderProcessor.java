package org.example;

import java.util.List;

public class OrderProcessor {
    static class Customer {
        private String name;
        private boolean isMember;

        public Customer(String name, boolean isMember) {
            this.name = name;
            this.isMember = isMember;
        }

        public String getName() {
            return name;
        }

        public boolean isMember() {
            return isMember;
        }
    }

    static class Item {
        private String name;
        private double price;
        private int quantity;

        public Item(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }
    }

    static class Order {
        private Customer customer;
        private List<Item> items;

        public Order(Customer customer, List<Item> items) {
            this.customer = customer;
            this.items = items;
        }

        public Customer getCustomer() {
            return customer;
        }

        public List<Item> getItems() {
            return items;
        }
    }

    private final CalculationService calculationService;

    public OrderProcessor() {
        this.calculationService = new CalculationService();
    }

    public OrderProcessor(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    static class CalculationService {
        public double calculateTotalPrice(List<Item> items) {
            double totalPrice = 0;
            for (Item item : items) {
                totalPrice += item.getPrice() * item.getQuantity();
            }
            return totalPrice;
        }

        public double applyDiscount(double totalPrice, boolean isMember) {
            if (isMember) {
                return totalPrice * 0.9; // 10% discount for members
            }
            return totalPrice;
        }
    }

    public void printOrderSummary(Order order) {
        double totalPrice = calculationService.calculateTotalPrice(order.getItems());
        totalPrice = calculationService.applyDiscount(totalPrice, order.getCustomer().isMember());
        printSummary(order, totalPrice);
    }

    private void printSummary(Order order, double totalPrice) {
        System.out.println("Order Summary:");
        System.out.println("Customer: " + order.getCustomer().getName());
        printItems(order.getItems());
        System.out.printf("Total Price: $%.2f%n", totalPrice);
    }

    private void printItems(List<Item> items) {
        System.out.println("Items:");
        for (Item item : items) {
            System.out.printf("  - %s: %d x $%.2f = $%.2f%n",
                    item.getName(),
                    item.getQuantity(),
                    item.getPrice(),
                    item.getQuantity() * item.getPrice());
        }
    }
}
