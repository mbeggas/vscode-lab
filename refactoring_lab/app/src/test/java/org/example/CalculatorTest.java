package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    void testCalc() {
        double result = calculator.calc(4, 2); // (4+2)/(4*2) = 6/8 = 0.75
        assertEquals(0.75, result, 0.0001);
    }
}
