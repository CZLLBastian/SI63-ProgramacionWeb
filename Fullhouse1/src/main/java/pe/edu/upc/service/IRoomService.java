package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entidades.Room;

public interface IRoomService {

public void insert (Room r);
	
	public List<Room> list();
	
	public void delete (int idRoom);
}
