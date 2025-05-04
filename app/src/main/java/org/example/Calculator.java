package org.example;

public class Calculator {
    public double calculateResult(double number1, double number2) {
        double sum = number1 + number2;
        double product = number1 * number2;
        return sum / product;
    }

    public void printResult(double result) {
        System.out.println("Result: " + result);
    }
}