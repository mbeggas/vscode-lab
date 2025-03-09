import org.example.StringUtilsHelper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringUtilsHelperTest {

    private final StringUtilsHelper stringUtilsHelper = new StringUtilsHelper();

    @Test
    public void testReverseString() {
        assertEquals("cba", stringUtilsHelper.reverseString("abc"));
        assertEquals("", stringUtilsHelper.reverseString(""));
        assertEquals("12345", stringUtilsHelper.reverseString("54321"));
    }
}