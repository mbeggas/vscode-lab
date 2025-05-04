package org.example.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void testCalc() {
        Calculator calc = new Calculator();
        double result = calc.calc(4, 2); // (4+2)/(4*2) = 6/8 = 0.75
        assertEquals(0.75, result, 0.0001);
    }
}
