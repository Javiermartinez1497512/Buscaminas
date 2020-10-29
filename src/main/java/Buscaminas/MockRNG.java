package Buscaminas;


public class MockRNG implements RNG{
	int Config;
	
	int v[][]= {{0,0},{0,-1},{-1,0},{8,7},{7,8},{0,8},{8,0},{-1,7},{7,-1},{0,1},{1,7},{0,7},{7,0},{7,1},{6,7},{7,7}};
	
	public void setConfig(int c){
		Config=c;		
	}
	
	public int[] getRandomNumber() {
		
		int V[] = v[Config];
		Config++;		
		return V;
	}

}
