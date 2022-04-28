package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IRoomDao;
import pe.edu.upc.entidades.Room;

public class RoomImplDao implements IRoomDao {

	@PersistenceContext(unitName = "Fullhouse1")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insert (Room r) {
		try {
			em.persist(r);
		} catch (Exception e) {
			System.out.println("Error al insertar habitacion");
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Room> list(){
		List<Room> listahabitacion = new ArrayList<Room>();
		try {
			Query jpql = em.createQuery("from Room r");
			listahabitacion = (List<Room>) jpql.getResultList();
		}
			catch (Exception e) {
				System.out.println("Error al listar habitacion");
			}
			return listahabitacion;
		
	}
	
	@Transactional
	@Override
	public void delete(int idRoom) {
		try {
			Room ro = em.find(Room.class, idRoom);
			em.remove(ro);
		} catch (Exception e) {

			System.out.println("Error al eliminar en el dao");
		}
	}
	
}
