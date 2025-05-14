package Vista;

import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.event.AncestorListener;

import Modelo.Transaccion;
import Repositorio.ConexionMySQL;
import Repositorio.FuncionesOperaciones;

import java.awt.Toolkit;
import javax.swing.JTable;
import java.awt.Label;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;

public class Transacciones extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel Historial;
	private JLabel lblNewLabel;
	private String usuario;
	private ConexionMySQL conexion;
	private JLabel BotonIcono;
	private JTable table;
	private JFrame f;
	private JTable j;
	ArrayList<Transaccion> ListaOperaciones;  // Todas las transacciones
	String[][] datos;
	 
	 
	public Transacciones(String usuario,ConexionMySQL conexion)  {
		this.usuario=usuario;
		this.conexion=conexion;

		// frame
	    JFrame f;
	    // Table
	    JTable j;
	 
	   
	        

	        f = new JFrame();
	        f.getContentPane().setBackground(new Color(255, 255, 255));
			f.setIconImage(Toolkit.getDefaultToolkit().getImage(Transacciones.class.getResource("/Imagenes/hucha.png")));     
	        f.setTitle("Transacciones");
	        f.setSize(500, 200);
	        f.setVisible(true);
	        
	        //Array y tamaño
	        datos = new String [100][6] ;
	        
	        //Nombre columnas
	 	    String[] columnNames = { "Movimiento", "Metodo", "Importe" , "Nota", "Usuario", "Categoria" };
	 	    
	        f.getContentPane().setLayout(null);
	        //Inicializamos la tabla
	        j = new JTable(datos, columnNames);
	        j.setBounds(30, 40, 200, 300);
	 
	        // La añadimos al scrollpane
	        JScrollPane sp = new JScrollPane(j);
	        sp.setBounds(0, 0, 486, 153);
	        f.getContentPane().add(sp);
	        
	        
	        try {
	    		ListaOperaciones = FuncionesOperaciones.Historial(usuario, conexion);
	    		for(int i=0;i<ListaOperaciones.size();i++) {
	    			datos[i][0] = ListaOperaciones.get(i).getMovimiento();
	    			datos[i][1] = ListaOperaciones.get(i).getMetodopago();
	    			datos[i][2] = ListaOperaciones.get(i).getImporte();
	    			datos[i][3] =ListaOperaciones.get(i).getNotas();
	    			datos[i][4] = ListaOperaciones.get(i).getUsuario();
	    			datos[i][5] = ListaOperaciones.get(i).getCategoria();

	    		}
	    	} catch (SQLException e1) {
	    		e1.printStackTrace();
	    	}
	    	
	        
	    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
}
	
	

	


