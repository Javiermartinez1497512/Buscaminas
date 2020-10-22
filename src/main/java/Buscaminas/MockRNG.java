package Buscaminas;


public class MockRNG extends Tablero{
	int Config;
	
	int v[][]= {{0,0},{2,3},{4,5},{6,7}};
	
	void setConfig(int c)
	{
		Config=c;		
	}
	
	int[] getRandomNumber() {
		return v[Config];
	}

}
