package Buscaminas;

public class Movimiento {
	private int fila;
	private String columna;
	
	public Movimiento() {
		this.fila = 0;
		this.columna = null;
	}
	
	private boolean validaFila(int fila) {
		boolean correcto = false;
		
		if (fila <= 8 && fila >= 1) {
			correcto = true;
			this.fila = fila;
		}
		
		return correcto;
	}
	
	private boolean validaColuma(String columna) {
		boolean correcto = false;
		
		if (columna.length() == 1) {
			String columna_Upper = columna.toUpperCase();
			switch(columna_Upper) {
				case("A"):
					correcto = true;
					break;
				case("B"):
					correcto = true;
					break;
				case("C"):
					correcto = true;
					break;
				case("D"):
					correcto = true;
					break;
				case("E"):
					correcto = true;
					break;
				case("F"):
					correcto = true;
					break;
				case("G"):
					correcto = true;
					break;
				case("H"):
					correcto = true;
					break;
			}
		}
		
		return correcto;
	}
	
	// Métodos Proxy de los métodos private.
	public boolean proxyValidaFila(int fila) {
		return validaFila(fila);
	}
	public boolean proxyValidaColumna(String columna) {
		return validaColuma(columna);
	}
}
