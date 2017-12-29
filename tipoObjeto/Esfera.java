package tipoObjeto;

import javax.vecmath.Vector3d;

import elemEscena.Rayo;

public class Esfera extends Objeto{

	private double radio = 0;
	
	public Esfera(double r, double g, double b, 
					double x, double y, double z, double radio){
		super(r,g,b,x,y,z);
		this.radio = radio;
		
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}
	
	/*
	 * Método que calcula la intersección del rayo con un objeto.
	 */
	public double interseccion(Rayo r){
		
		double a = 1.0;
		double x = r.getOrigen().x-posicion.x;
		double y = r.getOrigen().y-posicion.y;
		double z = r.getOrigen().z-posicion.z;
		Vector3d OC = new Vector3d(x,y,z);
		double b = 2.0*r.getDireccion().dot(OC);
		double c = OC.dot(OC) - Math.pow(radio,2);
		return resolverSegundoGrado(a,b,c);	// Se devuelve el resultado de la ecuación.
	}
	
	/*
	 * Función que calcula la solución o soluciones de una cierta ecuación
	 * de segundo grado para la intersección rayo-esfera.
	 */
	private static double resolverSegundoGrado(double a, double b, double c) {

		double delta = Math.pow(b,2) - 4*a*c;
		if (delta < 0.0) {	// Si delta es negativo no se puede obtener solución.
			return Double.NEGATIVE_INFINITY;
		} else if(delta == 0.0) {	// Si solo se tiene una solución...
			return -b/(2*a);
		} else {	// Si se tienen dos soluciones...
			double raiz = Math.sqrt(delta);
			double sol1 = (-b-raiz)/(2*a);
			double sol2 = (-b+raiz)/(2*a);
			if(sol1 < sol2){
				return sol1;
			} else{
				return sol2;
			}
		}
	}
}
