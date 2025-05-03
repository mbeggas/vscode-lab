package org.example.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void testCalculateExpression() {
        Calculator calc = new Calculator();
        double result = calc.calculateExpression(4, 2); 
        assertEquals(0.75, result, 0.0001);
    }
}
