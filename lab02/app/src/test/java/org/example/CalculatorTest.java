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
	public void testSubstraction() {
		assertEquals(5, calculator.substract(10, 5));
		assertEquals(-5, calculator.substract(0, 5));
	}

	@Test
	public void testDivision() {
		assertEquals(2, calculator.divide(10, 5));
		assertEquals(0, calculator.divide(0, 5));
		assertThrows(ArithmeticException.class, () -> calculator.divide(5, 0));
	}
}