package org.example;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CalculatorTest {

    @Test
    public void testPrtRes() {
        
        Calculator calculator = new Calculator();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        calculator.printResult(5.0);
        assertTrue(outContent.toString().contains("Result: 5.0"));
    }
}
