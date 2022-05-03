package pe.edu.upc.daointerfaces;

import java.util.List;

import pe.edu.upc.entities.Room;

public interface IRoomDao {

	public void insertR (Room r);
	
	public List<Room> list();
	
	public void deleteR (int idRoom);
	
	public void updateR (Room r);
	
	public List<Room> findByNameRoom(Room r);
	
}
