package test;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import src.Ficha;
import src.FichaBlanca;
import src.FichaNegra;
import src.Tablero;

public class TableroTest {
	
	@Test
	public void test_crear_un_tablero() {
		
		Tablero tablero = new Tablero(8);
		assertNotEquals(null, tablero);
	}
	
	@Test
	public void test_crear_un_tablero_con_columnas_pedidas() {
		
		Tablero tablero = new Tablero(8);
		assertEquals(8, tablero.length());
	}
	
	@Test 
	public void test_ocupar_el_primer_casillero() {
		Tablero tablero = new Tablero(8);
		FichaNegra ficha = new FichaNegra();
		tablero.ocupar('A', 1, ficha);
		assertEquals(true, tablero.estaOcupado('A', 1));
	}
	
	@Test 
	public void test_ocupar_el_ultimo_casillero() {
		Tablero tablero = new Tablero(8);
		FichaNegra ficha = new FichaNegra();
		tablero.ocupar('H', 8, ficha);
		assertEquals(true, tablero.estaOcupado('H', 8));
	}
	
	@Test 
	public void test_vaciar_el_primer_casillero() {
		Tablero tablero = new Tablero(8);
		FichaNegra ficha = new FichaNegra();
		tablero.ocupar('A', 1, ficha);
		tablero.vaciar('A', 1);
		assertEquals(false, tablero.estaOcupado('A', 1));
	}
	
	@Test 
	public void test_vaciar_el_ultimo_casillero() {
		Tablero tablero = new Tablero(8);
		FichaNegra ficha = new FichaNegra();
		tablero.ocupar('H', 8, ficha);
		tablero.vaciar('H', 8);
		assertEquals(false, tablero.estaOcupado('H', 8));
	}
	
	@Test
	public void test_ocupar_con_pieza_negra() {
		Tablero tablero = new Tablero(8);
		FichaNegra ficha = new FichaNegra();
		tablero.ocupar('A', 1, ficha);
		assertEquals(true, tablero.hayFichaNegra('A', 1));
	}
	
	@Test
	public void test_ocupar_con_pieza_blanca() {
		Tablero tablero = new Tablero(8);
		FichaBlanca ficha = new FichaBlanca();
		tablero.ocupar('A', 1, ficha);
		assertEquals(true, tablero.hayFichaBlanca('A', 1));
	}
	
	@Test
	public void test_tablero_listo_para_jugar() {
		Tablero tablero = new Tablero(8);
		tablero.posicionInicialTablero();
		assertEquals(true, tablero.hayFichaBlanca('D', 4));
		assertEquals(true, tablero.hayFichaBlanca('E', 5));
		assertEquals(true, tablero.hayFichaNegra('D', 5));
		assertEquals(true, tablero.hayFichaNegra('E', 4));
	}

}
