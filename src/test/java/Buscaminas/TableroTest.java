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
		
		Tablero tablero =  new Tablero();
		MockRNG mRNG= new MockRNG();
		tablero.setRNG(mRNG);
		mRNG.setConfig(0);
		
		tablero.inicializarMinasTest();
		
		assertEquals(tablero.getPos(0, 0), "X");
		assertEquals(tablero.getPos(0, 1), "X");
		assertEquals(tablero.getPos(0, 7), "X");
		assertEquals(tablero.getPos(1, 7), "X");
		assertEquals(tablero.getPos(7, 0), "X");
		assertEquals(tablero.getPos(7, 1), "X");
		assertEquals(tablero.getPos(6, 7), "X");
		assertEquals(tablero.getPos(7, 7), "X");	
		
		assertEquals(tablero.getPos(1, 0), null);
		assertEquals(tablero.getPos(0, 2), null);
		assertEquals(tablero.getPos(0, 6), null);
		assertEquals(tablero.getPos(2, 7), null);
		assertEquals(tablero.getPos(6, 0), null);
		assertEquals(tablero.getPos(7, 2), null);
		assertEquals(tablero.getPos(6, 6), null);
		assertEquals(tablero.getPos(7, 6), null);
		
		
		
	
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
		Tablero tablero = new Tablero();
		//Suponemos Minas en:
		// 2-B (1-1)
		// 2-G (1-6)
		// 4-E (3-4)
		// 4-H (3-7)
		// 5-F (4-5)
		// 6-B (5-1)
		// 8-C (7-2)
		// 8-H (7-7)
		
		int res0_0 = tablero.proxyCuentaVecinos(0,0);
		int res0_1 = tablero.proxyCuentaVecinos(0,1);
		int res0_2 = tablero.proxyCuentaVecinos(0,2);
		int res0_3 = tablero.proxyCuentaVecinos(0,3);
		int res0_4 = tablero.proxyCuentaVecinos(0,4);
		int res0_5 = tablero.proxyCuentaVecinos(0,5);
		int res0_6 = tablero.proxyCuentaVecinos(0,6);
		int res0_7 = tablero.proxyCuentaVecinos(0,7);
		
		int res1_0 = tablero.proxyCuentaVecinos(1,0);
		int res2_0 = tablero.proxyCuentaVecinos(2,0);
		int res3_0 = tablero.proxyCuentaVecinos(3,0);
		int res4_0 = tablero.proxyCuentaVecinos(4,0);
		int res5_0 = tablero.proxyCuentaVecinos(5,0);
		int res6_0 = tablero.proxyCuentaVecinos(6,0);
		int res7_0 = tablero.proxyCuentaVecinos(7,0);
		
		int res1_7 = tablero.proxyCuentaVecinos(1,7);
		int res2_7 = tablero.proxyCuentaVecinos(2,7);
		//res3_7 Mina
		int res4_7 = tablero.proxyCuentaVecinos(4,7);
		int res5_7 = tablero.proxyCuentaVecinos(5,7);
		int res6_7 = tablero.proxyCuentaVecinos(6,7);
		//res7_7 Mina
		
		int res7_1 = tablero.proxyCuentaVecinos(7,1);
		//res7_2 Mina
		int res7_3 = tablero.proxyCuentaVecinos(7,3);
		int res7_4 = tablero.proxyCuentaVecinos(7,4);
		int res7_5 = tablero.proxyCuentaVecinos(7,5);
		int res7_6 = tablero.proxyCuentaVecinos(7,6);
		
		int res2_3 = tablero.proxyCuentaVecinos(2,3);
		int res2_5 = tablero.proxyCuentaVecinos(2, 5);
		int res3_1 = tablero.proxyCuentaVecinos(3, 1);
		int res4_4 = tablero.proxyCuentaVecinos(4, 4);
		
		
		assertEquals(res0_0, 1);
		assertEquals(res0_1, 1);
		assertEquals(res0_2, 1);
		assertEquals(res0_3, 0);
		assertEquals(res0_4, 0);
		assertEquals(res0_5, 1);
		assertEquals(res0_6, 1);
		assertEquals(res0_7, 1);
		
		assertEquals(res1_0, 1);
		assertEquals(res2_0, 1);
		assertEquals(res3_0, 0);
		assertEquals(res4_0, 1);
		assertEquals(res5_0, 1);
		assertEquals(res6_0, 1);
		assertEquals(res7_0, 0);
		
		assertEquals(res1_7, 1);
		assertEquals(res2_7, 2);
		assertEquals(res4_7, 1);
		assertEquals(res5_7, 0);
		assertEquals(res6_7, 1);
		
		assertEquals(res7_1, 1);
		assertEquals(res7_3, 1);
		assertEquals(res7_4, 0);
		assertEquals(res7_5, 0);
		assertEquals(res7_6, 1);
		
		assertEquals(res2_3, 1);
		assertEquals(res2_5, 2);
		assertEquals(res3_1, 0);
		assertEquals(res4_4, 2);
		
		//Evidentemente este metodo fallara hasta el momento
		//que hagamos el mock para insertar minas donde nosotros queramos
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
