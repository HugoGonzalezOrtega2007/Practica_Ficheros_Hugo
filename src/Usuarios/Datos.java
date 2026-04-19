package Usuarios;

import java.util.Scanner;

public class Datos {
    private String nombre;
    private int edad;
    private String correo;

    public Datos(String correo, int edad, String nombre) {
        super();
        this.correo = correo;
        this.edad = edad;
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Edad: " + edad + " | Correo: " + correo;
    }
}
