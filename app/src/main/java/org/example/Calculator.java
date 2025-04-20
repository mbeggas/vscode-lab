package org.example;

public class Calculator {
    public double calculateSumDividedByProduct(double a, double b) {
        double sum = a + b;
        double product = a * b;
        return sum / product;
    }

    public void printResult(double result) {
        System.out.println("Result: " + result);
    }
}

