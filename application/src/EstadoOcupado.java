package src;

import excepciones.YaEstaOcupadoExcepcion;

public class EstadoOcupado extends EstadoCasillero{
	
	private Ficha ficha;
	
	public EstadoOcupado(Ficha ficha) {
		this.ficha = ficha;
	}
	
	public boolean estaOcupado() {
		return true;
	}
	
	public EstadoCasillero ocupar(Ficha ficha) throws YaEstaOcupadoExcepcion{
		throw new YaEstaOcupadoExcepcion();
	}
	
	public EstadoCasillero vaciar() {
		EstadoVacio estado = new EstadoVacio();
		return estado;
	}
	
	public boolean tieneFichaNegra() {
		return this.ficha.esNegra();
	}
	
	public boolean tieneFichaBlanca() {
		return this.ficha.esBlanca();
	}
	
	public void cambiarColor() {
		this.ficha = this.ficha.cambiarColor();
	}
}
