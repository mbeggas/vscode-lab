package org.example;

public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        
        int sum = calculator.add(10, 5);
        int product = calculator.multiply(10, 5);
        int subtract=calculator.subtract(6,5);
        int divide = calculator.divide(30, 10);
        String reversed = calculator.reverseString("Gradle");
        System.out.println("Sum: " + sum);
        System.out.println("Product: " + product);
        System.out.println(" subtract: " + subtract);
        System.out.println("divide: " + divide);
        System.out.println("Reversed String: " + reversed);
    }
    
}
