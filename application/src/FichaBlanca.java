package src;

public class FichaBlanca extends Ficha {

	public boolean esNegra() {
		return false;
	}
	public boolean esBlanca() {
		return true;
	}
	
	public Ficha cambiarColor() {
		return new FichaNegra();
	}
}
