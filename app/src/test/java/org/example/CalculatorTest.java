package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void TSAAM() {
        Calculator calculator = new Calculator();
        double result = calculator.calc(2, 2);
        assertEquals(1.0, result, 0.0001);
    }

    @Test
    void TSWZI() {
        Calculator calculator = new Calculator();
        double result = calculator.calc(0, 1);
        assertTrue(Double.isInfinite(result));
    }

    @Test
    void TSPR() {
        Calculator calculator = new Calculator();
        calculator.prtRes(1);
    }
}