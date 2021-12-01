
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class EscribirTodoJunto {


	public void escribirDOM(ArrayList<Cliente> alistaClientes ) {
//
//		try {
//			Document document; // Objeto Document que almacena el DOM del XML seleccionado.
//
//			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
//			DocumentBuilder builder = builderFactory.newDocumentBuilder();
//			DOMImplementation implementation = builder.getDOMImplementation();
//
//			document = implementation.createDocument(null, "cuenta", null); // "cuenta" quiere decir que la raiz del document es una etiqueta llamada cuenta
//
//			// -- Crear los nodos de todas las etiquetas generales
//			Node nodo_raiz = document.getDocumentElement();
//
//			// recorrer el arraylist de clientes
//			for (Cliente cli : alistaClientes) {
//
//				// -- Crear los nodos de todas las etiquetas del cliente
//				Node nodo_cliente = document.createElement("cliente");
//
//				Node nodo_dni = document.createElement("dni");
//				Node nodo_nombre = document.createElement("nombre");
//				Node nodo_edad = document.createElement("edad");
//
//				// -- Crear los nodos de texto con los valores de cada cliente
//				Node nodo_dni_texto = document.createTextNode(cli.getDni());
//				Node nodo_nombre_texto = document.createTextNode(cli.getNombre());
//				Node nodo_edad_texto = document.createTextNode(cli.getEdad() + "");
//
//				// -- Añadir cada nodo a su padre
//
//				nodo_dni.appendChild(nodo_dni_texto);
//				nodo_nombre.appendChild(nodo_nombre_texto);
//				nodo_edad.appendChild(nodo_edad_texto);
//
//				//Añadir al nodo padre
//
//				nodo_cliente.appendChild(nodo_dni);
//				nodo_cliente.appendChild(nodo_nombre);
//				nodo_cliente.appendChild(nodo_edad);
//
//				//-- Añadir cada nodo al raíz
//				nodo_raiz.appendChild(nodo_cliente);
//
//			}
//
//
//			// AHORA QUE YA TENEMOS EL OBJETO DOCUMENT CREADO EN MEMORIA
//			// CON TODO EL CONTENIDO AÑADIDO, HEMOS DE ESCRIBIR EL OBJETO EN UN
//			// FICHERO REAL;
//
//			File archivo_xml = new File("nuevoCuenta.xml");
//			//Especifica el formato de salida
//			OutputFormat format = new OutputFormat(document);
//
//			//Especifica que la salida esté indentada.
//			format.setIndenting(true);
//
//			//Escribe el contenido en el FILE
//			XMLSerializer serializer = new XMLSerializer(new FileOutputStream(archivo_xml), format);
//			serializer.serialize(document);
//
//
//
//
//
//
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
}
