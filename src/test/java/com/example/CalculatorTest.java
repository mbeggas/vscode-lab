package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void testCalculateBasic() {
        double result = calculator.calculate(2, 3);
        assertEquals(5.0/6.0, result, 1e-6, "calculate(2,3) يجب أن تكون (2+3)/(2*3)");
    }

    @Test
    void testCalculateZeros() {
        double result = calculator.calculate(0, 5);
        assertTrue(Double.isInfinite(result), "قسمة على صفر يجب أن تُرجع Infinity");
    }

    @Test
    void testPrintResultOutput() {
        double value = 1.2345;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        calculator.printResult(value);

        String printed = out.toString().trim();
        assertEquals("Result: 1.2345", printed, "طريقة printResult يجب أن تطبع النتيجة بالشكل الصحيح");
    }
}