package controlador;

import java.util.ArrayList;
import pojos.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import daos.ViviendaDAO;

public class Inicio {

	public static void main(String[] args) {

		// con estas lineas se puede ver en el log las consultas SQL que ejecuta Hibernate
		Logger log = Logger.getLogger("org.hibernate");
		log.setLevel(Level.SEVERE);

		ViviendaDAO viviendadao = new ViviendaDAO();

		// BORRAMOS TODOS LOS REGISRTOS PREVIOS PARA PARTIR DE CERO
		System.out.println("Borrados :" + viviendadao.borrarTodo("Vivienda"));
		System.out.println("Borrados :" + viviendadao.borrarTodo("Persona"));

		// CREAMOS UN PAR DE EJEMPLOS 
		Vivienda v1 = null, v2 = null, v3 = null;
		Persona p1=null, p2=null, p3=null;
		v1 = new Vivienda(11, "CHALET");
		v2 = new Vivienda(22, "PISO");
		v3 = new Vivienda(33, "FINCA");
		
		p1 = new Persona(1,"1111111K","Ana");
		p2 = new Persona(2,"2222222P","Eva");
		p3 = new Persona(3,"3333333U","Carmen");
		
//		p1.getListaviviendas().add(v1);
//		p1.getListaviviendas().add(v2);
//		p2.getListaviviendas().add(v1);
//		p2.getListaviviendas().add(v3);
		
		v1.getListaPersonas().add(p1);
		v1.getListaPersonas().add(p2);
		v2.getListaPersonas().add(p1);
		v2.getListaPersonas().add(p3);
		
		
		//
		//			// // --------- ALTA ------------
		//
		if (viviendadao.anadirVivienda(v1)) {
			System.out.println("--- ALTA CORRECTA");
		}
		if (viviendadao.anadirVivienda(v2)) {
			System.out.println("--- ALTA CORRECTA");
		}
		if (viviendadao.anadirVivienda(v3)) {
			System.out.println("--- ALTA CORRECTA");
		}
		//
		//			// --------- BAJA ------------
		//			// CUIDADO QUE EL ELEMENTO A BORRAR NO PUEDE BORRAR EN CASCADA EL OBJETO REFERENCIADO
		//			// SI EL OBJETO ESTA REFERENCIADO CON ALGUNA OTRO REGISTRO
		//			// EN ESTE CASO NO SE PUEDE BORRAR LA VIVIENDA 121 Y CON ELLA SU DIRECCION, DIGAMOS LA 144
		//			// SI LA DIRECCION 144 ESTA ASOCIADA A ALGUNA OTRA VIVIENDA
		//			// ADEMAS, SE INTENTA BORRAR EL ELEMENTO v1 QUE HA DE TENER ASOCIADA LA DIRECCION CORRECTA, LA 144
		if (viviendadao.borrarVivienda(22)) {
			System.out.println("--- BAJA CORRECTA");
		}
		//
		//			// --------- LISTADO ------------
		System.out.println("--- LISTADO");
		ArrayList<Vivienda> lista = viviendadao.listarViviendas();
		for (Vivienda v : lista) {
			System.out.println(v);
		}
		//
		//			// --------- CONSULTA ------------
		System.out.println("--- CONSULTA");
		Vivienda v = viviendadao.consultarVivienda(11);
		if (v != null) {
			System.out.println(v.getId_vivienda() + " ----- " + v.getTipo());
		}
		//
		//			// // --------- ACTUALIZAR ------------

//		v1.setTipo("CHALET DE LUJO ABSOLUTO");
//		v1.getListaPersonas().add(p3);
//		if (viviendadao.actualizarVivienda(v1)) {
//			System.out.println("--- MODIFICACION CORRECTA");
//		}

	}

}