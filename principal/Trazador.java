package principal;

import imagen.Imagen;
import javax.vecmath.Vector3d;
import tipoObjeto.Objeto;
import elemEscena.*;

public class Trazador {
	
	private static Escena escena;	// Lista de los objetos de la escena.
	private static Imagen imagen;	// Mapa de colores de los píxeles.

	/*
	 * Método principal que lanza el proceso de trazado de rayos.
	 */
	public static void main(String [] args){
		
		args = new String[1];
		args[0] = "Objetos.txt";
		
		if(args.length==1){			// Se compruebaa el número de argumenos.
			System.out.println("Cargando objetos...");
			System.out.println("--------------------------------------");
			escena = CargarEscena.cargarObjetos(args[0]);		// Se cargan los elementos de la escena.
		} else{
			System.err.println("Error con el número de argumentos.");
			System.exit(0);
		}
				
		System.out.println("\nGenerando escena...");
		System.out.println("--------------------------------------");
		
		long t1 = System.currentTimeMillis();			// Guardamos el tiempo de inicio.
		
		// Obtenemos los datos de los márgenes del plano y tamaño del píxel.
		double tamPixel = escena.getPlanoImagen().getTamPixel();
		double margenIzquierdo = escena.getObservador().x - escena.getPlanoImagen().getAncho()/2 + (tamPixel/2);
		double margenArriba = escena.getObservador().y + escena.getPlanoImagen().getAlto()/2 - (tamPixel/2);
		
		// Creamos la imagen y le damos tamaño.
		imagen = new Imagen((int)((escena.getPlanoImagen().getAncho() / tamPixel)),
				(int)(escena.getPlanoImagen().getAlto() / tamPixel));
						
		// Recorremos el plano lanzando rayos desde el observador.
		double x = 0, y = 0; int i=0, j=0;
		for(i=0; i<escena.getPlanoImagen().getAlto() / tamPixel; i++){
			for(j=0; j<escena.getPlanoImagen().getAncho() / tamPixel; j++){
				// Obtenemos las coordenadas del píxel del plano.
				x = margenIzquierdo + tamPixel*j;
				y = margenArriba - tamPixel*i;
				
				// Creamos el rayo con origen y dirección.
				Rayo rayo = new Rayo();			
				rayo.setOrigen(escena.getObservador());
				Vector3d direccion = new Vector3d(x-escena.getObservador().x,y-escena.getObservador().y,
						escena.getPlanoImagen().getAncho()*2.0-escena.getObservador().z);
				direccion.normalize();			// Normalizamos los valores del rayo.
				rayo.setDireccion(direccion);
				
				// Se obtiene el color y se guarda.
				Color pixel = trazado(rayo);
				imagen.setElemento(i, j, pixel);
				
			}
			
			// Se calcula el porcentaje generado.
			double porcentaje = ((i+1)*j)/((escena.getPlanoImagen().getAlto()/tamPixel)*
					(escena.getPlanoImagen().getAncho()/tamPixel))*100;
			if(porcentaje % 10.0 == 0.0){
				System.out.printf("Porcentaje calculado: %d\n",(int)(porcentaje));
			}
			
		}
		
		System.out.println("\nEscribiendo imagen en fichero...");
		System.out.println("--------------------------------------\n");
		imagen.escribirImagen();				// Se escribe la imagen en el fichero.
		
		long t2 = System.currentTimeMillis();			// Guardamos el tiempo final.
		System.out.println("\nCalculando tiempo total de cálculo...");
		System.out.println("--------------------------------------");
		System.out.println("Tiempo total: " + (t2-t1) + " ms.");
		
	}
	
	/*
	 * Método que calcula el color del píxel a partir del rayo lanzado desde el 
	 * observador.
	 */
	private static Color trazado(Rayo r){
		
		// Se inicializan los valores.
		double distancia = Double.MAX_VALUE;
		Objeto minObjeto = null;
		
		// Se calcula la intersección con todos los objetos.
		for(int i=0; i<escena.getObjetos().size(); i++){
			double distCalculo = escena.getObjetos().get(i).interseccion(r);
			if(distCalculo < distancia && distCalculo > 0.0 && distCalculo != Double.NEGATIVE_INFINITY){
				distancia = distCalculo;
				minObjeto = escena.getObjetos().get(i);
			}
		}
		
		// Se comprueba si el rayo ha intersectado con algún objeto o no.
		if(distancia != Double.MAX_VALUE){
			return minObjeto.getColor();
		} else{
			return new Color(0,0,0);
		}
	}
	
}
