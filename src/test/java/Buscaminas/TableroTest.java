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
	
	@Test
	public void aplicaAccionTest() {
		TableroMock tablero = new TableroMock();
		tablero.iniciarTablero();
		tablero.insertaMina(2, 2);
		tablero.insertaMina(4, 5);
		
		Movimiento movimiento = new Movimiento();
		assertTrue(movimiento.validaMovimiento(3, "C"));
		assertTrue(movimiento.validaAccion("A"));
		assertTrue(tablero.aplicaAccion(movimiento));
		
		tablero.pintar();
		
		Movimiento movimiento2 = new Movimiento();
		assertTrue(movimiento2.validaMovimiento(1, "b"));	
		assertTrue(movimiento2.validaAccion("A"));
		assertFalse(tablero.aplicaAccion(movimiento2));
		assertEquals(tablero.getPosicionTablero(movimiento2.getFila(), movimiento2.getColumna()), "A");
		
		tablero.pintar();
		
		Movimiento movimiento3 = new Movimiento();
		assertTrue(movimiento3.validaMovimiento(3, "H"));	
		assertTrue(movimiento3.validaAccion("M"));
		assertFalse(tablero.aplicaAccion(movimiento3));
		assertEquals(tablero.getPosicionTablero(movimiento3.getFila(), movimiento3.getColumna()), "M");
		
		tablero.pintar();
		
		Movimiento movimiento4 = new Movimiento();
		assertTrue(movimiento4.validaMovimiento(3, "H"));	
		assertTrue(movimiento4.validaAccion("D"));
		assertFalse(tablero.aplicaAccion(movimiento4));
		assertEquals(tablero.getPosicionTablero(movimiento4.getFila(), movimiento4.getColumna()), " ");
		
		tablero.pintar();
		
		Movimiento movimiento5 = new Movimiento();
		assertTrue(movimiento5.validaMovimiento(3, "H"));	
		assertTrue(movimiento5.validaAccion("D"));
		assertFalse(tablero.aplicaAccion(movimiento5));
		assertEquals(tablero.getPosicionTablero(movimiento5.getFila(), movimiento5.getColumna()), " ");
	}
	
	@Test
	public void cuentaVecinosTest() {
		TableroMock tablero = new TableroMock();
		tablero.iniciarTablero();
		tablero.insertaMina(2, 2);
		tablero.insertaMina(4, 5);
		
		tablero.cuentaVecinos(2,3);
	}
	
	@Test
	public void pintarTest() {
		Tablero tablero = new Tablero();
		
		String tablero_clear = "";
		tablero_clear+="   A B C D E F G H\n";
		for(int i = 0; i<8; i++) {
			tablero_clear+="  -----------------\n";
			tablero_clear+=(i+1)+" |";
			for (int j = 0; j<8; j++) {
				tablero_clear+=" "+"|";
			}
			tablero_clear+="\n";
		}
		
		String pintar1 = tablero.pintar();
		
		assertEquals(tablero_clear, pintar1);
	}
}
