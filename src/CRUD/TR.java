package CRUD;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class TR {
    ArrayList<Equipos> lista = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void guardarEquipo(Equipos eq) {
        try {
            FileWriter fw = new FileWriter("nombre.txt", true);
            fw.write(eq.getNombre() + "," + eq.getPais() + "," + eq.getTrofeos() + "\n");
            fw.close();
        } catch (IOException e) {
            System.out.println("Error al guardar");
        }
    }

    public void creacionEquipos() {
        boolean seguir = true;

        String nombre = "";
        String pais = "";
        int trofeos = 0;

        while (seguir) {
            try {
                System.out.print("¿Que nombre tiene el equipo? ");
                nombre = sc.next();

                System.out.print("¿De que pais es el equipo? ");
                pais = sc.next();

                System.out.print("¿Cuántos trofeos tiene el equipo? ");
                trofeos = sc.nextInt();

                Equipos eq = new Equipos(nombre, pais, trofeos);
                lista.add(eq);
                guardarEquipo(eq);

                seguir = false;

            } catch (InputMismatchException e) {
                System.out.println("Debes poner un número en trofeos.");
                sc.nextLine();
            }
        }
    }

    public void verEquipos() {
        System.out.println("\n=== EQUIPOS ===");

        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + " - " + lista.get(i));
        }
    }

    public void modificarEquipos() {
        System.out.print("¿Qué equipo quieres modificar? ");
        int posicion = sc.nextInt() - 1;

        if (posicion >= 0 && posicion < lista.size()) {

            System.out.print("Añade el nuevo nombre del equipo: ");
            String nuevoNombre = sc.next();
            lista.get(posicion).setNombre(nuevoNombre);

            System.out.print("Añade el nuevo pais del equipo: ");
            String nuevoPais = sc.next();
            lista.get(posicion).setPais(nuevoPais);

            boolean correcto = false;

            while (!correcto) {
                try {
                    System.out.print("Añade la nueva cantidad de trofeos: ");
                    int nuevoTrofeos = sc.nextInt();
                    lista.get(posicion).setTrofeos(nuevoTrofeos);
                    correcto = true;

                } catch (InputMismatchException e) {
                    System.out.println("Debes poner un número.");
                    sc.nextLine();
                }
            }

        } else {
            System.out.println("No tienes ese número de equipo.");
        }
    }

    public void eliminarEquipo() {
        System.out.print("¿Qué equipo quieres eliminar? ");
        int eliminar = sc.nextInt() - 1;

        if (eliminar >= 0 && eliminar < lista.size()) {
            lista.remove(eliminar);
        } else {
            System.out.println("No existe ese equipo.");
        }
    }
}

