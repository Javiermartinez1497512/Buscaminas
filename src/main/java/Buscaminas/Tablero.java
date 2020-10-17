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
        this.inicializarMinas();
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
	
	public void pintar() {
		
	}
	
	public void actualizar() {
		
	}
	
	public boolean compruebaMinas(Movimiento movimiento) {
		return true;
	}
}