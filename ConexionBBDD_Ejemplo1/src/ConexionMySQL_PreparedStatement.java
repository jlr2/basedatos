import java.sql.*;

public class ConexionMySQL_PreparedStatement {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL_CONEXION = "jdbc:mysql://localhost:3306/jardineria";

    public static void main(String args[]) {
        final String usuario = "jardineria";
        final String password = "jardineria";
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            Class.forName(DRIVER);
            dbConnection = DriverManager.getConnection(URL_CONEXION, usuario, password);

            // CONSULTA PRUEBA INYECCIÓN SQL
            //  consultar datos
            String gama =  "' OR '1'='1";
            String selectTableSQL = "SELECT gama, descripcion_texto FROM gama_producto WHERE gama = '" + gama + "'"; ;
            Statement statement = dbConnection.createStatement();
            rs = statement.executeQuery(selectTableSQL);
            System.out.println("#######################################");
            System.out.println ("PRUEBA SQL INYECTION");
            while (rs.next()) {
                String gama_pornombre = rs.getString("gama");
                String descripcion_texto_pornombre = rs.getString("descripcion_texto");
                System.out.print("gama_pornombre: " + gama_pornombre);
                System.out.println(" - descripcion_texto_pornombre: " + descripcion_texto_pornombre);
            }
            System.out.println("#######################################");



/*
            // INSERTAR DATOS
            String insertSQL = "INSERT INTO gama_producto (gama, descripcion_texto, descripcion_html, imagen) VALUES (?, ?, ?, ?)";
            preparedStatement = dbConnection.prepareStatement(insertSQL);
            preparedStatement.setString(1, "Accesorios6");
            preparedStatement.setString(2, "Articulos para arboles");
            preparedStatement.setString(3, null);  // Si deseas insertar NULL reales
            preparedStatement.setString(4, null);
            preparedStatement.executeUpdate();

            // CONSULTAR DATOS
            String selectSQL = "SELECT gama, descripcion_texto FROM gama_producto";
            preparedStatement = dbConnection.prepareStatement(selectSQL);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                System.out.println("gama: " + rs.getString("gama"));
                System.out.println("descripcion_texto: " + rs.getString("descripcion_texto"));
            }

            // CONSULTAR FUNCIÓN AGREGADA
            String countSQL = "SELECT count(gama) FROM gama_producto";
            preparedStatement = dbConnection.prepareStatement(countSQL);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                int num_gamas = rs.getInt(1);
                System.out.println("Cantidad de gamas: " + num_gamas);
            }

            // MODIFICAR DATOS
            String updateSQL = "UPDATE gama_producto SET gama = ? WHERE gama = ?";
            preparedStatement = dbConnection.prepareStatement(updateSQL);
            preparedStatement.setString(1, "Accesorios CAMBIADO");
            preparedStatement.setString(2, "Accesorios");
            preparedStatement.executeUpdate();

            // CONSULTAR NUEVAMENTE
            preparedStatement = dbConnection.prepareStatement(selectSQL);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                System.out.println("gama: " + rs.getString("gama"));
                System.out.println("descripcion_texto: " + rs.getString("descripcion_texto"));
            }

            // BORRAR DATOS
            String deleteSQL = "DELETE FROM gama_producto WHERE gama = ?";
            preparedStatement = dbConnection.prepareStatement(deleteSQL);
            preparedStatement.setString(1, "Accesorios2");
            preparedStatement.executeUpdate();

            // CONSULTAR FINAL
            preparedStatement = dbConnection.prepareStatement(selectSQL);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                System.out.println("gama: " + rs.getString("gama"));
                System.out.println("descripcion_texto: " + rs.getString("descripcion_texto"));
            }
*/
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar ResultSet: " + e.getMessage());
            }
            try {
                if (preparedStatement != null) preparedStatement.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar PreparedStatement: " + e.getMessage());
            }
            try {
                if (dbConnection != null) dbConnection.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
