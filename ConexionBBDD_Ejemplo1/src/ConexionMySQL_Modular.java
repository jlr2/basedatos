import java.sql.*;

public class ConexionMySQL_Modular {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/jardineria";
    private static final String USER = "jardineria";
    private static final String PASS = "jardineria";

    public static void main(String[] args) {
        try (Connection conn = conectar()) {
            insertarGama(conn, "Accesorios8", "Articulos para arboles", null, null);
            consultarGamas(conn);
            contarGamas(conn);
            actualizarGama(conn, "Accesorios", "Accesorios CAMBIADO");
            consultarGamas(conn);
            borrarGama(conn, "Accesorios2");
            consultarGamas(conn);
        } catch (Exception e) {
            System.out.println("Error general: " + e.getMessage());
        }
    }

    // 🔌 Conexión a la base de datos
    public static Connection conectar() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USER, PASS);
    }

    // 📥 Insertar
    public static void insertarGama(Connection conn, String gama, String descripcion, String html, String imagen) {
        String sql = "INSERT INTO gama_producto (gama, descripcion_texto, descripcion_html, imagen) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, gama);
            ps.setString(2, descripcion);
            ps.setString(3, html);
            ps.setString(4, imagen);
            ps.executeUpdate();
            System.out.println("✅ Gama insertada: " + gama);
        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }

    // 🔍 Consultar
    public static void consultarGamas(Connection conn) {
        String sql = "SELECT gama, descripcion_texto FROM gama_producto";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            System.out.println("📋 Lista de gamas:");
            while (rs.next()) {
                System.out.println(" - " + rs.getString("gama") + ": " + rs.getString("descripcion_texto"));
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar: " + e.getMessage());
        }
    }

    // 🔢 Contar
    public static void contarGamas(Connection conn) {
        String sql = "SELECT COUNT(gama) FROM gama_producto";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                int total = rs.getInt(1);
                System.out.println("🔢 Total de gamas: " + total);
            }
        } catch (SQLException e) {
            System.out.println("Error al contar: " + e.getMessage());
        }
    }

    // ✏️ Actualizar
    public static void actualizarGama(Connection conn, String viejaGama, String nuevaGama) {
        String sql = "UPDATE gama_producto SET gama = ? WHERE gama = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nuevaGama);
            ps.setString(2, viejaGama);
            ps.executeUpdate();
            System.out.println("✏️ Gama actualizada de '" + viejaGama + "' a '" + nuevaGama + "'");
        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }

    // ❌ Borrar
    public static void borrarGama(Connection conn, String gama) {
        String sql = "DELETE FROM gama_producto WHERE gama = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, gama);
            ps.executeUpdate();
            System.out.println("🗑️ Gama borrada: " + gama);
        } catch (SQLException e) {
            System.out.println("Error al borrar: " + e.getMessage());
        }
    }
}