package colas_dinamicas;

/**
 * COLA DINAMICA
 * Una cola dinámica, al contrario que una estática, no se
 * almacena en una coleccion de elementos, si no que simplemente es un grupo de
 * elementos (que llamaremos nodos).
 * Se sabe qué elemento es el primero de la cola, y cada elemento sabra quien
 * es el elemento que esta "detras" de el en la cola.
 *
 * La informacion que necesitamos es :
 * (A) saber que nodo es el que esta el primero de la cola.
 * (B) saber de cada nodo que otro nodo tiene detras.
 *
 * Para trabajar con colas dinamicas tenemos que usar:
 * (1) una clase Nodo, que tiene la informacion a guardar y la referencia del
 * nodo que esta debajo, y
 * (2) una clase ColaDinamica, que contiene los metodos y atributos para
 * crear una cola de nodos
 *
 * En el nodo almacenamos alguna informacion, de la que no definimos
 * el tipo, por lo que hacemos la clase generica, que tenga el patron T que
 * sustituiremos en el futuro al crear la clase.
 */
public class ColaDinamica<T> {

    /**
     * Atributo primerNodo. es el nodo que esta el primero de la cola
     */
    private Nodo primerNodo;

    /**
     * Constructor que crea la cola, y como no hay aun nodos, el primerNodo lo
     * pone como null. Este nodo null sera el "primero" de la cola, y
     * existira como la "cabeza" de la cola, aunque no tendra informacion, ni se
     * extraera nunca
     */
    public ColaDinamica() {
        primerNodo = null;
    }

    /**
     * cuantosElementosHay() Metodo que devuelve el numero de elementos que
     * tiene la cola
     * Para ello, parte del primerNodo, y mira si tiene algun nodo
     * detras, y si lo tiene, mira si este tiene tambien a su vez un anterior,
     * y si lo hay, si hay otro anterior, y asi sucesivamente, y contando cada
     * nodo para saber cuantos hay
     */
    public int cuantosElementosHay() {

        int res = 0;
        Nodo aux = primerNodo;

        while (aux != null) {
            aux = aux.anterior;
            res++;
        }
        return res;
    }

    /**
     * esvacia() Metodo que indica si la cola esta vacia, lo que obtiene
     * preguntando si el primerNodo es null
     */
    public boolean esVacia() {
        return primerNodo == null;
    }

    /**
     * extraer() Metodo que devuelve el primer nodo de la cola, y lo elimina
     * de esta
     */
    public Nodo extraer() {
        // guardamos cual es el primer nodo, que es el siguiente a la "base"
        Nodo elPrimero = primerNodo.anterior;
        // indicamos que ahora el primer nodo es el anterior al que era 
        // anterior al primer nodo
        primerNodo = primerNodo.anterior;
        // devolvemos el que guardamos que era el primer nodo
        return elPrimero;

    }

    public void insertar(T elem) {
        if (primerNodo == null) {
            primerNodo = new Nodo(elem, null);
        } else {
            // creamos un nuevo nodo con la informacion que se pasa al metodo
            // que sera el que se vaya a añadir a la cola
            Nodo nuevoNodo = new Nodo(elem, null);
            // cogemos el primer nodo y lo guardamos en un nodo que llamamos
            // "analizar" preccisamente para analizarlo despues
            Nodo analizar = primerNodo;
            // vamos viendo si este nodo "analizar" tiene algun nodo antes en 
            // la cola, y si lo tiene, analizar pasa a ser ese nodo anterior 
            while (analizar.anterior != null) {
                analizar = analizar.anterior;
            }
            // cuando el nodo analizar ya no tiene nadie detras, entonces le 
            // decimos a ese nodo que el que tiene detras ahroa es el nuevo 
            // nodo que queremos añadir
            analizar.anterior = nuevoNodo;
        }

    }
    /**
     * vaciar() Metodo que vacia una cola. Para ello, simplemente indica que el
     * primerNoxdo nuevamente sea null. Los nodos existentes no se eliminan de
     * memoria, pero la cola no puede volver a recuperarlos, por lo que es como
     * si no existieran
     */
    public void vaciar() {
        primerNodo = null;
    }

}
