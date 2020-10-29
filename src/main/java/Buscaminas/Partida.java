package Buscaminas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Partida {
	private boolean perdido;
	private Tablero tablero;

	public Partida() {
		this.perdido = false;
		this.tablero = new Tablero();
		this.tablero.iniciarMinasAleatorias();
		
	}

	public boolean seguir() {
		return this.perdido;
	}

	public void noSeguir() {
		this.perdido = true;
	}

	public void iniciar() throws IOException {
		// Objeto para leer por teclado.
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Empieza la partida");
		System.out.println();
		System.out.println(tablero.pintar());

		while (!this.seguir() || this.tablero.compruebaGanador()) {
			System.out.print("Introduce el numero de fila [1-8]: ");
			String x = reader.readLine();
			System.out.print("Introduce la letra de fila [A-H]: ");
			String y = reader.readLine();
			System.out.println();

			Movimiento movimiento = new Movimiento();

			if (movimiento.validaMovimiento(x, y)) {
				System.out.print("Introduce una acción a realizar A[Abrir], M[Marcar], D[Desmarcar], C[Cancelar]: ");
				String accion = reader.readLine();
				
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
					System.out.println("ERR3: Introduce Introduce una acción permitida (A, M, D, C).");
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
		}
	}

	public static void main(String [] args) throws IOException {
		Partida partida = new Partida();
		partida.iniciar();
	}
}
