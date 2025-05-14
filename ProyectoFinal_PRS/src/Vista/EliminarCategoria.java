package Vista;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Repositorio.ConexionMySQL;
import Repositorio.FuncionesCategorias;
import Repositorio.FuncionesOperaciones;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class EliminarCategoria extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField BorrarValor;
	private JLabel Categoria;
	private JButton BorrarBoton;
	private JSeparator separator;
	private String operacion;
	private String usuario;
	private ConexionMySQL conexion;
	private JLabel BotonIcono;
	
	public EliminarCategoria( String usuario,ConexionMySQL conexion) throws SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Categorias.class.getResource("/Imagenes/hucha.png")));
		this.usuario=usuario;
		this.conexion=conexion;
		Ventana();
		initPantalla();
	}
	
		public void Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		initPantalla();

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		BorrarValor = new JTextField();
		BorrarValor.setBounds(114, 35, 96, 19);
		contentPane.add(BorrarValor);
		BorrarValor.setColumns(10);
		
		Categoria = new JLabel("Categoria: ");
		Categoria.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Categoria.setBounds(10, 34, 94, 30);
		contentPane.add(Categoria);
		
		BorrarBoton = new JButton("Borrar");
		BorrarBoton.addActionListener(this);
		
		BorrarBoton.setBounds(200, 84, 81, 19);
		contentPane.add(BorrarBoton);
		
		separator = new JSeparator();
		separator.setBounds(0, 76, 302, 2);
		contentPane.add(separator);
		
		BotonIcono = new JLabel("");
		BotonIcono.setIcon(new ImageIcon(Categorias.class.getResource("/Imagenes/atras.png")));
		BotonIcono.setBounds(249, 14, 45, 13);
		contentPane.add(BotonIcono);	
		BotonIcono.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	setVisible(false);
               try {
				Principal2 p1 = new Principal2(operacion, usuario, conexion);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
            }
        });
		
		
	}
		
		

	/* Configuración general de la ventana principal */
	  private void initPantalla() {
		 	setLocation(500,200);
	        setTitle("Categorias"); //Título del JFrame
	        setSize(318, 153); //Dimensiones del JFrame
	        setResizable(true); //Redimensionable
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Cerrar proceso al cerrar ventana
	        setVisible(true); //Mostrar JFrame
	  }

	  public void actionPerformed(ActionEvent e) {
				
		if (e.getSource()==	BorrarBoton) {
			setVisible(false);
			// 1.- Recoge los datos de la operación 
	    	
			String recogerdatos = BorrarValor.getText();
	    	
	   
			// 3.- Insercción de operación
			try {
		    	int sentenciaCategorias =  FuncionesCategorias.BorrarCategoria(recogerdatos, conexion);
				Operaciones o1 = new Operaciones(operacion, usuario, conexion);
				o1.setVisible(true);
				System.out.println(sentenciaCategorias);
				
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
	    
			
        
	    	}
		  }
	}



