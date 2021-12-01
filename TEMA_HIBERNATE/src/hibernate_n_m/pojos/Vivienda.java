package pojos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "VIVIENDA")
public class Vivienda implements Serializable {

	private static final long serialVersionUID = 424111L;

	@Id
	@Column(name = "ID_VIVIENDA")
	private int id_vivienda;

	@Column(name = "TIPO")
	private String tipo;

	@ManyToMany(cascade = { CascadeType.ALL },fetch = FetchType.EAGER)
	@JoinTable(name = "VIVIENDA_PERSONA", joinColumns = { @JoinColumn(name = "ID_VIVIENDA") }, inverseJoinColumns = { @JoinColumn(name = "ID_PERSONA") })
	private Set<Persona> listaPersonas = new HashSet<Persona>();
	
	
   // El constructor no lleva la lista de Personas, eso lo deberia gestionar Hibernate
	public Vivienda(int id_vivienda, String tipo ){
		super();
		this.id_vivienda = id_vivienda;
		this.tipo = tipo;
	}

	public Vivienda() {
	}

	public int getId_vivienda() {
		return id_vivienda;
	}

	public void setId_vivienda(int id_vivienda) {
		this.id_vivienda = id_vivienda;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Set<Persona> getListaPersonas() {
		return listaPersonas;
	}

	public void setListaPersonas(Set<Persona> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}

	@Override
	public String toString() {
		return "Vivienda [id_vivienda=" + id_vivienda + ", tipo=" + tipo + ", listaPersonas=" + listaPersonas + "]";
	}

	
	
	
	
}
