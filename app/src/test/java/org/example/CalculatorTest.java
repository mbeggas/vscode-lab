package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    @Test
    void testCalc() {
        Calculator calc = new Calculator();
        double result = calc.calculateRatio(10, 5); // (10+5)/(10*5) = 15/50 = 0.3
        assertEquals(0.3, result, 0.0001);
    }
}
