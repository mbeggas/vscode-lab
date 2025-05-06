package com.example;

public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        
        int sum = calculator.add(10, 5);
        int product = calculator.multiply(10, 5);
        int diff = calculator.subtract(10, 5);
        int div = calculator.divide(10, 5);

        String reversed = calculator.reverse("Gradle");

        System.out.println("Sum: " + sum);
        System.out.println("Product: " + product);
        System.out.println("Difference: " + diff);
        System.out.println("Division: " + div);
        System.out.println("Reversed: " + reversed);
    }
}