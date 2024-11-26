package com.sinensia.primerprograma.patrones.factory;

import org.junit.jupiter.api.*;

public class BarcoTest {
	@Test
	public void mostrarInformacion() {
		Barco b = new Barco();
		b.mostrarInformacion();
	}
}
