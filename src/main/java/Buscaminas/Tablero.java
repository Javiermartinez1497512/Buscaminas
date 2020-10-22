package Buscaminas;

public class Tablero {
	
    protected String[][] tablero_minas;
    protected String[][] tablero;
    private int tamanoX = 8;
    private int tamanoY = 8;
    private int minas = 8;
    private MockRNG rng;

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

	private void inicializarMinas() {
		for (int i = 0; i < this.minas; i++) 
		{
			int v[]=rng.getRandomNumber();
	    	
			int aleatorioX= v[0];
			int aleatorioY = v[1];
			
			if (this.tablero_minas[aleatorioX][aleatorioY] == null) {
				this.tablero_minas[aleatorioX][aleatorioY] = "X";}
		}
	}
	
	public void inicializarMinasTest() {
		
		this.inicializarMinas();
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
	
	public void actualizar(Movimiento movimiento) {
		switch(movimiento.getAccion()) {
		case("A"):
			if(this.tablero[movimiento.getFila()][movimiento.getColumna()] == " ") {
				int vecinos = proxyCuentaVecinos(movimiento.getFila(),movimiento.getColumna());
				this.tablero[movimiento.getFila()][movimiento.getColumna()] = Integer.toString(vecinos);
				//this.tablero[movimiento.getFila()][movimiento.getColumna()] = "A";
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
	public void setRNG(MockRNG r) {
		
		this.rng=r;
	}
	public String getPos(int x, int y) {
		return this.tablero_minas[x][y];
	}
	public int getTamano()
	{
		return this.tamanoX;
	}
	
	
	public boolean compruebaMinas(Movimiento movimiento) {
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
}