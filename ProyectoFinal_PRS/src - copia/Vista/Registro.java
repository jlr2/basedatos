package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import Repositorio.ConexionMySQL;
import Repositorio.FuncionesOperaciones;
import Repositorio.FuncionesRegistro;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Toolkit;

public class Registro extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JSeparator separator;
	private JTextField userText; 
	private JButton botonregistro;
	private JPasswordField passwordText;
	private JLabel Usuario, Contraseña;
	private JFrame v_registro;
	private JLabel BotonIcono;
	private JLabel lblNewLabel;
	private ConexionMySQL conexion;


	public Registro(ConexionMySQL conexion) {
		this.conexion=conexion;
		Ventana();
		Componentes();
		

	}
	
	
	public void Ventana()
	{	
		//JFrame
		v_registro = new JFrame();
		v_registro.setIconImage(Toolkit.getDefaultToolkit().getImage(Registro.class.getResource("/Imagenes/hucha.png")));
		v_registro.setTitle("Registro");
		v_registro.setBackground(new Color(240, 240, 240));

		v_registro.setSize(388, 317);
		v_registro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		v_registro.setLocation(200,200);
		v_registro.setResizable(true);
		v_registro.setVisible(true);

		
		//JPanel
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		v_registro.getContentPane().add(contentPane);
		
		}
	
	
	public void Componentes() {
		contentPane.setLayout(null);
				
		separator = new JSeparator();
		separator.setBounds(0, 187, 436, 8);
		contentPane.add(separator);
		separator.setBounds(0, 187, 436, 36);
		contentPane.add(separator);
		
		//Usuario
		Usuario = new JLabel("Usuario:");
		Usuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Usuario.setForeground(new Color(0, 0, 0));
		Usuario.setBounds(30, 40, 107, 47);
		contentPane.add(Usuario);

		//Usuario Valor 
		userText = new JTextField(20);
		userText.setToolTipText("");
		userText.setBackground(new Color(255, 255, 255));
		userText.setBounds(120, 56, 166, 19);
		contentPane.add(userText);
		
		//Contraseña
		Contraseña = new JLabel("Contraseña:");
		Contraseña.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Contraseña.setForeground(new Color(0, 0, 0));
		Contraseña.setBounds(30, 127, 81, 19);
		contentPane.add(Contraseña);

		//Contraseña Valor
		passwordText = new JPasswordField(20);
		passwordText.setBounds(120, 129, 166, 19);
		contentPane.add(passwordText);

		//Botón Registro	
		botonregistro = new JButton("Registrar");
		botonregistro.addActionListener(this);
		botonregistro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botonregistro.setBounds(149, 209, 93, 27);
		contentPane.add(botonregistro);	
		
		//BotonIcono
		BotonIcono = new JLabel("");
		BotonIcono.setIcon(new ImageIcon(Registro.class.getResource("/Imagenes/atras.png")));
		BotonIcono.setBounds(329, 10, 45, 13);
		contentPane.add(BotonIcono);
		

		BotonIcono.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	setVisible(false);
               InicioSesion i1 = new InicioSesion();
               
            }
        });
}

	public void actionPerformed(ActionEvent e) {
		
		  if(e.getSource()==botonregistro) {
			  v_registro.setVisible(false);
			  
			  String usuario = userText.getText(); 
	        String contraseña = passwordText.getText(); 
	        
	       
			try {
			
				int Registro = FuncionesRegistro.registro(usuario,contraseña,conexion);
				
				//Si el usuario  se repite salta mensaje de Usuario Existente
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog( null, "Usuario Existente",
	  					"Fallo de registro", JOptionPane.ERROR_MESSAGE);}
			
			   userText.setText("");
			   passwordText.setText("");
			   
			   
			
	        
			}
		  
		
		
		
	
		 
	}
	
	
	

	}

