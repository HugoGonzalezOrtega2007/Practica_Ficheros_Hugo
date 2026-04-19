package CRUD;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TR tr = new TR();

        System.out.println("=== CLASIFICACION DE EQUIPOS ===");
        tr.creacionEquipos();

        boolean seguir = true;
        while (seguir) {
            try {
                System.out.print("\n¿Que acción quieres hacer? (1. Ver equipos | 2. Crear nuevo equipo | 3. Eliminar equipo | 4. Modificar equipo | 5. Salir) ");
                int accion = sc.nextInt();
                if (accion == 1) {
                    tr.verEquipos();
                } else if (accion == 2) {
                    tr.creacionEquipos();
                } else if (accion == 3) {
                    tr.eliminarEquipo();
                } else if (accion == 4) {
                    tr.modificarEquipos();
                } else if (accion == 5) {
                    seguir = false;
                } else {
                    System.out.println("Por favor, seleccione una de las opciones mostradas.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduzca un numero.");
                sc.next();
            }
        }
    }
}