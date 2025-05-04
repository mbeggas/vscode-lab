package org.example.app;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        assertEquals(15, calculator.add(10, 5));
    }

    @Test
    public void testMultiply() {
        Calculator calculator = new Calculator();
        assertEquals(50, calculator.multiply(10, 5));
    }

    @Test
    public void testSubtract() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.subtract(10, 5));
        assertEquals(-5, calculator.subtract(5, 10));
    }

    @Test
    public void testDivide() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.divide(10, 5));
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(10, 0));
    }

    // اختبار دالة عكس السلسلة
    @Test
    public void testReverseString() {
        Calculator calculator = new Calculator();
        assertEquals("gnitset", calculator.reverseString("testing"));
        assertEquals("12345", calculator.reverseString("54321"));
    }
}
