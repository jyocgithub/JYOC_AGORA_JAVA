package ejemploRMILonja;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

// La unica clase que no hace el servidor
public class ClienteLonja {

    public static  void main(String[] args) {
        try {
            String quepescado = "Trucha";
            // Creamos un acceso al registro, con getRegistry,
            // indicando donde ha de buscar objetos: host y puerto
            Registry registry = LocateRegistry.getRegistry("localhost",2222);

            // Con el regsitro, y su méodo lookuo, buscamos un objeto dado,
            // ubicandolo con el nombre del host y el nombre de publicacion que se dio en el servidor
            // lookup busca el objeto publicado, y lo devuelve como respuesta, pero lo devuelve como Object,
            // asi que se debe hacer un casting a la interfaz para poder manejar el objeto
            InterfaceLonja objRecibido = (InterfaceLonja) registry.lookup("//localhost/ObjetoObtenerPrecioDeLonja");

            // con el objeto recibido, puedo llamar ya a sus métodos....
            int respuesta = objRecibido.precioActual(quepescado);

            System.out.println("El precio actual de la "+quepescado+" me informan que es "+respuesta);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}



