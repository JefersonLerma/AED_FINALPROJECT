package interfaz;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import grafo.lista.VerticeLista;
import mundo.*;

public class PanelTablaInformacion extends JPanel{
	
	public final static int COLUMNAS = 4;
	private JScrollPane jscrollPane;
	private JPanel panelTabla;
	private JTextField [][] matrizInfo; 
	private PanelTitulo titulo;
	
	
	
	public PanelTablaInformacion(){
		setLayout(new BorderLayout());
		panelTabla = new JPanel();
		jscrollPane = new JScrollPane(panelTabla);
	    titulo = new PanelTitulo();
		add(titulo, BorderLayout.NORTH);
		add(jscrollPane, BorderLayout.CENTER);
	}

	public void actualizarMatriz(ArrayList<VerticeLista<Estacion>>listado){
		int totalFilas = 0;
		for (int i = 0; i < listado.size(); i++) {
			totalFilas+=listado.get(i).darAdyacentes().size();
		}
		panelTabla.setLayout(new GridLayout(totalFilas, COLUMNAS));
		matrizInfo = new JTextField[totalFilas][COLUMNAS];
		
		Font font = new Font("Tahoma", 1, 20);
		JTextField numeroArista = new JTextField("# Arista");
		JTextField partida = new JTextField("Partida");
		JTextField llegada = new JTextField("Llegada");
		JTextField costo = new JTextField("Tiempo");
		numeroArista.setEditable(false);
		partida.setEditable(false);
		llegada.setEditable(false);
		costo.setEditable(false);
		
		numeroArista.setHorizontalAlignment(JTextField.CENTER);
		partida.setHorizontalAlignment(JTextField.CENTER);
		llegada.setHorizontalAlignment(JTextField.CENTER);
		costo.setHorizontalAlignment(JTextField.CENTER);

		
		numeroArista.setFont(font);
		partida.setFont(font);
		llegada.setFont(font);
		costo.setFont(font);

		
		//Leno la primera fila de datos
		matrizInfo[0][0] = numeroArista;
		matrizInfo[0][1] = partida;
		matrizInfo[0][2] = llegada;
		matrizInfo[0][3] = costo;

		
		panelTabla.add(matrizInfo[0][0]);
		panelTabla.add(matrizInfo[0][1]);
		panelTabla.add(matrizInfo[0][2]);
		panelTabla.add(matrizInfo[0][3]);

		
		int conta = 0;
		ArrayList<JTextField> todosLosDatos;
		todosLosDatos = new ArrayList<>();
		
		for (int i = 0; i < listado.size(); i++) {
			for (int j = 0; j < listado.get(i).getAristas().size(); j++) {
				JTextField numAris = new JTextField(conta+"");
				JTextField inicio = new JTextField(listado.get(i).getElemento().darNombreEstacion());
				JTextField fin = new JTextField(listado.get(i).getAristas().get(j).getRelacion().getElemento().darNombreEstacion());
			    JTextField cost = new JTextField(listado.get(i).getAristas().get(j).getPeso()+" min ");
			    //JTextField rut = new JTextField("XD");
				conta++;
				
				todosLosDatos.add(numAris);
				todosLosDatos.add(inicio);
				todosLosDatos.add(fin);
				todosLosDatos.add(cost);
				//todosLosDatos.add(rut);
				
				numAris.setEditable(false);
				inicio.setEditable(false);
				fin.setEditable(false);
				cost.setEditable(false);
				//rut.setEditable(false);
				
				numAris.setHorizontalAlignment(JTextField.CENTER);
				inicio.setHorizontalAlignment(JTextField.CENTER);
				fin.setHorizontalAlignment(JTextField.CENTER);
				cost.setHorizontalAlignment(JTextField.CENTER);
				//rut.setHorizontalAlignment(JTextField.CENTER);
				
			}
			//conta++;
		}
		
		//Ahora agrego toda la informacion del Arraylist a la matriz
		
		int avanceJ = 0;
		for (int i = 1; i < totalFilas; i++) {
			for (int j = 0; j < COLUMNAS; j++) {
				matrizInfo[i][j] = todosLosDatos.get(avanceJ);
				panelTabla.add(matrizInfo[i][j]);
				avanceJ++;
			}
			//avanceJ++;
		}
		add(jscrollPane,BorderLayout.CENTER);
	}


	public class PanelTitulo extends JPanel{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public PanelTitulo(){
			setSize(1000,800);
			setLayout(new BorderLayout());
			JLabel a = new JLabel("Tabla Información Estaciones");
			a.setHorizontalAlignment(JLabel.CENTER);
			add(a,BorderLayout.CENTER);
		}
		
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			Graphics2D graficador = (Graphics2D) g;
			graficador.setFont(new Font("Arial", Font.BOLD, 24));
			graficador.drawString("Tabla Información Estaciones", 50, 50);
			
			
		}
	}


	public void borrarDatos() {
		for (int i = 1; i < matrizInfo.length; i++) {
			for (int j = 0; j < matrizInfo[0].length; j++) {
				matrizInfo[i][j].setText("");
			}
		}
		
	}
	

}
