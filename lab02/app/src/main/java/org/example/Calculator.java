package org.example;
public class Calculator {
	public int add(int a, int b) {
		return a + b;
	}

	public int multiply(int a, int b) {
		return a * b;
	}

	public int substract(int a, int b) {
		return a - b;
	}

	public float divide(int a, int b) throws ArithmeticException {
		if (b == 0) throw new ArithmeticException("Division by zero!");
		return (float)a / (float)b;
	}
}