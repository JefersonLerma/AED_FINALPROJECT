package mundo;

import grafo.lista.GrafoLista;
import grafo.matriz.GrafoMatriz;

public class Estacion {

	private String nombreEStacion;
    private Calle[] lasCalles;
    
    
    
    
    
    public Estacion(String pNombreEstacion, String[] pLasCalles) {
    	nombreEStacion = pNombreEstacion;
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
	
    
    //PAPI ESTOY WEED
    //pod�s usar este arraylist por silas
	public void emmNombreEstaciones() {
		
		String nombresESTACIONES[] = new String[10]; 
		nombresESTACIONES[0] = "Unidad Deportiva";
		nombresESTACIONES[1] = "Plaza De Toros";
		nombresESTACIONES[2] = "Pampalinda";
		nombresESTACIONES[3] = "Refugio";
		nombresESTACIONES[4] = "Caldas";
		nombresESTACIONES[5] = "Capri";
		nombresESTACIONES[6] = "Mel�ndez";
		nombresESTACIONES[7] = "Buitrera";
		nombresESTACIONES[8] = "Univalle";
		nombresESTACIONES[9] = "Universidades";
		
		String rutas[] = new String[10];
		
		
		
	}
	
	
}
