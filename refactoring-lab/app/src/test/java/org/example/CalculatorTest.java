package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    void testCalc() {
        double result = calculator.calc(4, 2);
        assertEquals(6.0 / 8.0, result);
    }
}
