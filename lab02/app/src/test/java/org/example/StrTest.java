package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StrTest {
	private final Str str = new Str();

	@Test
	public void testReverse() {
		assertEquals("", str.reverse(""));
		assertEquals("Hello", str.reverse("olleH"));
	}
}
