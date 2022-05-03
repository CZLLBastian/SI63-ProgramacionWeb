package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Distrito")
public class Distrito {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idDistrito;

	@Column(name = "nomDistrito", nullable = false, length = 47)
	private String nomDistrito;

	public Distrito() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Distrito(int idDistrito, String nomDistrito) {
		super();
		this.idDistrito = idDistrito;
		this.nomDistrito = nomDistrito;
	}

	public int getIdDistrito() {
		return idDistrito;
	}

	public void setIdDistrito(int idDistrito) {
		this.idDistrito = idDistrito;
	}

	public String getNomDistrito() {
		return nomDistrito;
	}

	public void setNomDistrito(String nomDistrito) {
		this.nomDistrito = nomDistrito;
	}

}
