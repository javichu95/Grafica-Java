package principal;

/**
 * Clase que encapsula el color de un objeto formado por los
 * colores rojo, verde y azul.
 * Autor: Javier Aranda
 */
public class Color {

	private double red;				// Color rojo.
	private double green;			// Color verde.
	private double blue;			// Color azul.
	
	/*
	 * Método constructor de un objeto Color.
	 */
	public Color(double r, double g, double b){
		
		red = r;
		green = g;
		blue = b;
	}

	/*
	 * Método que devuelve el color rojo.
	 */
	public double getRed() {
		return red;
	}

	/*
	 * Método que fija el color rojo.
	 */
	public void setRed(double red) {		
		this.red = red;
	}

	/*
	 * Método que devuelve el color verde.
	 */
	public double getGreen() {
		return green;
	}

	/*
	 * Método que fija el color verde.
	 */
	public void setGreen(double green) {		
		this.green = green;
	}

	/*
	 * Método que devuelve el color azul.
	 */
	public double getBlue() {		
		return blue;
	}

	/*
	 * Método que fija el color azul.
	 */
	public void setBlue(double blue) {	
		this.blue = blue;
	}
	
}
