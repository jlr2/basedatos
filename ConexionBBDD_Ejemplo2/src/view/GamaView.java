package view;

import controller.GamaController;
import java.util.Scanner;

public class GamaView {

    GamaController controlador = new GamaController();
    Scanner scanner = new Scanner(System.in);


    public void menuprincipal() {
        boolean salir = false;

        while (!salir) {
            String opcion = opcionesmenu();

            switch (opcion) {
                case "1":
                    System.out.print("Nombre de gama: ");
                    String gama = scanner.nextLine();
                    System.out.print("Descripción: ");
                    String descripcion = scanner.nextLine();
                    controlador.insertarGama(gama, descripcion, null, null);
                    break;
                case "2":
                    controlador.consultarGamas();
                    break;
                case "3":
                    controlador.contarGamas();
                    break;
                case "4":
                    System.out.print("Nombre de gama a actualizar: ");
                    String vieja = scanner.nextLine();
                    System.out.print("Nuevo nombre de gama: ");
                    String nueva = scanner.nextLine();
                    controlador.actualizarGama(vieja, nueva);
                    break;
                case "5":
                    System.out.print("Nombre de gama a borrar: ");
                    String borrar = scanner.nextLine();
                    controlador.borrarGama(borrar);
                    break;
                case "0":
                    salir = true;
                    break;
                default:
                    System.out.println("❌ Opción no válida.");
            }
        }

        System.out.println("👋 Aplicación finalizada.");
    }

    private String opcionesmenu() {
        System.out.println("\n=== MENÚ GESTIÓN DE GAMAS ===");
        System.out.println("1. Insertar gama");
        System.out.println("2. Consultar gamas");
        System.out.println("3. Contar gamas");
        System.out.println("4. Actualizar gama");
        System.out.println("5. Borrar gama");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
        String opcion = scanner.nextLine();

        return opcion;
    }
}


