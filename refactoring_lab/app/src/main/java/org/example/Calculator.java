package org.example;

public class Calculator {
    public calculateRatio(double first, double second) {
        double sum = first + second;
        double product = first * second;
        return sum / product;
    }

    public void printResult(double result) {
        System.out.println("Result: " + result);
    }
}
