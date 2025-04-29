package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        calculator = new Calculator(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("Normal calculation - positive numbers")
    void testCalculateCombinedNormal() {
        double result = calculator.calculateCombined(10.0, 5.0);
        assertEquals((10.0 + 5.0) / (10.0 * 5.0), result, 0.0001);
    }

    @Test
    @DisplayName("Calculation with negative numbers")
    void testCalculateCombinedWithNegatives() {
        double result = calculator.calculateCombined(-2.0, 3.0);
        assertEquals((-2.0 + 3.0) / (-2.0 * 3.0), result, 0.0001);
    }

    @Test
    @DisplayName("Division by zero - both operands zero")
    void testCalcDivideByZeroBothZero() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculateCombined(0, 0);
        });
    }

    @Test
    @DisplayName("Division by zero - product underflows")
    void testCalcDivideByZeroUnderflow() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculateCombined(Double.MIN_VALUE, Double.MIN_VALUE);
        });
    }

    @Test
    @DisplayName("NaN input handling")
    void testCalculateCombinedWithNaN() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateCombined(Double.NaN, 5.0);
        });
    }

    @Test
    @DisplayName("Infinite input handling")
    void testCalculateCombinedWithInfinity() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateCombined(Double.POSITIVE_INFINITY, 5.0);
        });
    }

    @Test
    @DisplayName("Print result format verification")
    void testPrintResult() {
        calculator.printResult(42.123456);
        assertEquals("Calculation Result: 42.1235" + System.lineSeparator(), 
                     outputStreamCaptor.toString());
    }

    @Test
    @DisplayName("Static utility method test")
    void testStaticCalculate() {
        double result = Calculator.calculate(4.0, 2.0);
        assertEquals((4.0 + 2.0) / (4.0 * 2.0), result, 0.0001);
    }
}