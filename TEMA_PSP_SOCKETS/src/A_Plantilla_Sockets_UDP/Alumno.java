package A_Plantilla_Sockets_UDP;

import java.io.Serializable;

public class Alumno implements Serializable {
    String nombre;
    int edad;
    public Alumno(String nombre, int edad) {
        super();
        this.nombre = nombre;
        this.edad = edad;
    }
}