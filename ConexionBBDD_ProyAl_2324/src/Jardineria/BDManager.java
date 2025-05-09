package Jardineria;
import java.sql.*;

public class BDManager {
    // Configuración de la conexión
    private static final String URL = "jdbc:mysql://localhost:3306/jardineria";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    // Método para obtener la conexión
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    // Método para cerrar la conexión
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para cerrar el statement
    public static void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para cerrar el result set
    public static void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para ejecutar una consulta SQL
    public static ResultSet executeQuery(String query) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResultSet(resultSet);
            closeStatement(statement);
            closeConnection(connection);
        }

        return resultSet;
    }

    // Método para ejecutar una actualización SQL (inserción, actualización, borrado)
    public static int executeUpdate(String query) {
        Connection connection = null;
        Statement statement = null;
        int rowsAffected = 0;

        try {
            connection = getConnection();
            statement = connection.createStatement();
            rowsAffected = statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(statement);
            closeConnection(connection);
        }

        return rowsAffected;
    }
}
