package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    @Test
    public void testCalc() {
        Calculator calc = new Calculator();
        double result = calc.calculateResult(4, 2);
        assertEquals(6.0 / 8.0, result, 0.0001);
    }
}
