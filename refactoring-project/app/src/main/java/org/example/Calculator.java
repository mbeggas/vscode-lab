package org.example;

public class Calculator{
    public double calculate(double num1, double num2) {
        double sum = num1 + num2;
        double product = num1 * num2;
        return sum / product;
    }
    
    public void printResult(double res) {
        System.out.println("Result: " + res);
    }
}
    
    