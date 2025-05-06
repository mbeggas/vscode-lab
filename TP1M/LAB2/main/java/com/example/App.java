package com.example;

public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        int sum = calculator.add(10, 5);
        int product = calculator.multiply(10, 5);
        int difference = calculator.subtract(10, 5);
        double quotient = calculator.divide(10, 5);

        System.out.println("Sum: " + sum);
        System.out.println("Product: " + product);
        System.out.println("Difference: " + difference);
        System.out.println("Quotient: " + quotient);

        String reversed = calculator.reverse("Gradle");
        System.out.println("Reversed: " + reversed);
    }
}
