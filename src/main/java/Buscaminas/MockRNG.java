package Buscaminas;


public class MockRNG extends Tablero{
	int Config;
	
	int v[][]= {{0,0},{0,1},{1,7},{0,7},{7,0},{7,1},{6,7},{7,7 }};
	
	void setConfig(int c)
	{
		Config=c;		
	}
	
	int[] getRandomNumber() {
		
		int V[] = v[Config];
		Config++;
		return V;
	}

}
