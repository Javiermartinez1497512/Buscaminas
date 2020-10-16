package Buscaminas;

import static org.junit.Assert.*;


import org.junit.Test;

public class PartidaTest {
	
	@Test
	public void seguirTest() {
		Partida partida = new Partida();
		assertFalse(partida.seguir());
	}
	
	@Test
	public void noSeguirTest() {
		Partida partida = new Partida();
		assertFalse(partida.seguir());
		partida.noSeguir();
		assertTrue(partida.seguir());
	}
	
	@Test
	public void Partida1Test() {
		Movimiento movimiento = new Movimiento();
		movimiento.validaMovimiento(0, "A");
		movimiento.validaAccion("A");
	}
}
