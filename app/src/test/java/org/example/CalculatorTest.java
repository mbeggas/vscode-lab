package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    public void testCalc() {
        double result = calculator.calculateSumDividedByProduct(10, 2);  // (10+2)/(10*2) = 12/20 = 0.6
        assertEquals(0.6, result, 0.0001);
    }
}