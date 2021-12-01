package inicio;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class GestionDBHibernate {

	SessionFactory factory;

	public GestionDBHibernate() {
		factory = new Configuration().configure().buildSessionFactory();
	}

	// ALTA REGISTRO
	public Integer anadirPelicula(tablapeliculas tablapeli) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer pelicontrol = null;
		try {
			tx = session.beginTransaction();

			String pe = (String) session.save(tablapeli);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return pelicontrol;
	}

	// BORRAR REGISTRO
	public boolean bajaPelicula(String titulo) {
		boolean sepudoborrar = false;
		if (!titulo.equals("")) {
			Session session = factory.openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				tablapeliculas peli = (tablapeliculas) session.get(tablapeliculas.class, titulo);
				if (peli != null) {
					session.delete(peli);
					tx.commit();
					sepudoborrar = true;
				}
			} catch (HibernateException e) {
				if (tx != null) tx.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
		return sepudoborrar;
	}

	// LISTADO REGISTRO
	public ArrayList<tablapeliculas> listapelis() {
		List listapelis = null;
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			listapelis = session.createQuery("FROM tablapeliculas").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {

			session.close();

		}
		return (ArrayList<tablapeliculas>) listapelis;
	}

	// RECUPERAR UN REGISTRO
	public tablapeliculas consultaPelicula(String titulo) {
		Session session = factory.openSession();
		Transaction tx = null;
		tablapeliculas peli = null;
		try {
			tx = session.beginTransaction();
			peli = (tablapeliculas) session.get(tablapeliculas.class, titulo);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return peli;
	}

	// ACTUALIZAR UN REGISTRO
	public void actualizaPelicula(tablapeliculas parampeli) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			tablapeliculas peli = (tablapeliculas) session.get(tablapeliculas.class, parampeli.getTitulo());
			peli.setGenero(parampeli.getGenero());
			peli.setDuracion(parampeli.getDuracion());
			peli.setActorprincipal(parampeli.getActorprincipal());
			session.update(peli);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
