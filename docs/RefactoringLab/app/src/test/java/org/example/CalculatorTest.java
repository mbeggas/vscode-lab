package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    public void testCalculateRatioOfSumToProduct() {
        Calculator calculator = new Calculator();
        double result = calculator.calculateRatioOfSumToProduct(4, 2);
        assertEquals(0.75, result, 0.0001);
    }
}
