package org.example;

import org.apache.commons.lang3.StringUtils;

public class Calculator {

    public int addNumbers(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    public int subtractNumbers(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }

    public int multiplyNumbers(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }

    public int divideNumbers(int dividend, int divisor) {
        validateDivisor(divisor);
        return dividend / divisor;
    }

    private void validateDivisor(int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
    }

    public String reverseText(String input) {
        return StringUtils.reverse(input);
    }
}
