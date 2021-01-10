package excepciones;

public class LetraNoValidaExcepcion extends RuntimeException {

	public String String() {
		return "La letra ingresada no coincide con ninguna coordenada valida";
	}
}
