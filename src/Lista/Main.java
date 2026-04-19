package Lista;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) throws FileNotFoundException {

        try {
            File myObj2 = new File("lista.txt");
            Scanner sc = new Scanner(myObj2);
            int contador = 0;
            System.out.println("Archivo importado correctamente");

            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                if (data.toLowerCase().contains("trump") || data.toLowerCase().contains("trump's")) {
                    contador++;
                }
            }
            System.out.println("La palabra Trump sale " + contador + " veces." );

            sc.close();

        } catch (InputMismatchException e) {
            System.out.println("Error al leer el archivo.");
        }
    }
}
