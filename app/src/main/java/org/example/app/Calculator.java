package org.example.app;

public class Calculator {

    /**
     * Calculates the ratio of the sum and the product of two numbers.
     *
     * @param a first input number
     * @param b second input number
     * @return result of (a + b) / (a * b), or Double.NaN if product is zero
     */
    public double calculateRatio(double a, double b) {
        double sum = a + b;
        double product = a * b;

        if (product == 0) {
            System.err.println("Error: Division by zero in calculateRatio.");
            return Double.NaN;
        }

        return sum / product;
    }

    /**
     * Prints the result in a formatted way.
     *
     * @param result the result to print
     */
    public void printResult(double result) {
        System.out.println("Result: " + result);
    }
}

