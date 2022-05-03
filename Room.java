package pe.edu.upc.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Room")
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idRoom;
	
	@Column(name = "descpRoom", nullable = false, length = 100)
	private String descpRoom;
	
	@Column(name = "adress", nullable =false , length = 100)
	private String adress;
	@ManyToOne
	@JoinColumn(name="idArrendador")
	private Arrendador idArrendador;
	@ManyToOne
	@JoinColumn(name="idDistrito")
	private Distrito idDistrito;
	
	
	public Room() {
		super();
	}


	public Room(int idRoom, String descpRoom, String adress, Arrendador idArrendador, Distrito idDistrito) {
		super();
		this.idRoom = idRoom;
		this.descpRoom = descpRoom;
		this.adress = adress;
		this.idArrendador = idArrendador;
		this.idDistrito = idDistrito;
	}


	public int getIdRoom() {
		return idRoom;
	}


	public void setIdRoom(int idRoom) {
		this.idRoom = idRoom;
	}


	public String getDescpRoom() {
		return descpRoom;
	}


	public void setDescpRoom(String descpRoom) {
		this.descpRoom = descpRoom;
	}


	public String getAdress() {
		return adress;
	}


	public void setAdress(String adress) {
		this.adress = adress;
	}


	public Arrendador getIdArrendador() {
		return idArrendador;
	}


	public void setIdArrendador(Arrendador idArrendador) {
		this.idArrendador = idArrendador;
	}


	public Distrito getIdDistrito() {
		return idDistrito;
	}


	public void setIdDistrito(Distrito idDistrito) {
		this.idDistrito = idDistrito;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idArrendador, idDistrito, idRoom);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		return Objects.equals(idArrendador, other.idArrendador) && Objects.equals(idDistrito, other.idDistrito)
				&& idRoom == other.idRoom;
	}

		
	
}
