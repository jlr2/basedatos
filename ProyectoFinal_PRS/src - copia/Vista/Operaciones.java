package Vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Modelo.Transaccion;
import Repositorio.ConexionMySQL;
import Repositorio.FuncionesInicioSesion;
import Repositorio.FuncionesOperaciones;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Image;


import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import java.awt.Toolkit;

public class Operaciones extends JFrame implements ActionListener, ItemListener, ChangeListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane ,panel;
	private JMenuBar menuBar;
	private JMenu Historial, Salir;
	private JMenuItem  SalirItem , Transacciones;
	private JButton Aceptar;
	private JLabel Categorias;
	private JComboBox <String> CategoriasValor;
	private JLabel Metodo, SaldoValor;
	private JLabel Saldo;
	private JLabel Importe;
	private JTextField ImporteValor;
	private ButtonGroup grupo;
	private JRadioButton TarjetaBoton, EfectivoBoton;
	String operacion;
	private JTextField NotaValor;
	private JLabel Nota;
	private JSeparator separador;
	private JLabel Foto;
	private JCheckBox Tarjeta, Efectivo;
	private String usuario;
	private String categoria;
	private String metodo;
	private ConexionMySQL conexion;
	private JLabel BotonIcono;
	
	public Operaciones(String operacion, String usuario, ConexionMySQL conexion) throws SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Usuario1\\Desktop\\Nuevo-ProyectoFinal\\Programacion\\Nuevo\\TrabajoFinal\\ProyectoFinal\\src\\Imagenes\\hucha.png"));
		this.operacion=operacion;//Para que salga ingreso o gasto de nombre en la ventana
		this.usuario = usuario;//Llevamos desde inicio de sesión el usuario que se ha introdocido 
		this.conexion=conexion;
		
		//Configuración del ContentPane
		getContentPane().setForeground(new Color(255, 255, 255));
		getContentPane().setBackground(new Color(0, 128, 128));
		getContentPane().setLayout(null);
		Menu();
		initPantalla();
		PanelPrincipal();
		
		//Saldo inicial
		int SaldoActual = FuncionesOperaciones.obtenerSaldo(usuario,conexion);	
		//Pasamos Saldo Actual de entero a String 
		SaldoValor.setText(SaldoActual + "");
		
	}
	
	
	
	//Barra de consultas
	public void Menu() {
 		
		
			//Separador
			separador = new JSeparator();
			separador.setBounds(0, 188, 514, 9);
			getContentPane().add(separador);
			
			menuBar=new JMenuBar();
			setJMenuBar(menuBar);
			//Historial + Transacciones	
			Historial = new JMenu("Historial");
			menuBar.add(Historial);	
			//
			Transacciones = new JMenuItem("Transacciones");
			Historial.add(Transacciones);
			Transacciones.addActionListener(this);
			
			//Salir + Cerrar sesión
			Salir=new JMenu("Salir");
			menuBar.add(Salir);			
			//
			SalirItem=new JMenuItem("Cerrar Sesión");
			Salir.add(SalirItem);
			SalirItem.addActionListener(this);
			getContentPane().setLayout(null);
		}
	
	
	//ContentPane
	 public void PanelPrincipal() throws SQLException {
				 
		 
		 	//Importe
	        Importe = new JLabel("Importe:");
	        Importe.setFont(new Font("Tahoma", Font.PLAIN, 15));
	        Importe.setBounds(10, 20, 60, 20);
	        getContentPane().add(Importe); 	        
	        //Importe Valor
	        ImporteValor = new JTextField();
	        ImporteValor.setBounds(91, 20, 100, 19);
	        getContentPane().add(ImporteValor);
	        ImporteValor.setColumns(10);
	        
	        
	        //Método 
	        Metodo = new JLabel("Método: ");
	        Metodo.setFont(new Font("Tahoma", Font.PLAIN, 15));
	        Metodo.setBounds(10, 57, 90, 36);
	        getContentPane().add(Metodo);        
	        //JPanel con dos CheckBox dentro 
	        panel = new JPanel();
	        panel.setBackground(new Color(255, 255, 255));
	        panel.setBounds(91, 47, 100, 46);
	        getContentPane().add(panel);
	        panel.setLayout(null);
	        //Tarjeta CheckBox
	        Tarjeta = new JCheckBox("Tarjeta");
	        Tarjeta.setBounds(0, 0, 97, 23);
	        panel.add(Tarjeta);
	        Tarjeta.addActionListener(this);
	        //Efectivo CheckBox
	        Efectivo = new JCheckBox("Efectivo");
	        Efectivo.setBounds(0, 23, 97, 23);
	        Efectivo.addActionListener(this);
	        panel.add(Efectivo);
	        
	        	 	
	        //Categorias
	        Categorias = new JLabel("Categorias:");
			Categorias.setFont(new Font("Tahoma", Font.PLAIN, 15));
			Categorias.setBounds(10, 94, 90, 36);
			getContentPane().add(Categorias);
			//Desplegable categorias
			CategoriasValor=new JComboBox<String>();
			CategoriasValor.setBounds(91,104,100,20);
			getContentPane().add(CategoriasValor);
			
			ArrayList <String> ListaCategorias = FuncionesOperaciones.leerCategorias(conexion);
			
			  for(int i = 0;i<ListaCategorias.size();i++) {
			  CategoriasValor.addItem(ListaCategorias.get(i));
			  
			  } CategoriasValor.addItem("Añadir"); CategoriasValor.addItemListener(this);
			 
				             
	        
	        //Nota
	        Nota = new JLabel("Nota: ");
	        Nota.setFont(new Font("Tahoma", Font.PLAIN, 15));
	        Nota.setBounds(20, 142, 45, 13);
	        getContentPane().add(Nota); 
	        //Nota Valor 
	        NotaValor = new JTextField();
	        NotaValor.setBounds(91, 140, 100, 19);
	        getContentPane().add(NotaValor);
	        NotaValor.setColumns(10);
	        
	        //Saldo
	        Saldo = new JLabel("SALDO: ");
	        Saldo.setFont(new Font("Tahoma", Font.BOLD, 24));
	        Saldo.setHorizontalAlignment(SwingConstants.CENTER);
	        Saldo.setBounds(233, 62, 110, 68);
	        getContentPane().add(Saldo);
	        //Saldo Valor
	    	SaldoValor = new JLabel("");
	    	SaldoValor.setBackground(new Color(0, 139, 139));
			SaldoValor.setFont(new Font("Tahoma", Font.BOLD, 15));
			SaldoValor.setHorizontalAlignment(SwingConstants.CENTER);
			SaldoValor.setBounds(335, 70, 90, 54);
			getContentPane().add(SaldoValor);
		
	        	       
	        //Aceptar botón
	        Aceptar = new JButton("Aceptar");
			Aceptar.setFont(new Font("Tahoma", Font.BOLD, 15));
			Aceptar.addActionListener(this);
			 
			Aceptar.setBackground(new Color(255, 255, 255));
			Aceptar.setForeground(new Color(0, 0, 0));
			Aceptar.setBounds(364, 202, 110, 20);
			getContentPane().add(Aceptar);
			
			//BotonIcono
			BotonIcono = new JLabel("");
			BotonIcono.setIcon(new ImageIcon(Categorias.class.getResource("/Imagenes/atras.png")));
			BotonIcono.setBounds(447, -11, 67, 60);
			getContentPane().add(BotonIcono);

			BotonIcono.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	setVisible(false);
	               try {
					Principal2 p1 = new Principal2(operacion, usuario, conexion);
					p1.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            }
	        });
	        

		    }
		 
	

		 //Metodo para que interactuen los items del menu desplegable
		    public void itemStateChanged(ItemEvent e) {
		        if (e.getSource()==CategoriasValor ) {
		            String seleccionado=(String)CategoriasValor.getSelectedItem();
		            
		            switch (seleccionado) {
		              case "Añadir":
		            	  setVisible(false);
		                  
						try {
							Categorias a1 = new Categorias(usuario,conexion);
			                  a1.setVisible(true);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		                  break;
		                  
		              default:categoria=seleccionado;//para seleccionar la categoria 	            	  
		                  
		        
		          }		            
		        }	
		       
		        	
		        }
		   
		   		
		
		    
		    
		    
		/////////////////// ActionPerformed ///////////////
	  public void actionPerformed(ActionEvent e) {		    
		
		  	
	        if (e.getSource()==SalirItem) {
	        	try {
					conexion.desconectar();//Desconexión base de datos
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
	        	 System.exit(0);
	        	 
	        }
	           	
	        
	        if (e.getSource()==	Transacciones) {
					Transacciones t1 = new Transacciones(usuario,conexion);
					t1.setVisible(true);
	        	
	        }
	        
	        
	        
	        if (e.getSource()==	Aceptar) {
	        	// 1.- Recoge los datos de la operación 
	        	
	        	String importe = ImporteValor.getText(); //Recogemos el importe introducido en el JTextField y lo guardamos en una variable temporal
	        	String nota = NotaValor.getText();
	        	String operacion = this.operacion;
	        	String usuario = this.usuario;
	        	
	        	//Método de pago
	        	if(Tarjeta.isSelected()) {
			  		metodo="Tarjeta";
			  	}
			  	if(Efectivo.isSelected()) {
			  		metodo="Efectivo";
			  	}
			  
	        		        

	        	// 3.- Insercción de operación
	    		try {
					int AñadirOperaciones = FuncionesOperaciones.anadir(importe, metodo, categoria, nota, operacion, usuario, conexion);
					int SaldoActual = FuncionesOperaciones.obtenerSaldo(usuario,conexion);	
					System.out.println("SaldoActual: " + SaldoActual);
					//Pasamos Saldo Actual de entero a String 
					SaldoValor.setText(SaldoActual + "");
					

					
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
	    		
	    		
	  
	        	}
	        	// 4.- Vuelta a la ventana principal
	    		if (e.getSource()==	Aceptar) {
		        	this.setVisible(false);
					try {
					Principal2 pp1 = new Principal2(operacion,usuario,conexion);
			        	pp1.setVisible(true);

					} catch (SQLException e1) {
						e1.printStackTrace();
					}		        		        	
	    		}
  
		      }

	  
	  @Override
		public void stateChanged(ChangeEvent e) {
			
		}
	  
	  /* Configuración general de la ventana principal */
		 private void initPantalla() {
			 	
			 	setLocation(250,250);
		        setTitle(operacion); //Título del JFrame
		        setSize(514, 291); //Dimensiones del JFrame
		        setResizable(true); //Redimensionable
		        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Cerrar proceso al cerrar ventana
		        setVisible(true); //Mostrar JFrame
		    }
}
