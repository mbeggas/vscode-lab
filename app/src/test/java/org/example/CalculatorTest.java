package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void testCalculateCombinedNormal() {
    double result = calculator.calculateCombined(10.0, 5.0);
    assertEquals(15.0 / 50.0, result, 0.0001);
    }

    @Test
    void testCalcDivideByZero() {
    double result = calculator.calculateCombined(0, 0);
    assertTrue(Double.isNaN(result));
    }


    @Test
    void testPrintResult() {
    calculator.printResult(42.0);
    }
}
