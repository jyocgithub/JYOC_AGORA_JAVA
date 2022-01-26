package crud_pelis.inicio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tablapeliculas")
public class Tablapeliculas {

	@Column(name = "titulo")
	String titulo;
	@Column(name = "genero")
	String genero;
	@Column(name = "duracion")
	int duracion;
	@Column(name = "actorprincipal")
	String actorprincipal;

	public Tablapeliculas() {

	}

	public Tablapeliculas(String titulo, String genero, int duracion, String actorprincipal) {
		super();
		this.titulo = titulo;
		this.genero = genero;
		this.duracion = duracion;
		this.actorprincipal = actorprincipal;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getActorprincipal() {
		return actorprincipal;
	}

	public void setActorprincipal(String actorprincipal) {
		this.actorprincipal = actorprincipal;
	}

}
