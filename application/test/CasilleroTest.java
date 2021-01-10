package test;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import excepciones.YaEstaVacioExcepcion;
import src.Casillero;
import src.FichaBlanca;
import src.FichaNegra;


public class CasilleroTest {

	@Test
	public void test_crear_un_casillero() {
		Casillero casillero = new Casillero();
		assertNotEquals(null, casillero);
	}
	
	@Test
	public void test_crear_un_casillero_inicializado_vacio() {
		Casillero casillero = new Casillero();
		assertEquals(false, casillero.estaOcupado());
	}
	
	@Test
	public void test_ocupar_un_casillero_vacio() {
		Casillero casillero = new Casillero();
		FichaNegra ficha = new FichaNegra();
		casillero.ocupar(ficha);
		assertEquals(true, casillero.estaOcupado());
	}
	
	@Test
	public void test_vaciar_un_casillero_ocupado() {
		Casillero casillero = new Casillero();
		FichaNegra ficha = new FichaNegra();
		casillero.ocupar(ficha);
		casillero.vaciar();
		assertEquals(false, casillero.estaOcupado());
	}
	
	@Test 
	public void test_ocupar_con_ficha_negra() {
		Casillero casillero = new Casillero();
		FichaNegra ficha = new FichaNegra();
		casillero.ocupar(ficha);
		assertEquals(true, casillero.tieneFichaNegra());
		assertEquals(false, casillero.tieneFichaBlanca());
	}
	
	@Test 
	public void test_ocupar_con_ficha_blanca() {
		Casillero casillero = new Casillero();
		FichaBlanca ficha = new FichaBlanca();
		casillero.ocupar(ficha);
		assertEquals(true, casillero.tieneFichaBlanca());
		assertEquals(false, casillero.tieneFichaNegra());
	}
	
	@Test 
	public void test_ocupar_con_ficha_blanca_y_cambiarle_el_color() {
		Casillero casillero = new Casillero();
		FichaBlanca ficha = new FichaBlanca();
		casillero.ocupar(ficha);
		casillero.cambiarColor();
		assertEquals(true, casillero.tieneFichaNegra());
	}
	
	@Test 
	public void test_ocupar_con_ficha_negra_y_cambiarle_el_color() {
		Casillero casillero = new Casillero();
		FichaNegra ficha = new FichaNegra();
		casillero.ocupar(ficha);
		casillero.cambiarColor();
		assertEquals(true, casillero.tieneFichaBlanca());
	}
	
}
