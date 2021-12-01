package ejemploRMILonjaConObjetos;

import java.io.Serializable;



public class Pez implements Serializable {
    private String familia="Sin clasificar";
    // Para evitar posibles problemas de serializacion, es aconsejable que esta clase
    // tenga el mismo serialVersionUID en cliente y servidor
    private static final long serialVersionUID = 111122223333444455L;

    public Pez(String familia) {
        this.familia = familia;
    }

    public String getFamilia() {
        return familia;
    }
}
