package comparator_comparable;

import java.util.Map;
import java.util.TreeMap;

public class EjComparable3 {
	public static void main (String[] args) {

		Map<Hombre, String> p = new TreeMap<Hombre, String> ();
		p.put (new Hombre ("Luis", "Ruiz"), "Ruiz");
		p.put (new Hombre ("Pablo", "Martinez"), "Martinez");
		p.put (new Hombre ("Alberto", "Lopez"), "Lopez");
		p.put (new Hombre ("Cesar", "Perez"), "Perez");
		for (Hombre h : p.keySet ())
			System.out.println (h.apellido);






	}
}

//Ejemplo Comparable
class Hombre implements Comparable<Hombre> {
	public String	nombre;
	public String	apellido;

	public Hombre (String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
	}

	@Override
	public int compareTo (Hombre p) {
		return nombre.compareTo (p.nombre);
	}

	@Override
	public String toString () {
		return (nombre + " " + apellido);
	}

}