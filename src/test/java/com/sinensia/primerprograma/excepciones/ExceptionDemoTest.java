package com.sinensia.primerprograma.excepciones;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class ExceptionDemoTest {
	@Test
	public void main1() {
		String[] args = null;
		assertThrows(java.lang.NullPointerException.class, () -> {
			ExceptionDemo.main(args);
		});
	}
}
