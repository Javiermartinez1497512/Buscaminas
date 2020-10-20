package Buscaminas;

public class TableroMock extends Tablero {

	public TableroMock() {
		 this.tablero_minas = new String[8][8];
	     this.tablero = new String[8][8];
	}
	
	public TableroMock(boolean x) {
		super();
	}
	
	public void insertaMina(int x, int y) {
		super.tablero_minas[x][y] = "X";
	}
	
	public String getPos(int x, int y) {
		return super.tablero_minas[x][y];
	}
	
	public int contarMinas() {
		int contador = 0;
		for (int i = 0; i<this.tablero_minas.length; i++) {
			for (int j = 0; j<this.tablero_minas[i].length; j++) {
				if (this.tablero_minas[i][j] == "X") {
					contador++;
				}
			}
		}
		return contador;
	}
	
	public void pintaMinas() {
		System.out.println("   A B C D E F G H");
		for(int i = 0; i<this.tablero_minas.length; i++) {
			System.out.println("  -----------------");
			System.out.print((i+1)+" |");
			for (int j = 0; j<this.tablero_minas[i].length; j++) {
				System.out.print(tablero_minas[i][j]+"|");
			}
			System.out.println();
		}
	}
}
