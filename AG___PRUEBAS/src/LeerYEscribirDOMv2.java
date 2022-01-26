import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class LeerYEscribirDOMv2 {


    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

        LeerTodoJuntov2 leer = new LeerTodoJuntov2();
        Cuenta cuenta  = leer.leerDOM();

        EscribirTodoJuntov2 escribir = new EscribirTodoJuntov2();
        escribir.escribirDOM(cuenta);

    }
}
