package model;

import java.sql.*;

public class GamaDAO {

    public void insertar(Connection conn, String gama, String descripcion, String html, String imagen) {
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

    public void consultar(Connection conn) {
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

    public void contar(Connection conn) {
        String sql = "SELECT COUNT(gama) FROM gama_producto";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                System.out.println("🔢 Total de gamas: " + rs.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println("Error al contar: " + e.getMessage());
        }
    }

    public void actualizar(Connection conn, String viejaGama, String nuevaGama) {
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

    public void borrar(Connection conn, String gama) {
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
