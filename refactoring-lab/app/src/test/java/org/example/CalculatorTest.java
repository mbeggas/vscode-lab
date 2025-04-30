package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    @Test
    public void testCalc() {
        Calculator calculator = new Calculator();
        double result = calculator.calc(4, 2); // (4+2)/(4*2) = 6/8 = 0.75
        assertEquals(0.75, result, 0.0001);
    }
}
