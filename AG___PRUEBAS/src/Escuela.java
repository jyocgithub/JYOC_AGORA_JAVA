import java.io.Serializable;
import java.util.ArrayList;

public class Escuela implements Serializable {
    ArrayList<Alumno> alumnos = new ArrayList<>();

    @Override
    public String toString() {
        return "Escuela{" +
                "alumnos=" + alumnos +
                '}';
    }
}