package elemEscena;

/**
 * Clase que representa una abstracción del plano de la
 * imagen con su ancho, alto, tamaño del píxel...
 * Autor: Javier Aranda
 *
 */
public class PlanoImagen {

	private double ancho, alto;
	private double tamPixel;
	
	/*
	 * Método constructor de un objeto Plano.
	 */
	public PlanoImagen(double ancho, double alto, double pixel){
		
		this.ancho = ancho;
		this.alto = alto;
		tamPixel = pixel;
	}

	/*
	 * Método que devuelve el ancho del plano.
	 */
	public double getAncho() {
		return ancho;
	}

	/*
	 * Método que fija el ancho del plano.
	 */
	public void setAncho(double ancho) {
		this.ancho = ancho;
	}

	/*
	 * Método que devuelve el alto del plano.
	 */
	public double getAlto() {
		return alto;
	}

	/*
	 * Método que fija el alto del plano.
	 */
	public void setAlto(double alto) {
		this.alto = alto;
	}

	/*
	 * Método que devuelve el tamaño del píxel.
	 */
	public double getTamPixel() {
		return tamPixel;
	}

	/*
	 * Método que fija el tamaño del píxel.
	 */
	public void setTamPixel(double tamPixel) {
		this.tamPixel = tamPixel;
	}
	
}

