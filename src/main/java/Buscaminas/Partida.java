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
		tablero.pintar();

		while (!this.seguir()) {
			System.out.print("Introduce el numero de fila [1-8]: ");
			String x = reader.readLine();
			System.out.print("Introduce la letra de fila [A-H]: ");
			String y = reader.readLine();
			System.out.println();

			// Convertimos el numero de fila a String
			int x_toInt = Integer.parseInt(x);

			Movimiento movimiento = new Movimiento();

			if (movimiento.validaMovimiento(x_toInt, y)) {
				System.out.print("Introduce una acción a realizar A[Abrir], M[Marcar], D[Desmarcar], C[Cancelar]: ");
				String accion = reader.readLine();
				
				if (movimiento.validaAccion(accion)) {
					//Aqui tocaria ya comprobar cosas con el tablero.
					boolean mina = tablero.aplicaAccion(movimiento);
					
					if (mina) {
						System.out.println("GAME OVER :(");
						this.noSeguir();
					}else {
						tablero.pintar();
					}
				}else {
					System.out.println("ERR3: Introduce Introduce una acción permitida (A, M, D, C).");
				}	
			}else {
				if (!movimiento.validaFila(x_toInt)) {
					System.out.println("ERR1: Introduce un valor entre 1 y 8.");
					this.noSeguir();
				}else if (!movimiento.validaColumna(y)) {
					System.out.println("ERR2: Introduce una letra entre A y H.");
					this.noSeguir();
				}
			}
		}
	}

	public static void main(String [] args) throws IOException {
		Partida partida = new Partida();
		partida.iniciar();
	}
}
