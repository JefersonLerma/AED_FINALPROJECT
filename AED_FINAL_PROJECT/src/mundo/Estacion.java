package mundo;

import grafo.lista.GrafoLista;
import grafo.matriz.GrafoMatriz;

public class Estacion {

	private String nombreEStacion;
    private Calle[] lasCalles;
    
    
    
    
    
    public Estacion(String pNombreEstacion, Calle[] pLasCalles) {
    	nombreEStacion = pNombreEstacion;
    	lasCalles = pLasCalles;
    }
    
    public String darNombreEstacion(){
    	return nombreEStacion;
    }
    
    public void cambiarNombreEstacion(String pNombreEstacion) {
    	nombreEStacion = pNombreEstacion;
    }
    
    public Calle[] darLasCalles() {
    	return lasCalles;
    }
    
    public void cambiarLasCalles(Calle[] pLasCalles) {
    	lasCalles = pLasCalles;
    }
	
    public String toString() {
    	return nombreEStacion + "  ";
    }

	
}
