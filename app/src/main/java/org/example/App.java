package org.example;

import org.example.Calculator;

public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        int product = calculator.multiply(5, 7);
        int sum = calculator.add(5, 7);
        int subtract = calculator.subtract(5, 7);
        int divide = calculator.divide(0, 7);
        String reversed = calculator.reverseString("Amara");

        System.out.println("the Multiplication result: " + product);
        System.out.println("The total sum is: " + sum);
        System.out.println("the Difference between numbers: " + subtract);
        System.out.println("the Division outcome: " + divide);
        System.out.println("the Reversed word: " + reversed);
    }
}
