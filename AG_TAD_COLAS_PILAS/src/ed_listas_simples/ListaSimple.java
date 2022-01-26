package ed_listas_simples;


// actua como una pila, LIFO.
public class ListaSimple {
    private Nodo nodoPrimero;

    ListaSimple() {
        nodoPrimero = null;

    }

    public int tamanoLista() {

        Nodo aux = nodoPrimero;
        int i = 0;
        while (aux != null) {
            aux = aux.nodoSiguiente;
            i++;
        }
        return i;
    }

    public void insertarNodoAlPrincipio(int x) {
        Nodo aux = new Nodo(x);
        if (nodoPrimero == null) {
            nodoPrimero = aux;
        } else {
            aux.nodoSiguiente = nodoPrimero;
            nodoPrimero = aux;
        }
    }

    public void insertarNodoAlFinal(int x) {
        Nodo nuevo = new Nodo(x);
        if (nodoPrimero == null) {
            nodoPrimero = nuevo;
        } else {
            Nodo aux = nodoPrimero;
            for (int i = 1; i < tamanoLista(); i++) {
                aux = aux.nodoSiguiente;
            }
            aux.nodoSiguiente = nuevo;
        }
    }

    public void insertarNodoEnPosicion(int pos, int n) {
        if ((pos > 0) && (pos <= (tamanoLista() + 1))) {
            if (pos == 1) {
                insertarNodoAlPrincipio(n);
            } else {
                if (pos < (tamanoLista() + 1)) {
                    Nodo nuevo = new Nodo(n);
                    Nodo aux = nodoPrimero;
                    for (int i = 2; i < pos; i++) {
                        aux = aux.nodoSiguiente;
                    }
                    nuevo.nodoSiguiente = aux.nodoSiguiente;
                    aux.nodoSiguiente = nuevo;
                }
                if (pos == (tamanoLista() + 1)) {
                    insertarNodoAlFinal(n);
                }
            }
        } else {
        }
    }

    public Nodo buscarNodoPorPosicionn(int pos) {
        if (pos <= 0 || pos > tamanoLista() || nodoPrimero == null) {
            return null;
        }
        Nodo aux = nodoPrimero;
        for (int i = 1; i < pos; i++) {
            aux = aux.nodoSiguiente;
        }
        return aux;
    }


    public void eliminarTodo() {
        nodoPrimero = null;
    }

    public void eliminarPrimerNodo() {
        Nodo prim = nodoPrimero;
        if (nodoPrimero != null) {
            if (nodoPrimero.nodoSiguiente == null)
                nodoPrimero = null;
            else {
                nodoPrimero = prim.nodoSiguiente;
                prim.nodoSiguiente = prim.nodoSiguiente.nodoSiguiente;
            }

            System.out.println("Primero Nodo borrado con exito");
        }
    }

    public void eliminarUltimoNodo() {
        if (nodoPrimero != null) {
            if (nodoPrimero.nodoSiguiente == null)
                nodoPrimero = null;
            else {
                Nodo aux = nodoPrimero;
                while (aux.nodoSiguiente.nodoSiguiente != null)
                    aux = aux.nodoSiguiente;
                aux.nodoSiguiente = null;
            }
        }
    }


    public void eliminarNodoPorPosicion(int pos) {
        Nodo nodoAEliminar = buscarNodoPorPosicionn(pos);
        Nodo nodoPrevioAlQueHayQueEliminar = buscarNodoPorPosicionn(pos - 1);

        // si el nodo no existe
        if (nodoAEliminar == null) {
            System.out.println("Posicion no existente");
            return;
        }
        // si pos es el primer nodo
        if (pos == 1) {
            nodoPrimero = nodoPrimero.nodoSiguiente;
            return;
        }
        // si pos no es el primer nodo
        nodoPrevioAlQueHayQueEliminar.nodoSiguiente = nodoAEliminar.nodoSiguiente;
    }
    public void eliminarNodoPorValor(int valorbuscado) {
        Nodo elim = nodoPrimero;

        if (elim == null)
            System.out.println("Lista Vacia");
        else if (nodoPrimero.valor ==valorbuscado) {
            nodoPrimero = nodoPrimero.nodoSiguiente;
        } else {
            while (((valorbuscado != elim.nodoSiguiente.valor) && (elim != null)))
                elim = elim.nodoSiguiente;
            if (elim.nodoSiguiente != null)
                elim.nodoSiguiente = elim.nodoSiguiente.nodoSiguiente;
            else
                System.out.println("Nodo no Existe");
        }
    }
    public Nodo mostrarUltimoNodo() {
        if (nodoPrimero != null) {
            Nodo aux = nodoPrimero;
            while (aux.nodoSiguiente != null)
                aux = aux.nodoSiguiente;
            return aux;
        }
        return null;
    }

    public Nodo mostrarNodoAnterior(Nodo p) {
        if (nodoPrimero == p)
            return null;
        else {
            Nodo aux = nodoPrimero;
            while (aux.nodoSiguiente != p)
                aux = aux.nodoSiguiente;
            return aux;
        }
    }

//    public void reemplazarNodo(int pos, int n) {
//        int i;
//        if ((pos0)) {
//            Nodo aux = nodoPrimero;
//            for (i = 1; (aux != null) && (i < pos); i++)
//                aux = aux.nodoSiguiente;
//            aux.numero = n;
//        } else
//            System.out.println("[Reemplazar]>Nodo no Existe");
//    }


    public void mostrarLista() {
        Nodo aux = nodoPrimero;
        int i = 1;
        System.out.println("- Lista de nodos -");
        while (aux != null) {
            System.out.println("Nodo Nº " + i + ": " + aux.valor);
            aux = aux.nodoSiguiente;
            i++;
        }
    }

    public void mostrarListaInversa() {
        Nodo mov = nodoPrimero;
        int i, j;
        //La idea fundamental es que siempre se muestre el ultimo Nodo
        //Decrementando el limite en cada ciclo.
        System.out.println("- Lista inversa de nodos -");
        for (i = tamanoLista(); i > 0; i--) {
            for (j = 1; j < i; j++) {
                mov = mov.nodoSiguiente;
            }
            System.out.println("Nodo Nº " + i + ": " + mov.valor);
            mov = nodoPrimero;
        }
    }




//    public void mostrarInvertidoR(Nodo f) {
//        if (f.nodoSiguiente != null) {
//            oAsc(f.nodoSiguiente);
//        }
//        System.out.println(f.valor);
//    }


//    public void insertarNumListaOrd(int n) {    // Considerando que una lista esta ordenada
//        Nodo num = new Nodo(n);                // en forma ASC agregue un Nodo manteniendo el orden
//        Nodo i = nodoPrimero;
//        while ((n > i.valor) && (i.nodoSiguiente != null))
//            i = i.nodoSiguiente;
//        if (n <= nodoPrimero.valor) {
//            num.nodoSiguiente = nodoPrimero;
//            nodoPrimero = num;
//        } else if (n <= i.valor) {
//            num.nodoSiguiente = i;
//            mostrarNodoAnterior(i).nodoSiguiente = num;
//        } else {
//            i.nodoSiguiente = num;
//        }
//
//    }
//
//    public void eliminarNodosR() {    // Eliminar los nodos que tengan numeros repetidos
//        Nodo i, j;
//        for (i = nodoPrimero; i != null; i = i.nodoSiguiente) {
//            for (j = i.nodoSiguiente; j != null; j = j.nodoSiguiente) {
//                if (i.valor == j.valor) {
//                    mostrarNodoAnterior(j).nodoSiguiente = j.nodoSiguiente;
//                }
//            }
//        }
//    }


}
