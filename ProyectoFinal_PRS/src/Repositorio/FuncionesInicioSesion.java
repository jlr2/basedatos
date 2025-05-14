package Repositorio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class FuncionesInicioSesion {

	// comprobar el usuario y contraseña introducidos.
	//Si el usuario existe devuelve true sino false.
	public static boolean login(String usuario, String contraseña, ConexionMySQL conexion) throws SQLException  {
		  String resultado = "";
		  String resultado2 = "";

			System.out.println("Repositorio: consultando a la base de datos. usuario: " + usuario + " contraseña: " + contraseña);
			
			
	// comprobar si el usuario y la contraseña existen en la base de datos String
	String sentenciaNombre = "SELECT usuario FROM Usuarios	WHERE usuario = '" + usuario + "'"; 
			  
	String sentenciaContraseña ="SELECT contraseña	FROM Usuarios	 WHERE contraseña = '" + contraseña + "'";
			  
			  
			  ResultSet datos; 
			  //Comprobación  de nombre
			  datos = conexion.ejecutarSelect(sentenciaNombre);
			  while(datos.next()) {
				  // Consulta del nombre 
				  resultado = datos.getString("usuario");//nombre del campo en la base de datos
				  System.out.println("RESULTADO USUARIO: " + resultado);
			  }
			 //Comprobación de contraseñaDO
			  datos = conexion.ejecutarSelect(sentenciaContraseña);
			  while(datos.next()) {
				  // Consulta del nombre 
				resultado2 = datos.getString("contraseña");
				  System.out.println("RESULTADO CONTRASEÑA: " + resultado2);
			  }
			 
			  if(!resultado.equals("") && (!resultado2.equals(""))) {
				  System.out.println("El usuario existe");
				  return true;
			  }
			  	return false;
			 
			
	}

}
