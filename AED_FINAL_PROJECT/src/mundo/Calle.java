package mundo;

public class Calle {
	
	private String nombreCalle;
	
	private String[] paradas;
	
	public Calle(String pNombreCalles, String[] pParadas) {
		nombreCalle = pNombreCalles;
		paradas = pParadas;
	}
	
	public String darNombreCalle() {
		return nombreCalle;
	}
	
	public void cambiarNombreCalle(String pNombreCalle) {
		nombreCalle = pNombreCalle;
	}
	
	public String[] darParadas() {
		return paradas;
	}
	
	public void cambiarParadas(String[] pParadas) {
		paradas = pParadas;
	}
	
	public String toString() {
		String mensaje = "";
		
		mensaje += nombreCalle +", Paradas: - ";
		for(int i = 0; i<paradas.length; i++) {
			mensaje += paradas[i] +" - ";
		}
		return mensaje;
	}

	
	//Este metodo retorna, cuanto tardaria un bus en recorres todas las estaciones.
	public double darTiempoDeViaje() {
		return paradas.length*3.0;
	}
}
