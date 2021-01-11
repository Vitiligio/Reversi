package src;

import excepciones.NoHayFichaExcepcion;
import excepciones.NoSePuedeCambiarColorExcepcion;
import excepciones.YaEstaVacioExcepcion;

public class EstadoVacio extends EstadoCasillero {

	public boolean estaOcupado() {
		return false;
	}
	
	public EstadoCasillero ocupar(Ficha ficha) {
		EstadoOcupado estado = new EstadoOcupado(ficha);
		return estado;
	}
	
	public EstadoCasillero vaciar() throws YaEstaVacioExcepcion{
		throw new YaEstaVacioExcepcion();
	}

	public boolean tieneFichaNegra() {
		return false;
	}
	
	public boolean tieneFichaBlanca() {
		return false;
	}
	
	public void cambiarColor() throws NoSePuedeCambiarColorExcepcion {
		throw new NoSePuedeCambiarColorExcepcion();
	}
	
	public Ficha getFicha() throws NoHayFichaExcepcion{
		throw new NoHayFichaExcepcion();
	}
}
