package com.sinensia.primerprograma.tipos;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TiposTest {
	@Test
	public void customOperation() {
		Tipos t = new Tipos();
		int x = 123;
		int y = 123;
		int expected = 123;
		int actual = t.customOperation(x, y);

		assertEquals(expected, actual);
	}
}
