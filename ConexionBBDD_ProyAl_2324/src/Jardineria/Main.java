package Jardineria;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		mainMenu();
	}

	public static void mainMenu() {
		Scanner scanner = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("----- Menú Principal -----");
			System.out.println("1. Inserción");
			System.out.println("2. Actualización");
			System.out.println("3. Borrado");
			System.out.println("4. Consultas");
			System.out.println("5. Salir");
			System.out.print("Seleccione una opción: ");
			opcion = scanner.nextInt();
			scanner.nextLine(); // Limpiar el buffer del scanner

			switch (opcion) {
			case 1:
				menuInsercion();
				break;
			case 2:
				menuActualizacion();
				break;
			case 3:
				menuBorrado();
				break;
			case 4:
				menuConsultas();
				break;
			case 5:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
			}
		} while (opcion != 5);

	}

	public static void menuInsercion() {
		Scanner scanner = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("----- Menú de Inserción -----");
			System.out.println("1. Inserción de Oficina");
			System.out.println("2. Inserción de Empleado");
			System.out.println("3. Inserción de Gama de Producto");
			System.out.println("4. Inserción de Cliente");
			System.out.println("5. Inserción de Pedido");
			System.out.println("6. Volver al menú principal");
			System.out.print("Seleccione una opción: ");
			opcion = scanner.nextInt();
			scanner.nextLine(); // Limpiar el buffer del scanner

			switch (opcion) {
			case 1:
				insertarOficina(scanner);
				break;
			case 2:
				insertarEmpleado(scanner);
				break;
			case 3:
				insertarGamaProducto(scanner);
				break;
			case 4:
				insertarCliente(scanner);
				break;
			case 5:
				insertarPedido(scanner);
				break;
			case 6:
				System.out.println("Volviendo al menú principal...");
				break;
			default:
				System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
			}
		} while (opcion != 6);

	}

	public static void menuActualizacion() {
		Scanner scanner = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("----- Menú de Actualización -----");
			System.out.println("1. Actualizar Oficina");
			System.out.println("2. Actualizar Empleado");
			System.out.println("3. Actualizar Gama de Producto");
			System.out.println("4. Actualizar Cliente");
			System.out.println("5. Actualizar Pedido");
			System.out.println("6. Volver al menú principal");
			System.out.print("Seleccione una opción: ");
			opcion = scanner.nextInt();
			scanner.nextLine(); // Limpiar el buffer del scanner

			switch (opcion) {
			case 1:
				actualizarCiudadOficina(scanner);
				break;
			case 2:
				actualizarNombreEmpleado(scanner);
				break;
			case 3:
				actualizarDescripcionTextoGamaProducto(scanner);
				break;
			case 4:
				actualizarTelefonoCliente(scanner);
				break;
			case 5:
				actualizarEstadoPedido(scanner);
				break;
			case 6:
				System.out.println("Volviendo al menú principal...");
				break;
			default:
				System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
			}
		} while (opcion != 6);
	}

	public static void menuBorrado() {
		Scanner scanner = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("----- Menú de Eliminación -----");
			System.out.println("1. Eliminar Oficina");
			System.out.println("2. Eliminar Empleado");
			System.out.println("3. Eliminar Gama de Producto");
			System.out.println("4. Eliminar Cliente");
			System.out.println("5. Eliminar Pedido");
			System.out.println("6. Volver al menú principal");
			System.out.print("Seleccione una opción: ");
			opcion = scanner.nextInt();
			scanner.nextLine(); // Limpiar el buffer del scanner

			switch (opcion) {
			case 1:
				eliminarOficina(scanner);
				break;
			case 2:
				eliminarEmpleado(scanner);
				break;
			case 3:
				eliminarGamaProducto(scanner);
				break;
			case 4:
				eliminarCliente(scanner);
				break;
			case 5:
				eliminarPedido(scanner);
				break;
			case 6:
				System.out.println("Volviendo al menú principal...");
				break;
			default:
				System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
			}
		} while (opcion != 6);
	}

	public static void menuConsultas() {
		Scanner scanner = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("----- Menú de Consultas -----");
			System.out.println("1. Consultas de Tablas");
			System.out.println("2. Consultas de Composición Interna");
			System.out.println("3. Consultas de Composición Externa");
			System.out.println("4. Consultas de Subconsultas");
			System.out.println("5. Consultas con Funciones Agregadas");
			System.out.println("6. Crear vistas");
			System.out.println("7. Consultar vistas");
			System.out.println("8. Volver al menú principal");
			System.out.print("Seleccione una opción: ");
			opcion = scanner.nextInt();
			scanner.nextLine(); // Limpiar el buffer del scanner

			switch (opcion) {
			case 1:
				submenuConsultasTablas();
				break;
			case 2:
				submenuConsultasComposicionInterna();
				break;
			case 3:
				submenuConsultasComposicionExterna();
				break;
			case 4:
				submenuConsultasSubconsultas();
				break;
			case 5:
				submenuConsultasFuncionesAgregadas();
				break;
			case 6:
				menuCrearVistas();
				break;
			case 7:
				menuConsultarVistas(null);
				break;
			case 8:
				System.out.println("Volviendo al menú principal...");
				break;
			default:
				System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
			}
		} while (opcion != 8);
	}

	public static void submenuConsultasTablas() {
		Scanner scanner = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("----- Submenú de Consultas de Tablas -----");
			System.out.println("1. Consultar Oficinas");
			System.out.println("2. Consultar Empleados");
			System.out.println("3. Volver al menú de consultas principal");
			System.out.print("Seleccione una opción: ");
			opcion = scanner.nextInt();
			scanner.nextLine(); // Limpiar el buffer del scanner

			switch (opcion) {
			case 1:
				consultarOficina();
				break;
			case 2:
				consultarEmpleado();
				break;
			case 3:
				System.out.println("Volviendo al menú de consultas principal...");
				break;
			default:
				System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
			}
		} while (opcion != 3);
	}

	public static void submenuConsultasComposicionInterna() {
		Scanner scanner = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("----- Submenú de Consultas de Composición Interna -----");
			System.out.println("1. Consulta 1");
			System.out.println("2. Consulta 2");
			System.out.println("3. Volver al menú de consultas principal");
			System.out.print("Seleccione una opción: ");
			opcion = scanner.nextInt();
			scanner.nextLine(); // Limpiar el buffer del scanner

			switch (opcion) {
			case 1:
				consultarEmpleadoYOficina();
				break;
			case 2:
				consultarPedidoYCliente();
				break;
			case 3:
				System.out.println("Volviendo al menú de consultas principal...");
				break;
			default:
				System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
			}
		} while (opcion != 3);
	}

	public static void submenuConsultasComposicionExterna() {
		Scanner scanner = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("----- Submenú de Consultas de Composición Externa -----");
			System.out.println("1. Consulta 1");
			System.out.println("2. Consulta 2");
			System.out.println("3. Volver al menú de consultas principal");
			System.out.print("Seleccione una opción: ");
			opcion = scanner.nextInt();
			scanner.nextLine(); // Limpiar el buffer del scanner

			switch (opcion) {
			case 1:
				consultarProductoYDetallePedido();
				break;
			case 2:
				consultarPagoYCliente();
				break;
			case 3:
				System.out.println("Volviendo al menú de consultas principal...");
				break;
			default:
				System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
			}
		} while (opcion != 3);
	}

	public static void submenuConsultasSubconsultas() {
		Scanner scanner = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("----- Submenú de Consultas de Subconsultas -----");
			System.out.println("1. Consulta 1");
			System.out.println("2. Consulta 2");
			System.out.println("3. Volver al menú de consultas principal");
			System.out.print("Seleccione una opción: ");
			opcion = scanner.nextInt();
			scanner.nextLine(); // Limpiar el buffer del scanner

			switch (opcion) {
			case 1:
				consultarClienteYPedidos();
				break;
			case 2:
				consultarProductoYGama();
				break;
			case 3:
				System.out.println("Volviendo al menú de consultas principal...");
				break;
			default:
				System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
			}
		} while (opcion != 3);
	}

	public static void submenuConsultasFuncionesAgregadas() {
		Scanner scanner = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("----- Submenú de Consultas con Funciones Agregadas -----");
			System.out.println("1. Consulta 1");
			System.out.println("2. Consulta 2");
			System.out.println("3. Volver al menú de consultas principal");
			System.out.print("Seleccione una opción: ");
			opcion = scanner.nextInt();
			scanner.nextLine(); // Limpiar el buffer del scanner

			switch (opcion) {
			case 1:
				consultarCantidadPedidos();
				break;
			case 2:
				consultarPrecioMaxProducto();
				break;
			case 3:
				System.out.println("Volviendo al menú de consultas principal...");
				break;
			default:
				System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
			}
		} while (opcion != 3);
	}

	public static void menuCrearVistas() {
		Scanner scanner = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("----- Menú de Creación de Vistas -----");
			System.out.println("1. Crear Vista de Productos con Precio Mayor a un Umbral");
			System.out.println("2. Crear Vista de Pedidos con Cantidad Mayor a un Umbral");
			System.out.println("3. Volver al menú principal");
			System.out.print("Seleccione una opción: ");
			opcion = scanner.nextInt();
			scanner.nextLine(); // Limpiar el buffer del scanner

			switch (opcion) {
			case 1:
				crearVistaProductosPrecioMayor(100); // Utiliza 100 como umbral
				break;
			case 2:
				crearVistaPedidosCantidadMayor(10); // Utiliza 10 como umbral
				break;
			case 3:
				System.out.println("Volviendo al menú principal...");
				break;
			default:
				System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
			}
		} while (opcion != 3);
	}

	public static void menuConsultarVistas(Connection connection) {
		Scanner scanner = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("----- Menú de Consultas de Vistas -----");
			System.out.println("1. Consultar Productos con Precio Mayor a un Umbral (Vista)");
			System.out.println("2. Consultar Pedidos con Cantidad Mayor a un Umbral (Vista)");
			System.out.println("3. Volver al menú principal");
			System.out.print("Seleccione una opción: ");
			opcion = scanner.nextInt();
			scanner.nextLine(); // Limpiar el buffer del scanner

			switch (opcion) {
			case 1:
				consultarProductosPrecioMayor();
				break;
			case 2:
				consultarPedidosCantidadMayor();
				break;
			case 3:
				System.out.println("Volviendo al menú principal...");
				break;
			default:
				System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
			}
		} while (opcion != 3);
	}

	// Métodos de inserción para cada tabla

	public static void insertarOficina(Scanner scanner) {
		// creamos las variables para poder introducir mas tarde los campos
		String codigo_oficina, ciudad, pais, region, codigo_postal, telefono, linea_direccion1, linea_direccion2;

		// pedimos todos los datos por teclado
		System.out.println("Insertar codigo oficina");
		codigo_oficina = scanner.nextLine();
		System.out.println("Insertar ciudad");
		ciudad = scanner.nextLine();
		System.out.println("Insertar pais");
		pais = scanner.nextLine();
		System.out.println("Insertar region");
		region = scanner.nextLine();
		System.out.println("Insertar codigo postal");
		codigo_postal = scanner.nextLine();
		System.out.println("Insertar telefono");
		telefono = scanner.nextLine();
		System.out.println("Insertar linea direccion 1");
		linea_direccion1 = scanner.nextLine();
		System.out.println("Insertar linea direccion 2");
		linea_direccion2 = scanner.nextLine();

		try {
			Connection connection = BDManager.getConnection();
			// Preparar la sentencia SQL
			String query = "INSERT INTO oficina (codigo_oficina, ciudad, pais, region, codigo_postal, telefono, linea_direccion1, linea_direccion2) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(query);

			// Establecer los valores de los parámetros
			statement.setString(1, codigo_oficina);
			statement.setString(2, ciudad);
			statement.setString(3, pais);
			statement.setString(4, region);
			statement.setString(5, codigo_postal);
			statement.setString(6, telefono);
			statement.setString(7, linea_direccion1);
			statement.setString(8, linea_direccion2);

			// Ejecutar la consulta
			int filasAfectadas = statement.executeUpdate();

			if (filasAfectadas > 0) {
				System.out.println("Oficina insertada correctamente.");
			} else {
				System.out.println("No se pudo insertar la oficina.");
			}

			// Cerrar la conexión
			BDManager.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void insertarEmpleado(Scanner scanner) {
		// Declaramos las variables para poder introducir más tarde los campos
		Integer codigo_empleado, codigo_jefe;
		String nombre, apellido1, apellido2, extension, email, codigo_oficina, puesto;

		// Pedimos todos los datos por teclado
		System.out.println("Insertar código empleado");
		codigo_empleado = scanner.nextInt();
		scanner.nextLine(); // Limpiar el buffer del scanner
		System.out.println("Insertar nombre");
		nombre = scanner.nextLine();
		System.out.println("Insertar primer apellido");
		apellido1 = scanner.nextLine();
		System.out.println("Insertar segundo apellido");
		apellido2 = scanner.nextLine();
		System.out.println("Insertar extensión");
		extension = scanner.nextLine();
		System.out.println("Insertar email");
		email = scanner.nextLine();
		System.out.println("Insertar código oficina");
		codigo_oficina = scanner.nextLine();
		System.out.println("Insertar código jefe (puede ser nulo)");
		String codigo_jefe_input = scanner.nextLine();
		codigo_jefe = codigo_jefe_input.isEmpty() ? null : Integer.parseInt(codigo_jefe_input);
		System.out.println("Insertar puesto (puede ser nulo)");
		puesto = scanner.nextLine();

		try {
			Connection connection = BDManager.getConnection();
			// Preparar la sentencia SQL
			String query = "INSERT INTO empleado (codigo_empleado, nombre, apellido1, apellido2, extension, email, codigo_oficina, codigo_jefe, puesto) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(query);

			// Establecer los valores de los parámetros
			statement.setInt(1, codigo_empleado);
			statement.setString(2, nombre);
			statement.setString(3, apellido1);
			statement.setString(4, apellido2);
			statement.setString(5, extension);
			statement.setString(6, email);
			statement.setString(7, codigo_oficina);
			if (codigo_jefe == null) {
				statement.setNull(8, java.sql.Types.INTEGER);
			} else {
				statement.setInt(8, codigo_jefe);
			}
			statement.setString(9, puesto);

			// Ejecutar la consulta
			int filasAfectadas = statement.executeUpdate();

			if (filasAfectadas > 0) {
				System.out.println("Empleado insertado correctamente.");
			} else {
				System.out.println("No se pudo insertar el empleado.");
			}

			// Cerrar la conexión
			BDManager.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insertarGamaProducto(Scanner scanner) {
		// Declaramos las variables para poder introducir más tarde los campos
		String gama, descripcion_texto, descripcion_html, imagen;

		// Pedimos todos los datos por teclado
		System.out.println("Insertar gama de producto");
		gama = scanner.nextLine();
		System.out.println("Insertar descripción en texto");
		descripcion_texto = scanner.nextLine();
		System.out.println("Insertar descripción en HTML");
		descripcion_html = scanner.nextLine();
		System.out.println("Insertar URL de la imagen");
		imagen = scanner.nextLine();

		try {
			Connection connection = BDManager.getConnection();
			// Preparar la sentencia SQL
			String query = "INSERT INTO gama_producto (gama, descripcion_texto, descripcion_html, imagen) VALUES (?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(query);

			// Establecer los valores de los parámetros
			statement.setString(1, gama);
			statement.setString(2, descripcion_texto);
			statement.setString(3, descripcion_html);
			statement.setString(4, imagen);

			// Ejecutar la consulta
			int filasAfectadas = statement.executeUpdate();

			if (filasAfectadas > 0) {
				System.out.println("Gama de producto insertada correctamente.");
			} else {
				System.out.println("No se pudo insertar la gama de producto.");
			}

			// Cerrar la conexión
			BDManager.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insertarCliente(Scanner scanner) {
		// Declaramos las variables para poder introducir más tarde los campos
		int codigo_cliente;
		String nombre_cliente, nombre_contacto, apellido_contacto, telefono, fax, linea_direccion1, linea_direccion2,
				ciudad, region, pais, codigo_postal;
		Integer codigo_empleado_rep_ventas = null;
		Double limite_credito = null;

		// Pedimos todos los datos por teclado
		System.out.println("Insertar código de cliente");
		codigo_cliente = scanner.nextInt();
		scanner.nextLine(); // Limpiar el buffer del scanner
		System.out.println("Insertar nombre del cliente");
		nombre_cliente = scanner.nextLine();
		System.out.println("Insertar nombre del contacto");
		nombre_contacto = scanner.nextLine();
		System.out.println("Insertar apellido del contacto");
		apellido_contacto = scanner.nextLine();
		System.out.println("Insertar teléfono");
		telefono = scanner.nextLine();
		System.out.println("Insertar fax");
		fax = scanner.nextLine();
		System.out.println("Insertar línea de dirección 1");
		linea_direccion1 = scanner.nextLine();
		System.out.println("Insertar línea de dirección 2");
		linea_direccion2 = scanner.nextLine();
		System.out.println("Insertar ciudad");
		ciudad = scanner.nextLine();
		System.out.println("Insertar región");
		region = scanner.nextLine();
		System.out.println("Insertar país");
		pais = scanner.nextLine();
		System.out.println("Insertar código postal");
		codigo_postal = scanner.nextLine();
		System.out.println("Insertar código del empleado representante de ventas (puede ser nulo)");
		String codigo_empleado_rep_ventas_input = scanner.nextLine();
		if (!codigo_empleado_rep_ventas_input.isEmpty()) {
			codigo_empleado_rep_ventas = Integer.parseInt(codigo_empleado_rep_ventas_input);
		}
		System.out.println("Insertar límite de crédito (puede ser nulo)");
		String limite_credito_input = scanner.nextLine();
		if (!limite_credito_input.isEmpty()) {
			limite_credito = Double.parseDouble(limite_credito_input);
		}

		try {
			Connection connection = BDManager.getConnection();
			// Preparar la sentencia SQL
			String query = "INSERT INTO cliente (codigo_cliente, nombre_cliente, nombre_contacto, apellido_contacto, telefono, fax, linea_direccion1, linea_direccion2, ciudad, region, pais, codigo_postal, codigo_empleado_rep_ventas, limite_credito) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(query);

			// Establecer los valores de los parámetros
			statement.setInt(1, codigo_cliente);
			statement.setString(2, nombre_cliente);
			statement.setString(3, nombre_contacto);
			statement.setString(4, apellido_contacto);
			statement.setString(5, telefono);
			statement.setString(6, fax);
			statement.setString(7, linea_direccion1);
			statement.setString(8, linea_direccion2);
			statement.setString(9, ciudad);
			statement.setString(10, region);
			statement.setString(11, pais);
			statement.setString(12, codigo_postal);
			if (codigo_empleado_rep_ventas == null) {
				statement.setNull(13, java.sql.Types.INTEGER);
			} else {
				statement.setInt(13, codigo_empleado_rep_ventas);
			}
			if (limite_credito == null) {
				statement.setNull(14, java.sql.Types.DECIMAL);
			} else {
				statement.setDouble(14, limite_credito);
			}

			// Ejecutar la consulta
			int filasAfectadas = statement.executeUpdate();

			if (filasAfectadas > 0) {
				System.out.println("Cliente insertado correctamente.");
			} else {
				System.out.println("No se pudo insertar el cliente.");
			}

			// Cerrar la conexión
			BDManager.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insertarPedido(Scanner scanner) {
		// Declaramos las variables para poder introducir más tarde los campos
		int codigo_pedido, codigo_cliente;
		String estado, comentarios;
		Date fecha_pedido, fecha_esperada, fecha_entrega = null;

		// Pedimos todos los datos por teclado
		System.out.println("Insertar código de pedido");
		codigo_pedido = scanner.nextInt();
		scanner.nextLine(); // Limpiar el buffer del scanner
		System.out.println("Insertar fecha de pedido (yyyy-mm-dd)");
		fecha_pedido = Date.valueOf(scanner.nextLine());
		System.out.println("Insertar fecha esperada (yyyy-mm-dd)");
		fecha_esperada = Date.valueOf(scanner.nextLine());
		System.out.println("Insertar fecha de entrega (puede ser nulo) (yyyy-mm-dd)");
		String fecha_entrega_input = scanner.nextLine();
		if (!fecha_entrega_input.isEmpty()) {
			fecha_entrega = Date.valueOf(fecha_entrega_input);
		}
		System.out.println("Insertar estado");
		estado = scanner.nextLine();
		System.out.println("Insertar comentarios (puede ser nulo)");
		comentarios = scanner.nextLine();
		System.out.println("Insertar código de cliente");
		codigo_cliente = scanner.nextInt();
		scanner.nextLine(); // Limpiar el buffer del scanner

		try {
			Connection connection = BDManager.getConnection();
			// Preparar la sentencia SQL
			String query = "INSERT INTO pedido (codigo_pedido, fecha_pedido, fecha_esperada, fecha_entrega, estado, comentarios, codigo_cliente) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(query);

			// Establecer los valores de los parámetros
			statement.setInt(1, codigo_pedido);
			statement.setDate(2, fecha_pedido);
			statement.setDate(3, fecha_esperada);
			if (fecha_entrega == null) {
				statement.setNull(4, java.sql.Types.DATE);
			} else {
				statement.setDate(4, fecha_entrega);
			}
			statement.setString(5, estado);
			statement.setString(6, comentarios);
			statement.setInt(7, codigo_cliente);

			// Ejecutar la consulta
			int filasAfectadas = statement.executeUpdate();

			if (filasAfectadas > 0) {
				System.out.println("Pedido insertado correctamente.");
			} else {
				System.out.println("No se pudo insertar el pedido.");
			}

			// Cerrar la conexión
			BDManager.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void actualizarCiudadOficina(Scanner scanner) {
		// Declaramos las variables para poder introducir más tarde los campos
		String codigo_oficina, nueva_ciudad;

		// Pedimos los datos por teclado
		System.out.println("Insertar código de oficina");
		codigo_oficina = scanner.nextLine();
		System.out.println("Insertar nueva ciudad");
		nueva_ciudad = scanner.nextLine();

		try {
			Connection connection = BDManager.getConnection();
			// Preparar la sentencia SQL
			String query = "UPDATE oficina SET ciudad = ? WHERE codigo_oficina = ?";
			PreparedStatement statement = connection.prepareStatement(query);

			// Establecer los valores de los parámetros
			statement.setString(1, nueva_ciudad);
			statement.setString(2, codigo_oficina);

			// Ejecutar la consulta
			int filasAfectadas = statement.executeUpdate();

			if (filasAfectadas > 0) {
				System.out.println("Ciudad de la oficina actualizada correctamente.");
			} else {
				System.out.println("No se pudo actualizar la ciudad de la oficina.");
			}

			// Cerrar la conexión
			BDManager.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void eliminarOficina(Scanner scanner) {
		// Declaramos la variable para poder introducir más tarde el código de la
		// oficina
		String codigo_oficina;

		// Pedimos el código de la oficina por teclado
		System.out.println("Insertar código de oficina a eliminar");
		codigo_oficina = scanner.nextLine();

		try {
			Connection connection = BDManager.getConnection();
			// Preparar la sentencia SQL
			String query = "DELETE FROM oficina WHERE codigo_oficina = ?";
			PreparedStatement statement = connection.prepareStatement(query);

			// Establecer el valor del parámetro
			statement.setString(1, codigo_oficina);

			// Ejecutar la consulta
			int filasAfectadas = statement.executeUpdate();

			if (filasAfectadas > 0) {
				System.out.println("Oficina eliminada correctamente.");
			} else {
				System.out.println("No se pudo eliminar la oficina.");
			}

			// Cerrar la conexión
			BDManager.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void eliminarEmpleado(Scanner scanner) {
		// Declaramos la variable para poder introducir más tarde el código del empleado
		int codigo_empleado;

		// Pedimos el código del empleado por teclado
		System.out.println("Insertar código de empleado a eliminar");
		codigo_empleado = scanner.nextInt();
		scanner.nextLine(); // Limpiar el buffer del scanner

		try {
			Connection connection = BDManager.getConnection();
			// Preparar la sentencia SQL
			String query = "DELETE FROM empleado WHERE codigo_empleado = ?";
			PreparedStatement statement = connection.prepareStatement(query);

			// Establecer el valor del parámetro
			statement.setInt(1, codigo_empleado);

			// Ejecutar la consulta
			int filasAfectadas = statement.executeUpdate();

			if (filasAfectadas > 0) {
				System.out.println("Empleado eliminado correctamente.");
			} else {
				System.out.println("No se pudo eliminar el empleado.");
			}

			// Cerrar la conexión
			BDManager.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void eliminarGamaProducto(Scanner scanner) {
		// Declaramos la variable para poder introducir más tarde la gama de producto
		String gama;

		// Pedimos la gama de producto por teclado
		System.out.println("Insertar gama de producto a eliminar");
		gama = scanner.nextLine();

		try {
			Connection connection = BDManager.getConnection();
			// Preparar la sentencia SQL
			String query = "DELETE FROM gama_producto WHERE gama = ?";
			PreparedStatement statement = connection.prepareStatement(query);

			// Establecer el valor del parámetro
			statement.setString(1, gama);

			// Ejecutar la consulta
			int filasAfectadas = statement.executeUpdate();

			if (filasAfectadas > 0) {
				System.out.println("Gama de producto eliminada correctamente.");
			} else {
				System.out.println("No se pudo eliminar la gama de producto.");
			}

			// Cerrar la conexión
			BDManager.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void eliminarCliente(Scanner scanner) {
		// Declaramos la variable para poder introducir más tarde el código del cliente
		int codigo_cliente;

		// Pedimos el código del cliente por teclado
		System.out.println("Insertar código de cliente a eliminar");
		codigo_cliente = scanner.nextInt();
		scanner.nextLine(); // Limpiar el buffer del scanner

		try {
			Connection connection = BDManager.getConnection();
			// Preparar la sentencia SQL
			String query = "DELETE FROM cliente WHERE codigo_cliente = ?";
			PreparedStatement statement = connection.prepareStatement(query);

			// Establecer el valor del parámetro
			statement.setInt(1, codigo_cliente);

			// Ejecutar la consulta
			int filasAfectadas = statement.executeUpdate();

			if (filasAfectadas > 0) {
				System.out.println("Cliente eliminado correctamente.");
			} else {
				System.out.println("No se pudo eliminar el cliente.");
			}

			// Cerrar la conexión
			BDManager.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void eliminarPedido(Scanner scanner) {
		// Declaramos la variable para poder introducir más tarde el código del pedido
		int codigo_pedido;

		// Pedimos el código del pedido por teclado
		System.out.println("Insertar código de pedido a eliminar");
		codigo_pedido = scanner.nextInt();
		scanner.nextLine(); // Limpiar el buffer del scanner

		try {
			Connection connection = BDManager.getConnection();
			// Preparar la sentencia SQL
			String query = "DELETE FROM pedido WHERE codigo_pedido = ?";
			PreparedStatement statement = connection.prepareStatement(query);

			// Establecer el valor del parámetro
			statement.setInt(1, codigo_pedido);

			// Ejecutar la consulta
			int filasAfectadas = statement.executeUpdate();

			if (filasAfectadas > 0) {
				System.out.println("Pedido eliminado correctamente.");
			} else {
				System.out.println("No se pudo eliminar el pedido.");
			}

			// Cerrar la conexión
			BDManager.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void actualizarNombreEmpleado(Scanner scanner) {
		// Declaramos las variables para poder introducir más tarde los campos
		int codigo_empleado;
		String nuevo_nombre;

		// Pedimos los datos por teclado
		System.out.println("Insertar código de empleado");
		codigo_empleado = scanner.nextInt();
		scanner.nextLine(); // Limpiar el buffer del scanner
		System.out.println("Insertar nuevo nombre");
		nuevo_nombre = scanner.nextLine();
		try {
			Connection connection = BDManager.getConnection();
			// Preparar la sentencia SQL
			String query = "UPDATE empleado SET nombre = ? WHERE codigo_empleado = ?";
			PreparedStatement statement = connection.prepareStatement(query);

			// Establecer los valores de los parámetros
			statement.setString(1, nuevo_nombre);
			statement.setInt(2, codigo_empleado);

			// Ejecutar la consulta
			int filasAfectadas = statement.executeUpdate();

			if (filasAfectadas > 0) {
				System.out.println("Nombre del empleado actualizado correctamente.");
			} else {
				System.out.println("No se pudo actualizar el nombre del empleado.");
			}

			// Cerrar la conexión
			BDManager.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void actualizarDescripcionTextoGamaProducto(Scanner scanner) {
		// Declaramos las variables para poder introducir más tarde los campos
		String gama, nueva_descripcion_texto;

		// Pedimos los datos por teclado
		System.out.println("Insertar gama de producto");
		gama = scanner.nextLine();
		System.out.println("Insertar nueva descripción en texto");
		nueva_descripcion_texto = scanner.nextLine();
		try {
			Connection connection = BDManager.getConnection();
			// Preparar la sentencia SQL
			String query = "UPDATE gama_producto SET descripcion_texto = ? WHERE gama = ?";
			PreparedStatement statement = connection.prepareStatement(query);

			// Establecer los valores de los parámetros
			statement.setString(1, nueva_descripcion_texto);
			statement.setString(2, gama);

			// Ejecutar la consulta
			int filasAfectadas = statement.executeUpdate();

			if (filasAfectadas > 0) {
				System.out.println("Descripción en texto de la gama de producto actualizada correctamente.");
			} else {
				System.out.println("No se pudo actualizar la descripción en texto de la gama de producto.");
			}

			// Cerrar la conexión
			BDManager.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void actualizarTelefonoCliente(Scanner scanner) {
		// Declaramos las variables para poder introducir más tarde los campos
		int codigo_cliente;
		String nuevo_telefono;

		// Pedimos los datos por teclado
		System.out.println("Insertar código de cliente");
		codigo_cliente = scanner.nextInt();
		scanner.nextLine(); // Limpiar el buffer del scanner
		System.out.println("Insertar nuevo teléfono");
		nuevo_telefono = scanner.nextLine();

		try {
			Connection connection = BDManager.getConnection();
			// Preparar la sentencia SQL
			String query = "UPDATE cliente SET telefono = ? WHERE codigo_cliente = ?";
			PreparedStatement statement = connection.prepareStatement(query);

			// Establecer los valores de los parámetros
			statement.setString(1, nuevo_telefono);
			statement.setInt(2, codigo_cliente);

			// Ejecutar la consulta
			int filasAfectadas = statement.executeUpdate();

			if (filasAfectadas > 0) {
				System.out.println("Teléfono del cliente actualizado correctamente.");
			} else {
				System.out.println("No se pudo actualizar el teléfono del cliente.");
			}

			// Cerrar la conexión
			BDManager.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void actualizarEstadoPedido(Scanner scanner) {
		// Declaramos las variables para poder introducir más tarde los campos
		int codigo_pedido;
		String nuevo_estado;

		// Pedimos los datos por teclado
		System.out.println("Insertar código de pedido");
		codigo_pedido = scanner.nextInt();
		scanner.nextLine(); // Limpiar el buffer del scanner
		System.out.println("Insertar nuevo estado");
		nuevo_estado = scanner.nextLine();

		try {
			Connection connection = BDManager.getConnection();
			// Preparar la sentencia SQL
			String query = "UPDATE pedido SET estado = ? WHERE codigo_pedido = ?";
			PreparedStatement statement = connection.prepareStatement(query);

			// Establecer los valores de los parámetros
			statement.setString(1, nuevo_estado);
			statement.setInt(2, codigo_pedido);

			// Ejecutar la consulta
			int filasAfectadas = statement.executeUpdate();

			if (filasAfectadas > 0) {
				System.out.println("Estado del pedido actualizado correctamente.");
			} else {
				System.out.println("No se pudo actualizar el estado del pedido.");
			}

			// Cerrar la conexión
			BDManager.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void consultarOficina() {
		try {
			Connection connection = BDManager.getConnection();
			// Preparar la sentencia SQL
			String query = "SELECT * FROM oficina";
			Statement statement = connection.createStatement();

			// Ejecutar la consulta
			ResultSet resultSet = statement.executeQuery(query);

			// Procesar los resultados
			while (resultSet.next()) {
				String codigo_oficina = resultSet.getString("codigo_oficina");
				String ciudad = resultSet.getString("ciudad");
				String pais = resultSet.getString("pais");
				String region = resultSet.getString("region");
				String codigo_postal = resultSet.getString("codigo_postal");
				String telefono = resultSet.getString("telefono");
				String linea_direccion1 = resultSet.getString("linea_direccion1");
				String linea_direccion2 = resultSet.getString("linea_direccion2");

				System.out.printf(
						"Oficina: %s, Ciudad: %s, País: %s, Región: %s, Código Postal: %s, Teléfono: %s, Dirección 1: %s, Dirección 2: %s%n",
						codigo_oficina, ciudad, pais, region, codigo_postal, telefono, linea_direccion1,
						linea_direccion2);
			}

			// Cerrar la conexión
			BDManager.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void consultarEmpleado() {
		try {
			Connection connection = BDManager.getConnection();
			// Preparar la sentencia SQL
			String query = "SELECT * FROM empleado";
			Statement statement = connection.createStatement();

			// Ejecutar la consulta
			ResultSet resultSet = statement.executeQuery(query);

			// Procesar los resultados
			while (resultSet.next()) {
				int codigo_empleado = resultSet.getInt("codigo_empleado");
				String nombre = resultSet.getString("nombre");
				String apellido1 = resultSet.getString("apellido1");
				String apellido2 = resultSet.getString("apellido2");
				String extension = resultSet.getString("extension");
				String email = resultSet.getString("email");
				String codigo_oficina = resultSet.getString("codigo_oficina");
				int codigo_jefe = resultSet.getInt("codigo_jefe");
				String puesto = resultSet.getString("puesto");

				System.out.printf(
						"Empleado: %d, Nombre: %s, Apellido 1: %s, Apellido 2: %s, Extensión: %s, Email: %s, Código Oficina: %s, Código Jefe: %d, Puesto: %s%n",
						codigo_empleado, nombre, apellido1, apellido2, extension, email, codigo_oficina, codigo_jefe,
						puesto);
			}

			// Cerrar la conexión
			BDManager.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void consultarEmpleadoYOficina() {
		try {
			Connection connection = BDManager.getConnection();
			// Preparar la sentencia SQL
			String query = "SELECT e.nombre, e.apellido1, e.apellido2, o.ciudad " + "FROM empleado e "
					+ "JOIN oficina o ON e.codigo_oficina = o.codigo_oficina";
			Statement statement = connection.createStatement();

			// Ejecutar la consulta
			ResultSet resultSet = statement.executeQuery(query);

			// Procesar los resultados
			while (resultSet.next()) {
				String nombre = resultSet.getString("nombre");
				String apellido1 = resultSet.getString("apellido1");
				String apellido2 = resultSet.getString("apellido2");
				String ciudad = resultSet.getString("ciudad");

				System.out.printf("Empleado: %s %s %s, Ciudad de Oficina: %s%n", nombre, apellido1, apellido2, ciudad);
			}

			// Cerrar la conexión
			BDManager.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void consultarPedidoYCliente() {
		try {
			Connection connection = BDManager.getConnection();
			// Preparar la sentencia SQL
			String query = "SELECT p.codigo_pedido, c.nombre_cliente " + "FROM pedido p "
					+ "JOIN cliente c ON p.codigo_cliente = c.codigo_cliente";
			Statement statement = connection.createStatement();

			// Ejecutar la consulta
			ResultSet resultSet = statement.executeQuery(query);

			// Procesar los resultados
			while (resultSet.next()) {
				int codigo_pedido = resultSet.getInt("codigo_pedido");
				String nombre_cliente = resultSet.getString("nombre_cliente");

				System.out.printf("Pedido: %d, Nombre del Cliente: %s%n", codigo_pedido, nombre_cliente);
			}

			// Cerrar la conexión
			BDManager.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void consultarProductoYDetallePedido() {
		try {
			Connection connection = BDManager.getConnection();
			// Preparar la sentencia SQL
			String query = "SELECT p.codigo_producto, p.nombre, dp.codigo_pedido, dp.cantidad, dp.precio_unidad "
					+ "FROM producto p " + "LEFT JOIN detalle_pedido dp ON p.codigo_producto = dp.codigo_producto";
			Statement statement = connection.createStatement();

			// Ejecutar la consulta
			ResultSet resultSet = statement.executeQuery(query);

			// Procesar los resultados
			while (resultSet.next()) {
				String codigo_producto = resultSet.getString("codigo_producto");
				String nombre = resultSet.getString("nombre");
				int codigo_pedido = resultSet.getInt("codigo_pedido");
				int cantidad = resultSet.getInt("cantidad");
				double precio_unidad = resultSet.getDouble("precio_unidad");

				System.out.printf("Producto: %s, Nombre: %s, Pedido: %d, Cantidad: %d, Precio Unidad: %.2f%n",
						codigo_producto, nombre, codigo_pedido, cantidad, precio_unidad);
			}

			// Cerrar la conexión
			BDManager.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void consultarPagoYCliente() {
		try {
			Connection connection = BDManager.getConnection();
			// Preparar la sentencia SQL
			String query = "SELECT p.id_transaccion, p.total, c.nombre_cliente " + "FROM pago p "
					+ "RIGHT JOIN cliente c ON p.codigo_cliente = c.codigo_cliente";
			Statement statement = connection.createStatement();

			// Ejecutar la consulta
			ResultSet resultSet = statement.executeQuery(query);

			// Procesar los resultados
			while (resultSet.next()) {
				String id_transaccion = resultSet.getString("id_transaccion");
				double total = resultSet.getDouble("total");
				String nombre_cliente = resultSet.getString("nombre_cliente");

				System.out.printf("Transacción: %s, Total: %.2f, Cliente: %s%n", id_transaccion, total, nombre_cliente);
			}

			// Cerrar la conexión
			BDManager.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void consultarClienteYPedidos() {
		try {
			Connection connection = BDManager.getConnection();
			// Preparar la sentencia SQL con subconsulta
			String query = "SELECT c.nombre_cliente, "
					+ "(SELECT COUNT(*) FROM pedido p WHERE p.codigo_cliente = c.codigo_cliente) AS cantidad_pedidos "
					+ "FROM cliente c";
			Statement statement = connection.createStatement();

			// Ejecutar la consulta
			ResultSet resultSet = statement.executeQuery(query);

			// Procesar los resultados
			while (resultSet.next()) {
				String nombre_cliente = resultSet.getString("nombre_cliente");
				int cantidad_pedidos = resultSet.getInt("cantidad_pedidos");

				System.out.printf("Cliente: %s, Cantidad de Pedidos: %d%n", nombre_cliente, cantidad_pedidos);
			}

			// Cerrar la conexión
			BDManager.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void consultarProductoYGama() {
		try {
			Connection connection = BDManager.getConnection();
			// Preparar la sentencia SQL con subconsulta
			String query = "SELECT p.nombre, " + "(SELECT g.gama FROM gama_producto g WHERE g.gama = p.gama) AS gama "
					+ "FROM producto p";
			Statement statement = connection.createStatement();

			// Ejecutar la consulta
			ResultSet resultSet = statement.executeQuery(query);

			// Procesar los resultados
			while (resultSet.next()) {
				String nombre_producto = resultSet.getString("nombre");
				String gama = resultSet.getString("gama");

				System.out.printf("Producto: %s, Gama: %s%n", nombre_producto, gama);
			}

			// Cerrar la conexión
			BDManager.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void consultarCantidadPedidos() {

		try {
			Connection connection = BDManager.getConnection();
			// Preparar la sentencia SQL con la función COUNT
			String query = "SELECT COUNT(*) AS cantidad_pedidos FROM pedido";
			Statement statement = connection.createStatement();

			// Ejecutar la consulta
			ResultSet resultSet = statement.executeQuery(query);

			// Procesar los resultados
			if (resultSet.next()) {
				int cantidad_pedidos = resultSet.getInt("cantidad_pedidos");

				System.out.printf("Cantidad total de Pedidos: %d%n", cantidad_pedidos);
			}

			// Cerrar la conexión
			BDManager.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void consultarPrecioMaxProducto() {
		try {
			Connection connection = BDManager.getConnection();
			// Preparar la sentencia SQL con la función MAX
			String query = "SELECT MAX(precio_venta) AS precio_maximo FROM producto";
			Statement statement = connection.createStatement();

			// Ejecutar la consulta
			ResultSet resultSet = statement.executeQuery(query);

			// Procesar los resultados
			if (resultSet.next()) {
				double precio_maximo = resultSet.getDouble("precio_maximo");

				System.out.printf("Precio Máximo de Producto: %.2f%n", precio_maximo);
			}

			// Cerrar la conexión
			BDManager.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void crearVistaProductosPrecioMayor(double umbralPrecio) {
		try {
			Connection connection = BDManager.getConnection();
			// Preparar la sentencia SQL para crear la vista
			String query = "CREATE VIEW productos_precio_mayor AS " + "SELECT * FROM producto "
					+ "WHERE precio_venta > ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setDouble(1, umbralPrecio);

			// Ejecutar la consulta
			statement.executeUpdate();
			System.out.println("Vista de productos con precio mayor creada correctamente.");
			BDManager.closeConnection(connection);
		} catch (SQLException e) {
			System.out.println("Error al crear la vista de productos con precio mayor: " + e.getMessage());
		}
	}

	public static void crearVistaPedidosCantidadMayor(int umbralCantidad) {
		try {
			Connection connection = BDManager.getConnection();
			// Preparar la sentencia SQL para crear la vista
			String query = "CREATE VIEW pedidos_cantidad_mayor AS " + "SELECT * FROM pedido " + "WHERE cantidad > ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, umbralCantidad);

			// Ejecutar la consulta
			statement.executeUpdate();
			System.out.println("Vista de pedidos con cantidad mayor creada correctamente.");
			BDManager.closeConnection(connection);
		} catch (SQLException e) {
			System.out.println("Error al crear la vista de pedidos con cantidad mayor: " + e.getMessage());
		}
	}

	public static void consultarProductosPrecioMayor() {
		try {
			Connection connection = BDManager.getConnection();
			System.out.println("Método de consulta de Productos con Precio Mayor a un Umbral (Vista)");
			// Preparar la sentencia SQL
			String query = "SELECT * FROM productos_precio_mayor";
			Statement statement = connection.createStatement();

			// Ejecutar la consulta
			ResultSet resultSet = statement.executeQuery(query);

			// Procesar los resultados
			while (resultSet.next()) {
				String codigo_producto = resultSet.getString("codigo_producto");
				String nombre = resultSet.getString("nombre");
				double precio_venta = resultSet.getDouble("precio_venta");

				System.out.printf("Producto: %s, Nombre: %s, Precio Venta: %.2f%n", codigo_producto, nombre,
						precio_venta);
			}
			BDManager.closeConnection(connection);
		} catch (SQLException e) {
			System.out.println("Error al consultar la vista de productos con precio mayor: " + e.getMessage());
		}
	}

	public static void consultarPedidosCantidadMayor() {
		try {
			Connection connection = BDManager.getConnection();
			System.out.println("Método de consulta de Pedidos con Cantidad Mayor a un Umbral (Vista)");
			// Preparar la sentencia SQL
			String query = "SELECT * FROM pedidos_cantidad_mayor";
			Statement statement = connection.createStatement();

			// Ejecutar la consulta
			ResultSet resultSet = statement.executeQuery(query);

			// Procesar los resultados
			while (resultSet.next()) {
				int codigo_pedido = resultSet.getInt("codigo_pedido");
				Date fecha_pedido = resultSet.getDate("fecha_pedido");
				int cantidad = resultSet.getInt("cantidad");

				System.out.printf("Pedido: %d, Fecha: %s, Cantidad: %d%n", codigo_pedido, fecha_pedido.toString(),
						cantidad);
			}
			BDManager.closeConnection(connection);
		} catch (SQLException e) {
			System.out.println("Error al consultar la vista de pedidos con cantidad mayor: " + e.getMessage());
		}
	}

}
