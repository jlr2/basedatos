package Repositorio;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class FuncionesCategorias {

	public static int añadirCategorias(String nombre , ConexionMySQL conexion) throws SQLException {
		String sentenciaCategorias = "INSERT INTO Categorias(nombre) "
				+ " VALUES ('" +nombre+"');"; 
		
		int numfilas = conexion.ejecutarInsertDeleteUpdate(sentenciaCategorias);		 
		 return numfilas;
		
		
	}
	
	
	public static int BorrarCategoria(String categoria, ConexionMySQL conexion) throws SQLException {
		
		String sentenciaBorrar = "DELETE FROM Categorias WHERE Nombre = '" + categoria + "';";
		String sentenciaConsulta = "SELECT Nombre FROM Categorias WHERE Nombre= '" + categoria + "';"; 
		String resultado = "";
			
		
		/////// Consulta de la categoría a borrar 
	
		ResultSet borrar; 
		  //Comprobación  de nombre
		borrar = conexion.ejecutarSelect(sentenciaConsulta);
		  while(borrar.next()) {
			  // Consulta del nombre 
			  resultado = borrar.getString("Nombre");//nombre del campo en la base de datos
		  }
		  //
		  if(resultado.equals(categoria)) {
			  int fila= conexion.ejecutarInsertDeleteUpdate(sentenciaBorrar);
		  }
		  else {
			  JOptionPane.showMessageDialog(null, "La categoria no existe",
	  					"Error", JOptionPane.ERROR_MESSAGE);
		  }
			return 0;
}
}
