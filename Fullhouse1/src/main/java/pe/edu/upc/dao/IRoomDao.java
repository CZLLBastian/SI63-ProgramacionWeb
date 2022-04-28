package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entidades.Room;

public interface IRoomDao {

	public void insert (Room r);
	
	public List<Room> list();
	
	public void delete (int idRoom);
	
}
