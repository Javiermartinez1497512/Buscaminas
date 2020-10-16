
package Buscaminas;
import java.util.*; 


public class CrearAleatorioMock implements CrearAleatorio {

	@Override
	public Integer RandomDouble (Integer i) {
		
		return this.randoms.get(i);
	}
	private Hashtable<Integer, Integer> randoms = new Hashtable<Integer, Integer>();
	
	public void addRandom(Integer i, Integer d)
	{
		this.randoms.put(i, d);
	}
}
