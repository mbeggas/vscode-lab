package refactoring;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void testCalculateResult() {
        Calculator calculator = new Calculator();
        double result = calculator.calc(2, 3);
        assertEquals(0.833, result, 0.001);
    }
}
