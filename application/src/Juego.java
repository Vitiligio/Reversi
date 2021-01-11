package src;

import excepciones.NoHayFichaExcepcion;

public class Juego {

	private Tablero tablero;
	
	public Juego() {
		this.tablero = new Tablero(8);
	}
	
	public void prepararJuego() {
		this.tablero.posicionInicialTablero();
	}
	
	public boolean hayFichaNegraEn(char letra, int numero) {
		return this.tablero.hayFichaNegra(letra, numero);
	}
	public boolean hayFichaBlancaEn(char letra, int numero) {
		return this.tablero.hayFichaBlanca(letra, numero);
	}
	
	public void ponerFicha(char letra, int numero, Ficha ficha) {
		int letraTraducida = this.tablero.traducirLetra(letra);
		numero = this.tablero.traducirNumero(numero);
		this.ponerFicha(letraTraducida, numero, ficha);
	}
	
	public void ponerFicha(int letra, int numero, Ficha ficha) {

		try {
			for(int i = numero  - 1; i <= numero + 1; i++) {
				for(int j = letra - 1; j <= letra + 1; j++) {
					if(this.hayUnaFichaOpuesta(j, i, ficha)) {
						boolean cambianColor = this.terminaEnMismoColor(letra, numero, j - letra, i - numero, ficha);
						if(cambianColor) {
							this.voltearFichasOpuestas(letra, numero, j - letra, i - numero, ficha);
							this.tablero.ocupar(letra, numero, ficha);
						}
					}
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			
		}
	}
	
	public void voltearFichasOpuestas(int letra, int numero, int direccionLetra, int direccionNumero, Ficha ficha) {
		
		if(this.hayUnaFichaOpuesta(letra + direccionLetra, numero + direccionNumero, ficha)) {
			this.tablero.cambiarColor(letra + direccionLetra, numero + direccionNumero);
			this.terminaEnMismoColor(letra + direccionLetra, numero + direccionNumero, direccionLetra, direccionNumero, ficha);
		}

	}
	
	public boolean terminaEnMismoColor(int letra, int numero, int direccionLetra, int direccionNumero, Ficha ficha) {
		
		if(this.hayUnaFichaOpuesta(letra + direccionLetra, numero + direccionNumero, ficha)) {
			return this.terminaEnMismoColor(letra + direccionLetra, numero + direccionNumero, direccionLetra, direccionNumero, ficha);
		}
		
		else if(this.hayUnaFichaIgual(letra + direccionLetra, numero + direccionNumero, ficha)) {
			return true;
		} 
		
		else {
			return false;
		}
	}
	
	public boolean hayUnaFichaIgual(int j, int i, Ficha ficha) {
		try {
			Ficha otraFicha = this.tablero.getFicha(j, i);
			return this.sonIguales(ficha, otraFicha);
		} catch (NoHayFichaExcepcion e) {
			return false;
		}
		
	}
	
	public boolean sonIguales(Ficha ficha, Ficha otraFicha) {
		return (ficha.getClass() == otraFicha.getClass());
	}
	
	public boolean hayUnaFichaOpuesta(int j, int i, Ficha ficha) {
		try {
			Ficha otraFicha = this.tablero.getFicha(j, i);
			otraFicha = otraFicha.cambiarColor();
			return this.sonIguales(ficha, otraFicha);
		} catch (NoHayFichaExcepcion e) {
			return false;
		}
		
	}

	
}
