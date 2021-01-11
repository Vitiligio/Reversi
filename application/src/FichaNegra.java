package src;

public class FichaNegra extends Ficha{

	public boolean esNegra() {
		return true;
	}
	public boolean esBlanca() {
		return false;
	}
	
	public Ficha cambiarColor() {
		return new FichaBlanca();
	}
	
	public Ficha getFicha() {
		return new FichaNegra();
	}
}
