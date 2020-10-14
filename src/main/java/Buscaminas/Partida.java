package Buscaminas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Partida {
	private boolean perdido;

	public Partida() {
		this.perdido = false;
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
				System.out.println("De momento todo OK.");
				this.noSeguir();
			}else {
				if (!movimiento.validaFila(x_toInt)) {
					System.out.println("Introduce un valor entre 1 y 8.");
					this.noSeguir();
				}else if (!movimiento.validaColumna(y)) {
					System.out.println("Introduce una letra entre A y H.");
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
