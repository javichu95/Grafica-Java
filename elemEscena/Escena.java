package elemEscena;

import java.util.ArrayList;

import javax.vecmath.Vector3d;

import tipoObjeto.Objeto;

/**
 * Clase que representa una abstracción de todos los elementos
 * que puede contener una escena: luces, objetos...
 * Autor: Javier Aranda
 *
 */
public class Escena {

	private ArrayList<Objeto> objetos;	// Lista de objetos de la escena.
	private ArrayList<Luz> luces;		// Lista de luces de la escena.
	private PlanoImagen planoImagen;	// Plano de la imagen.
	private Vector3d observador;		// Observador de la imagen.
	
	/*
	 * Método constructor de una Escena.
	 */
	public Escena(){
		
		objetos = new ArrayList<Objeto>();	
		luces = new ArrayList<Luz>();		
	}

	/*
	 * Método que devuelve los objetos de la escena.
	 */
	public ArrayList<Objeto> getObjetos() {
		return objetos;
	}

	/*
	 * Método que fija los objetos de la escena.
	 */
	public void setObjetos(ArrayList<Objeto> objetos) {
		this.objetos = objetos;
	}

	/*
	 * Método que devuelve las luces de la escena.
	 */
	public ArrayList<Luz> getLuces() {
		return luces;
	}

	/*
	 * Método que fija las luces de la escena.
	 */
	public void setLuces(ArrayList<Luz> luces) {
		this.luces = luces;
	}
	
	/*
	 * Método que devuelve el plano de la escena.
	 */
	public PlanoImagen getPlanoImagen() {
		return planoImagen;
	}

	/*
	 * Método que fija el plano de la escena.
	 */
	public void setPlanoImagen(PlanoImagen plano) {
		this.planoImagen = plano;
	}
	
	/*
	 * Método que fija el observador de la imagen.
	 */
	public void setObservador(Vector3d obser){
		
		observador = obser;
	}
	
	/*
	 * Método que devuelve el observador de la imagen.
	 */
	public Vector3d getObservador(){
		
		return observador;
	}

	/*
	 * Método que añade una luz a la lista de luces.
	 */
	public void anadirLuz(Luz luz){
		luces.add(luz);
	}
	
	/*
	 * Método que añade un objeto a la lista de objetos.
	 */
	public void anadirObjeto(Objeto objeto){
		objetos.add(objeto);
	}
	
}
