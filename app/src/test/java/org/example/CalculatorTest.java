package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    public void testAddition() {
        assertEquals(15, calculator.add(10, 5));
        assertEquals(0, calculator.add(-5, 5));
    }

    @Test
    public void testMultiplication() {
        assertEquals(50, calculator.multiply(10, 5));
        assertEquals(0, calculator.multiply(0, 5));
    }
    @Test
    void testSubtraction() {
        assertEquals(5, calculator.subtract(10, 5));
        assertEquals(-15, calculator.subtract(-10, 5));
    }

    @Test
    void testDivision() {
        assertEquals(2.0, calculator.divide(10, 5));
        assertEquals(0.5, calculator.divide(5, 10));
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(5, 0));
    }
    @Test
    void testStringReversal() {
        assertEquals("cba", calculator.reverseString("abc"));
        assertEquals("", calculator.reverseString(""));
        assertEquals("54321", calculator.reverseString("12345"));
    }

}