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
		
	}

}
