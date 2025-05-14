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
import Repositorio.FuncionesOperaciones;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.Toolkit;

public class ActualizarNombre implements ActionListener {
	// Las creamos fuera para poder utilizarlas en todos los metodos
	JTextField NuevoUsuario;
	JFrame v_actualizarnombre;
	JButton Actualizar;
	JPanel contentPane;
	ConexionMySQL conexion;//Defino la variable conexión fuera del if para poder llamarla en toda la función
    String usuario;
	
	public ActualizarNombre(String usuario,ConexionMySQL conexion) {
		this.usuario= usuario;
		this.conexion=conexion;
		v_actualizarnombre = new JFrame("Actualizar nombre");
		v_actualizarnombre.setIconImage(Toolkit.getDefaultToolkit().getImage(InicioSesion.class.getResource("/Imagenes/hucha.png")));
		v_actualizarnombre.setBackground(new Color(240, 240, 240));
		v_actualizarnombre.setSize(382, 229);
		v_actualizarnombre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		v_actualizarnombre.setLocation(500, 200);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		v_actualizarnombre.getContentPane().add(contentPane);
		ComponentesLogin(contentPane);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 124, 374, 2);
		contentPane.add(separator);

		v_actualizarnombre.setVisible(true);
	}

	private void ComponentesLogin(JPanel panel) {

		panel.setLayout(null);

		//Usuario
		JLabel Usuario = new JLabel("Nuevo Usuario:");
		Usuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Usuario.setForeground(new Color(0, 0, 0));
		Usuario.setBounds(10, 60, 118, 25);
		panel.add(Usuario);

		//Usuario Valor
		NuevoUsuario = new JTextField(20);
		NuevoUsuario.setToolTipText("");
		NuevoUsuario.setBackground(new Color(255, 255, 255));
		NuevoUsuario.setBounds(147, 62, 160, 25);
		panel.add(NuevoUsuario);
			
		//Botón Registro
		Actualizar = new JButton("Actualizar");
		Actualizar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Actualizar.setBounds(216, 136, 118, 39);
		panel.add(Actualizar);
		Actualizar.addActionListener(this);

	}
		

	@Override
	public void actionPerformed(ActionEvent e) {
			
		if(e.getSource()==Actualizar) {
			
		v_actualizarnombre.setVisible(false);		
			
		String nuevousuario = NuevoUsuario.getText(); 
		
		
		try {
			FuncionesOperaciones.actualizar(usuario,nuevousuario, conexion);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		InicioSesion r1 = new InicioSesion();
		}

		
		}
	}

	
