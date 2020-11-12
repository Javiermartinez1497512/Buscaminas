package Buscaminas;


public class MockRNG implements RNG{
	private int config;
	private int v[][]= {
						//Config 0
						{0,0},{0,1},{1,7},{0,7},{7,0},{7,1},{6,7},{7,7},
						//Config 8
						{0,1},{0,6},{1,0},{2,6},{3,3},{5,6},{6,2},{7,4},
						//Config 16
						{1,1},{1,7},{1,6},{6,0},{6,1},{7,1},{5,1},{3,3},
						//Config 24
						{6,6},{6,7},{7,6},{1,4},{1,3},{1,7},{1,6},{4,4},
						//Config 32
						{4,5},{4,6},{5,4},{6,4},{6,6},{6,6},{7,1},{7,2},{7,3}
						};
	
	
	public void setConfig(int c){
		this.config=c;		
	}
	
	public int[] getRandomNumber() {
		int v[] = this.v[this.config];
		this.config++;		
		return v;
	}
	
	
}
