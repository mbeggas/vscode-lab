package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest { private final Calculator calculator = new Calculator();

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
public void testSubtract() {
    assertEquals(15, calculator.add(10, 5));
    assertEquals(0, calculator.add(-5, 5));
}

  @Test
    public void testDivision() {
        assertEquals(3, calculator.divide(15, 5));
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(10, 0));
    }

    @Test
    public void testReverseString() {
        assertEquals("cba", calculator.reverseString("abc"));
        assertEquals("987654321", calculator.reverseString("123456789"));
    }
}