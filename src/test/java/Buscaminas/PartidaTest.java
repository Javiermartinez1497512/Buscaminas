package Buscaminas;

import static org.junit.Assert.*;


import org.junit.Test;

public class PartidaTest {
	
	@Test
	public void seguirTest() {
		Partida partida = new Partida();
		assertFalse(partida.seguir());
	}
	
	@Test
	public void noSeguirTest() {
		Partida partida = new Partida();
		assertFalse(partida.seguir());
		partida.noSeguir();
		assertTrue(partida.seguir());
	}
	public void iniciarTest() throws Exception {
		
		Partida partida = new Partida();
		BufferedReaderInterface mockBufferReader= new MockBufferedReader();
		partida.setBufferedReader(mockBufferReader);
		
		assertTrue(partida.iniciar());
		
	}
}
