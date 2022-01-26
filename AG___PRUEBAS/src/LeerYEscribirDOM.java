import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class LeerYEscribirDOM {


    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

        LeerTodoJunto leer = new LeerTodoJunto();
        ArrayList<Cliente> alistaClientes  = leer.leerDOM();

        EscribirTodoJunto escribir = new EscribirTodoJunto();
        escribir.escribirDOM(alistaClientes);

    }
}
