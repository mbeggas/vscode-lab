package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    Calculator calc = new Calculator();

    @Test
    public void testCalc() {
        double result = calc.calc(4, 2);
        assertEquals(6.0 / 8.0, result, 0.0001);
    }
}
