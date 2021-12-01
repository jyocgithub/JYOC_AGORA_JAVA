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
@Table(name = "PERSONA")  
public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_PERSONA") 
	private int id_persona; 
	
	@Column(name = "DNI") 
	private String dni; 

	@Column(name = "NOMBRE")
	private String nombre;

//	@ManyToMany(cascade = { CascadeType.ALL }, mappedBy = "listapersonas")
	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinTable(name = "VIVIENDA_PERSONA", joinColumns = { @JoinColumn(name = "ID_PERSONA") }, inverseJoinColumns = { @JoinColumn(name = "ID_VIVIENDA") })
	private Set<Vivienda> listaviviendas = new HashSet<Vivienda>();

	
	
	// El constructor no lleva la lista de Viviendas, eso lo deberia gestionar Hibernate
	public Persona(int id_persona, String dni, String nombre) {
		super();
		this.id_persona = id_persona;
		this.dni = dni;
		this.nombre = nombre;
	}

	public Persona() {

	}

	public int getId_persona() {
		return id_persona;
	}

	public void setId_persona(int id_persona) {
		this.id_persona = id_persona;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Vivienda> getListaviviendas() {
		return listaviviendas;
	}

	public void setListaviviendas(Set<Vivienda> listaviviendas) {
		this.listaviviendas = listaviviendas;
	}



	

}
