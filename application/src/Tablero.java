package src;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import excepciones.LetraNoValidaExcepcion;

public class Tablero {
	
	private Casillero[][] tablero;
	
	public Tablero(int fila) {
		this.tablero = new Casillero[fila][fila];
		this.inicializarTablero();
	}
	
	private void inicializarTablero() {
		for(int i = 0; i < this.tablero.length; i++) {
			for(int j = 0; j < this.tablero.length; j++) {
				this.tablero[i][j] = new Casillero();
			}
		}
	}
	
	public void posicionInicialTablero() {
		
		this.vaciarTablero();
		
		FichaNegra fichaNegra = new FichaNegra();
		FichaBlanca fichaBlanca = new FichaBlanca();
		
		this.ocupar('D', 4, fichaBlanca);
		this.ocupar('E', 5, fichaBlanca);
		this.ocupar('D', 5, fichaNegra);
		this.ocupar('E', 4, fichaNegra);
	}
	
	public void ocupar(char letra, int numero, Ficha ficha) {
		int letraTraducida = this.traducirLetra(letra);
		numero = this.traducirNumero(numero);
		this.ocupar(letraTraducida, numero, ficha);
	}
	public void vaciar(char letra, int numero) {
		int letraTraducida = this.traducirLetra(letra);
		numero = this.traducirNumero(numero);
		this.vaciar(letraTraducida, numero);
	}
	
	public void ocupar(int letra, int numero, Ficha ficha) {
		this.tablero[letra][numero].ocupar(ficha);
	}
	public void vaciar(int letra, int numero) {
		this.tablero[letra][numero].vaciar();
	}
	
	public boolean estaOcupado(char letra, int numero) {
		int letraTraducida = this.traducirLetra(letra);
		numero = this.traducirNumero(numero);
		return this.tablero[letraTraducida][numero].estaOcupado();
	}
	
	private int traducirLetra(char letra) throws LetraNoValidaExcepcion {
		switch(letra) {
			case 'A':
				return 0;
			case 'B':
				return 1;
			case 'C':
				return 2;
			case 'D':
				return 3;
			case 'E':
				return 4;
			case 'F':
				return 5;
			case 'G':
				return 6;
			case 'H':
				return 7;
			default:
				throw new LetraNoValidaExcepcion();
		}
	}
	
	private int traducirNumero(int numero) {
		return (numero - 1);
	}
	
	public int length() {
		return this.tablero.length;
	}
	
	public void vaciarTablero() {
		for(int i = 0; i < this.tablero.length; i++) {
			for(int j = 0; j < this.tablero.length; j++) {
				this.vaciar(i, j);
			}
		}
	}
	
	public boolean hayFichaNegra(char letra, int numero) {
		int letraTraducida = this.traducirLetra(letra);
		numero = this.traducirNumero(numero);
		return this.hayFichaNegra(letraTraducida, numero);
	}
	
	public boolean hayFichaNegra(int letra, int numero) {
		return this.tablero[letra][numero].tieneFichaNegra();
	}
	
	public boolean hayFichaBlanca(char letra, int numero) {
		int letraTraducida = this.traducirLetra(letra);
		numero = this.traducirNumero(numero);
		return this.hayFichaBlanca(letraTraducida, numero);
	}
	
	public boolean hayFichaBlanca(int letra, int numero) {
		return this.tablero[letra][numero].tieneFichaBlanca();
	}

	
}
