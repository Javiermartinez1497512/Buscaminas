package Buscaminas;

public class Partida {
	private boolean perdido;
	private Tablero tablero;
	private BufferedReaderInterface reader;

	public Partida(RNG RandomNumberGenerator) {
		this.perdido = false;
		this.tablero = new Tablero();
		tablero.setRNG(RandomNumberGenerator);
		this.tablero.inicializarMinas();
		
	}

	public boolean getPerdido() {
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
	
			while (!this.getPerdido() && !this.tablero.compruebaGanador()) {
				System.out.print("Introduce el numero de fila [1-8]: "+"\n");
				String x = reader.read();
				System.out.print("Introduce la letra de fila [A-H]: "+"\n");
				String y = reader.read();
				System.out.println();
	
				Movimiento movimiento = new Movimiento();
	
				if (movimiento.validaMovimiento(x, y)) {
					System.out.print("Introduce una accion a realizar A[Abrir], M[Marcar], D[Desmarcar], C[Cancelar]: "+"\n");
					String accion = reader.read();
					
					if (movimiento.validaAccion(accion)) {
						//Aqui tocaria ya comprobar cosas con el tablero.
						boolean mina = tablero.aplicaAccion(movimiento);
						
						if (mina) {
							System.out.println("GAME OVER :("+"\n");
							this.noSeguir();
							
						}else {
							System.out.println(tablero.pintar());
						}
					}else {
						System.out.println("ERR3: Las acciones permitidas son : A, M, D, C . Vuelva a introducir su casilla y su accion"+"\n");
					}	
				}else {
					if (!movimiento.validaFila(x)) {
						System.out.println("ERR1: El primer campo es un valor entre 1 y 8. Vuelva a introducir su casilla"+"\n");
					}else if (!movimiento.validaColumna(y)) {
						System.out.println("ERR2: El segundo campo es una letra entre A y H. Vuelva a introducir su casilla"+"\n");
					}
				}
			}
			boolean ganador = false;
			if (tablero.compruebaGanador()) {
				System.out.println("YOU WIN!!!!!");
				ganador = true;
			}
			return ganador;
		}

	public static void main(String [] args) throws Exception {
		
		RNG rng= new AleatorioRNG();		
		Partida partida = new Partida(rng);
		
		BufferedReaderInterface BufferReader= new BufferedReaderManual();
		partida.setBufferedReader(BufferReader);
		
		partida.iniciar();
		
	}
}
