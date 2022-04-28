package pe.edu.upc.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Room")
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idRoom;
	
	@Column(name = "descpRoom", nullable = false, length = 100)
	private String descpRoom;
	
	@Column(name = "adress", nullable =false , length = 40)
	private String adress;
		
	public Room() {
		super();
	}

	public Room(int idRoom, String descpRoom, String adress) {
		super();
		this.idRoom = idRoom;
		this.descpRoom = descpRoom;
		this.adress = adress;
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
	
	
	
}
