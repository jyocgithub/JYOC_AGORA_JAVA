package ColasYPilas;

// actua como una pila, LIFO.
public class ListaEnlazadaSimple {
	protected Nodo ultimoNodo;

	// constructor. Al crear la lista, el ultimo nodo es null (no hay aun nodos)
	public ListaEnlazadaSimple () {
		this.ultimoNodo = null;
	}

	// getters y setters
	public Nodo getUltimoNodo () {
		return this.ultimoNodo;
	}

	public void setUltimoNodo (Nodo ultimoNodo) {
		this.ultimoNodo = ultimoNodo;
	}

	// METODOS 
	// Nos dice si esta vacia la pila, si no hay nodos
	public boolean estaVacia () {
		return (this.ultimoNodo == null);
	}

	// inserta al final de la pila, encima del todo
	public void insertar (String info) {
		// crear un nuevo nodo con la info pasada
		Nodo nodoNuevo = new Nodo (info);
		// a este nodo le dice que el que estara antes que el es ultimoNodo
		nodoNuevo.setNodoAnterior (this.ultimoNodo);
		// a partir de ahora, el ultimo nodo es el nuevo creado
		ultimoNodo = nodoNuevo;
	}

	// extraer el ultimo nodo de la lista y devolver su informacion
	public String extraer () {
		String resultado = null;
		// si esta vacia devolvera null, simplemente
		if (!estaVacia ()) {
			//cojo la informacion del ultimo nodo
			resultado = this.ultimoNodo.getInformacionDelNodo ();
			//el nuevo ultimoNodo es el nodoAnterior del que era ultimoNodo
			this.ultimoNodo = this.ultimoNodo.getNodoAnterior ();
		}
		// deveulveo el resultado
		return resultado;
	}

	// Inserta un nodo antes del que se le pasa por parámetro
	public void insertar (String info, Nodo predecesor) {
		// creo un nodo nuevo
		Nodo nodoNuevo = new Nodo (info);
		// el anterior a este nodo nuevo es el que era anterior del precedesor
		nodoNuevo.setNodoAnterior (predecesor.getNodoAnterior ());
		// el anterior del predecesor es el nodo nuevo
		predecesor.setNodoAnterior (nodoNuevo);

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
		Nodo unNodo = this.ultimoNodo;
		// recorro, contando nodos, desde el ultimo nodo hasta que ultimoNodo sea null
		while (unNodo != null) {
			cuantos++;
			unNodo = unNodo.getNodoAnterior ();
		}
		return cuantos;
	}

	// Pinta toda la cola desde el ultimo elemento al primero
	@Override
	public String toString () {
		String resultado = "";
		Nodo unNodo = this.ultimoNodo;
		while (unNodo != null) {
			resultado = resultado + unNodo.getInformacionDelNodo ().toString ();
			if (unNodo.getNodoAnterior () != null) {
				resultado = resultado + " -> ";
			}
			unNodo = unNodo.getNodoAnterior ();
		}
		return resultado;
	}

	public void print () {
		System.out.println (this);
	}

	// devuelve un nodo si existe, indicando su informacion
	public Nodo buscarNodo (String info) {
		Nodo nodoFinal = null;
		Nodo nodoActual = this.ultimoNodo;
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
		Nodo nodoActual = this.ultimoNodo;
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
		Nodo primero = this.ultimoNodo;
		while (primero != null && primero.getNodoAnterior () != null) {
			primero = primero.getNodoAnterior ();
		}
		return primero;
	}

	// busca un nodo por su posicion
	public int buscarPosicion (String info) {
		Nodo current = this.ultimoNodo;
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

	// indica cuantas ocurrencias hay de una informacion 
	public int numberOfOccurrences (String info) {
		int counter = 0;
		Nodo current = this.ultimoNodo;
		while (current != null) {
			if (current.getInformacionDelNodo ().equals (info)) {
				counter++;
			}
			current = current.getNodoAnterior ();
		}
		return counter;
	}

}
