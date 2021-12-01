package ed_pilas;

public class Pila {
    protected Nodo ultimoNodo;

    // CONSTUCTOR. Al crear la pila, el ultimo nodo es null (no hay aun nodos)
    public Pila() {
        ultimoNodo = null;
    }
    

    // METODOS
    // Nos dice si esta vacia la pila, si no hay nodos
    public boolean estaVacia () {
        return (ultimoNodo == null);
    }

    // inserta al final de la pila, encima del todos los demas nodos
    public void insertar (String info) {
        Nodo nodoNuevo = new Nodo (info); // crear un nuevo nodo con la info pasada
        nodoNuevo.setNodoAnterior(ultimoNodo);   // a este nodo le dice que el que estara antes que el es ultimoNodo
        ultimoNodo = nodoNuevo;  // a partir de ahora, el ultimo nodo es el nuevo creado
    }

    // extraer el ultimo nodo de la lista y devolver su informacion
    public String extraer () {
        String resultado = null;
        if (! estaVacia()) {                                    // si esta vacia devolvera null, simplemente
            resultado = ultimoNodo.getInformacionDelNodo ();    //cojo la informacion del ultimo nodo
            ultimoNodo = ultimoNodo.getNodoAnterior ();         //el nuevo ultimoNodo es el nodoAnterior del que era ultimoNodo
        }
        return resultado;                                       // deveulvo el resultado
    }

    public void insertar (String info, Nodo predecesor) {       // Inserta un nodo antes del que se le pasa por parámetro
        Nodo nodoNuevo = new Nodo (info);                        // creo un nodo nuevo
        nodoNuevo.setNodoAnterior(predecesor.getNodoAnterior ()); // el anterior a este nodo nuevo es el que era anterior del precedesor
        predecesor.setNodoAnterior(nodoNuevo);                   // el anterior del predecesor es el nodo nuevo
    }

    // extrae el nodo anterior en la pila al indicado por parametro
    public String extraer (Nodo precedente) {
        String resultado = null;
        // si el que pasamos es el primero, no tiene nodo anterior que devolver
        if (precedente.getNodoAnterior () != null) {
            // recogemos la informacion del nodo anterior al precedente
            resultado = precedente.getNodoAnterior ().getInformacionDelNodo ();
            // el nuevo anterior del precedente es el anterior del extraido (el anterior del precedente)
            precedente.setNodoAnterior (precedente.getNodoAnterior ().getNodoAnterior ());
        }
        return resultado;
    }

    // calcula el tamaño de la pila.
    public int cuantosNodos () {
        int cuantos = 0;
        Nodo unNodo = ultimoNodo;
        // recorro, contando nodos, desde el ultimo nodo hasta que ultimoNodo sea null
        while (unNodo != null) {
            cuantos++;
            unNodo = unNodo.getNodoAnterior ();
        }
        return cuantos;
    }

    // Pinta toda la cola desde el ultimo elemento al primero
    public String toString () {
        String resultado = "";
        Nodo unNodo = ultimoNodo;
        while (unNodo != null) {
            resultado = resultado + unNodo.getInformacionDelNodo ().toString ();
            if (unNodo.getNodoAnterior () != null) {
                resultado = resultado + " -> ";
            }
            unNodo = unNodo.getNodoAnterior ();
        }
        return resultado;
    }
    // devuelve un nodo si existe, indicando su informacion
    public Nodo buscarNodo (String info) {
        Nodo nodoFinal = null;
        Nodo nodoActual = ultimoNodo;
        while (nodoActual != null && !nodoActual.getInformacionDelNodo ().equals (info)) {
            nodoActual = nodoActual.getNodoAnterior ();
        }
        if (nodoActual != null) {
            nodoFinal = nodoActual;
        }
        return nodoFinal;
    }

    // devuelve un nodo si existe, indicando su posicion
    public Nodo buscarNodo (int n) {
        Nodo nodoFinal = null;
        Nodo nodoActual = ultimoNodo;
        int control = 0;
        while (nodoActual != null && control < n) {
            nodoActual = nodoActual.getNodoAnterior ();
            control++;
        }
        if (nodoActual != null) {
            nodoFinal = nodoActual;
        }
        return nodoFinal;
    }

    // devuelve el primer nodo de la cola.
    public Nodo buscarPrimerNodo () {
        Nodo primero = ultimoNodo;
        while (primero != null && primero.getNodoAnterior () != null) {
            primero = primero.getNodoAnterior ();
        }
        return primero;
    }

    // busca un nodo por su posicion
    public int buscarPosicion (String info) {
        Nodo current = ultimoNodo;
        int infoPosition = -1;
        if (!estaVacia ()) {
            infoPosition = 0;
            while (current != null && !current.getInformacionDelNodo ().equals (info)) {
                infoPosition++;
                current = current.getNodoAnterior ();
            }
        }
        return infoPosition;
    }
}