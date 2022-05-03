package pe.edu.upc.daoimpls;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerfaces.IRoomDao;
import pe.edu.upc.entities.Room;

public class RoomImplDao implements IRoomDao {

	@PersistenceContext(unitName = "FullHouse")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertR (Room r) {
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
	public void deleteR (int idRoom) {
		try {
			Room ro = em.find(Room.class, idRoom);
			em.remove(ro);
		} catch (Exception e) {

			System.out.println("Error al eliminar en el dao");
		}
	}
	@Transactional
	@Override
	public void updateR (Room r) {
		try {
			em.merge(r);
		}catch(Exception e) {
			System.out.println("Error al modificar la habitacion en el implements");
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Room> findByNameRoom(Room r) {
		List<Room> lista = new ArrayList<Room>();
		try {
			Query q = em.createQuery("from Room r where r.descpRoom like ?1");
			q.setParameter(1,"%" + r.getDescpRoom()+ "%");
			lista = (List<Room>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al buscar habitacion en el implements");
		}
		return lista;
	}
}
