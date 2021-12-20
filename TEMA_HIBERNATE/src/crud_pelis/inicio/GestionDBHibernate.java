package crud_pelis.inicio;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class GestionDBHibernate {

	SessionFactory factory;

	public GestionDBHibernate() {
		factory = new Configuration().configure().buildSessionFactory();
	}

	// ALTA REGISTRO
	public Integer anadirPelicula(Tablapeliculas tablapeli) {
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
				// normalmente buscamos la pelicula a borrar antes, por si no existe
				Tablapeliculas peli = (Tablapeliculas) session.get(Tablapeliculas.class, titulo);
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

	// LISTADO REGISTROs
	public ArrayList<Tablapeliculas> listapelis() {
		List listapelis = null;
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			listapelis = session.createQuery("FROM crud_pelis.inicio.Tablapeliculas").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {

			session.close();

		}
		return (ArrayList<Tablapeliculas>) listapelis;
	}

	// LISTADO REGISTROS CON CONDICION Y PARAMETROS PREPARADOS
	public ArrayList<Tablapeliculas> listaPelisDeDuracionMinima(int minimaDuracion) {
		List listapelis = null;
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String sql = "FROM  crud_pelis.inicio.Tablapeliculas  where duracion > :duracionminima";
			Query query = session.createQuery(sql);
			query.setParameter("duracionminima", minimaDuracion);
			listapelis = (ArrayList<String>) query.list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {

			session.close();

		}
		return (ArrayList<Tablapeliculas>) listapelis;
	}

	// RECUPERAR UN REGISTRO
	public Tablapeliculas consultaPelicula(String titulo) {
		Session session = factory.openSession();
		Transaction tx = null;
		Tablapeliculas peli = null;
		try {
			tx = session.beginTransaction();
			peli = (Tablapeliculas) session.get(Tablapeliculas.class, titulo);
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
	public void actualizaPelicula(Tablapeliculas parampeli) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Tablapeliculas peli = (Tablapeliculas) session.get(Tablapeliculas.class, parampeli.getTitulo());
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

	// ACTUALIZAR UN REGISTRO ve3sion 2
	public void actualizaPeliculaV2(Tablapeliculas parampeli) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(parampeli);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
