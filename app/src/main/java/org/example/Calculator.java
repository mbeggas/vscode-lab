package org.example;

public class Calculator {
    public double calculateCombined(double a, double b) {
        double sum = a + b;
        double product = a * b;
        return sum / product;
    }

    public void printResult(double res) {
        System.out.println("Result: " + res);
    }
}