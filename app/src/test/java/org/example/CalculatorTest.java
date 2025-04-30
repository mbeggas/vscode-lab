package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testCalculateSumProductRatio() {
        Calculator calculator = new Calculator();
        double result = calculator.calculateSumProductRatio(2.0, 2.0);
        assertEquals(1.0, result, 0.0001);
    }

    @Test
    void testWithZeroInput() {
        Calculator calculator = new Calculator();
        double result = calculator.calculateSumProductRatio(0.0, 1.0);
        assertTrue(Double.isInfinite(result));
    }

    @Test
    void testPrintResult() {
        Calculator calculator = new Calculator();
        calculator.printResult(1.0);
    }
}