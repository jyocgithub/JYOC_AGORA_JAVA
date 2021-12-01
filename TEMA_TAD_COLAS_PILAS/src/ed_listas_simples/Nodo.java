package ed_listas_simples;

public class Nodo{
	int valor;
	Nodo nodoSiguiente;
	Nodo(int x){
		valor = x;
		nodoSiguiente = null;
	}

	@Override
	public String toString() {
		return "Nodo{" +
				"numero=" + valor +
				", nodoSiguiente=" + nodoSiguiente +
				'}';
	}
}