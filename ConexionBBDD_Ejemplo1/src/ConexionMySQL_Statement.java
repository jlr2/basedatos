import java.sql.*;

/**
 *
 * @author jlr2
 */
public class ConexionMySQL_Statement {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL_CONEXION = "jdbc:mysql://localhost:3306/jardineria";

    public static void main(String args[]) throws SQLException {
        final String usuario = "jardineria";
        final String password = "jardineria";
        Connection dbConnection = null;
        Statement statement=null;


        try {
            // Conexión a la BD
            // Cargar el drive
            Class.forName(DRIVER);
            // Conectar con la base de datos
            dbConnection = DriverManager.getConnection(URL_CONEXION, usuario, password);

            // insertar datos
           /* String sentenciaSql = "INSERT INTO gama_producto (gama, descripcion_texto, descripcion_html, imagen) VALUES ('Accesorios9','Articulos para rosas', 'NULL','NULL')";

            statement = dbConnection.createStatement();
            statement.executeUpdate(sentenciaSql);*/

            //  consultar datos
            String selectTableSQL = "SELECT gama, descripcion_texto FROM gama_producto";
            statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                String gama_pornombre = rs.getString("gama");
                String gama_porcolumna= rs.getString (1);  // forma alternativa
                String descripcion_texto_pornombre = rs.getString("descripcion_texto");
                String descripcion_texto_porcolumna= rs.getString(2);
                System.out.println("gama_pornombre: " + gama_pornombre);
                System.out.println("gama_porcolumna: " + gama_porcolumna);
                System.out.println("descripcion_texto_pornombre: " + descripcion_texto_pornombre);
                System.out.println("descripcion_texto_porcolumna: " + descripcion_texto_porcolumna);
            }


            //  consultar datos: funciones agregadas
            selectTableSQL = "SELECT count(gama) FROM gama_producto";
            statement = dbConnection.createStatement();
            rs = statement.executeQuery(selectTableSQL);
            rs.next(); // solo se ejecuta una vez
            int num_gamas = rs.getInt(1);
            System.out.println("Cantidad de gamas: " + num_gamas);



            //  modificar datos
          String  sentenciaSql = "UPDATE gama_producto SET gama = 'Accesorios CAMBIADO es hora de irse' WHERE gama = 'Accesorios9'";
            statement = null;
            statement = dbConnection.createStatement();
            statement.executeUpdate(sentenciaSql);
/*

            //  consultar datos
            selectTableSQL = "SELECT gama, descripcion_texto FROM gama_producto";
            statement = dbConnection.createStatement();
            rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                    String gama_pornombre = rs.getString("gama");
                String gama_porcolumna = rs.getString(1);  // forma alternativa
                String descripcion_texto_pornombre = rs.getString("descripcion_texto");
                String descripcion_texto_porcolumna = rs.getString(2);
                System.out.println("gama_pornombre: " + gama_pornombre);
                System.out.println("gama_porcolumna: " + gama_porcolumna);
                System.out.println("descripcion_texto_pornombre: " + descripcion_texto_pornombre);
                System.out.println("descripcion_texto_porcolumna: " + descripcion_texto_porcolumna);


                // borrar datos
                sentenciaSql = "DELETE from gama_producto WHERE gama = 'Accesorios2'";
                statement = null;
                statement = dbConnection.createStatement();
                statement.executeUpdate(sentenciaSql);


                //  consultar datos
                selectTableSQL = "SELECT gama, descripcion_texto FROM gama_producto";
                statement = dbConnection.createStatement();
                rs = statement.executeQuery(selectTableSQL);
                while (rs.next()) {
                    gama_pornombre = rs.getString("gama");
                    gama_porcolumna = rs.getString(1);  // forma alternativa
                    descripcion_texto_pornombre = rs.getString("descripcion_texto");
                    descripcion_texto_porcolumna = rs.getString(2);
                    System.out.println("gama_pornombre: " + gama_pornombre);
                    System.out.println("gama_porcolumna: " + gama_porcolumna);
                    System.out.println("descripcion_texto_pornombre: " + descripcion_texto_pornombre);
                    System.out.println("descripcion_texto_porcolumna: " + descripcion_texto_porcolumna);

                }
            }
*/
        } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
           catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver: " + e.getMessage());
            }

        finally
        {
                try {
                    if (statement != null) statement.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar el statement: " + e.getMessage());
                }

                try {
                    if (dbConnection != null) dbConnection.close();
                    }
                catch (SQLException e)
                {
                    System.out.println("Error al cerrar la conexión: " + e.getMessage());
                }
        }

        }

}
