package Escuela;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Alumnos {

	public static void main(String[] args) {
		
		ConexionMySQL conexion=new ConexionMySQL("usuario", "pass", "db");
		Scanner sc=new Scanner(System.in);
		
		
		try {
			conexion.conectar();
			
			int numero;
			//Llamamos a la función menú de la clase Funciones
			
		
			do {			
				Funciones.Menu();
				numero=sc.nextInt();
				
				switch (numero) {
				case 1:
					Funciones.Implementar(sc, conexion);			
					break;
				case 2:
					Funciones.Consulta(sc, conexion);
					break;
				case 3:
					Funciones.Actualizar(sc, conexion);
					break;
				case 4:
					Funciones.Borrar(sc, conexion);
					break;
				case 5:
					System.exit(0);
				
				default:
					System.out.println("Introduce un valor válido");
				}
			}	while (numero<=4 && numero>0);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		finally {
			try {
				conexion.desconectar();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}

