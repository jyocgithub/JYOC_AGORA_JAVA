package soluciones_ejercicicios.ims.jyoc.cap30_3_GranHermanastro;

public class Habitante {
    private String nombre;
    private int puntos;

    public Habitante(String nombre, int puntos) {
        this.nombre = nombre;
        this.puntos = puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
}