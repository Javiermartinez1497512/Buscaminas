package Buscaminas;

public class AleatorioRNG implements RNG{

	public int[] getRandomNumber() {
		int [] v= {(int) (Math.random()*8),(int) (Math.random()*8)};
		return v;
	}
	public int[] getRandomNumber2() {
		int [] v= {(int) (Math.random()*8),(int) (Math.random()*8)};
		return v;
	}

	@Override
	public void setConfig(int c) {}
}
