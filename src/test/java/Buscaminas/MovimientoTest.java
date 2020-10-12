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
}
