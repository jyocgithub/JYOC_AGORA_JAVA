package comparator_comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EjComparable2 {
	public static void main (String[] args) {
		List<Persona2> p = new ArrayList<Persona2> ();
		p.add (new Persona2 ("Luis", "Ruiz"));
		p.add (new Persona2 ("Pablo", "Martinex"));
		p.add (new Persona2 ("Alberto", "Lopez"));
		p.add (new Persona2 ("Cesar", "Perez"));
		Collections.sort (p);
		for (Persona2 persona : p)
			System.out.println (persona);
	}
}

//Ejemplo Comparable
class Persona2 implements Comparable<Persona2> {
	private String	nombre;
	private String	apellido;

	public Persona2 (String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
	}

	@Override
	public int compareTo (Persona2 p) {
		return nombre.compareTo (p.nombre);
	}

	@Override
	public String toString () {
		return (nombre + " " + apellido);
	}

}