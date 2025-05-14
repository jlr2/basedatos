package controller;

import model.ConexionMySQL;
import model.GamaDAO;

import java.sql.Connection;

public class GamaController {

    private final GamaDAO gamaDAO;

    public GamaController() {
        this.gamaDAO = new GamaDAO();
    }

    public void insertarGama(String gama, String descripcion, String html, String imagen) {
        try (Connection conn = ConexionMySQL.conectar()) {
            gamaDAO.insertar(conn, gama, descripcion, html, imagen);
        } catch (Exception e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }

    public void consultarGamas() {
        try (Connection conn = ConexionMySQL.conectar()) {
            gamaDAO.consultar(conn);
        } catch (Exception e) {
            System.out.println("Error al consultar: " + e.getMessage());
        }
    }

    public void contarGamas() {
        try (Connection conn = ConexionMySQL.conectar()) {
            gamaDAO.contar(conn);
        } catch (Exception e) {
            System.out.println("Error al contar: " + e.getMessage());
        }
    }


    public void actualizarGama(String viejaGama, String nuevaGama) {
        try (Connection conn = ConexionMySQL.conectar()) {
            gamaDAO.actualizar(conn, viejaGama, nuevaGama);
        } catch (Exception e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }

    public void borrarGama(String gama) {
        try (Connection conn = ConexionMySQL.conectar()) {
            gamaDAO.borrar(conn, gama);
        } catch (Exception e) {
            System.out.println("Error al borrar: " + e.getMessage());
        }
    }


}
