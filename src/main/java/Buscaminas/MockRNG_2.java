package Buscaminas;

public class MockRNG_2 implements RNG{
	private int v[][]= {{0,1},{0,6},{1,0},{2,6},{3,3},{5,6},{6,2},{7,4}};
	private int config;
	
	public void setConfig(int c){
		this.config=c;		
	}
	
	public int[] getRandomNumber() {
		int v [] = this.v[this.config];
		this.config++;
		return v;
	}
}
