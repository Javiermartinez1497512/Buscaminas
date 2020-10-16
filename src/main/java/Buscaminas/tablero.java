package Buscaminas;

public class tablero {
	
    private String[][] tablero_minas;
    private int tamanoX = 8;
    private int tamanoY = 8;


    public void Tablero() {

        this.tablero_minas = new String[this.tamanoX][this.tamanoY];
        this.inicializarMinas();
    }
	private void inicializarMinas() {};
	
	public void inicializarMinasTest() {
		inicializarMinas();	}
	
	public String getRes(Integer x, Integer y) 
	{		
			return tablero_minas[x][y];
		
	}
}