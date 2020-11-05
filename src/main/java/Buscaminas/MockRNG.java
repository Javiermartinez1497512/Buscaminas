package Buscaminas;


public class MockRNG implements RNG{
	private int config;
	private int v[][]= {{0,0},{0,1},{1,7},{0,7},{7,0},{7,1},{6,7},{7,7}};
	
	
	public void setConfig(int c){
		this.config=c;		
	}
	
	public int[] getRandomNumber() {
		int v[] = this.v[this.config];
		this.config++;		
		return v;
	}
	
	
}
