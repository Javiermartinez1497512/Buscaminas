package Buscaminas;

import static org.junit.Assert.*;

import org.junit.Test;

public class tableroTest {
		

	@Test
	public void validainicializarMinasTest() {
		CrearAleatorioMock A = new CrearAleatorioMock();
		
		Integer Random1= 8;
		A.addRandom(1, Random1);
		
		Integer Random2= 1;
		A.addRandom(1, Random2);
		
		tablero t =new tablero();
		t.inicializarMinasTest();
		
		assertEquals(t.getRes(Random1,Random2),"X" );
		
	
	}

}
