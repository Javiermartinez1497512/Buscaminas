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
		
		//Fast Lose , RNG= config 0 
		mRNG.setConfig(0);
		Partida partida = new Partida(mRNG);
		partida.setBufferedReader(mockBufferReader);		
		mockBufferReader.setConfig(1);			
		assertFalse(partida.iniciar());
		
		//Last Lose,  RNG= config 0 
		mRNG.setConfig(0);
		partida = new Partida(mRNG);
		partida.setBufferedReader(mockBufferReader);		
		mockBufferReader.setConfig(2);			
		assertFalse(partida.iniciar());
		
		//Win , RNG= config 0
		mRNG.setConfig(0);
		partida = new Partida(mRNG);
		partida.setBufferedReader(mockBufferReader);
		mockBufferReader.setConfig(0);			
		assertTrue(partida.iniciar());
		
		//Win using Deseleccionar and Cancelar, RNG= config 0
		mRNG.setConfig(0);
		partida = new Partida(mRNG);
		partida.setBufferedReader(mockBufferReader);
		mockBufferReader.setConfig(3);			
		assertTrue(partida.iniciar());
		
		//Win , RNG= config 8
		mRNG.setConfig(8);
		partida = new Partida(mRNG);
		partida.setBufferedReader(mockBufferReader);
		mockBufferReader.setConfig(4);			
		assertTrue(partida.iniciar());
		
		//Win trying invalid Casillas, RNG= config 8
		mRNG.setConfig(8);
		partida = new Partida(mRNG);
		partida.setBufferedReader(mockBufferReader);
		mockBufferReader.setConfig(5);			
		assertTrue(partida.iniciar());
		
		//Win trying invalid Casillas, RNG= config 8
		mRNG.setConfig(8);
		partida = new Partida(mRNG);
		partida.setBufferedReader(mockBufferReader);
		mockBufferReader.setConfig(6);			
		assertTrue(partida.iniciar());
		
		
	}
}
