package Buscaminas;

public class Movimiento {
	private int fila;
	private String columna;
	private String accion;
	
	public Movimiento() {
		this.fila = 0;
		this.columna = null;
		this.accion = null;
	}
	
	public boolean validaFila(int fila) {
		boolean correcto = false;
		
		if (fila <= 8 && fila >= 1) {
			correcto = true;
			this.fila = fila;
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
			
			if (correcto) {
				this.columna = columna_Upper;
			}
		}
		
		return correcto;
	}
	public boolean validaMovimiento(int fila, String columna) {
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
}
