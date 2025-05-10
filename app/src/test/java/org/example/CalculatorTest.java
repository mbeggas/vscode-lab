package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
     void testCalculate() {
        double result = calculator.calculate(10, 4);
        assertEquals(8.0 / 15.0, result, 0.0001);
    }
}