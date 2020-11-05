package Buscaminas;

public class MockBufferedReader implements BufferedReaderInterface {
	private String[] S= {	"1","a","M" ,	"1","b","M" ,	"1","c","A" ,	"1","d","A" ,	"1","e","A" ,	"1","f","A" ,	"1","g","A" ,	"1","h","M" ,
							"2","a","A" ,	"2","b","A" ,	"2","c","A" ,	"2","d","A" ,	"2","e","A" ,	"2","f","A" ,	"2","g","A" ,	"2","h","M" ,
							"3","a","A" ,	"3","b","A" ,	"3","c","A" ,	"3","d","A" ,	"3","e","A" ,	"3","f","A" ,	"3","g","A" ,	"3","h","A" ,
							"4","a","A" ,	"4","b","A" ,	"4","c","A" ,	"4","d","A" ,	"4","e","A" ,	"4","f","A" ,	"4","g","A" ,	"4","h","A" ,
							"5","a","A" ,	"5","b","A" ,	"5","c","A" ,	"5","d","A" ,	"5","e","A" ,	"5","f","A" ,	"5","g","A" ,	"5","h","A" ,
							"6","a","A" ,	"6","b","A" ,	"6","c","A" ,	"6","d","A" ,	"6","e","A" ,	"6","f","A" ,	"6","g","A" ,	"6","h","A" ,
							"7","a","A" ,	"7","b","A" ,	"7","c","A" ,	"7","d","A" ,	"7","e","A" ,	"7","f","A" ,	"7","g","A" ,	"7","h","M" ,
							"8","a","M" ,	"8","b","M" ,	"8","c","A" ,	"8","d","A" ,	"8","e","A" ,	"8","f","A" ,	"8","g","A" ,	"8","h","M"	 
														
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
