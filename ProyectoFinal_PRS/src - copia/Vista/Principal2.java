package Vista;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Repositorio.ConexionMySQL;
import Repositorio.FuncionesOperaciones;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.SpringLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JRadioButton;

public class Principal2 extends JFrame implements ActionListener {

	private JMenuBar menuBar;
	private JMenu Historial, Salir;
	private JPanel contentPane;
	private JSeparator separator;
	private JMenu Categorias;
	private JMenuItem SalirItem,OpcionAñadir, Transacciones,OpcionBorrar;
	private JLabel Saldo;
	private JLabel SaldoValor;
	private JButton ingreso, gasto;
	private String usuario;//Guarda el nombre del usuario que ha iniciado sesión
	private ConexionMySQL conexion;
	private String operacion;
	private JMenuItem NuevoUsuario;
	private JMenu Actualizar;

	
	 	public Principal2(String operacion, String usuario, ConexionMySQL conexion) throws SQLException {

		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal2.class.getResource("/Imagenes/hucha.png")));
		this.usuario = usuario;
		this.conexion=conexion;
		this.operacion=operacion;
		Menu();
		Saldo();
	    initPantalla();
	    
	    //Saldo Actual
	    int SaldoActual = FuncionesOperaciones.obtenerSaldo(usuario,conexion);	
		//Pasamos Saldo Actual de entero a String 
		SaldoValor.setText(SaldoActual + "");


	   
	}   

//////////MENU/////////

	
	
	public void Menu() {
		     		
		/* Creamos el JMenuBar y lo asociamos con el JFrame */
		menuBar=new JMenuBar();
		setJMenuBar(menuBar);
		
		Categorias = new JMenu("Categorias");
		menuBar.add(Categorias);

		
		OpcionAñadir = new JMenuItem("Añadir");
		Categorias.add(OpcionAñadir);
		
		OpcionBorrar = new JMenuItem("Borrar");
		Categorias.add(OpcionBorrar);
        OpcionAñadir.addActionListener(this);
        OpcionBorrar.addActionListener(this);

		
		Historial = new JMenu("Historial");
		menuBar.add(Historial);
		
		
		Transacciones = new JMenuItem("Transacciones");
		Historial.add(Transacciones);
		Transacciones.addActionListener(this);
		
		Actualizar = new JMenu("Modificar Usuario");
		menuBar.add(Actualizar);
		
		NuevoUsuario = new JMenuItem("Cambiar nombre");
		Actualizar.add(NuevoUsuario);
		NuevoUsuario.addActionListener(this);
		
		
		Salir=new JMenu("Salir");
		menuBar.add(Salir);
		
		SalirItem=new JMenuItem("Cerrar Sesión");
		Salir.add(SalirItem);
		SalirItem.addActionListener(this);
		getContentPane().setLayout(null);
		
		
		}
      	
      	
        public void Saldo() {
        	
        
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 128, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        separator = new JSeparator();
        separator.setBounds(0, 62, 529, 10);
        contentPane.add(separator);
        
        //botón ingreso
        ingreso = new JButton("Ingreso");
        ingreso.setFont(new Font("Tahoma", Font.BOLD, 18));
        ingreso.addActionListener(this);
        ingreso.setBackground(new Color(255, 0, 0));
        ingreso.setBounds(47, 135, 111, 56);
        contentPane.add(ingreso);
        ingreso.setBackground(Color.GREEN);
        ingreso.setForeground(new Color(0, 0, 0));
        
        //botón gasto
        gasto = new JButton("Gasto");
        gasto.setFont(new Font("Tahoma", Font.BOLD, 18));
        gasto.addActionListener(this);     
        gasto.setBackground(new Color(128, 0, 0));
        gasto.setBounds(225, 135, 111, 56);
        contentPane.add(gasto);
        gasto.setBackground(Color.RED);
        gasto.setForeground(new Color(0, 0, 0));
        
        //SaldoValor
        SaldoValor = new JLabel("");
        SaldoValor.setFont(new Font("Tahoma", Font.BOLD, 18));
        SaldoValor.setHorizontalAlignment(SwingConstants.CENTER);
        SaldoValor.setBounds(177, 21, 68, 42);
        contentPane.add(SaldoValor);
        
        //Saldo
        Saldo = new JLabel("SALDO:");
        Saldo.setBounds(101, 21, 97, 42);
        contentPane.add(Saldo);
        Saldo.setForeground(new Color(0, 0, 0));
        Saldo.setHorizontalAlignment(SwingConstants.CENTER);
        Saldo.setFont(new Font("Tahoma", Font.BOLD, 18));
              

        
       }
        
  
	    public void actionPerformed(ActionEvent e) {
	               
	        if (e.getSource()==SalirItem) {
	        	try {
					conexion.desconectar();//Desconexión base de datos
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		           System.exit(0);//Cierre de programa
		           
		        }
	        
	        if (e.getSource()==OpcionAñadir) {
	        	setVisible(false);
				try {
					Categorias ca1 = new Categorias(usuario, conexion);
					ca1.setVisible(true);
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
	        	
		        }
	        
	        if (e.getSource()==ingreso) {
	        	setVisible(false);
	        	
				try {
					Operaciones i1 = new Operaciones("Ingreso" , usuario, conexion);
					i1.setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				} 
	  	    	
		        }
	        
	        if (e.getSource()==gasto) {
	        	setVisible(false);
	        
				try {
					Operaciones i1 = new Operaciones("Gasto" , usuario,conexion);
					i1.setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				} 
		    
		        }
	        
	        if(e.getSource()==Transacciones) {
	        	Transacciones t1 = new Transacciones(usuario,conexion);
	        }
	        
	        
	        if(e.getSource()== NuevoUsuario) {
	        	setVisible(false);
	        	ActualizarNombre a1 = new ActualizarNombre(usuario,conexion);
	        	
	        }
	        
	        if(e.getSource()==OpcionBorrar) {
	        	setVisible(false);
	        	try {
					EliminarCategoria  t1  = new EliminarCategoria(usuario,conexion);
					t1.setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
	        }
	        
	      
	        
	        
	      
	    }
	    
		/* Configuración general de la ventana principal */
        private void initPantalla() {
		 	setLocation(500,250);
	        setTitle("Ventana Principal"); //Título del JFrame
	        setSize(402, 321); //Dimensiones del JFrame
	        setResizable(true); //Redimensionable
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cerrar proceso al cerrar ventana
	        setVisible(true); //Mostrar JFrame
	    }
	    }

