package interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import grafo.lista.GrafoLista;
import grafo.lista.VerticeLista;
import grafo.matriz.GrafoMatriz;
import grafo.matriz.RutaMatriz;
import mundo.*;

public class InterfazPrincipal_SITM extends JFrame{
	

    private SITM_Cali mundo;	
	private PanelPintarGrafo panelPintarGrafo;
	private PanelBotones panelBotones;
	private PanelTablaInformacion panelTablaInformacion;
	
	
	public InterfazPrincipal_SITM(){
		setTitle("°°°°° Sistema Integrado De Transporte Masivo                        SITM_CALI °°°°°");
		mundo = new SITM_Cali();
		setSize(1250,700);
		setLayout(new BorderLayout());
		panelPintarGrafo = new PanelPintarGrafo(this);
		panelTablaInformacion = new PanelTablaInformacion();
		panelBotones = new PanelBotones(this);		
		add(panelBotones,  BorderLayout.SOUTH);
		//pack();
	}
	
	
	public boolean cargarDeArchivo(){
		boolean cargoArchivo = false;
		JFileChooser fileCh = new JFileChooser("./doc");
		int opcion = fileCh.showOpenDialog(this);
		switch(opcion){	
			case JFileChooser.APPROVE_OPTION:
				File f = fileCh.getSelectedFile();
				try{
					mundo.leerMatriz(f);;
					JPanel aux = new JPanel();
					aux.setLayout(new GridLayout(1,2));
					aux.add(panelPintarGrafo);
					aux.add(panelTablaInformacion);
					add(aux, BorderLayout.CENTER);
					setSize(1300,701);
					panelTablaInformacion.actualizarMatriz(darGrafoListaSITM().getVertices());
					panelBotones.habilitarBotones();
					cargoArchivo = true;
				}catch(IOException ioexc){
					JOptionPane.showMessageDialog(this, "Problemas leyendo el archivo\nEs probable que el formato no sea válido.");
				}
			break;
			case JFileChooser.CANCEL_OPTION:				
			break;
			case JFileChooser.ERROR_OPTION:
			break;
		}
		return cargoArchivo;
	}
	
	public void borrarTodo(){
		salir();
	}
	
	public GrafoLista<Estacion> darGrafoListaSITM(){
		return mundo.darListaEstacion();
	}
	
	public GrafoMatriz<Estacion> darGrafoMatrizSITM(){
		return mundo.darMatrizEstacion();
	}
	
	
	public static void main(String[] args) {
		InterfazPrincipal_SITM interfaz = new InterfazPrincipal_SITM();
		interfaz.setVisible(true);
	}


	public void mostrarAlgoritmoDijstra(Estacion estacionPartida, Estacion estacionLLegada) {
		if (darGrafoListaSITM().dijsktraParcial(estacionPartida, estacionLLegada)!=null) {
	JOptionPane.showMessageDialog(this, darGrafoListaSITM().dijsktraParcial(estacionPartida, estacionLLegada).toString(),"Camino más corto: Dijstra",1);
		}else{
			JOptionPane.showMessageDialog(this, "ERROR EN LA EJECUCUÓN, SORRY");
		
		}
	}


	
	public void mostrarAlgoritmoFloydWarshall() {
		
		RutaMatriz<Estacion>[][] matrizFloyd = darGrafoMatrizSITM().floydWarshall();
		
		String mensaje = "";
		
		for (int i = 0; i < matrizFloyd.length; i++) {
			for (int j = 0; j < matrizFloyd[0].length; j++) {
				int peso = (int) matrizFloyd[i][j].getPeso();
				if(peso<10) {
					mensaje += peso+"        ";	
				}else {
					mensaje += peso+"      ";
				}
				
			}
			mensaje+="\n";
		}
		JOptionPane.showMessageDialog(this, mensaje, "Matriz Floyd Warshall", 1);
	}
	
	
	public void salir(){
		int opcion;
			opcion = JOptionPane.showConfirmDialog(this, "¿Seguro que desea cerrar la ventana?");
			if(opcion==JOptionPane.YES_OPTION){
				JOptionPane.showMessageDialog(this, "Gracias por disfrutar del Proyecto"+"\n");
				System.exit(0);
			}
		
	}
	
	public int darContador() {
		return panelBotones.getCuantasDijkestra();
	}
	
	public String mostarBFS() {
		String mensaje = "";
		ArrayList<Estacion> bfs = darGrafoListaSITM().BFS(mundo.darPordefecto());
		for(int i = 0; i<bfs.size(); i++) {
			mensaje += bfs.get(i).darNombreEstacion() + " - ";
		}
		return mensaje;
	}
	
	public String mostarDFS() {
		String mensaje = "";
		ArrayList<Estacion> bfs = darGrafoListaSITM().DFS(mundo.darPordefecto());
		for(int i = 0; i<bfs.size(); i++) {
			mensaje += bfs.get(i).darNombreEstacion() + " - ";
		}
		return mensaje;
	}
	
	public void visualizarDistinto() {
		panelPintarGrafo.repaint();
	}
}