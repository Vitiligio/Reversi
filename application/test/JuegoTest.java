package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import src.FichaBlanca;
import src.FichaNegra;
import src.Juego;

class JuegoTest {

	@Test
	void test_crear_juego() {
		Juego juego = new Juego();
		assertNotEquals(null, juego);
	}
	
	@Test
	void test_se_puede_poner_una_ficha_negra_en_D_3() {
		
		Juego juego = new Juego();
		juego.prepararJuego();
		FichaNegra ficha = new FichaNegra();
		juego.ponerFicha('D', 3, ficha);
		
		assertEquals(true, juego.hayFichaNegraEn('D', 3));
		assertEquals(true, juego.hayFichaNegraEn('D', 4));		
		assertEquals(true, juego.hayFichaNegraEn('D', 5));		
	}
	
	@Test
	void test_se_puede_poner_una_ficha_negra_en_C_4() {
		
		Juego juego = new Juego();
		juego.prepararJuego();
		FichaNegra ficha = new FichaNegra();
		juego.ponerFicha('C', 4, ficha);
		
		assertEquals(true, juego.hayFichaNegraEn('C', 4));
		assertEquals(true, juego.hayFichaNegraEn('D', 4));		
		assertEquals(true, juego.hayFichaNegraEn('E', 4));		
	}
	
	@Test
	void test_no_puedo_poner_ficha_negra_en_A_1() {
		
		Juego juego = new Juego();
		juego.prepararJuego();
		FichaNegra ficha = new FichaNegra();
		juego.ponerFicha('A', 1, ficha);
		
		assertEquals(false, juego.hayFichaNegraEn('A', 1));
	} 
	
	@Test
	void test_no_puedo_poner_ficha_negra_en_E_3() {
		
		Juego juego = new Juego();
		juego.prepararJuego();
		FichaNegra ficha = new FichaNegra();
		juego.ponerFicha('E', 3, ficha);
		
		assertEquals(false, juego.hayFichaNegraEn('E', 3));
	} 
	
	@Test
	void test_se_puede_poner_una_ficha_blanca_en_E_3() {
		
		Juego juego = new Juego();
		juego.prepararJuego();
		FichaBlanca ficha = new FichaBlanca();
		juego.ponerFicha('E', 3, ficha);
		
		assertEquals(true, juego.hayFichaBlancaEn('E', 3));
		assertEquals(true, juego.hayFichaBlancaEn('E', 4));		
		assertEquals(true, juego.hayFichaBlancaEn('E', 5));		
	}
	
	@Test
	void test_se_dan_vuelta_multiples_fichas_negras() {
		
		Juego juego = new Juego();
		juego.prepararJuego();
		FichaBlanca blanca = new FichaBlanca();
		FichaNegra negra = new FichaNegra();
		
		juego.ponerFicha('D', 3, negra);
		juego.ponerFicha('C', 5, blanca);
		juego.ponerFicha('E', 3, blanca);
		
		assertEquals(true, juego.hayFichaNegraEn('D', 3));
		assertEquals(true, juego.hayFichaBlancaEn('E', 3));
		assertEquals(true, juego.hayFichaBlancaEn('D', 4));
		assertEquals(true, juego.hayFichaBlancaEn('E', 4));
		assertEquals(true, juego.hayFichaBlancaEn('C', 5));
		assertEquals(true, juego.hayFichaBlancaEn('D', 5));
		assertEquals(true, juego.hayFichaBlancaEn('E', 5));
		
	}
}
