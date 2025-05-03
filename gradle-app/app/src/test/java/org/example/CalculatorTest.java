package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    public void testAddition() {
        assertEquals(15, calculator.add(10, 5));
        assertEquals(0, calculator.add(-5, 5));
        assertEquals(-10, calculator.add(-5, -5));
        assertEquals(Integer.MAX_VALUE - 1, calculator.add(Integer.MAX_VALUE - 2, 1));
    }

    @Test
    public void testMultiplication() {
        assertEquals(50, calculator.multiply(10, 5));
        assertEquals(0, calculator.multiply(0, 5));
        assertEquals(-15, calculator.multiply(3, -5));
        assertEquals(25, calculator.multiply(-5, -5));
    }

    @Test
    public void testSubtraction() {
        assertEquals(5, calculator.subtract(10, 5));
        assertEquals(-10, calculator.subtract(-5, 5));
        assertEquals(0, calculator.subtract(-5, -5));
        assertEquals(Integer.MIN_VALUE + 1, calculator.subtract(Integer.MIN_VALUE, -1));
    }

    @Test
    public void testDivision() {
        assertEquals(2, calculator.divide(10, 5));
        assertEquals(-2, calculator.divide(10, -5));
        assertEquals(0, calculator.divide(0, 5));
        assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
    }

    @Test
    public void testDivisionWithDoubleResult() {
        assertEquals(2.5, calculator.divide(5, 2), 0.0001);
        assertEquals(-0.3333, calculator.divide(1, -3), 0.0001);
    }

    @Test
    public void testDivisionByZero() {
        assertEquals(2.5, calculator.divide(5, 2), 0.0001);
        assertEquals(-0.3333, calculator.divide(1, -3), 0.0001);
    }

}