package elemEscena;

import javax.vecmath.Vector3d;

/**
 * Clase que representa una abstracción de un rayo
 * en la escena desde un punto origen y con una dirección.
 * Autor: Javier Aranda
 *
 */
public class Rayo {

	private Vector3d origen;				// Origen del rayo.
	private Vector3d direccion;				// Dirección del rayo.
	
	/*
	 * Método constructor de un objeto Rayo.
	 */
	public Rayo(){
		
	}
	
	/*
	 * Método que fija el origen del rayo.
	 */
	public void setOrigen(double x, double y, double z){
		origen = new Vector3d(x,y,z);
	}
	
	/*
	 * Método que fija el origen del rayo.
	 */
	public void setOrigen(Vector3d vector){	
		origen = vector;
	}
	
	/*
	 * Método que devuelve el origen del rayo.
	 */
	public Vector3d getOrigen(){
		return origen;
	}
	
	/*
	 * Método que fija la dirección del rayo.
	 */
	public void setDireccion(double x, double y, double z){	
		direccion = new Vector3d(x,y,z);
	}
	
	/*
	 * Método que fija la dirección del rayo.
	 */
	public void setDireccion(Vector3d vector){	
		direccion = vector;
	}
	
	/*
	 * Método que devuelve la dirección del rayo.
	 */
	public Vector3d getDireccion(){
		return direccion;
	}
	
}
