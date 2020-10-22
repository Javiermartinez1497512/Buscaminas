
package Buscaminas;

public class RNG extends Tablero {
	
	int[] getRandomNumber() {
		int [] v= {(int) (Math.random()*this.getTamano()),(int) (Math.random()*this.getTamano())};
		return v;
	}
}