package Buscaminas;

public class Tablero {
	
    private String[][] tablero_minas;
    private String[][] tablero;
    private int tamanoX = 8;
    private int tamanoY = 8;
    private int minas = 8;
    private RNG rng;
    private int casillasRestantes = this.tamanoX*this.tamanoY-this.minas;

    public Tablero() {
        this.tablero_minas = new String[this.tamanoX][this.tamanoY];
        this.tablero = new String[this.tamanoX][this.tamanoY];
        this.iniciarTablero(); 
    }
    
    public void iniciarTablero() {
		for(int i = 0; i<this.tablero.length; i++) {
			for (int j = 0; j<this.tablero[i].length; j++) {
				tablero[i][j] = " ";
			}
		}
    }

    public void inicializarMinas() {	
		int v[];
		int aleatorioX, aleatorioY;
		for (int i = 0; i < this.minas; i++) {
			 v=rng.getRandomNumber();		 
			 aleatorioX= v[0];
			 aleatorioY = v[1];
			 			
			if (this.tablero_minas[aleatorioX][aleatorioY] == null){
				this.tablero_minas[aleatorioX][aleatorioY] = "X";
			}
			else if(this.tablero_minas[aleatorioX][aleatorioY] == "X") 
				i--;
		}
	}
	public String pintar() {
		String pintar = "";
		pintar+="   A B C D E F G H\n";
		for(int i = 0; i<this.tablero.length; i++) {
			pintar+="  -----------------\n";
			pintar+=(i+1)+" |";
			for (int j = 0; j<this.tablero[i].length; j++) {
				pintar+=this.tablero[i][j]+"|";
			}
			pintar+="\n";
		}
		return pintar;
	}
	public boolean compruebaGanador() {
		boolean ganador = false;
    	
    	if (this.casillasRestantes == 0) {
    		ganador = true;
    	}
    	
    	return ganador;
    }
	
	private void actualizar(Movimiento movimiento) {
		switch(movimiento.getAccion()) {
		case("A"):
			if(this.tablero[movimiento.getFila()][movimiento.getColumna()] == " ") {
				int vecinos = this.cuentaVecinos(movimiento.getFila(),movimiento.getColumna());
				this.tablero[movimiento.getFila()][movimiento.getColumna()] = Integer.toString(vecinos);
				this.setCasillasRestantes(this.casillasRestantes = this.casillasRestantes-1);
			}
			break;
		case("M"):
			if (this.tablero[movimiento.getFila()][movimiento.getColumna()] == " ") {
				this.tablero[movimiento.getFila()][movimiento.getColumna()] = "M";
			}
			break; 	
		case("D"):
			if (this.tablero[movimiento.getFila()][movimiento.getColumna()] == "M") {
				this.tablero[movimiento.getFila()][movimiento.getColumna()] = " ";
			}
			break;
		}
	}
	public void setRNG(RNG r) {
		this.rng=r;
	}
	public void setCasillasRestantes(int restantes) {
		this.casillasRestantes=restantes;
	}
	
    	public String[][] getTablero() {
  		return tablero;
      	}
	public String getPos(int x, int y) {
		return this.tablero_minas[x][y];
	}
	
	public int getTamano()	{
		return this.tamanoX;
	}
	
	public String getPosicionTablero(int x, int y) {
		return this.tablero[x][y];
	}
	
	private boolean compruebaMinas(Movimiento movimiento) {
		boolean mina = false;
		 
		if (tablero_minas[movimiento.getFila()][movimiento.getColumna()]=="X") {
			mina = true;
		}
		
		return mina;
	}
	
	
	public boolean aplicaAccion(Movimiento movimiento) {
		boolean mina = false;
		
		switch(movimiento.getAccion()) {
		case("A"):
			if (this.tablero[movimiento.getFila()][movimiento.getColumna()] == " ") {
				mina = this.compruebaMinas(movimiento);
				if (!mina) {
					this.actualizar(movimiento);
				}
			}
			break;
		case("M"):
			this.actualizar(movimiento);
			break;
		case("D"):
			this.actualizar(movimiento);
			break;
		case("C"):
			break;
		}
		
		return mina;
	}
	
	private int cuentaVecinos(int fila, int columna) {
		int contador = 0;
		
		if (fila == 0 && columna == 0) {
			contador = this.cuentaArribaIzquierda();
		}else if (fila == 0 && columna == this.tamanoY-1) {
			contador = this.cuentaArribaDerecha();
		}else if (fila == this.tamanoX-1 && columna == 0) {
			contador = this.cuentaAbajoIzquierda();
		}else if (fila == this.tamanoX-1 && columna == this.tamanoY-1) {
			contador = this.cuentaAbajoDerecha();
		}else if (fila == 0) {
			contador = this.cuentaArriba(columna);
		}else if (fila == this.tamanoX-1) {
			contador = this.cuentaAbajo(columna);
		}else if(columna == 0) {
			contador = this.cuentaIzquierda(fila);
		}else if (columna == this.tamanoY-1) {
			contador = this.cuentaDerecha(fila);
		}else {
			contador = this.cuentaCentro(fila, columna);
		}
		
		return contador;
	}
	
