package pe.edu.upc.serviceimpls;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daointerfaces.IRoomDao;
import pe.edu.upc.entities.Room;
import pe.edu.upc.serviceinterfaces.IRoomService;


@Named
public class RoomServiceImpl implements IRoomService{
	
	@Inject
	private IRoomDao rDao;
	
	@Override
	public void insertR (Room r) {
		rDao.insertR(r);
	}
	@Override
	public List<Room> list(){
		return rDao.list();
	}
	
	@Override
	public void deleteR (int idRoom) {
		rDao.deleteR(idRoom);
	}
	
	@Override
	public void updateR (Room r) {
		rDao.updateR(r);
	}
	
	@Override
	public List<Room> findByNameRoom (Room r){
		return rDao.findByNameRoom(r);
	}
}
