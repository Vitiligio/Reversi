package src;

import excepciones.NoSePuedeCambiarColorExcepcion;
import excepciones.YaEstaOcupadoExcepcion;
import excepciones.YaEstaVacioExcepcion;

public class Casillero {
	
	private EstadoCasillero estado;
	
	public Casillero() {
		this.estado = new EstadoVacio();
	}
	
	public boolean estaOcupado() {
		return this.estado.estaOcupado();
	}
	
	public void ocupar(Ficha ficha) {
		try{
			this.estado = this.estado.ocupar(ficha);
		} catch (YaEstaOcupadoExcepcion e) {
			
		}
	}
	
	public void vaciar() {
		try {
			this.estado = this.estado.vaciar();
		} catch (YaEstaVacioExcepcion e) {
			
		}
	}
	
	public boolean tieneFichaNegra() {
		return this.estado.tieneFichaNegra();
	}
	
	public boolean tieneFichaBlanca() {
		return this.estado.tieneFichaBlanca();
	}
	
	public void cambiarColor() {
		try{
			this.estado.cambiarColor();
		} catch(NoSePuedeCambiarColorExcepcion e) {
			
		}
	}
	
}
