package interfaz;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;

import grafo.lista.VerticeLista;
import mundo.Estacion;

public class PanelPintarGrafo extends JPanel {
	public final static int RADIO = 50;
	public final static int DISTANCIA_ENTRE_NODOS = 50;

	//Lista de vertices de los aeropuertos
	private ArrayList<VerticeLista<Estacion>> listaVertices;

	//LA llave es un objeto tipo aero puerto, lo necesario son las posiciones donde quedan
	private HashMap<Estacion, int[]> verticePosicion;

	InterfazPrincipal_SITM interfazPrincipal;
	
	private Graphics graficador;
	

	public PanelPintarGrafo(InterfazPrincipal_SITM v){

		interfazPrincipal = v;

		verticePosicion = new HashMap<>();

	}



	public void paintComponent(Graphics g){
		
		super.paintComponent(g);

		 graficador = (Graphics2D) g;

		graficador.setFont(new Font("Arial", Font.BOLD, 24));
		graficador.drawString("Visualización Grafo", DISTANCIA_ENTRE_NODOS, DISTANCIA_ENTRE_NODOS);

		
		listaVertices = interfazPrincipal.darGrafoListaSITM().getVertices();

		int x = DISTANCIA_ENTRE_NODOS*6;
		int y = DISTANCIA_ENTRE_NODOS*6;

		graficador.setFont(new Font("Arial", Font.BOLD, 12));
		
		
		for (int i = 0; i < listaVertices.size(); i++) {

			g.setColor(asignarColor(i));
			graficador.fillOval (x, y, RADIO, RADIO);
			int[] value = {x,y};
			verticePosicion.put(listaVertices.get(i).getElemento(), value);
			graficador.setColor(Color.BLACK);
			String nombreEstacion = listaVertices.get(i).getElemento().darNombreEstacion();
			graficador.drawString(nombreEstacion, x-20, y+15);
			x=numeroRandom();
			y=numeroRandom();
			
		}
		if(interfazPrincipal.darContador() ==0) {
			g.setColor(Color.BLACK);
		}else {
			g.setColor(asignarColor(randomColor()));
		}
		
		
		
		
		
		//Tengo mis datos guardados en un HASHMAP
		//Ahora procedo a recorrer La lista de vetices Y luego los adyacentes a este
		
		for (int i = 0; i < listaVertices.size(); i++) {
			
			int [] valuesInicio = verticePosicion.get(listaVertices.get(i).getElemento());
			//Posiciones dado el vertice
			int Xinicio = valuesInicio[0];
			int Yinicio = valuesInicio[1];
			ArrayList<VerticeLista<Estacion>> adyacentes = listaVertices.get(i).darAdyacentes();
			
			for (int j = 0; j < adyacentes.size(); j++) {
				int [] valuesFin = verticePosicion.get(adyacentes.get(j).getElemento());
				//Posiciones de llegada
				int Xfin = valuesFin[0];
				int Yfin = valuesFin[1];
				
				((Graphics2D) g).setStroke( new BasicStroke( 2 ) );
				g.drawLine(Xinicio, Yinicio, Xfin, Yfin);
				
			}
			
		}
		

	}


	public Color asignarColor(int index){

		Color color = null;

		if (index == 0) {
			color = Color.BLUE;
		}else if (index == 1) {
			color = Color.CYAN;
		}else if (index == 2) {
			color = Color.GRAY;
		}else if (index == 3) {
			color = Color.GREEN;
		}else if (index == 4) {
			color = Color.ORANGE;
		}else if (index == 5) {
			color = Color.RED;
		}else if (index == 6) {
			color = Color.YELLOW;
		}else if (index == 7) {
			color = Color.MAGENTA;
		}else if (index == 8) {
			color = Color.PINK;
		}else if (index == 9){
         color = Color.WHITE;
		}else if (index == 10) {
			color = Color.LIGHT_GRAY;
		}else if (index == 11) {
			color = Color.BLACK;
		}else if (index > 10) {
			return asignarColor(randomColor());
		}


		return color;
	}


	private int ajustarX(int x) {
		return x * getWidth() / (listaVertices.size() + 1)
				+ getWidth() / (2 * (listaVertices.size() + 1));
	}

	private int ajustarY(int y) {
		return y * getHeight() / (listaVertices.size() + 1)
				+ getHeight() / (2 * (listaVertices.size() + 1));
	}


	public int numeroRandom(){
		int numero = (int) (Math.random() * 550) + DISTANCIA_ENTRE_NODOS;
		return numero;
	}

	public int randomColor(){
		return (int) (Math.random() * 10) + 1;
	}
	 
	public void cambiarListaVertices(ArrayList<VerticeLista<Estacion>> pLista) {
		listaVertices = pLista;
	}


	public void rePintarCamino(Graphics2D g) {
		super.paintComponent(g);
		 graficador = (Graphics2D) g;
		 //TODO
		 g.setColor(Color.BLUE);
		 
		 //VOY AQUI
	for (int i = 0; i < listaVertices.size(); i++) {
			
			int [] valuesInicio = verticePosicion.get(listaVertices.get(i).getElemento());
			//Posiciones dado el vertice
			int Xinicio = valuesInicio[0];
			int Yinicio = valuesInicio[1];
			ArrayList<VerticeLista<Estacion>> adyacentes = listaVertices.get(i).darAdyacentes();
			
			for (int j = 0; j < adyacentes.size(); j++) {
				int [] valuesFin = verticePosicion.get(adyacentes.get(j).getElemento());
				//Posiciones de llegada
				int Xfin = valuesFin[0];
				int Yfin = valuesFin[1];
				
				((Graphics2D) g).setStroke( new BasicStroke( 2 ) );
				g.drawLine(Xinicio, Yinicio, Xfin, Yfin);
				
			}
			
		}
	}
	
	public Graphics darGraficador() {
		return graficador;
	}
}