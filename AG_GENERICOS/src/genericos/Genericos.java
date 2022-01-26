package genericos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.JButton;

//// MODO CLASICO DE INVOCAR UN METODO DE UNA INTERFAZ
//class MathOperationImpl implements IMathOperation {
//	public int operacion(int a, int b) {
//		return a + b;
//	}
//}
//
//class ProbarMathOperationImpl {
//	public static void main(String args[]) {
//		MathOperationImpl objetoMathImpl = new MathOperationImpl();
//		System.out.println(objetoMathImpl.operacion(3, 12));
//	}
//}

class ProbarLambdaListenerTradicional {

	public static void main(String args[]) {
		JButton button = new JButton("Pusar aqui");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				System.out.println("ha pulsado el boton!");
			}

		});
	}
}

class ProbarLambdaListener {

	public static void main(String args[]) {

		JButton button = new JButton("Pusar aqui");

		// Implementacion de escuchador CON clase anonima
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				System.out.println("ha pulsado el boton!");
			}

		});

		// Como ActionListener es una interface que tiene solo un metodo, actionPerformed(),
		// es una interface funcional, asi que des idonea para usar una expresion Lambda
		button.addActionListener(e -> System.out.println("ha pulsado el boton!"));

	}
}

// class miActionListener implements ActionListener {
// public void actionPerformed(ActionEvent evt) {
// System.out.println("ha pulsado el boton!");
// }
// }
//
// class ProbarListenerSinAnonima {
// public static void main(String args[]) {
// JButton button = new JButton("Pusar aqui");
//
// // Implementacion de escuchador SIN clase anonima
// button.addActionListener(new miActionListener());
// }
// }

// UNA INTERFAZ NORMAL CON SOLO UN METODO
interface IMathOperation {
	public int operacion(int a, int b);
}

class ProbarLambdaDirecto {

	public static void main(String args[]) {
		// Creamos un objeto de la interfaz, que desarrolla realmente el metodo de la interfaz
		IMathOperation sumar = (int a, int b) -> a + b;
		// Con ese objeto "interfaz-metodo", llamamos al metodo original con los atributos
		int s = sumar.operacion(2, 4);

		// Con polimorfismo se puede ver mejor la utilidad
		// Creamos un objeto de la interfaz, que desarrolla realmente el metodo de la interfaz
		IMathOperation multiplicar = (int a, int b) -> a * b;
		IMathOperation restar = (int a, int b) -> a - b;

		int res1 = llamarAOperacion(3, 4, multiplicar);
		int res2 = llamarAOperacion(3, 4, restar);

		System.out.println(res1);
		System.out.println(res2);

	}

	public static int llamarAOperacion(int a, int b, IMathOperation objMath) {
		return objMath.operacion(a, b);
	}
}

public class Genericos {

