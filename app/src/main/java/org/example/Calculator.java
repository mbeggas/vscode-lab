package org.example;

import java.io.PrintStream;
import java.util.Objects;

public class Calculator {
    private final PrintStream output;

    // Default constructor uses System.out
    public Calculator() {
        this(System.out);
    }

    // Constructor with dependency injection for output stream
    public Calculator(PrintStream output) {
        this.output = Objects.requireNonNull(output, "Output stream cannot be null");
    }

    /**
     * Calculates the combined operation result of (a + b) / (a * b)
     * @param a First operand
     * @param b Second operand (cannot be zero if a is zero)
     * @return Result of the calculation
     * @throws ArithmeticException if division by zero would occur
     * @throws IllegalArgumentException if either parameter is NaN or infinite
     */
    public double calculateCombined(double a, double b) {
        validateInput(a, b);
        checkForDivisionByZero(a, b);
        
        double sum = a + b;
        double product = a * b;
        return sum / product;
    }

    /**
     * Prints the result to the configured output stream
     * @param result The value to print
     */
    public void printResult(double result) {
        output.printf("Calculation Result: %.4f%n", result);
    }

    private void validateInput(double a, double b) {
        if (Double.isNaN(a) || Double.isNaN(b)) {
            throw new IllegalArgumentException("Operands cannot be NaN");
        }
        if (Double.isInfinite(a) || Double.isInfinite(b)) {
            throw new IllegalArgumentException("Operands cannot be infinite");
        }
    }

    private void checkForDivisionByZero(double a, double b) {
        if (a == 0 && b == 0) {
            throw new ArithmeticException("Division by zero - both operands are zero");
        }
        if (Math.abs(a * b) < Double.MIN_VALUE) {
            throw new ArithmeticException("Potential division by zero - product is too small");
        }
    }

    /**
     * Static utility version that doesn't require instance creation
     * @param a First operand
     * @param b Second operand
     * @return Result of the calculation
     */
    public static double calculate(double a, double b) {
        return new Calculator().calculateCombined(a, b);
    }
}