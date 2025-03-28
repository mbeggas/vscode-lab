package org.example;
public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        
        int sum = calculator.add(10,5);
        int product = calculator.multiply(10, 5);
        int difference = calculator.subtract(10, 5);
        int quotient = calculator.divide(10 ,5);
        String reverse = calculator.reverseString("hello");

        System.out.println("Sum: " + sum);
        System.out.println("Product: " + product);
        System.out.println("Difference: " + difference);
        System.out.println("Quotient: " + quotient);
        System.out.println("Reversed String: " + reverse);
    }
}