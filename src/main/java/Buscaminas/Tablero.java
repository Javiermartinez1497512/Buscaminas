package Buscaminas;

public class Tablero {
	
    protected String[][] tablero_minas;
    protected String[][] tablero;
    private int tamanoX = 8;
    private int tamanoY = 8;
    private int minas = 8;


    public Tablero() {
        this.tablero_minas = new String[this.tamanoX][this.tamanoY];
        this.tablero = new String[this.tamanoX][this.tamanoY];
        this.iniciarTablero();
        this.inicializarMinas();
    }
    
    public void iniciarTablero() {
		for(int i = 0; i<this.tablero.length; i++) {
			for (int j = 0; j<this.tablero[i].length; j++) {
				tablero[i][j] = " ";
			}
		}
    }
    
	private void inicializarMinas() {
		for (int i = 0; i < this.minas; i++) {
			boolean stop = false;
			
			while (!stop) {
				int aleatorioX = (int) (Math.random()*this.tamanoX);
				int aleatorioY = (int) (Math.random()*this.tamanoY);
				
				if (this.tablero_minas[aleatorioX][aleatorioY] == null) {
					this.tablero_minas[aleatorioX][aleatorioY] = "X";
					stop = true;
				}
			}
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
	
	public void actualizar(Movimiento movimiento) {
		switch(movimiento.getAccion()) {
		case("A"):
			if(this.tablero[movimiento.getFila()][movimiento.getColumna()] == " ") {
				//this.tablero cuentaVecinos(movimiento.getFila(),movimiento.getColumna())
				this.tablero[movimiento.getFila()][movimiento.getColumna()] = "A";
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
	
	public int cuentaVecinos(int fila, int columna) {
		int contador = 0;
		
		return contador;
	}
}