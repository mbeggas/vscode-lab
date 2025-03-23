package org.example;

import org.example.Calculator;

public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        int sum = calculator.add(20, 8);
        int product = calculator.multiply(7, 3);
        int subtract = calculator.subtract(15, 4);
        int divide = calculator.divide(50, 5);
        String reversed = calculator.reverseString("Gradle");

        System.out.println("The total sum is: " + sum);
        System.out.println("Multiplication result: " + product);
        System.out.println("Difference between numbers: " + subtract);
        System.out.println("Division outcome: " + divide);
        System.out.println("Reversed word: " + reversed);
    }
}
