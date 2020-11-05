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
		
		
		assertTrue(movimiento.validaFila("1"));
		assertTrue(movimiento.validaFila("2"));
		assertTrue(movimiento.validaFila("7"));
		assertTrue(movimiento.validaFila("8"));
		assertFalse(movimiento.validaFila("9"));
		assertFalse(movimiento.validaFila("0"));
		assertFalse(movimiento.validaFila("-1"));
	}
	
	@Test
	public void validaColumnaTest() {
		Movimiento movimiento = new Movimiento();
		
		
		assertTrue(movimiento.validaColumna("A"));
		assertTrue(movimiento.validaColumna("a"));
		assertTrue(movimiento.validaColumna("B"));
		assertTrue(movimiento.validaColumna("b"));
		assertTrue(movimiento.validaColumna("G"));
		assertTrue(movimiento.validaColumna("g"));
		assertTrue(movimiento.validaColumna("H"));
		assertTrue(movimiento.validaColumna("h"));
		
		assertFalse(movimiento.validaColumna("1"));
		assertFalse(movimiento.validaColumna("2"));
		assertFalse(movimiento.validaColumna("I"));
		assertFalse(movimiento.validaColumna("i"));
		assertFalse(movimiento.validaColumna("X"));
		assertFalse(movimiento.validaColumna("x"));
		assertFalse(movimiento.validaColumna("fallo"));
		assertFalse(movimiento.validaColumna("?"));
	}
	
	@Test
	public void validaMovimientoTest() {
		Movimiento movimiento = new Movimiento();
		
		assertFalse(movimiento.validaMovimiento("9","?"));
		assertFalse(movimiento.validaMovimiento("9","a"));
		assertFalse(movimiento.validaMovimiento("9","A"));
		assertFalse(movimiento.validaMovimiento("4","?"));
		assertFalse(movimiento.validaMovimiento("4","aa"));
		assertFalse(movimiento.validaMovimiento("4","AA"));
		assertFalse(movimiento.validaMovimiento("4","X"));
		assertFalse(movimiento.validaMovimiento("4","x"));

		assertTrue(movimiento.validaMovimiento("1","A"));
		assertTrue(movimiento.validaMovimiento("1","B"));
		assertTrue(movimiento.validaMovimiento("2","A"));
		assertFalse(movimiento.validaMovimiento("-1","A"));
		assertFalse(movimiento.validaMovimiento("1","?"));
		
		
		assertTrue(movimiento.validaMovimiento("1","h"));
		assertTrue(movimiento.validaMovimiento("1","h"));
		assertTrue(movimiento.validaMovimiento("2","g"));
		assertFalse(movimiento.validaMovimiento("-1","h"));
		assertFalse(movimiento.validaMovimiento("1","i"));
		
		assertTrue(movimiento.validaMovimiento("7","A"));
		assertTrue(movimiento.validaMovimiento("8","B"));
		assertTrue(movimiento.validaMovimiento("8","A"));		
		assertFalse(movimiento.validaMovimiento("9","A"));
		assertFalse(movimiento.validaMovimiento("8","?"));
		
		assertTrue(movimiento.validaMovimiento("7","h"));
		assertTrue(movimiento.validaMovimiento("8","h"));
		assertTrue(movimiento.validaMovimiento("8","g"));
		assertFalse(movimiento.validaMovimiento("9","H"));
		assertFalse(movimiento.validaMovimiento("8","i"));
	}
	
	@Test
	public void validaAccionTest() {
		Movimiento movimiento = new Movimiento();
		assertTrue(movimiento.validaAccion("A"));
		assertTrue(movimiento.validaAccion("M"));
		assertTrue(movimiento.validaAccion("D"));
		assertTrue(movimiento.validaAccion("C"));
		assertTrue(movimiento.validaAccion("a"));
		assertTrue(movimiento.validaAccion("m"));
		assertTrue(movimiento.validaAccion("d"));
		assertTrue(movimiento.validaAccion("c"));
		
		assertFalse(movimiento.validaAccion("AA"));
		assertFalse(movimiento.validaAccion("3"));
		assertFalse(movimiento.validaAccion("-3"));
		assertFalse(movimiento.validaAccion("J"));
		assertFalse(movimiento.validaAccion("j"));
		assertFalse(movimiento.validaAccion("?"));
	}
}
