package Buscaminas;

public class Partida {
	private boolean perdido;
	private Tablero tablero;
	private BufferedReaderInterface reader;

	public Partida() {
		this.perdido = false;
		this.tablero = new Tablero();
		MockRNG mRNG= new MockRNG();
		tablero.setRNG(mRNG);
		mRNG.setConfig(0);
		this.tablero.inicializarMinas();
		
	}

	public boolean seguir() {
		return this.perdido;
	}

	public void noSeguir() {
		this.perdido = true;
	}
	public void setBufferedReader(BufferedReaderInterface r) {
		this.reader=r;
	}

	public boolean iniciar() throws Exception {
		// Objeto para leer por teclado.

		System.out.println("Empieza la partida");
		System.out.println();
		System.out.println(tablero.pintar());

		while (!this.seguir() || this.tablero.compruebaGanador()) {
			System.out.print("Introduce el numero de fila [1-8]: ");
			String x = reader.read();
			System.out.print("Introduce la letra de fila [A-H]: ");
			String y = reader.read();
			System.out.println();

			Movimiento movimiento = new Movimiento();

			if (movimiento.validaMovimiento(x, y)) {
				System.out.print("Introduce una accion a realizar A[Abrir], M[Marcar], D[Desmarcar], C[Cancelar]: ");
				String accion = reader.read();
				
				if (movimiento.validaAccion(accion)) {
					//Aqui tocaria ya comprobar cosas con el tablero.
					boolean mina = tablero.aplicaAccion(movimiento);
					
					if (mina) {
						System.out.println("GAME OVER :(");
						this.noSeguir();
						
					}else {
						System.out.println(tablero.pintar());
					}
				}else {
					System.out.println("ERR3: Introduce Introduce una accion permitida (A, M, D, C).");
				}	
			}else {
				if (!movimiento.validaFila(x)) {
					System.out.println("ERR1: Introduce un valor entre 1 y 8.");
				}else if (!movimiento.validaColumna(y)) {
					System.out.println("ERR2: Introduce una letra entre A y H.");
				}
			}
		}
		if (tablero.compruebaGanador()) {
			System.out.println("YOU WIN!!!!!");
			return true;
		}
		return false;
	}

	public static void main(String [] args) throws Exception {
		Partida partida = new Partida();
		BufferedReaderInterface mockBufferReader= new MockBufferedReader();
		partida.setBufferedReader(mockBufferReader);
		boolean guanyat=partida.iniciar();
	}
}
