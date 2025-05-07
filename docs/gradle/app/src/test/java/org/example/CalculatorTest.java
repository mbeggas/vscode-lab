package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

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
    public void testSubtraction() {
        assertEquals(5, calculator.subtract(10, 5));
    }

    @Test
    public void testDivision() {
        assertEquals(2, calculator.divide(10, 5));
    }

    @Test
    public void testReverseString() {
        assertEquals("olleh", calculator.reverseString("hello"));
        assertEquals("4321", calculator.reverseString("1234"));
    }
}
