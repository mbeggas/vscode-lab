package org.example;

public class Calculator {
     public double calculate(double a, double b) {
        double sum = add(a, b);
        double product = multiply(a, b);
        return divide(sum, product);
    }

    public void printResult(double result) {
        System.out.println("Result: " + result);
    }

    private double add(double a, double b) {
        return a + b;
    }

    private double multiply(double a, double b) {
        return a * b;
    }

    public void prtRes(double res) {
        System.out.println("Result: " + res);
    }
    
    private double divide(double numerator, double denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return numerator / denominator;
    }
}