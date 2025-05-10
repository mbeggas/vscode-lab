package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    void testCalc() {
        double result = calculator.calc(3, 5);
        assertEquals(8.0 / 15.0, result);
    }
}