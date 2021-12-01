import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class LeerTodoJunto {

    // se pone a nivel de clase, no dentro del main, para poder acceder desde fuera con un getter
    ArrayList<Cliente> alistaClientes = new ArrayList<>();

    public ArrayList<Cliente> leerDOM() throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("Cuenta.xml"));


        if (! new File("Cuenta.xml").exists()){
            System.out.println("no hay xml");
        }
        document.getDocumentElement().normalize();


        Node nodo_raiz = document.getDocumentElement(); // sacar del document el nodo raiz

        String nombreDelNodoRaiz = nodo_raiz.getNodeName(); // sacar el nombre del nodo raiz

        // cogemos los hijos directos de raiz. No usamos bucle por que no hay muchos, solo uno de cada cosa
        NodeList ncc_hijo = document.getElementsByTagName("ncc").item(0).getChildNodes();
        Node valornodo = ncc_hijo.item(0);
        String ncc = valornodo.getNodeValue();

        NodeList saldo_hijo = document.getElementsByTagName("saldo").item(0).getChildNodes();
        Node valorsaldo = ncc_hijo.item(0);
        String saldo = valornodo.getNodeValue();

        // vamos ahora a por la lista de clientes
        NodeList listaClientes = document.getElementsByTagName("cliente");

        // y la recorremos
        for (int t = 0; t < listaClientes.getLength(); t++) {
            Node nodoCadaCliente = listaClientes.item(t);

            Element elem = (Element) nodoCadaCliente;   // LOS METODOS SIGUIENTES QUE SE USAN SON DE TIPO ELEMENT, no vale node

            NodeList hijos1 = elem.getElementsByTagName("dni").item(0).getChildNodes();
            Node valorNodo = hijos1.item(0);   // NODO CON EL TEXTO
            String dni = valorNodo.getNodeValue();

            NodeList hijos2 = elem.getElementsByTagName("nombre").item(0).getChildNodes();
            valorNodo = hijos2.item(0);   // NODO CON EL TEXTO
            String nombre = valorNodo.getNodeValue();

            NodeList hijos3 = elem.getElementsByTagName("edad").item(0).getChildNodes();
            valorNodo = hijos3.item(0);   // NODO CON EL TEXTO
            String edad = valorNodo.getNodeValue();  // getNodeValue devuelve siempreun string

            Cliente c = new Cliente(dni, nombre, Integer.parseInt(edad));  // edad necesita converrtisrse en int
            alistaClientes.add(c);
        }
        for (Cliente cc : alistaClientes) {
            System.out.println(cc);
        }

        return alistaClientes;
    }


}
