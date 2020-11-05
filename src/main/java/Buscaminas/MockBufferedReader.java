package Buscaminas;

public class MockBufferedReader implements BufferedReaderInterface {
	private String[] S= 	{"3","a","A",
							"2","b","B" ,
							"1","a","A"
							};
	private int config;
	
	public void setConfig(int c){
		this.config=c;		
	}
	public String read() {
		String s =S[this.config];
		this.config++;
		return s;
	}

}
