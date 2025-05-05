package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void testAddition() {
        assertEquals(15, calculator.addNumbers(10, 5));
        assertEquals(0, calculator.addNumbers(-5, 5));
    }

    @Test
    public void testSubtraction() {
        assertEquals(5, calculator.subtractNumbers(10, 5));
        assertEquals(-10, calculator.subtractNumbers(-5, 5));
    }

    @Test
    public void testMultiplication() {
        assertEquals(50, calculator.multiplyNumbers(10, 5));
        assertEquals(0, calculator.multiplyNumbers(0, 5));
    }

    @Test
    public void testDivision() {
        assertEquals(2, calculator.divideNumbers(10, 5));
        assertEquals(-2, calculator.divideNumbers(-10, 5));
        assertThrows(ArithmeticException.class, () -> calculator.divideNumbers(10, 0));
    }

    @Test
    public void testReverseText() {
        assertEquals("gnitset", calculator.reverseText("testing"));
        assertEquals("54321", calculator.reverseText("12345"));
        assertEquals("", calculator.reverseText(""));
    }
}
