package imagen;

import java.io.FileWriter;
import java.io.PrintWriter;

import principal.Color;

/**
 * Clase que representa una abstracción de la imagen con los
 * valores RGB de cada píxel
 * Autor: Javier Aranda
 */
public class Imagen {

	Color [][] imagen = null;			// Tabla con los colores de cada píxel de la imagen.
	
	/*
	 * Método constructor de un objeto Imagen.
	 */
	public Imagen(int ancho, int alto){
		
		imagen = new Color[alto][ancho];
	}
	
	/*
	 * Método que fija el color de un cierto píxel de la imagen.
	 */
	public void setElemento(int fila, int columna, Color color){
		imagen[fila][columna] = color;
	}
	
	/*
	 * Método que devuelve el color de un cierto píxel de la imagen
	 */
	public Color getElemento(int fila, int columna){
		return imagen[fila][columna];
	}
	
	/*
	 * Método que escribe la escena calculada en el fichero.
	 */
	public void escribirImagen(){
		
		try{
			// Creamos el fichero de la imagen.
			PrintWriter fichEsc = new PrintWriter(new FileWriter("escena.pgm"));
		
			// Se escribe la imagen en el fichero.
			fichEsc.println("P3");
			fichEsc.println("#Escena");
			fichEsc.println(imagen[0].length + " " + imagen.length);
			fichEsc.println("255");
			for(int i=0; i<imagen.length; i++){
				for(int j=0; j<imagen[0].length; j++){
					fichEsc.print((int)(imagen[i][j].getRed()) + " ");
					fichEsc.print((int)(imagen[i][j].getGreen()) + " ");
					fichEsc.print((int)(imagen[i][j].getBlue()) + " ");
				}
				fichEsc.println();
			}
			
			fichEsc.close();		// Se cierra el fichero.
			
		} catch(Exception e){		// Se capturan las posibles excepciones.
			System.err.println("Error al escribir el fichero de la imagen.");
			System.exit(-1);
		}
		
	}
	
}
