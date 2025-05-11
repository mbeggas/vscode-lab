
import org.apache.commons.lang3.StringUtils;

public class Calculator {

    public int addNumbers(int a, int b) {
        return a + b;
    }

    public int multiplyNumbers(int a, int b) {
        return a * b;
    }

    public int subtractNumbers(int a, int b) {
        return a - b;
    }

    public int safelyDivide(int a, int b) {
        validateDivisor(b);
        return a / b;
    }

    private void validateDivisor(int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
    }

    public String reverseString(String input) {
        return StringUtils.reverse(input);
    }
}
