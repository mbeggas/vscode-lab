package org.example;

import org.apache.commons.lang3.StringUtils;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int divide(int a, int b) {
        return a / b;
    }

    public String reverse(String input) {
        return StringUtils.reverse(input);
    }
}
