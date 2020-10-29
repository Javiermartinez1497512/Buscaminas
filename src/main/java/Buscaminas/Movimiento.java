package Buscaminas;

public class Movimiento {
	private int fila;
	private int columna;
	private String accion;
	
	public Movimiento() {
		this.fila = 0;
		this.columna = 0;
		this.accion = null;
	}
	
	public boolean validaFila(String fila) {
		boolean correcto = false;
		
		try {
			int fila_integer = Integer.parseInt(fila);
			
			if (fila_integer <= 8 && fila_integer >= 1) {
				correcto = true;
				this.fila = fila_integer-1;
			}
		}catch(NumberFormatException nfe) {
			correcto = false;
		} 
		return correcto;
	}
	
	public boolean validaColumna(String columna) {
		boolean correcto = false;
		
		if (columna.length() == 1) {
			String columna_Upper = columna.toUpperCase();
			switch(columna_Upper) {
				case("A"):
					correcto = true;
					this.columna = 0;
					break;
				case("B"):
					correcto = true;
					this.columna = 1;
					break;
				case("C"):
					correcto = true;
					this.columna = 2;
					break;
				case("D"):
					correcto = true;
					this.columna = 3;
					break;
				case("E"):
					correcto = true;
					this.columna = 4;
					break;
				case("F"):
					correcto = true;
					this.columna = 5;
					break;
				case("G"):
					correcto = true;
					this.columna = 6;
					break;
				case("H"):
					correcto = true;
					this.columna = 7;
					break;
			}
		}
		
		return correcto;
	}
	public boolean validaMovimiento(String fila, String columna) {
		boolean correcto = false;
		
		if (this.validaFila(fila) && this.validaColumna(columna)) {
			correcto = true;
		}
		return correcto;
	}
	public boolean validaAccion(String accion) {
		boolean correcto = false;
		if (accion.length() == 1) {
			String accion_Upper = accion.toUpperCase();
			
			switch(accion_Upper) {
			case("A"):
				correcto = true;
				break;
			case("M"):
				correcto = true;
				break;
			case("D"):
				correcto = true;
				break;
			case("C"):
				correcto = true;
				break;
			}
			
			if (correcto) {
				this.accion = accion_Upper;
			}
		}
		return correcto;
	}
	
	public int getFila() {
		return this.fila;
	}
	
	public int getColumna() {
		return this.columna;
	}
	
	public String getAccion() {
		return this.accion;
	}
}