	//Metodos para contar vecinos de las esquinas.
	private int cuentaArribaIzquierda() {
		int contador = 0;
		if (this.tablero_minas[0][1] == "X") {
			contador++;
		}
		if (this.tablero_minas[1][0] == "X") {
			contador++;
		}
		if(this.tablero_minas[1][1] == "X") {
			contador++;
		}
		return contador;
	}
	private int cuentaArribaDerecha() {
		int contador = 0;
		if (this.tablero_minas[0][this.tamanoY-2] == "X") {
			contador++;
		}
		if (this.tablero_minas[1][this.tamanoY-2] == "X") {
			contador++;
		}
		if (this.tablero_minas[1][this.tamanoY-1] == "X") {
			contador++;
		}
		return contador;
	}
	private int cuentaAbajoIzquierda() {
		int contador = 0;
		if (this.tablero_minas[this.tamanoX-2][0] == "X") {
			contador++;
		}
		if (this.tablero_minas[this.tamanoX-2][1] == "X") {
			contador++;
		}
		if (this.tablero_minas[this.tamanoX-1][1] == "X") {
			contador++;
		}
		return contador;
	}
	private int cuentaAbajoDerecha() {
		int contador = 0;
		if (this.tablero_minas[this.tamanoX-2][this.tamanoY-2] == "X") {
			contador++;
		}
		if (this.tablero_minas[this.tamanoX-2][this.tamanoY-1] == "X") {
			contador++;
		}
		if (this.tablero_minas[this.tamanoX-1][this.tamanoY-2] == "X") {
			contador++;
		}
		return contador;
	}
	//Metodos contar limites tablero
	private int cuentaArriba(int columna) {
		int contador = 0;
		if (this.tablero_minas[0][columna-1] == "X") {
			contador++;
		}
		if (this.tablero_minas[0][columna+1] == "X") {
			contador++;
		}
		if (this.tablero_minas[1][columna-1] == "X") {
			contador++;
		}
		if (this.tablero_minas[1][columna] == "X") {
			contador++;
		}
		if (this.tablero_minas[1][columna+1] == "X") {
			contador++;
		}
		return contador;
	}
	private int cuentaDerecha(int fila) {
		int contador = 0;
		if (this.tablero_minas[fila-1][this.tamanoY-1] == "X") {
			contador++;
		}
		if (this.tablero_minas[fila-1][this.tamanoY-2] == "X") {
			contador++;
		}
		if (this.tablero_minas[fila][this.tamanoY-2] == "X") {
			contador++;
		}
		if (this.tablero_minas[fila+1][this.tamanoY-2] == "X") {
			contador++;
		}
		if (this.tablero_minas[fila+1][this.tamanoY-1] == "X") {
			contador++;
		}
		return contador;
	}
	private int cuentaIzquierda(int fila) {
		int contador = 0;
		if (this.tablero_minas[fila-1][0] == "X") {
			contador++;
		}
		if (this.tablero_minas[fila-1][1] == "X") {
			contador++;
		}
		if (this.tablero_minas[fila][1] == "X") {
			contador++;
		}
		if (this.tablero_minas[fila+1][0] == "X") {
			contador++;
		}
		if (this.tablero_minas[fila+1][1] == "X") {
			contador++;
		}
		return contador;
	}
	private int cuentaAbajo(int columna) {
		int contador = 0;
		if (this.tablero_minas[this.tamanoX-1][columna-1] == "X") {
			contador++;
		}
		if (this.tablero_minas[this.tamanoX-2][columna-1] == "X") {
			contador++;
		}
		if (this.tablero_minas[this.tamanoX-2][columna] == "X") {
			contador++;
		}
		if (this.tablero_minas[this.tamanoX-2][columna+1] == "X") {
			contador++;
		}
		if (this.tablero_minas[this.tamanoX-1][columna+1] == "X") {
			contador++;
		}
		return contador;
	}
	//Metodo para contar vecinos centrales
	private int cuentaCentro(int fila, int columna) {
		int contador = 0;
		if (this.tablero_minas[fila-1][columna-1] == "X") {
			contador++;
		}
		if (this.tablero_minas[fila-1][columna] == "X") {
			contador++;
		}
		if (this.tablero_minas[fila-1][columna+1] == "X") {
			contador++;
		}
		if (this.tablero_minas[fila][columna-1] == "X") {
			contador++;
		}
		if (this.tablero_minas[fila][columna+1] == "X") {
			contador++;
		}
		if (this.tablero_minas[fila+1][columna-1] == "X") {
			contador++;
		}
		if (this.tablero_minas[fila+1][columna] == "X") {
			contador++;
		}
		if (this.tablero_minas[fila+1][columna+1] == "X") {
			contador++;
		}
		return contador;
	}
	
	
	
	//Metodos Proxy
	public int proxyCuentaVecinos(int fila, int columna) {
		int vecinos = this.cuentaVecinos(fila, columna); 
		return vecinos;
	}
	public boolean proxyCompruebaMinas(Movimiento movimiento) {
		return this.compruebaMinas(movimiento);
	}
	public int proxyCuentaArribaIzquierda() {
		return this.cuentaArribaIzquierda();
	}
	public int proxyCuentaArribaDerecha() {
		return this.cuentaArribaDerecha();
	}
	public int proxyCuentaAbajoIzquierda() {
		return this.cuentaAbajoIzquierda();
	}
	public int proxyCuentaAbajoDerecha() {
		return this.cuentaAbajoDerecha();
	}
	public int proxyCuentaArriba(int columna) {
		return this.cuentaArriba(columna);
	}
	public int proxyCuentaAbajo(int columna) {
		return this.cuentaAbajo(columna);
	}
	public int proxyCuentaIzquierda(int fila) {
		return this.cuentaIzquierda(fila);
	}
	public int proxyCuentaDerecha(int fila) {
		return this.cuentaDerecha(fila);
	}
	public int proxyCuentaCentro(int fila, int columna) {
		return this.cuentaCentro(fila, columna);
	}
}
