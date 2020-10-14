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
		
		assertFalse(movimiento.validaFila(0));
		assertTrue(movimiento.validaFila(1));
		assertTrue(movimiento.validaFila(8));
		assertFalse(movimiento.validaFila(9));
	}
	
	@Test
	public void validaColumnaTest() {
		Movimiento movimiento = new Movimiento();
		
		assertFalse(movimiento.validaColumna("?"));
		assertTrue(movimiento.validaColumna("A"));
		assertTrue(movimiento.validaColumna("a"));
		assertTrue(movimiento.validaColumna("H"));
		assertTrue(movimiento.validaColumna("h"));
		assertFalse(movimiento.validaColumna("X"));
		assertFalse(movimiento.validaColumna("x"));
		assertFalse(movimiento.validaColumna("fallo"));
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
