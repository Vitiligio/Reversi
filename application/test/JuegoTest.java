package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import src.Juego;

class JuegoTest {

	@Test
	void test_crear_juego() {
		Juego juego = new Juego();
		assertNotEquals(null, juego);
	}

	@Test
	void test_poner_una_ficha_y_que_se_den_vuelta_las_fichas_correspondientes() {
		
		Juego juego = new Juego();
		juego.prepararJuego();
		
		
		
	}
}
