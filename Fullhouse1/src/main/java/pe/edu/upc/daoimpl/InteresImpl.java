package pe.edu.upc.daoimpls;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerfaces.IInteresDao;
import pe.edu.upc.entities.Interes;

public class InteresImpl implements IInteresDao {
	
	@PersistenceContext(unitName = "FullHouse")
	private EntityManager em;
	
	@Override
	@Transactional
	public void insert(Interes i) {
		try {
			em.persist(i);
		} catch (Exception e) {
			System.out.println("Error al insertar interes en el DAO"+e.getMessage());
		}	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Interes> list() {
		List<Interes> listaInteres = new ArrayList<Interes>();
		try {
			Query jpql = em.createQuery("from Interes s");
			listaInteres = (List<Interes>) jpql.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar interes en DAO "+ e.getCause());
		}
		return listaInteres;
	}
	
	@Transactional
	@Override
	public void update(Interes i) {
		try {
			em.merge(i);
		} catch (Exception e) {
			System.out.println("Error al actualizar interes");
		}
		
	}

	
	@Transactional
	@Override
	public void delete(int id) {
		try {
			Interes in = em.find(Interes.class, id);
			em.remove(in);
		} catch (Exception e) {
			System.out.println("Error al eliminar interes en el DAO " + e.getMessage());
		}
		
	}

}
