package Buscaminas;

import static org.junit.Assert.*;

import org.junit.Test;

public class MovimientoTest {
	/* Vamos a empezar comprobando los movimientos que realizara el usuario.
	 * El "tablero" de juego de las minas será de 8x8.
	 * Entoces tenemos que asegurar-nos que el usuario realiza un movimiento permitido.
	 */
	
	@Test
	public void validaFilaTest() {
		Movimiento movimiento = new Movimiento();
		
		assertFalse(movimiento.proxyValidaFila(0));
		assertTrue(movimiento.proxyValidaFila(1));
		assertTrue(movimiento.proxyValidaFila(8));
		assertFalse(movimiento.proxyValidaFila(9));
	}
	
	@Test
	public void validaColumnaTest() {
		Movimiento movimiento = new Movimiento();
		
		assertFalse(movimiento.proxyValidaColumna("?"));
		assertTrue(movimiento.proxyValidaColumna("A"));
		assertTrue(movimiento.proxyValidaColumna("a"));
		assertTrue(movimiento.proxyValidaColumna("H"));
		assertTrue(movimiento.proxyValidaColumna("h"));
		assertFalse(movimiento.proxyValidaColumna("X"));
		assertFalse(movimiento.proxyValidaColumna("x"));
		assertFalse(movimiento.proxyValidaColumna("fallo"));
	}
	
	@Test
	public void validaMovimiento() {
		Movimiento movimiento = new Movimiento();
		
		assertFalse(movimiento.validaMovimiento(9,"?"));
		assertFalse(movimiento.validaMovimiento(9,"a"));
		assertFalse(movimiento.validaMovimiento(9,"A"));
		assertFalse(movimiento.validaMovimiento(4,"?"));
		assertFalse(movimiento.validaMovimiento(4,"aa"));
		assertFalse(movimiento.validaMovimiento(4,"AA"));
		assertFalse(movimiento.validaMovimiento(4,"X"));
		assertFalse(movimiento.validaMovimiento(4,"x"));

		assertTrue(movimiento.validaMovimiento(1,"A"));
		assertTrue(movimiento.validaMovimiento(3,"a"));
		assertTrue(movimiento.validaMovimiento(5,"H"));
		assertTrue(movimiento.validaMovimiento(8,"h"));
		
	}
}
