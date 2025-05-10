package org.example;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest { private final Calculator calculator = new Calculator();



@Test
public void testAddition() {
    assertEquals(12, calculator.add(5, 7));
    assertEquals(-2, calculator.add(5, 7));
}

@Test
public void testMultiplication() {
    assertEquals(35, calculator.multiply(5, 7));
    assertEquals(0, calculator.multiply(0, 57));
}

@Test
public void testSubtract() {
    assertEquals(15, calculator.subtract(5, -7));
    assertEquals(-12, calculator.subtract(-5, 7));
}

  @Test
    public void testDivision() {
        assertEquals(10, calculator.divide(50, 5));
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(10, 0));
    }

    @Test
    public void testReverseString() {
        assertEquals("olleH", calculator.reverseString("Hello"));
        assertEquals("987654321", calculator.reverseString("123456789"));
    }

    public Calculator getCalculator() {
        return calculator;
    }
}