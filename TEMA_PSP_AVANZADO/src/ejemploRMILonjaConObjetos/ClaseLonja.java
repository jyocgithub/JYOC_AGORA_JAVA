package ejemploRMILonjaConObjetos;

import java.io.Serializable;
import java.rmi.server.UnicastRemoteObject;

// Clase de la que vamos a crear objetos para compartir
// Debe extender de UnicastRemoteObject,
// y debe implementar la interfaz que se creo (que define los métodos que se comparten)
public class ClaseLonja extends UnicastRemoteObject implements InterfaceLonja, Serializable {
    private static final long serialVersionUID = 111122223333444466L;

    // Debe obligatoriamente tener un constructor vacio
    public ClaseLonja() throws Exception {
    }

    // Este es un o de los métodos que se comparten
    public int precioActual(String tipopescado) {
        int precio = 0;
        try {
            if (tipopescado.equals("Trucha")) {
                precio = 3;
            } else if (tipopescado.equals("Lubina")) {
                precio = 7;
            } else {
                precio = -1;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return precio;
    }

    // Este es otro de los métodos que se comparten
    public Pez getPez() {
        Pez pez = new Pez("Pelágico");
        return pez;
    }
}
