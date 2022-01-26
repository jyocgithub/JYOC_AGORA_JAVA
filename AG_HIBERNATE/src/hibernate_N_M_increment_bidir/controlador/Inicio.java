package hibernate_N_M_increment_bidir.controlador;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import hibernate_N_M_increment_bidir.pojos.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import hibernate_N_M_increment_bidir.daos.*;

public class Inicio {

	public static void main(String[] args) {
		// Para ver en el log las consultas SQL que ejecuta Hibernate
//		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);

		ViviendaDAO dao = new ViviendaDAO();

		// BORRAMOS TODOS LOS REGISRTOS PREVIOS PARA PARTIR DE CERO
		System.out.println("Borrados :" + dao.borrarTodo("VIVIENDA"));
		System.out.println("Borrados :" + dao.borrarTodo("PERSONA"));

		// CREAMOS EJEMPLOS
		Persona p1 = new Persona("111111A", "Ana");
		Persona p2 = new Persona("222222b", "Eva");
		Persona p3 = new Persona("333333n", "Marta");
		Persona p4 = new Persona("444444n", "Maria");
		Persona p5 = new Persona("555555k", "Pepa");
		Persona p6 = new Persona("666666l", "Isabel");

		Vivienda v1 = new Vivienda("Piso");
		Vivienda v2 = new Vivienda("Atico");
		Vivienda v3 = new Vivienda("Entresuelo");

		v1.agregarPersona(p1);
		v1.agregarPersona(p2);
		v1.agregarPersona(p3);
		v2.agregarPersona(p1);
		v2.agregarPersona(p2);
		// no hace fala hacerlo todo en las dos direcciones pues cada metodo hace lo suyo 
		// ambos permiten actualizar en ambas direcciones 
		p4.agregarVivienda(v3);
		p5.agregarVivienda(v3);
		p6.agregarVivienda(v3);

		// --------- ALTA ------------
		if (dao.anadirVivienda(v1))
			System.out.println("--- ALTA CORRECTA");
		if (dao.anadirVivienda(v2))
			System.out.println("--- ALTA CORRECTA");
		if (dao.anadirVivienda(v3))
			System.out.println("--- ALTA CORRECTA");

		// --------- LISTADO ------------
		System.out.println("--- LISTADO");
		ArrayList<Vivienda> lista = dao.listarViviendas();
		for (Vivienda v : lista) {
			System.out.println(v);
		}

		// --------- ACTUALIZAR ------------
		v1.setTipo("PISO DE LUJO");
		v1.quitarPersona(p1);
		v1.agregarPersona(p6);
		if (dao.actualizarVivienda(v1))
			System.out.println("--- MODIFICACION CORRECTA");

		// --------- CONSULTA ------------
		System.out.println("--- CONSULTA");
		Vivienda v = dao.consultarVivienda(lista.get(0).getId_vivienda());
		if (v != null)
			System.out.println(v);

		// --------- BAJA ------------
		if (dao.borrarVivienda(lista.get(2).getId_vivienda()))
			System.out.println("--- BAJA CORRECTA");

	}

}