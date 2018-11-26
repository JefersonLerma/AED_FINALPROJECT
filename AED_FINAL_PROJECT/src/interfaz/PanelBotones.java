package interfaz;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import grafo.lista.VerticeLista;
import mundo.Estacion;
import mundo.SITM_Cali;

public class PanelBotones extends JPanel implements ActionListener{
	
	public final static String CARGAR_ARCHIVO = "Cargar";
	public final static String BORRAR = "Borrar";

	public final static String DIJKSTRA = "Dijkstra";
	public final static String FLOYD_WARSHALL = "Floyd-Warshall";
	
	public final static String DFS = "dfs";
	public final static String BFS = "bfs";
	
	public final static String VISUALIZAR = "visualizar";

	private JButton btnCargar;
	private JButton btnBorrar;

	private JButton btnDijk;
	private JButton btnFloyd;
	
	private JButton btnDfs;
	private JButton btnBfs;
	
	private JButton btnVisualizar;

	private JComboBox<String> opcionesPartida;
	private JComboBox<String> opcionesLlegada;
	
	private Estacion estacionPartida;
	private Estacion estacionLlegada;

	InterfazPrincipal_SITM interfaz;
	
	private int cuantasDijkestra;

	public PanelBotones(InterfazPrincipal_SITM v){

		interfaz = v;

		setBorder( new TitledBorder("Opciones"));

		setLayout( new FlowLayout());
		
		

		btnCargar = new JButton("CARGAR");
		btnCargar.addActionListener(this);
		btnCargar.setActionCommand(CARGAR_ARCHIVO);

		btnBorrar = new JButton("SALIR");
		btnBorrar.addActionListener(this);
		btnBorrar.setActionCommand(BORRAR);
      cuantasDijkestra = 0;


		add(btnCargar);
		add(btnBorrar);


	}


	public void habilitarBotones(){


		btnDijk = new JButton("Dijkstra");
		btnDijk.addActionListener(this);
		btnDijk.setActionCommand(DIJKSTRA);

		btnFloyd = new JButton("Floyd W");
		btnFloyd.addActionListener(this);
		btnFloyd.setActionCommand(FLOYD_WARSHALL);
		
		btnBfs = new JButton("BFS");
		btnBfs.addActionListener(this);
		btnBfs.setActionCommand(BFS);
		
		btnDfs = new JButton("DFS");
		btnDfs.addActionListener(this);
		btnDfs.setActionCommand(DFS);
		
		btnVisualizar = new JButton("Visualizar Distinto");
        btnVisualizar.addActionListener(this);
        btnVisualizar.setActionCommand(VISUALIZAR);

		int tamnho = interfaz.darGrafoListaSITM().getVertices().size();

		String [] codigosSalida = new String[tamnho+1];
		codigosSalida[0] = "P. Partida";

		String [] codigoLLegada = new String[tamnho+1];
		codigoLLegada[0] = "P Llegada";

		for (int i = 0, k = 1; i <  tamnho; i++,k++) {
			codigosSalida[k] = interfaz.darGrafoListaSITM().getVertices().get(i).getElemento().darNombreEstacion();
			codigoLLegada[k] = interfaz.darGrafoListaSITM().getVertices().get(i).getElemento().darNombreEstacion();
		}

		opcionesPartida = new JComboBox<>(codigosSalida);
		opcionesLlegada = new JComboBox<>(codigoLLegada);


		add(opcionesPartida);
		add(opcionesLlegada);
		add(btnDijk);
		add(btnFloyd);
		add(btnBfs);
		add(btnDfs);
		add(btnVisualizar);
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		String evento = e.getActionCommand();

		if (evento.equals(CARGAR_ARCHIVO)) {
			interfaz.cargarDeArchivo();
		}else if (evento.equals(BORRAR)) {
			interfaz.borrarTodo();
		}else if (evento.equals(DIJKSTRA)) {

			String partida = opcionesPartida.getSelectedItem()+"";
			String llegada = opcionesLlegada.getSelectedItem()+"";


			 estacionPartida = ejecutarInformacionDijsktra(interfaz.darGrafoListaSITM().getVertices(), partida);
			 estacionLlegada  = ejecutarInformacionDijsktra(interfaz.darGrafoListaSITM().getVertices(), llegada);

			try {
				interfaz.mostrarAlgoritmoDijstra(estacionPartida, estacionLlegada);
				cuantasDijkestra++;
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Error en Ejecución");
			}
		}else if (evento.equals(FLOYD_WARSHALL)) {

			try {
				interfaz.mostrarAlgoritmoFloydWarshall();
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Error en Ejecución");
			}
		}else if(evento.equals(BFS)) {
			JOptionPane.showMessageDialog(null, interfaz.mostarBFS());
		}else if(evento.equals(DFS)) {
			JOptionPane.showMessageDialog(null, interfaz.mostarDFS());
		}else if(evento.equals(VISUALIZAR)) {
			interfaz.visualizarDistinto();
		}


	}


	public Estacion ejecutarInformacionDijsktra(ArrayList<VerticeLista<Estacion>> arrayList, String nombre){
		Estacion mio = null;
		boolean termino = false;
		for (int i = 0; i < arrayList.size()&& !termino; i++) {
			if (arrayList.get(i).getElemento().darNombreEstacion().equals(nombre)) {
				mio = arrayList.get(i).getElemento();
				termino = true;
			}
		}

		return mio;

	}


	public int getCuantasDijkestra() {
		return cuantasDijkestra;
	}


	public void setCuantasDijkestra(int cuantasDijkestra) {
		this.cuantasDijkestra = cuantasDijkestra;
	}


	public Estacion getEstacionPartida() {
		return estacionPartida;
	}


	public void setEstacionPartida(Estacion estacionPartida) {
		this.estacionPartida = estacionPartida;
	}


	public Estacion getEstacionLlegada() {
		return estacionLlegada;
	}


	public void setEstacionLlegada(Estacion estacionLlegada) {
		this.estacionLlegada = estacionLlegada;
	}
	
	
	
	
}