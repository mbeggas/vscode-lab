package org.example;

public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        int sum = calculator.addNumbers(10, 5);
        int product = calculator.multiplyNumbers(10, 5);

        displayResults(sum, product);
    }

    private static void displayResults(int sum, int product) {
        System.out.println("Sum: " + sum);
        System.out.println("Product: " + product);
    }

    public String getGreeting() {
        return "Hello, world!";
    }
}
