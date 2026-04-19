package Usuarios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Usuarios {
    Scanner sc = new Scanner(System.in);
    ArrayList<Datos> lista = new ArrayList<>();

    public static void crearArchivo() {
        File myFile = new File("nombre.txt");

        try {
            if (myFile.createNewFile()) {
                System.out.println("Has creado el archivo " + myFile.getName());
            } else {
                System.out.println("El archivo ya existe");
            }

        } catch (IOException e) {
            System.out.println("Error al crear el archivo");
        }
    }

    public void leerArchivo() {
        try {
            File file = new File("nombre.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] datos = linea.split(",");

                String nombre = datos[0];
                int edad = Integer.parseInt(datos[1]);
                String correo = datos[2];

                lista.add(new Datos(correo, edad, nombre));
            }

            sc.close();

        } catch (FileNotFoundException e) {
            System.out.println("No hay archivo previo");
        }
    }

    public void guardarUsuario(Datos d) {
        try {
            FileWriter fw = new FileWriter("nombre.txt", true);
            fw.write(d.getNombre() + "," + d.getEdad() + "," + d.getCorreo() + "\n");
            fw.close();
        } catch (IOException e) {
            System.out.println("Error al guardar");
        }
    }

    public void pedirDatos() {
        boolean crear = true;
        while (crear) {

            System.out.print("Introduce tu nombre: ");
            String nombre = sc.next();

            int edad = 0;

            while (true) {
                try {
                    System.out.print("Introduce tu edad: ");
                    edad = sc.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Error: introduce un número");
                    sc.nextLine();
                }
            }

            System.out.print("Introduce tu correo: ");
            String correo = sc.next();

            Datos d = new Datos(correo, edad, nombre);
            lista.add(d);
            guardarUsuario(d);

            System.out.print("¿Quieres crear otro usuario mas? ");
            String crea = sc.next();
            if (crea.equalsIgnoreCase("si")) {
                crear = true;
            } else {
                crear = false;
            }
        }
    }

    public void verUsuarios () {
        System.out.println("\n--- LISTA DE USUARIOS ---");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }
}