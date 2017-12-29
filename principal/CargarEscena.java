package principal;

import java.io.File;
import java.util.Scanner;

import javax.vecmath.Vector3d;

import tipoObjeto.*;
import elemEscena.Escena;
import elemEscena.Luz;
import elemEscena.PlanoImagen;

/**
 * Clase que carga los objetos y los parámetros de la escena
 * contenidos en un fichero.
 * Autor: Javier Aranda
 */
public class CargarEscena {

	/*
	 * Método que carga los objetos desde un archivo.
	 */
	public static Escena cargarObjetos(String nombreFichero){
		
		Escena escena = new Escena();			// Se crea la escena.
		
		try{
			Scanner fichero = new Scanner(new File(nombreFichero));
			String linea; String [] carac;			// Variables para la lectura del fichero.
			
			while(fichero.hasNextLine()){			// Se leen las líneas del fichero de la escena.
				linea = fichero.nextLine();
				carac = linea.split(" ");			// Se obtiene el objeto.
				
				if(carac[0].equals("Esfera")){				// Si es una esfera...
					System.out.println("Leida esfera");
					carac = carac[1].split(",");			// Se separan las características.
					escena.anadirObjeto(leerEsfera(carac));
				} else if(carac[0].equals("Plano")){		// Si es un plano...
					System.out.println("Leido plano");
					carac = carac[1].split(",");			// Se separan las características.
					//escena.anadirObjeto(leerPlano(carac));
				} else if(carac[0].equals("Triangulo")){	// Si es un triángulo...
					System.out.println("Leido triangulo");
					carac = carac[1].split(",");			// Se separan las características.
				} else if(carac[0].equals("Luz")){			// Si es una luz...
					System.out.println("Leida luz");
					carac = carac[1].split(",");			// Se separan las características.
					escena.anadirLuz(leerLuz(carac));
				} else if(carac[0].equals("PImagen")){			// Si es el plano de la imagen...
					System.out.println("Leido plano de la imagen");
					carac = carac[1].split(",");			// Se separan las características.
					escena.setPlanoImagen(leerPlanoImagen(carac));
				} else if(carac[0].equals("Observador")){			// Si es el observador...
					System.out.println("Leido observador");
					carac = carac[1].split(",");			// Se separan las características.
					escena.setObservador(leerObservador(carac));
				} else{			// Si es un objeto desconocido...
					System.out.println("Leido objeto desconocido");
				}
			}
			
			fichero.close();			// Se cierra el fichero
			
		} catch(Exception e){		// Se captura la posible excepción.
			System.err.println("Error al leer el fichero " + nombreFichero);
			System.exit(-1);
		}
		
		return escena;			// Se devuelve la escena.
	}
	
	/*
	 * Método que obtiene las características de una luz.
	 */
	private static Luz leerLuz(String [] carac){
		
		// Se obtienen las coordenadas.
		double x = obtenerCarac(carac[0]);			
		double y = obtenerCarac(carac[1]);
		double z = obtenerCarac(carac[2]);
		double inten = obtenerCarac(carac[3]);		// Se obtiene la intensidad de la luz.
		
		Luz luz = new Luz(x,y,z,inten);
		return luz;			// Se devuelve la luz.
	}
	
	/*
	 * Método que obtiene las características de una esfera.
	 */
	private static Esfera leerEsfera(String [] carac){
		
		// Se obtienen las coordenadas.
		double x = obtenerCarac(carac[0]);			
		double y = obtenerCarac(carac[1]);
		double z = obtenerCarac(carac[2]);
		
		double radio = obtenerCarac(carac[3]);		// Se obtiene el radio de la esfera.
		
		// Se obtienen los colores de la esfera.
		double red = obtenerCarac(carac[4]);			
		double green = obtenerCarac(carac[5]);
		double blue = obtenerCarac(carac[6]);
		
		Esfera esfera = new Esfera(red,green,blue,x,y,z,radio);
				
		return esfera;			// Se devuelve la esfera.
	}
	
	/*
	 * Método que obtiene las características de un plano.
	 */
	private static Plano leerPlano(String [] carac){
		
		Plano plano = new Plano();
		return plano;				// Se devuelve el plano.
	}
	
	/*
	 * Método que obtiene las características del plano de imagen.
	 */
	private static PlanoImagen leerPlanoImagen(String [] carac){
		
		// Se obtiene el ancho y alto del plano.
		double ancho = obtenerCarac(carac[0]);			
		double alto = obtenerCarac(carac[1]);
		
		double tamPixel = obtenerCarac(carac[2]);		// Se obtiene el tamaño del píxel.
		
		PlanoImagen pImagen = new PlanoImagen(ancho,alto,tamPixel);
				
		return pImagen;			// Se devuelve el plano de la imagen.
	}
	
	/*
	 * Método que obtiene las características del observador.
	 */
	private static Vector3d leerObservador(String [] carac){
		
		// Se obtienen las coordenadas del observador.
		double x = obtenerCarac(carac[0]);
		double y = obtenerCarac(carac[1]);
		double z = obtenerCarac(carac[2]);
				
		return new Vector3d(x,y,z);				// Se devuelven las coordenadas.
		
	}
	
	/*
	 * Método que extrae el valor de una cierta característica.
	 */
	private static double obtenerCarac(String carac){
		
		double valor = Double.parseDouble(carac.substring(carac.indexOf(':')+1,carac.length()));
		return valor;
	}
}
