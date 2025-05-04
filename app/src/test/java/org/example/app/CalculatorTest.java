package org.example.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void testCalculateRatio() {
        Calculator calculator = new Calculator();
        double result = calculator.calculateRatio(4, 2); // (4+2)/(4*2) = 6/8 = 0.75
        assertEquals(0.75, result, 0.0001);
    }

    @Test
    public void testCalculateRatioWithZeroProduct() {
        Calculator calculator = new Calculator();
        double result = calculator.calculateRatio(0, 0); // 0+0 / 0*0 = 0/0 => NaN
        assertTrue(Double.isNaN(result));
    }
}
