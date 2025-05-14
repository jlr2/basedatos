package Vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Repositorio.ConexionMySQL;
import Repositorio.FuncionesInicioSesion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.Toolkit;

public class InicioSesion implements ActionListener {
	// Las creamos fuera para poder utilizarlas en todos los metodos
	public static JTextField UsuarioValor;
	JPasswordField ContraseñaValor;
	JFrame v_iniciosesion;
	JButton botonregistro, botonlogin;
	JPanel contentPane;
	ConexionMySQL conexion;//Defino la variable conexión fuera del if para poder llamarla en toda la función
	private boolean ConexionEstablecida = false; //Creamos una variable booleana para saber si la conexion ya ha sido establecida

	
	public InicioSesion() {

		v_iniciosesion = new JFrame("Inicio de Sesión");
		v_iniciosesion.setIconImage(Toolkit.getDefaultToolkit().getImage(InicioSesion.class.getResource("/Imagenes/hucha.png")));
		v_iniciosesion.setBackground(new Color(240, 240, 240));
		v_iniciosesion.setSize(388, 317);
		v_iniciosesion.setLocation(500, 250);
		v_iniciosesion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		v_iniciosesion.getContentPane().add(contentPane);
		ComponentesLogin();
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 186, 374, 2);
		contentPane.add(separator);

		v_iniciosesion.setVisible(true);
	}

	private void ComponentesLogin()
	{

		contentPane.setLayout(null);

		//Usuario
		JLabel Usuario = new JLabel("Usuario:");
		Usuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Usuario.setForeground(new Color(0, 0, 0));
		Usuario.setBounds(24, 42, 80, 25);
		contentPane.add(Usuario);

		//Usuario Valor
		UsuarioValor = new JTextField(20);
		UsuarioValor.setToolTipText("");
		UsuarioValor.setBackground(new Color(255, 255, 255));
		UsuarioValor.setBounds(114, 44, 160, 25);
		contentPane.add(UsuarioValor);
		
		//Contaseña
		JLabel Contraseña = new JLabel("Contraseña:");
		Contraseña.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Contraseña.setForeground(new Color(0, 0, 0));
		Contraseña.setBounds(10, 116, 102, 25);
		contentPane.add(Contraseña);

		//Contraseña Valor
		ContraseñaValor = new JPasswordField(20);
		ContraseñaValor.setBounds(114, 116, 160, 25);
		contentPane.add(ContraseñaValor);

		//Botón login
		botonlogin = new JButton("Inicio Sesión");
		botonlogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botonlogin.setBounds(190, 206, 130, 52);
		contentPane.add(botonlogin);
		botonlogin.addActionListener(this);
			
		//Botón Registro
		botonregistro = new JButton("Registrar");
		botonregistro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botonregistro.setBounds(52, 206, 118, 52);
		contentPane.add(botonregistro);
		botonregistro.addActionListener(this);

	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource()==botonregistro) {
			
			//Establece conexión con la base de datos para registro si no se ha establecido previamente
			if(ConexionEstablecida ==false) //Conexión no establecida aún
			{
				conexion = new ConexionMySQL("proyectofinal", "proyectofinal", "proyectofinal");
				try {
					conexion.conectar();
					ConexionEstablecida=true;//Marcamos que la conexión se ha establecido

				} catch (SQLException e1) {
					e1.printStackTrace();
				}							
			}	
			
			//Abrimos la ventana de registro
			Registro r1 = new Registro(conexion);
			r1.setVisible(true);
			
		}
		else {
			
		
		// Recoge el nombre de usuario y contraseña de la interfaz
	
		String usuario = UsuarioValor.getText();
		String contraseña = ContraseñaValor.getText();


		// Establece conexión con la base de datos desde el inicio de sesión
		if(ConexionEstablecida == false)
		{
			conexion = new ConexionMySQL("proyectofinal", "proyectofinal", "proyectofinal");
			try {
				conexion.conectar();
				ConexionEstablecida=true;//Marcamos que la conexión se ha establecido

			} catch (SQLException e1) {
				e1.printStackTrace();
			}							
		}	
		

		// 3.-consulta a la base de datos, para comprobar el usuario y la contraseña

		try {
			boolean existeusuario = FuncionesInicioSesion.login(usuario, contraseña, conexion);

			
			if(existeusuario) 
				{
					// al iniciar correctamente la sesión, debe desaparecer la ventana de inicio de sesión.
					v_iniciosesion.setVisible(false);
					Principal2 vp = new Principal2("", usuario, conexion);

				} 
				else 
				{
			  		JOptionPane.showMessageDialog(null, "El usuario no existe, inténtalo de nuevo",
  					"Fallo de autenticación", JOptionPane.ERROR_MESSAGE);}
			} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
    
		}
	}

	
}