package src;

public class Juego {

	private Tablero tablero;
	
	public Juego() {
		this.tablero = new Tablero(8);
	}
	
	public void prepararJuego() {
		this.tablero.posicionInicialTablero();
	}
}