	public static void main(String[] args) {

		String[] h = "Linea a trocear".split("");
		for (String c : h) {
			System.out.println(">" + c + "<");
		}

		// int[] x = {4, 67, 23, 4, 3, 5, 3, 5, 54};
		// Arrays.sort(x);
		//
		//
		// ArrayList<Persona> ss = new ArrayList<>();
		// ss.add(new Persona("Pepe", 34));
		// ss.add(new Persona("Luis", 12));
		// ss.add(new Persona("Ana", 31));
		// ss.add(new Persona("Ricardo", 65));
		// ss.add(new Persona("Carmen", 3));
		//
		// for(Persona pp : ss){
		// if(pp.nombre.startsWith("R")){
		// ss.remove(pp);
		// }
		// }
		//
		//
		// Iterator<Persona> ttt = ss.iterator();
		//
		// while(ttt.hasNext()){
		// Persona pp = ttt.next();
		// if(pp.nombre.startsWith("R")){
		// ttt.remove();
		// }
		// }
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		// ss.sort(new modeloComparadorNonbre());
		//
		// for (Persona p : ss) {
		// System.out.println(p.nombre + " " + p.edad);
		// }
		//
		//
		// ss.sort(new modeloComparadorEdad());
		//
		// for (Persona p : ss) {
		// System.out.println(p.nombre + " " + p.edad);
		// }
		//
		//
		//
		//
		//
		// for(int f=0; f<10;f++){
		// for(int c=0; c<f+1;c++){
		// System.out.print("+");
		// }
		// System.out.println("");
		// }
		//
		// String xx = "*************************";
		// int c;
		// for( c=0; c<10;c++){
		// System.out.println(xx.substring(0,c+1));
		// }
		// for(int r=c; r>0;r--){
		// System.out.println(xx.substring(0,r+1));
		// }

		//
		//
		//
		// Cajon c = new Cajon(3);
		// ArrayList<String> ss = new ArrayList();
		// ss.add("jhg∆∆∆kjhgjkhgk gkhjg");
		// ss.add("kjhgjkhg");
		// ss.add("fs");
		// ss.add("jhg∆∆∆kjhgjkhgk gkhjg");
		// ss.add("jhg∆∆∆kjhgjkhgk gkhjg");
		//
		//// for(String a : ss){
		//// if(a.startsWith("j")){
		//// ss.remove(a);
		//// }
		//// }
		//
		//
		// Iterator<String> it = ss.iterator();
		//
		// while (it.hasNext()) {
		// String a = it.next();
		// if (a.startsWith("j")) {
		// it.remove();
		// }
		// }
		//
		//
		//
		// Cajon<Vehiculo> ccc = new Cajon<>(2);
		// Vehiculo v = new Moto(123);
		// ccc.setValor(v);
		// ArrayList<Integer> i = new ArrayList<>();
		//
		// ccc.setValor(v);
		//
		// Cajon<Integer> bbb = new Cajon<>(3);
		// bbb.setValor(234432);
	}

	public void lista(ArrayList<String> lista) {
		for (String o : lista) {
			System.out.println(o);
		}

	}

}

class Cajon<T> {

	public T valor;
	public int id;

	public Cajon(int id) {
		this.id = id;
	}

	public void setValor(T vv) {
		this.valor = vv;
	}

	public T getValor() {
		return valor;
	}

	public void concate(T wwww) {
		if (wwww instanceof String) {

		}
	}

}

// *********************************************************
abstract class Vehiculo {

	int precio;

	public Vehiculo(int precio) {
		super();
		this.precio = precio;
	}

	public double calcularDto(int porcentaje) {
		return precio / 100 * porcentaje;
	}

	abstract public void mostrar();

}
// *********************************************************

class Coche extends Vehiculo implements ICoches {

	int puertas;
	String matricula;

	public Coche(int precio, int puertas, String matricula) {
		super(precio);
		this.puertas = puertas;
		this.matricula = matricula;
	}

	@Override
	public double calcularDto(int porcentaje) {
		if (puertas == 5) {
			return 1000;
		}
		return precio / 100 * porcentaje + 1000;
	}

	@Override
	public void mostrar() {
		System.out.println("El coche tiene " + puertas + " puertas");

	}

	@Override
	public void pagarITV() {
		System.out.println("he pagado");

	}
}

// *********************************************************
class Moto extends Vehiculo {

	public Moto(int precio) {
		super(precio);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mostrar() {
		System.out.println("Soy una motoooooo");
	}
}
// *********************************************************

interface ICoches {

	void pagarITV();
}

// class Persona implements Comparable<Persona> {
//
// String nombre;
// int edad;
//
// public Persona(String n, int e) {
// this.nombre = n;
// this.edad = e;
// }
//
// @Override
// // metodo compareTo sencillo
// public int compareTo(Persona p) {
// return nombre.length()-p.nombre.length();
//// return edad.compareTo(p.edad);
//// return nombre.compareTo(p.nombre);
// }
//
//
class Persona {

	String nombre;
	int edad;

	public Persona(String n, int e) {
		this.nombre = n;
		this.edad = e;
	}

}

class modeloComparadorNonbre implements Comparator<Persona> {
	@Override
	public int compare(Persona p1, Persona p2) {
		return (p1.nombre.compareTo(p2.nombre));

	}
}

class modeloComparadorEdad implements Comparator<Persona> {
	@Override
	public int compare(Persona p1, Persona p2) {
		return (p1.edad - p2.edad);

	}
}