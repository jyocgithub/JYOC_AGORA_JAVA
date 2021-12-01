package ed_pilas;

public class Nodo {
    private String	informacionDelNodo;
    private Nodo	nodoAnterior;

    public Nodo (String info, Nodo next) {
        this.informacionDelNodo = info;
        this.nodoAnterior = next;
    }
    public Nodo (String info) {
        this (info, null);
    }

    public String getInformacionDelNodo () {
        return this.informacionDelNodo;
    }
    public Nodo getNodoAnterior () {
        return this.nodoAnterior;
    }
    public void setInformacionDelNodo (String info) {
        this.informacionDelNodo = info;
    }
    public void setNodoAnterior (Nodo next) {
        this.nodoAnterior = next;
    }
    public String toString () {
        if (informacionDelNodo != null) {
            return informacionDelNodo.toString ();
        }
        else {
            return null;
        }
    }
}