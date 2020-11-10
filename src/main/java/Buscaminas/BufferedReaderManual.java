package Buscaminas;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BufferedReaderManual implements BufferedReaderInterface {


	public String read() throws Exception {
		 BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		 String s = r.readLine();
		return s;
	}

	@Override
	public void setConfig(int c) {
		
		
	}

}
