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
	
	// Métodos Proxy de los métodos private.
	public boolean proxyValidaFila(int fila) {
		return validaFila(fila);
	}
}
