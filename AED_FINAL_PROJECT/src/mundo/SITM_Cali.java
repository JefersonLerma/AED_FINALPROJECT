	package mundo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
	
	public void leerMatriz(File archivo)  throws IOException{
		FileReader reader = new FileReader(archivo);	
		BufferedReader br = new BufferedReader(reader);
		
		//Este arraylist va almacenar las estaciones (que vienen en orden alfabetico), y con el me voy a ayudar para encontrar las adyacencias.
		ArrayList<Estacion> estaciones= new ArrayList<Estacion>();
		
		//Leo la cantidad de estaciones
		int cantidadEstaciones = Integer.parseInt(br.readLine());
		
		//tengo que crearme esas estaciones
		for(int i =0; i<cantidadEstaciones; i++) {
			String[] datosEstacion = br.readLine().split(",");
			String nombreEstacion = datosEstacion[0];
			int cantidadCalles = Integer.parseInt(br.readLine());
			Calle[] lasCalles = new Calle[cantidadCalles];
			
			//para las estaciones necesito las calles asi que las creo.
			for(int j = 0; j<cantidadCalles; j++) {
				String [] datosCalle= br.readLine().split(",");
				String nombreCalle = datosCalle[0];
				String[] paradas = new String[datosCalle.length-1]; 
				
				// para las calles necesito las paradas asi que las leo.
				for(int k = 0; k<paradas.length; k++) {
					paradas[k] = datosCalle[k+1];
				}
				
				// aqui me creo las calles
		     lasCalles[j] = new Calle(nombreCalle, paradas);
			}
			
			// aqui me creo la estacion con sus calles.
			Estacion actual = new Estacion(nombreEstacion, lasCalles);
			estaciones.add(actual);
		}
		
//TODO
	//Ahora voy a leer la matriz de adyacencias para poder agregarlas a los grafos.
		for(int x = 0; x<estaciones.size(); x++) {
			Estacion actual = estaciones.get(x);
		}
	
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
