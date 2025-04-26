package org.example;

<<<<<<< HEAD
public class Calculator {
    public double calc(double a, double b) {
        double x = a + b;
        double y = a * b;
        return x / y;
    }

    public void prtRes(double res) {
        System.out.println("Result: " + res);
    }
}
=======
import org.apache.commons.lang3.StringUtils;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int subtract(int a, int b){
        return a - b;
    }

    public int divide(int a, int b){
        if (b == 0){
            throw new ArithmeticException("Division by zero");
        }
        return a/b;
    }

    public String reverseString(String input) {
        return StringUtils.reverse(input);
    }
}
>>>>>>> 9d19c19e109a899bd4dc6f82db5126ffc0e5aec1
