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

}