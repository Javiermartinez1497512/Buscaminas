package Buscaminas;

import static org.junit.Assert.*;


import org.junit.Test;

public class PartidaTest {
	
	@Test
	public void seguirTest() {
		RNG mRNG= new MockRNG();		
		mRNG.setConfig(0);
		Partida partida = new Partida(mRNG);
		assertFalse(partida.seguir());
	}
	
	@Test
	public void noSeguirTest() {
		
		RNG mRNG= new MockRNG();		
		mRNG.setConfig(0);
		Partida partida = new Partida(mRNG);
		assertFalse(partida.seguir());
		partida.noSeguir();
		assertTrue(partida.seguir());
	}
	@Test
	public void iniciarTest() throws Exception {
		RNG mRNG= new MockRNG();				
		BufferedReaderInterface mockBufferReader= new MockBufferedReader();
		
		mRNG.setConfig(0);
		Partida partida = new Partida(mRNG);
		partida.setBufferedReader(mockBufferReader);		
		mockBufferReader.setConfig(1);			
		assertFalse(partida.iniciar());
		
		mRNG.setConfig(0);
		partida = new Partida(mRNG);
		partida.setBufferedReader(mockBufferReader);		
		mockBufferReader.setConfig(2);			
		assertFalse(partida.iniciar());
		
		mRNG.setConfig(0);
		partida = new Partida(mRNG);
		partida.setBufferedReader(mockBufferReader);
		mockBufferReader.setConfig(0);			
		assertTrue(partida.iniciar());
		
		mRNG.setConfig(0);
		partida = new Partida(mRNG);
		partida.setBufferedReader(mockBufferReader);
		mockBufferReader.setConfig(3);			
		assertTrue(partida.iniciar());
		
		
		
		
	
	}
}
