	package mundo;

import grafo.lista.GrafoLista;
import grafo.matriz.GrafoMatriz;

public class SITM_Cali {
	
	private String nombre;
	
	private GrafoLista<Estacion> listaEstacion;
	
	private GrafoMatriz<Estacion> matrizEstacion;
	
	public SITM_Cali() {
		nombre = "MIO";
		listaEstacion = new GrafoLista<Estacion>();
		matrizEstacion = new GrafoMatriz<Estacion>();
	}
	
	public String darNombre() {
		return nombre;
	}
	
	public void cambiarNombre(String pNombre) {
		nombre = pNombre;
	}
	
	public GrafoLista<Estacion> darListaEstacion(){
		return listaEstacion;
	}
	
	public void cambiarListaEstacion(GrafoLista<Estacion> pListaEstacion) {
		listaEstacion = pListaEstacion;
	}
	
	public GrafoMatriz<Estacion> darMatrizEstacion(){
		return matrizEstacion;
	}
	
	public void cambiarMatrizEstacion(GrafoMatriz<Estacion> pMatrizEstacion) {
		matrizEstacion = pMatrizEstacion;
	}

}
