package com.example.refactoring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    public void testCalculateResult() {
        Calculator calculator = new Calculator();
        double result = calculator.calculateResult(2, 3);
        assertEquals(5.0/6.0, result, 0.0001);
    }
}