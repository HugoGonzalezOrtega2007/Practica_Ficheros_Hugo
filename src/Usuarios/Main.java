package Usuarios;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(System.in);
        Usuarios u = new Usuarios();

        u.crearArchivo();
        u.leerArchivo();
        u.pedirDatos();

        System.out.println("¿Que deseas hacer? (1. Ver usuarios | 2. Salir) ");
        int opcion = sc.nextInt();

        if (opcion == 1) {
            u.verUsuarios();
        } else {
            System.exit(0);
        }
    }
}