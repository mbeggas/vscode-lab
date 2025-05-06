package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    @Test
    public void testCalc() {
        Calculator calc = new Calculator();
        double result = calc.calc(4, 2);
        assertEquals(1.5, result, 0.01);
    }
}
