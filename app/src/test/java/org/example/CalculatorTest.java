package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void testCalcNormal() {
        double result = calculator.calc(10.0, 5.0);
        assertEquals(15.0 / 50.0, result, 0.0001);
    }

    @Test
    void testCalcDivideByZero() {
    double result = calculator.calc(0, 0);
    assertTrue(Double.isNaN(result));
    }


    @Test
    void testPrintResult() {
        // لا يوجد تحقق هنا لأنه يطبع فقط، لكن نجرب استدعاءه بدون خطأ
        calculator.prtRes(42.0);
    }
}
