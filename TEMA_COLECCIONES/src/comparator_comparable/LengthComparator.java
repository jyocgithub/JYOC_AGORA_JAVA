package comparator_comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Ejemplo Comparator
public class LengthComparator implements Comparator<Persona> {

	@Override
	public int compare (Persona p1, Persona p2) {
		if (p1.toString ().length () < p2.toString ().length ()) return 1;
		else if (p1.toString ().length () > p2.toString ().length ()) return -1;
		else return 0;
	}

	public static void main (String[] args) {
		List<Persona> p = new ArrayList<Persona> ();
		p.add (new Persona ("Ana", "Rodes"));
		p.add (new Persona ("Hector", "Lopez"));
		p.add (new Persona ("Ana", "Buigues"));
		p.add (new Persona ("Carlitos", "Perez"));
		Collections.sort (p, new LengthComparator ());
		for (Persona person : p)
			System.out.println (person);
	}
}



class Persona {
	private String	nombre;
	private String	apellido;

	public Persona (String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
	}


	@Override
	public String toString () {
		return (nombre + " " + apellido);
	}

}