package tipoObjeto;

import javax.vecmath.Vector3d;

import principal.Color;
import elemEscena.Rayo;

/**
 * Clase que representa una abstracción de un objeto
 * en la escena.
 * Autor: Javier Aranda
 */
public class Objeto {

	Vector3d posicion = null;			// Posición del objeto.
	private Color color = null;			// Color del objeto.
	
	/*
	 * Método constructor de un Objeto.
	 */
	public Objeto(){}
	
	/*
	 * Método constructor de un Objeto.
	 */
	public Objeto(double r, double g, double b, double x, double y, double z){
		this.color = new Color(r,g,b);
		this.posicion = new Vector3d(x,y,z);
	}

	/*
	 * Método que devuelve la posición del objeto.
	 */
	public Vector3d getPosicion() {
		return posicion;
	}

	/*
	 * Método que fija la posición del objeto.
	 */
	public void setPosicion(double x, double y, double z) {
		this.posicion = new Vector3d(x,y,z);
	}
	
	/*
	 * Método que devuelve el color del objeto.
	 */
	public Color getColor() {
		return color;
	}

	/*
	 * Método que fija el color del objeto.
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	/*
	 * Método que calcula la intersección de un objeto con un cierto rayo.
	 */
	public double interseccion(Rayo r){
		return 0.0;
	}
	
}
