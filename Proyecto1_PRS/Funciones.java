package Escuela;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class Funciones {


	public static void Menu() {
		
	//Menú
		System.out.println("******* MENÚ *******");
		System.out.println("1.Inserción de datos");
		System.out.println("2.Consultas de Datos");
		System.out.println("3.Actualización de Datos");
		System.out.println("4.Borrado de Datos");
		System.out.println("5.Salir del programa");
	}
	
	//Menu para consultas
	public static void MenuConsultas() {
		System.out.println("CONSULTAS");
	
		System.out.println("1.Mostrar todos los registros");
		System.out.println("2.Buscar por nombre");
		System.out.println("3.Buscar por DNI");
		System.out.println("4.Salir de consultas");

	}
	//Menu para actualizar los datos 
	public static void MenuActualizar() {
	System.out.println("ACTUALIZAR");
	
	System.out.println("1.Modificar el nombre: ");
	System.out.println("2.Modificar la edad: ");
	System.out.println("3.Modificar nombre y edad: ");
	}
	
	//Metodo para introducir el nombre, la edad y el DNI del estudiante
	public static void Implementar (Scanner sc, ConexionMySQL conexion) throws SQLException {
		System.out.println("Nombre del estudiante: ");
		String Nombre=sc.next();
		System.out.println("Edad del estudiante: ");
		String Edad=sc.next();
		System.out.println("DNI del estudiante: ");
		String DNI=sc.next();
		
		//Sentencia den para añadirlo a la tabla estudiantes
		String sentencia="INSERT INTO Estudiantes (Nombre, Edad, DNI) VALUES ('"+Nombre+"', '"+Edad+"', '"+DNI+"')";
		conexion.ejecutarInsertDeleteUpdate(sentencia);
	
	}
	
	//Metodo para poder ver todos los registros o para buscar a los alumnos por su nombre o DNI
	public static void Consulta(Scanner sc, ConexionMySQL conexion) throws SQLException {
		// Mostrar el menú
		MenuConsultas();
		// Leer la opción
		int numero = sc.nextInt();
		
		while(numero<=3 && numero>0) {
			
			
			switch(numero) {
			
				//Con esta opción podremos ver todos los registros 
				case 1:

					System.out.println("Todos los resultados: ");

					String sentencia = "SELECT * FROM Estudiantes";
					ResultSet datos;
					datos = conexion.ejecutarSelect(sentencia);

					while (datos.next()) {
						String nombre = datos.getString("Nombre");
						int edad = datos.getInt("Edad");
						String dni = datos.getString("DNI");

						System.out.println(nombre + ", " + edad + ", " + dni);
					}

					break;
				//Con esta opción podremos buscar a los alumnos por su nombre	
				case 2:
					System.out.println("Nombre del estudiante: ");
					// Para introducir el nombre que deseemos por teclado

					String nombre = sc.next();
					String sentenciaNombre = "SELECT * FROM Estudiantes WHERE Nombre = '" + nombre + "'";
					ResultSet datosNombre;
					datosNombre = conexion.ejecutarSelect(sentenciaNombre);

					while (datosNombre.next()) {
						String nombre2 = datosNombre.getString("Nombre");
						int edad = datosNombre.getInt("Edad");
						String dni = datosNombre.getString("DNI");

						System.out.println(nombre2 + ", " + edad + ", " + dni);
					}
					 
					break;
					//Con esta opción podremos buscar a los alumnos por su DNI
					case 3:
						System.out.println("DNI del estudiante: ");

						int DNI = sc.nextInt();
						String sentenciaDNI = "SELECT * FROM Estudiantes WHERE DNI = '" + DNI + "'";
						ResultSet datosDNI;
						datosDNI = conexion.ejecutarSelect(sentenciaDNI);

						while (datosDNI.next()) {
							String nombre2 = datosDNI.getString("Nombre");
							int edad = datosDNI.getInt("Edad");
							String DNI2 = datosDNI.getString("DNI");

							System.out.println(nombre2 + ", " + edad + ", " + DNI2);
						}

						break;
				
				default:
						System.out.println("Introduzca un valor entre 1 y 3");
					
		}
			// Mostrar el menú
			MenuConsultas();
			// Leer la opción
			numero = sc.nextInt();
			
	}
		
}
	//Metodo para actulizar el nombre y/o la edad
	public static void Actualizar(Scanner teclado, ConexionMySQL conexion) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el DNI que desee buscar: " );		
		String DNI = sc.next();
		System.out.println("CON EL DNI " + DNI + " PODRÁ REALIZAR LAS SIGUIENTES MODIFICACIONES");
		MenuActualizar();
		int numero = sc.nextInt();
		
		while(numero<=3 && numero>0) {
			
			
					
			switch(numero) {
			//Opción para cambiar el nombre
			case 1:
				System.out.println("Introduce un nuevo nombre: ");
				String nuevoNombre = sc.next();
				System.out.println("El nuevo nombre es: " + nuevoNombre);
				String sentenciaNuevoNombre  = "UPDATE Estudiantes SET Nombre = '" + nuevoNombre + "' WHERE DNI = '" + DNI +"'";
				
				conexion.ejecutarInsertDeleteUpdate(sentenciaNuevoNombre);
				break;
				
			//Opción para cambiar edad
			case 2: 
				System.out.println("Introduce una nueva edad: ");
				int nuevaEdad = sc.nextInt();
				System.out.println("La nueva edad es: " + nuevaEdad);
				String sentenciaNuevaEdad = "UPDATE Estudiantes SET Edad = '" + nuevaEdad + "' WHERE DNI = '" + DNI +"'";
			
				conexion.ejecutarInsertDeleteUpdate(sentenciaNuevaEdad);
				break;
			//Opción para cambiar el nombre y la edad
			case 3:
				System.out.println("Introduzca un nuevo nombre:");
				String nuevoNombre1 = sc.next();
				System.out.println("El nuevo nombre es: " + nuevoNombre1);
				System.out.println("Introduzca una nueva edad:");
				int nuevaEdad1 = sc.nextInt();
				System.out.println("La nueva edad es: " + nuevaEdad1);
				
				String sentenciaNombreEdad = "UPDATE Estudiantes SET Nombre = '" + nuevoNombre1  + "', Edad = '" + nuevaEdad1 + "'  WHERE DNI = '" + DNI +"'";
				conexion.ejecutarInsertDeleteUpdate(sentenciaNombreEdad);
				break;
				
				default:
					System.out.println("Introduzca un valor entre 1 y 3");
					break;
		}
			MenuActualizar();
			numero = sc.nextInt();
	}
	
}
	
	public static void Borrar(Scanner teclado, ConexionMySQL conexion)throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el DNI del alumno: ");
		int DNI = sc.nextInt();
		
		System.out.println("Eliminación de datos del alumno con " + DNI + ": ");
		String sentenciaBorrarDatos = "DELETE FROM Estudiantes WHERE DNI = '"+ DNI +"'";
		
		conexion.ejecutarInsertDeleteUpdate(sentenciaBorrarDatos);
		System.out.println("Borrado con éxito");
	}
}

		
		
	
