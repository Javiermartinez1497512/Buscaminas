package Buscaminas;

import static org.junit.Assert.*;

import org.junit.Test;

public class TableroTest {
		

	@Test
	public void tableroMockTest() {
		TableroMock tablero = new TableroMock();
		
		tablero.insertaMina(0, 0);
		
		assertEquals(tablero.getPos(0, 0), "X");
		assertEquals(tablero.getPos(0, 1), null);
	}
	
	@Test
	public void inicializarMinasTest() {
		TableroMock tablero = new TableroMock(true);
		int counter = tablero.contarMinas();
		assertEquals(counter, 8);
		
		TableroMock tablero2 = new TableroMock(true);
		int counter2 = tablero2.contarMinas();
		assertEquals(counter2, 8);
	}
	
	@Test
	public void compruebaMinasTest() {
		
		TableroMock tablero = new TableroMock();
		tablero.insertaMina(2, 2);
		tablero.insertaMina(4, 5);
				
		Movimiento movimiento = new Movimiento();
		assertTrue(movimiento.validaMovimiento(3, "c"));	
		assertTrue(tablero.compruebaMinas(movimiento));
		
		Movimiento movimiento2 = new Movimiento();
		assertTrue(movimiento2.validaMovimiento(1, "b"));		
		assertFalse(tablero.compruebaMinas(movimiento2));
		
		Movimiento movimiento3 = new Movimiento();
		assertTrue(movimiento3.validaMovimiento(5, "F"));
		assertTrue(tablero.compruebaMinas(movimiento3));
	}
	
	public void aplicaAccionTest() {
		TableroMock tablero = new TableroMock();
		tablero.insertaMina(2, 2);
		tablero.insertaMina(4, 5);
		
		Movimiento movimiento = new Movimiento();
		assertTrue(movimiento.validaMovimiento(3, "C"));
		assertTrue(movimiento.validaAccion("A"));
		assertTrue(tablero.aplicaAccion(movimiento));
		
		Movimiento movimiento2 = new Movimiento();
		assertTrue(movimiento2.validaMovimiento(1, "b"));	
		assertTrue(movimiento.validaAccion("A"));
		assertFalse(tablero.aplicaAccion(movimiento2));
		
	}

}
