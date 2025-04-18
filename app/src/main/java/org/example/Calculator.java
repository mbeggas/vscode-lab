package com.example;

import org.apache.commons.lang3.StringUtils;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    // TODO: subtract
    public int subtract(int a, int b) {
        return a - b;
    }

    // TODO: divide
    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divider cannot be zero");
        }
        return (double) a / b;
    }

    // TODO: reverse string with StringUtils
    public String reverseString(String input) {
        return StringUtils.reverse(input);
    }
}
