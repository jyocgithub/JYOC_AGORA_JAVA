package comparator_comparable;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

//// Clase Persona
//class Persona implements Comparable<Persona> {
//	String	nombre;
//	int		edad;
//
//	public Persona (String n, int e) {
//		this.nombre = n;
//		this.edad = e;
//	}
//
////	@Override
////	// metodo compareTo sencillo
////	public int compareTo (Persona p) {			
////		return nombre.compareTo (p.nombre);
////	}
//	@Override
//	// metodo compareTo sencillo
//	public int compareTo (Persona p) {
//		return nombre.compareTo (p.nombre);
//	}
//}


public class EjComparable {
	public static void main (String[] args) {


		System.out.println ("-------------- con un HashSet");
		// no hace falta usar Collections.sort()
		// ya un treeset esta autoordenado
		Set<String> p3 = new HashSet<> ();
		p3.add ("Luis");
		p3.add ("Pablo");
		p3.add ("Alberto");
		for (String nombre : p3)
			System.out.println (nombre);

		System.out.println ("-------------- con un TreeSet");
		// no hace falta usar Collections.sort()
		// ya un treeset esta autoordenado
		Set<String> p35 = new TreeSet<> ();
		p35.add ("Luis");
		p35.add ("Pablo");
		p35.add ("Alberto");
		for (String nombre : p35)
			System.out.println (nombre);



	}
}

//// Clase Persona
//class Persona implements Comparable<Persona> {
//	String	nombre;
//	int		edad;
//
//	public Persona (String n, int e) {
//		this.nombre = n;
//		this.edad = e;
//	}
//
//	@Override
//	public int compareTo (Persona p) {			// metodo compareTo sencillo
//		return nombre.compareTo (p.nombre);
//	}
//}