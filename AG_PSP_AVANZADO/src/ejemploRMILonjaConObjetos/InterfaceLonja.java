package ejemploRMILonjaConObjetos;

import java.io.Serializable;
import java.rmi.Remote;

public interface InterfaceLonja extends Remote{

    // Definimos los métodos que vamos a publicar.
    // Pueden arrojar RemoteException, o controlar la excepcion en el futuro en el propio método
    // Puede ser mas cómodo arrojar la excepcion y que en el cliente sea donde se controle, si algo va mal
    int precioActual(String tipoPescado) throws Exception;
    Pez getPez() throws Exception;
}

