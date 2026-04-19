package CRUD;

public class Equipos {
    private String nombre;
    private String pais;
    private int trofeos;

    public Equipos(String nombre, String pais, int trofeos) {
        this.nombre = nombre;
        this.pais = pais;
        this.trofeos = trofeos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getTrofeos() {
        return trofeos;
    }

    public void setTrofeos(int trofeos) {
        this.trofeos = trofeos;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Pais: " + pais + " | Trofeos: " + trofeos;
    }
}

