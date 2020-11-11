package Buscaminas;

import static org.junit.Assert.*;

import org.junit.Test;

public class TableroTest {
	
	@SuppressWarnings("deprecation")
	@Test
	public void iniciarTableroTest() {
		Tablero tablero =  new Tablero();
		String[][] tableroEsperado = {
				{" "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "}

		};
		assertEquals(tablero.getTablero(), tableroEsperado);		
	}
	@Test
	public void inicializarMinasTest() {	
		Tablero tablero =  new Tablero();
		RNG mRNG= new MockRNG();
		tablero.setRNG(mRNG);
		mRNG.setConfig(0);
		
		tablero.inicializarMinas();
		
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
		Tablero tablero =  new Tablero();
		RNG mRNG= new MockRNG();
		tablero.setRNG(mRNG);
		mRNG.setConfig(0);
		
		tablero.inicializarMinas();
		
		Movimiento movimiento = new Movimiento();
		movimiento.validaMovimiento("1", "A");	
		assertTrue(tablero.proxyCompruebaMinas(movimiento));		

		 movimiento = new Movimiento();
		movimiento.validaMovimiento("1", "B");		
		assertTrue(tablero.proxyCompruebaMinas(movimiento));
		
		 movimiento = new Movimiento();
		movimiento.validaMovimiento("2", "H");	
		assertTrue(tablero.proxyCompruebaMinas(movimiento));
		
		 movimiento = new Movimiento();
		movimiento.validaMovimiento("1", "H");		
		assertTrue(tablero.proxyCompruebaMinas(movimiento));
		
		 movimiento = new Movimiento();
		movimiento.validaMovimiento("8", "A");	
		assertTrue(tablero.proxyCompruebaMinas(movimiento));
		
		 movimiento = new Movimiento();
		movimiento.validaMovimiento("8", "B");			
		assertTrue(tablero.proxyCompruebaMinas(movimiento));
		
		 movimiento = new Movimiento();
		movimiento.validaMovimiento("7", "H");	
		assertTrue(tablero.proxyCompruebaMinas(movimiento));
		
		 movimiento = new Movimiento();
		movimiento.validaMovimiento("8", "H");		
		assertTrue(tablero.proxyCompruebaMinas(movimiento));
		
		 movimiento = new Movimiento();
		movimiento.validaMovimiento("2", "A");
		assertFalse(tablero.proxyCompruebaMinas(movimiento));
		
		 movimiento = new Movimiento();
		movimiento.validaMovimiento("1", "G");
		assertFalse(tablero.proxyCompruebaMinas(movimiento));
		
		 movimiento = new Movimiento();
		movimiento.validaMovimiento("7", "A");
		assertFalse(tablero.proxyCompruebaMinas(movimiento));
		
		 movimiento = new Movimiento();
		movimiento.validaMovimiento("8", "G");
		assertFalse(tablero.proxyCompruebaMinas(movimiento));
	}
	@Test 
	public void CompruebaGanadorTest()
	{
		Tablero tablero = new Tablero();
		RNG mRNG= new MockRNG();
		tablero.setRNG(mRNG);
		mRNG.setConfig(0);		
		tablero.inicializarMinas();
		
		tablero.setCasillasRestantes(0);		
		assertTrue(tablero.compruebaGanador());
		
		tablero.setCasillasRestantes(7);
		assertFalse(tablero.compruebaGanador());
		
		tablero.setCasillasRestantes(9);
		assertFalse(tablero.compruebaGanador());
		
		tablero.setCasillasRestantes(-1);
		assertFalse(tablero.compruebaGanador());
		
	}
	@Test
	public void aplicaAccionTest() {
		Tablero tablero = new Tablero();
		RNG mRNG= new MockRNG();
		tablero.setRNG(mRNG);
		mRNG.setConfig(0);
		
		tablero.inicializarMinas();
		
		//Encontramos mina
		Movimiento movimiento = new Movimiento();
		assertTrue(movimiento.validaMovimiento("7", "H"));
		assertTrue(movimiento.validaAccion("A"));
		assertTrue(tablero.aplicaAccion(movimiento));
		
		Movimiento movimiento2 = new Movimiento();
		assertTrue(movimiento2.validaMovimiento("1", "c"));	
		assertTrue(movimiento2.validaAccion("A"));
		assertFalse(tablero.aplicaAccion(movimiento2));
		
		System.out.println(tablero.pintar());
		
		Movimiento movimiento3 = new Movimiento();
		assertTrue(movimiento3.validaMovimiento("3", "H"));	
		assertTrue(movimiento3.validaAccion("M"));
		assertFalse(tablero.aplicaAccion(movimiento3));
		assertEquals(tablero.getPosicionTablero(movimiento3.getFila(), movimiento3.getColumna()), "M");
		
		System.out.println(tablero.pintar());
		
		Movimiento movimiento4 = new Movimiento();
		assertTrue(movimiento4.validaMovimiento("3", "H"));	
		assertTrue(movimiento4.validaAccion("D"));
		assertFalse(tablero.aplicaAccion(movimiento4));
		assertEquals(tablero.getPosicionTablero(movimiento4.getFila(), movimiento4.getColumna()), " ");
		
		System.out.println(tablero.pintar());
		
		Movimiento movimiento5 = new Movimiento();
		assertTrue(movimiento5.validaMovimiento("3", "H"));	
		assertTrue(movimiento5.validaAccion("D"));
		assertFalse(tablero.aplicaAccion(movimiento5));
		assertEquals(tablero.getPosicionTablero(movimiento5.getFila(), movimiento5.getColumna()), " ");
	}
	
	@Test
	public void cuentaVecinosTest() {		
		Tablero tablero = new Tablero();
		RNG mRNG= new MockRNG();
		tablero.setRNG(mRNG);
		mRNG.setConfig(0);
		
		tablero.inicializarMinas();
		
		//res0_0 Mina
		//res0_1 Mina
		int res0_2 = tablero.proxyCuentaVecinos(0,2);
		int res0_3 = tablero.proxyCuentaVecinos(0,3);
		int res0_4 = tablero.proxyCuentaVecinos(0,4);
		int res0_5 = tablero.proxyCuentaVecinos(0,5);
		int res0_6 = tablero.proxyCuentaVecinos(0,6);
		//res0_7 Mina
		
		int res1_0 = tablero.proxyCuentaVecinos(1,0);
		int res2_0 = tablero.proxyCuentaVecinos(2,0);
		int res3_0 = tablero.proxyCuentaVecinos(3,0);
		int res4_0 = tablero.proxyCuentaVecinos(4,0);
		int res5_0 = tablero.proxyCuentaVecinos(5,0);
		int res6_0 = tablero.proxyCuentaVecinos(6,0);
		//res7_0 Mina
		
		//res1_7 Mina
		int res2_7 = tablero.proxyCuentaVecinos(2,7);
		int res3_7 = tablero.proxyCuentaVecinos(3,7);
		int res4_7 = tablero.proxyCuentaVecinos(4,7);
		int res5_7 = tablero.proxyCuentaVecinos(5,7);
		//res6_7 Mina
		//res7_7 Mina
		
		//res7_1 Mina
		int res7_2 = tablero.proxyCuentaVecinos(7, 2);
		int res7_3 = tablero.proxyCuentaVecinos(7,3);
		int res7_4 = tablero.proxyCuentaVecinos(7,4);
		int res7_5 = tablero.proxyCuentaVecinos(7,5);
		int res7_6 = tablero.proxyCuentaVecinos(7,6);
		
		int res2_3 = tablero.proxyCuentaVecinos(2,3);
		int res2_5 = tablero.proxyCuentaVecinos(2, 5);
		int res3_1 = tablero.proxyCuentaVecinos(3, 1);
		int res4_4 = tablero.proxyCuentaVecinos(4, 4);
		
		
		assertEquals(res0_2, 1);
		assertEquals(res0_3, 0);
		assertEquals(res0_4, 0);
		assertEquals(res0_5, 0);
		assertEquals(res0_6, 2);
		
		assertEquals(res1_0, 2);
		assertEquals(res2_0, 0);
		assertEquals(res3_0, 0);
		assertEquals(res4_0, 0);
		assertEquals(res5_0, 0);
		assertEquals(res6_0, 2);
		
		assertEquals(res2_7, 1);
		assertEquals(res3_7, 0);
		assertEquals(res4_7, 0);
		assertEquals(res5_7, 1);
		
		assertEquals(res7_2, 1);
		assertEquals(res7_3, 0);
		assertEquals(res7_4, 0);
		assertEquals(res7_5, 0);
		assertEquals(res7_6, 2);
		
		assertEquals(res2_3, 0);
		assertEquals(res2_5, 0);
		assertEquals(res3_1, 0);
		assertEquals(res4_4, 0);
		
		/* Versión de Mock 2 */
		tablero = new Tablero();
		RNG mRNG2= new MockRNG();
		tablero.setRNG(mRNG2);
		mRNG2.setConfig(8);
		
		tablero.inicializarMinas();
		
		int res0_0 = tablero.proxyCuentaVecinos(0, 0);
		//res0_1 Mina
		res0_2 = tablero.proxyCuentaVecinos(0,2);
		res0_3 = tablero.proxyCuentaVecinos(0,3);
		res0_4 = tablero.proxyCuentaVecinos(0,4);
		res0_5 = tablero.proxyCuentaVecinos(0,5);
		//res0_6 Mina
		int res0_7 = tablero.proxyCuentaVecinos(0, 7);
		
		//res1_0 Mina
		res2_0 = tablero.proxyCuentaVecinos(2,0);
		res3_0 = tablero.proxyCuentaVecinos(3,0);
		res4_0 = tablero.proxyCuentaVecinos(4,0);
		res5_0 = tablero.proxyCuentaVecinos(5,0);
		res6_0 = tablero.proxyCuentaVecinos(6,0);
		int res7_0 = tablero.proxyCuentaVecinos(7, 0);
		
		int res1_7 = tablero.proxyCuentaVecinos(1, 7);
		res2_7 = tablero.proxyCuentaVecinos(2,7);
		res3_7 = tablero.proxyCuentaVecinos(3,7);
		res4_7 = tablero.proxyCuentaVecinos(4,7);
		res5_7 = tablero.proxyCuentaVecinos(5,7);
		int res6_7 = tablero.proxyCuentaVecinos(6, 7);
		int res7_7 = tablero.proxyCuentaVecinos(7, 7);
		
		int res7_1 = tablero.proxyCuentaVecinos(7, 1);
		res7_2 = tablero.proxyCuentaVecinos(7, 2);
		res7_3 = tablero.proxyCuentaVecinos(7,3);
		//res7_4 Mina
		res7_5 = tablero.proxyCuentaVecinos(7,5);
		res7_6 = tablero.proxyCuentaVecinos(7,6);
		
		res2_3 = tablero.proxyCuentaVecinos(2,3);
		res2_5 = tablero.proxyCuentaVecinos(2, 5);
		res3_1 = tablero.proxyCuentaVecinos(3, 1);
		res4_4 = tablero.proxyCuentaVecinos(4, 4);
		
		assertEquals(res0_0, 2);
		assertEquals(res0_2, 1);
		assertEquals(res0_3, 0);
		assertEquals(res0_4, 0);
		assertEquals(res0_5, 1);
		assertEquals(res0_7, 1);
		
		assertEquals(res2_0, 1);
		assertEquals(res3_0, 0);
		assertEquals(res4_0, 0);
		assertEquals(res5_0, 0);
		assertEquals(res6_0, 0);
		assertEquals(res7_0, 0);
		
		assertEquals(res1_7, 2);
		assertEquals(res2_7, 1);
		assertEquals(res3_7, 1);
		assertEquals(res4_7, 1);
		assertEquals(res5_7, 1);
		assertEquals(res6_7, 1);
		assertEquals(res7_7, 0);
		
		assertEquals(res7_1, 1);
		assertEquals(res7_2, 1);
		assertEquals(res7_3, 2);
		assertEquals(res7_5, 1);
		assertEquals(res7_6, 0);
		
		assertEquals(res2_3, 1);
		assertEquals(res2_5, 1);
		assertEquals(res3_1, 0);
		assertEquals(res4_4, 1);
	}
	@Test
	public void cuentaArribaIzquierdaTest() {
		Tablero tablero = new Tablero();
		RNG mRNG= new MockRNG();
		tablero.setRNG(mRNG);
		mRNG.setConfig(8);
		
		tablero.inicializarMinas();
		
		int res_0 =tablero.proxyCuentaArribaIzquierda();
		assertEquals(res_0, 2);
	}
	@Test
	public void cuentaArribaDerechaTest() {
		Tablero tablero = new Tablero();
		RNG mRNG= new MockRNG();
		tablero.setRNG(mRNG);
		mRNG.setConfig(8);
		
		tablero.inicializarMinas();
		int res_0 = tablero.proxyCuentaArribaDerecha();
		assertEquals(res_0, 1);
	}
	@Test
	public void cuentaAbajoIzquierdaTest() {
		Tablero tablero = new Tablero();
		RNG mRNG= new MockRNG();
		tablero.setRNG(mRNG);
		mRNG.setConfig(8);
		
		tablero.inicializarMinas();
		int res_0 = tablero.proxyCuentaAbajoIzquierda();
		assertEquals(res_0, 0);
	}
	@Test
	public void cuentaAbajoDerechaTest() {
		Tablero tablero = new Tablero();
		RNG mRNG= new MockRNG();
		tablero.setRNG(mRNG);
		mRNG.setConfig(8);
		
		tablero.inicializarMinas();
		int res_0 = tablero.proxyCuentaAbajoDerecha();
		assertEquals(res_0, 0);
	}
	@Test
	public void cuentaArribaTest() {
		Tablero tablero = new Tablero();
		RNG mRNG= new MockRNG();
		tablero.setRNG(mRNG);
		mRNG.setConfig(0);
		
		tablero.inicializarMinas();
		
		int res0_2 = tablero.proxyCuentaArriba(2);
		int res0_3 = tablero.proxyCuentaArriba(3);
		int res0_4 = tablero.proxyCuentaArriba(4);
		int res0_5 = tablero.proxyCuentaArriba(5);
		int res0_6 = tablero.proxyCuentaArriba(6);
		
		assertEquals(res0_2, 1);
		assertEquals(res0_3, 0);
		assertEquals(res0_4, 0);
		assertEquals(res0_5, 0);
		assertEquals(res0_6, 2);
	}
	@Test
	public void cuentaAbajoTest() {
		Tablero tablero = new Tablero();
		RNG mRNG= new MockRNG();
		tablero.setRNG(mRNG);
		mRNG.setConfig(0);
		
		tablero.inicializarMinas();
		
		int res7_2 = tablero.proxyCuentaAbajo(2);
		int res7_3 = tablero.proxyCuentaAbajo(3);
		int res7_4 = tablero.proxyCuentaAbajo(4);
		int res7_5 = tablero.proxyCuentaAbajo(5);
		int res7_6 = tablero.proxyCuentaAbajo(6);
		
		assertEquals(res7_2, 1);
		assertEquals(res7_3, 0);
		assertEquals(res7_4, 0);
		assertEquals(res7_5, 0);
		assertEquals(res7_6, 2);
	}
	@Test
	public void cuentaDerechaTest() {
		Tablero tablero = new Tablero();
		RNG mRNG= new MockRNG();
		tablero.setRNG(mRNG);
		mRNG.setConfig(0);
		
		tablero.inicializarMinas();
		
		int res2_7 = tablero.proxyCuentaDerecha(2);
		int res3_7 = tablero.proxyCuentaDerecha(3);
		int res4_7 = tablero.proxyCuentaDerecha(4);
		int res5_7 = tablero.proxyCuentaDerecha(5);
		
		assertEquals(res2_7, 1);
		assertEquals(res3_7, 0);
		assertEquals(res4_7, 0);
		assertEquals(res5_7, 1);
	}
	@Test
	public void CuentaIzquierdaTest() {
		Tablero tablero = new Tablero();
		RNG mRNG= new MockRNG();
		tablero.setRNG(mRNG);
		mRNG.setConfig(0);
		
		tablero.inicializarMinas();
		
		int res1_0 = tablero.proxyCuentaIzquierda(1);
		int res2_0 = tablero.proxyCuentaIzquierda(2);
		int res3_0 = tablero.proxyCuentaIzquierda(3);
		int res4_0 = tablero.proxyCuentaIzquierda(4);
		int res5_0 = tablero.proxyCuentaIzquierda(5);
		int res6_0 = tablero.proxyCuentaIzquierda(6);
		
		assertEquals(res1_0, 2);
		assertEquals(res2_0, 0);
		assertEquals(res3_0, 0);
		assertEquals(res4_0, 0);
		assertEquals(res5_0, 0);
		assertEquals(res6_0, 2);
	}
	@Test
	public void cuentaCentroTest() {
		Tablero tablero = new Tablero();
		RNG mRNG= new MockRNG();
		tablero.setRNG(mRNG);
		mRNG.setConfig(8);
		
		tablero.inicializarMinas();
		
		int res2_3 = tablero.proxyCuentaCentro(2,3);
		int res2_5 = tablero.proxyCuentaCentro(2, 5);
		int res3_1 = tablero.proxyCuentaCentro(3, 1);
		int res4_4 = tablero.proxyCuentaCentro(4, 4);
		
		assertEquals(res2_3, 1);
		assertEquals(res2_5, 1);
		assertEquals(res3_1, 0);
		assertEquals(res4_4, 1);
		
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
		System.out.println(pintar1);
	}
}
