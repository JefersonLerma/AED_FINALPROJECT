package interfaz;
import mundo.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import grafo.matriz.RutaMatriz;
import grafo.matriz.RutasMatriz;

public class PruebaInterfaz {

	
	private static SITM_Cali xd;
	public static void main(String [] args) throws IOException {

File archivo = new File("./doc/prueba2.txt");
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
RutaMatriz<Estacion>[][] ajam = xd.darMatrizEstacion().floydWarshall();


String mensaje = "";
String mensaje2  = "";
for(int d =0; d<ajam.length; d++) {
	for (int r = 0; r<ajam[0].length; r++) {
		int peso = (int) ajam[d][r].getPeso();
		mensaje2 += ajam[d][r].toString() + "        " + "\n";
		mensaje += peso+"        ";
	}
	mensaje+="\n";
}
//TODO esto es para mostrar el floyd.
//System.out.println(mensaje);
System.out.println("POR FLOYD///////////////////////////////////////////////////////////");
System.out.println(mensaje2);

//para probar con dikestra.

Estacion inicio = xd.darPordefecto();
Estacion fin = xd.darPordefecto1();
System.out.println("ALGORITMO DE DIKESTRA!!!!!!!!///////////////////////////////////////////////");
System.out.println(xd.darMatrizEstacion().dijsktraParcial(inicio, fin).toString());

  
	}
}
