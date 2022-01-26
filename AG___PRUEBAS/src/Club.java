/*7.b.7. Ejercicio ClubSocios. Definir una clase Club y otra clase Socio. La clase Socio debe tener los siguientes
atributos privados: nombre y antig�edad en el club (en a�os). La clase Club debe tener como
atributos 3 objetos de la clase Socio. Definir en ella un m�todo para imprimir el nombre del socio con
mayor antig�edad en el club. Crear una clase Prueba, instancias un Club, a�adir socios y probar los
m�todos creados.
JYOC - JAVA - EJERCICIOS 45
MEJORA 1: Hacer un constructor copia (que valga para crear un ClubSocios recibiendo como
par�metro otro ClubSocios) y un m�todo ClubSocios copiar(), que devuelve un duplicado del
ClubSocios actual. Ambas son duplicados, no copias, esto es, las copias han de ser "profundas" (deep
copy)*/

import java.util.Scanner;

public class Club {
	private Scanner teclado;
	private Socio socio1;
	private Socio socio2;
	private Socio socio3;

	public Club(Socio socio1, Socio socio2, Socio socio3) {

		this.socio1 = new Socio(socio1.getNombre(), socio1.getAntiguedad());

		this.socio2 = new Socio(socio1.getNombre(), socio1.getAntiguedad());

		this.socio3 = new Socio(socio1.getNombre(), socio1.getAntiguedad());
	}

	public Club() {
		socio1 = new Socio();
		socio2 = new Socio();
		socio3 = new Socio();
	}

		public Socio SocioMayorAntiguedad() {
		Socio masAntiguo = new Socio();
		if (socio1.getAntiguedad() > socio2.getAntiguedad() && socio1.getAntiguedad() > socio3.getAntiguedad()) {
			masAntiguo.setNombre(socio1.getNombre());
			masAntiguo.setAntiguedad(socio1.getAntiguedad());
		}  if (socio2.getAntiguedad() > socio1.getAntiguedad() && socio2.getAntiguedad() > socio3.getAntiguedad()) {
			masAntiguo.setNombre(socio2.getNombre());
			masAntiguo.setAntiguedad(socio2.getAntiguedad());
		}  if (socio3.getAntiguedad() > socio1.getAntiguedad() && socio3.getAntiguedad() > socio2.getAntiguedad()) {
			masAntiguo.setAntiguedad(socio1.getAntiguedad());
			masAntiguo.setAntiguedad(socio3.getAntiguedad());
		}
		return masAntiguo;
	}

	public Socio getSocio1() {
		return socio1;
	}

	public void setSocio1(Socio socio1) {
		this.socio1 = socio1;
	}

	public Socio getSocio2() {
		return socio2;
	}

	public void setSocio2(Socio socio2) {
		this.socio2 = socio2;
	}

	public Socio getSocio3() {
		return socio3;
	}

	public void setSocio3(Socio socio3) {
		this.socio3 = socio3;
	}

	@Override
	public String toString() {
		return "Club [socio1=" + socio1 + ", socio2=" + socio2 + ", socio3=" + socio3 + "]";
	}

}
