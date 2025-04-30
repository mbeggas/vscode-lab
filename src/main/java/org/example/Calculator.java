package org.example;

import org.apache.commons.lang3.StringUtils;
public class Calculator {
    public int add(int firstnbr, int secondnbr) {
        return firstnbr + secondnbr;
    }

    public int multiply(int firstnbr, int secondnbr) {
        return firstnbr * secondnbr;
    }
    
    public int subtract(int firstnbr, int secondnbr) {
        return firstnbr - secondnbr;
    }
     public int divide(int firstnbr, int secondnbr) {
         if (secondnbr == 0) {
             throw new IllegalArgumentException("Cannot divide by zero");
         }
        return firstnbr / secondnbr;
    }
    
    public String reverseString(String input) {
        return StringUtils.reverse(input);
    }
}
