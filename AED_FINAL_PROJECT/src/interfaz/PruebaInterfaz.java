package interfaz;
import mundo.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import grafo.matriz.RutasMatriz;

public class PruebaInterfaz {

	
	private static SITM_Cali xd;
	public static void main(String [] args) throws IOException {

File archivo = new File("./doc/prueba1.txt");
xd = new SITM_Cali();

	xd.leerMatriz(archivo);

	String [] paradas1 = new String[3];
	paradas1[0] = "p3";
	paradas1[1] = "p4";
	paradas1[2] = "p5";
	String[] paradas2 = new String[1];
	paradas2[0] = "p6";
	Calle calle1 = new Calle("Calle 1", paradas1);
	Calle calle2 = new Calle("Calle 2", paradas2);
	Calle[] lasCalles = new Calle[2];
	lasCalles[0] = calle1;
	lasCalles[1] = calle2;
	Estacion miEstacion = new Estacion("La Casa del Dani", lasCalles);
	
ArrayList<Estacion> xddd = xd.darMatrizEstacion().BFS(xd.darPordefecto());

for(int i = 0; i<xddd.size(); i++) {
	System.out.println(xddd.get(i).toString());
}


  
	}
}
