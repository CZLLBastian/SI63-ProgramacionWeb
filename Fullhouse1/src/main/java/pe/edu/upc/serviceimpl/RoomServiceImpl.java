package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IRoomDao;
import pe.edu.upc.entidades.Room;
import pe.edu.upc.service.IRoomService;

@Named
public class RoomServiceImpl implements IRoomService{
	
	@Inject
	private IRoomDao rDao;
	
	@Override
	public void insert (Room r) {
		rDao.insert(r);
	}
	@Override
	public List<Room> list(){
		return rDao.list();
	}
	
	@Override
	public void delete (int idRoom) {
		rDao.delete(idRoom);
	}
}
