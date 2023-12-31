package examen;

import java.util.Scanner;

public class Principal {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		// Variable donde se almacenará el movimiento del jugador
		String movimiento;

		// Variable donde se almacenará el valor del movimiento
		int valorMovimiento = 0;

		// Creamos un nuevo objeto de Tablero
		Tablero tab = new Tablero();

		// Le damos la bienvenida al usuario
		System.out.println("BIENVENIDO AL JUEGO DE LA BÚSQUEDA DEL TESORO");

		// Generamos la posicion del tesoro
		Tablero.generaPosicionTesoro();

		// Ejecutamos hasta que encuentre el tesoro
		while (!tab.buscaTesoro()) {

			// Pintamos el tablero
			tab.pintaTablero();

			// Ejecutamos mientras el movimiento no sea válido
			do {
				// Obtenemos la cadena del movimiento
				movimiento = pideMovimiento();

				// Obtenemos el valor de movimiento
				valorMovimiento = tab.mueveJugador(movimiento);

				// Según el valor devuelto mostramos un mensaje
				if (valorMovimiento == -1) {
					System.out.println("Ese movimiento no está dentro de los límites del tablero");
				} else if (valorMovimiento == -2) {
					System.out.println("Lo siento, pero no entiendo ese movimiento");
				}

			} while (valorMovimiento != 0);

		}

		// Cuando el jugador gana volvemos a pintar el tablero
		tab.pintaTablero();
		
		// Mostramos el mensaje de victoria
		System.out.println("¡ENHORABUENA! Has encontrado el tesoro =D");

		// Cerramos el Scanner
		sc.close();
	}

	// Función que pide el movimiento
	static String pideMovimiento() {
		// Variable donde se almacena el movimiento del jugador
		String movimiento;

		// Pedimos y almacenamos el movimiento
		System.out.println("¿Hacia donde quiere moverse? (ARRIBA, ABAJO, IZQUIERDA, DERECHA)");
		movimiento = sc.nextLine();

		// Devolvemos el movimiento del jugador
		return movimiento;
	}

}
