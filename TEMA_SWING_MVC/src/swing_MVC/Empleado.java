package swing_MVC;

public class Empleado {
    private String NIF;
    private String nombre;

    public Empleado(String NIF, String nombre) {
        this.NIF = NIF;
        this.nombre = nombre;
    }


    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}