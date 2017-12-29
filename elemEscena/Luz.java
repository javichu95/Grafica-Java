package elemEscena;

import javax.vecmath.Vector3d;

/**
 * Clase que representa unas abstracción de una luz
 * en la escena.
 * Autor: Javier Aranda
 *
 */
public class Luz {

	private Vector3d posicion = null;				// Coordenadas de la posición de la luz.
	private double intensidad = 0.0;				// Intensidad de la luz.
	
	/*
	 * Método constructor de un objeto Luz.
	 */
	public Luz(double x, double y, double z, double inten){
		
		posicion = new Vector3d(x,y,z);
		intensidad = inten;
	}

	/*
	 * Método que devuelve la posición de la luz.
	 */
	public Vector3d getPosicion() {
		return posicion;
	}

	/*
	 * Método que fija la posición de la luz.
	 */
	public void setPosicion(Vector3d posicion) {
		this.posicion = posicion;
	}

	/*
	 * Método que devuelve la intensidad de la luz.
	 */
	public double getIntensidad() {
		return intensidad;
	}

	/*
	 * Método que fija la intensidad de la luz.
	 */
	public void setIntensidad(double intensidad) {
		this.intensidad = intensidad;
	}
	
}
