package src;

import excepciones.NoHayFichaExcepcion;
import excepciones.YaEstaOcupadoExcepcion;
import excepciones.YaEstaVacioExcepcion;

public abstract class EstadoCasillero {

	public abstract boolean estaOcupado();
	public abstract EstadoCasillero ocupar(Ficha ficha) throws YaEstaOcupadoExcepcion;
	public abstract EstadoCasillero vaciar() throws YaEstaVacioExcepcion;
	public abstract boolean tieneFichaNegra();
	public abstract boolean tieneFichaBlanca();
	public abstract void cambiarColor();
	public abstract Ficha getFicha() throws NoHayFichaExcepcion;
}
