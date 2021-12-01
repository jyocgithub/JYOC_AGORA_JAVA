package hibernate_1_1_noincrement_biidir_primarykeyjoin.pojos;

import javax.persistence.*;
import hibernate_1_1_noincrement_biidir_primarykeyjoin.pojos.*;

@Entity(name = "VIVIENDA")
@Table(name = "VIVIENDA")
public class Vivienda {
	@Id
	@Column(name = "ID_VIVIENDA")
	private int id_vivienda;

	@Column(name = "TIPO")
	private String tipo;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
	private Direccion direccion;

	public Vivienda() {

	}

	public Vivienda(int id_vivienda, String tipo, Direccion direccion) {
		super();
		this.id_vivienda = id_vivienda;
		this.tipo = tipo;
		this.direccion = direccion;
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

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion ubicacion) {
		this.direccion = ubicacion;
	}

}