package DOM;


import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;


public class DOM_Escribir {


    public static void main(String[] args) {
        ArrayList<Empleado> listaEmpleados;
        listaEmpleados = new ArrayList<>();
        listaEmpleados.add(new Empleado("c10", "Pepe", "Perez", "d10"));
        listaEmpleados.add(new Empleado("c11", "Eva", "Lopez", "d20"));

        Node nodo_personal, nodo_empleado, nodo_raiz, nodo_nombre, nodo_apellidos, nodo_nombre_texto, nodo_apellidos_texto;

        Document miDocDom; //Objeto Document que almacena el DOM del XML seleccionado.
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            String nombreDelNodoRaiz = "datosDePersonal";
            miDocDom = implementation.createDocument(null, nombreDelNodoRaiz, null);
            miDocDom.setXmlVersion("1.0");

            //-- Crear los nodos de todas las etiquetas generales
            nodo_raiz = miDocDom.getDocumentElement();
            nodo_personal = miDocDom.createElement("personal");

            // recorrer el arraylist de empleados
            for (Empleado em : listaEmpleados) {

                //-- Crear los nodos de todas las etiquetas del empleado
                nodo_empleado = miDocDom.createElement("empleado");
                nodo_nombre = miDocDom.createElement("nombre");
                nodo_apellidos = miDocDom.createElement("apellidos");

                //-- Crear los nodos de texto con los valores de cada empleado
                nodo_nombre_texto = miDocDom.createTextNode(em.getNombreEmpleado());
                nodo_apellidos_texto = miDocDom.createTextNode(em.getApellidoEmpleado());

                //-- Añade atributos como elementos de texto, esto no crea nodos, modifica los ya creados
                ((Element) nodo_empleado).setAttribute("codigoEmp", em.getCodigoEmpleado());
                ((Element) nodo_empleado).setAttribute("codDptoPertenencia", em.getCodDpto() + "");

                //-- Añadir cada nodo a su padre
                nodo_nombre.appendChild(nodo_nombre_texto);
                nodo_apellidos.appendChild(nodo_apellidos_texto);
                nodo_empleado.appendChild(nodo_nombre);
                nodo_empleado.appendChild(nodo_apellidos);
                nodo_personal.appendChild(nodo_empleado);
            }
            // Se añade el nodo personal a nodo raiz, no se hace dentro del for, pues hay que meter todos los empleados
            // en la etiqueta personal....
            nodo_raiz.appendChild(nodo_personal);

        } catch (Exception e) {
            e.printStackTrace();
        }




    }

}
