@Test
public void testSubtraction() {
    assertEquals(5, calculator.subtract(10, 5));
    assertEquals(-10, calculator.subtract(-5, 5));
}

@Test
public void testDivision() {
    assertEquals(2.0, calculator.divide(10, 5));
    assertEquals(1.5, calculator.divide(3, 2));
}
@Test
public void testReverseString() {
    assertEquals("olleH", calculator.reverseString("Hello"));
    assertEquals("avaJ", calculator.reverseString("Java"));
}
