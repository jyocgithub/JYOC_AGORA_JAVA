package ejemploRMILonja;

import java.rmi.server.UnicastRemoteObject;

// Clase de la que vamos a crear objetos para compartir
// Debe extender de UnicastRemoteObject,
// y debe implementar la interfaz que se creo (que define los métodos que se comparten)
public class ClaseLonja extends UnicastRemoteObject implements InterfaceLonja {

    // Debe obligatoriamente tener un constructor vacio
    public ClaseLonja(int id) throws Exception {
    }

    // Este es el método que se comparte (pueed haber mas, claro)
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
}
