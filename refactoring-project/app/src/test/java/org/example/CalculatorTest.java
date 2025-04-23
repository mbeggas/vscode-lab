package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void testCalc() {
        Calculator calculator = new Calculator();
        double result = calculator.calc(6, 3); // (6+3)/(6*3) = 9/18 = 0.5
        assertEquals(0.5, result, 0.0001);
    }
}
