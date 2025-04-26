package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    void testAddition() {
        assertEquals(15, calculator.add(10, 5));
        assertEquals(0, calculator.add(-5, 5));
    }

    @Test
    void testMultiplication() {
        assertEquals(50, calculator.multiply(10, 5));
        assertEquals(0, calculator.multiply(0, 5));
    }

    @Test
    void testSubtraction() {
        assertEquals(5, calculator.subtract(10, 5));
        assertEquals(-10, calculator.subtract(5, 15));
    }

    @Test
    void testDivision() {
        assertEquals(2, calculator.divide(10, 5));
        assertEquals(0, calculator.divide(0, 5));
    }

    @Test
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
    }

    @Test
    void testReverseString() {
        assertEquals("olleh", calculator.reverseString("hello"));
        assertEquals("", calculator.reverseString(""));
    }
}