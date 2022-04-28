package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="arrend")
public class Arrendador {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idArrendador;
	
	@Column(name ="nomArrendador", nullable= false,length=47)
	private String nomArrendador;
	
	@Column(name = "dniArrendador", nullable = false, length = 46)
	private int dniArrendador;
	
	@Column(name = "edadArrendador", nullable = false, length = 45)
	private int edadArrendador;
	
	@Column(name = "celArrendador", nullable = false, length = 44)
	private int celArrendador;
	
	@Column(name = "emailArrendador", nullable = false, length = 43)
	private String emailArrendador;
	
	@Column(name = "username", nullable = false, length = 42)
	private String username;
	
	@Column(name = "password", nullable = false, length = 42)
	private String password;

	
	public Arrendador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Arrendador(int idArrendador, String nomArrendador, int dniArrendador, int edadArrendador, int celArrendador,
			String emailArrendador, String username, String password) {
		super();
		this.idArrendador = idArrendador;
		this.nomArrendador = nomArrendador;
		this.dniArrendador = dniArrendador;
		this.edadArrendador = edadArrendador;
		this.celArrendador = celArrendador;
		this.emailArrendador = emailArrendador;
		this.username = username;
		this.password = password;
	}

	public int getIdArrendador() {
		return idArrendador;
	}

	public void setIdArrendador(int idArrendador) {
		this.idArrendador = idArrendador;
	}

	public String getNomArrendador() {
		return nomArrendador;
	}

	public void setNomArrendador(String nomArrendador) {
		this.nomArrendador = nomArrendador;
	}

	public int getDniArrendador() {
		return dniArrendador;
	}

	public void setDniArrendador(int dniArrendador) {
		this.dniArrendador = dniArrendador;
	}

	public int getEdadArrendador() {
		return edadArrendador;
	}

	public void setEdadArrendador(int edadArrendador) {
		this.edadArrendador = edadArrendador;
	}

	public int getCelArrendador() {
		return celArrendador;
	}

	public void setCelArrendador(int celArrendador) {
		this.celArrendador = celArrendador;
	}

	public String getEmailArrendador() {
		return emailArrendador;
	}

	public void setEmailArrendador(String emailArrendador) {
		this.emailArrendador = emailArrendador;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
