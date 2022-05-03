package pe.edu.upc.daoimpls;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerfaces.IUniversidadDAO;
import pe.edu.upc.entities.Universidad;

public class UniversidadImpl implements IUniversidadDAO {
	@PersistenceContext(unitName = "fullhousebd")
	private EntityManager em;

	@Transactional
	public void insert(Universidad u) {

		try {

			em.persist(u);

		} catch (Exception e) {

			System.out.println("Error al insertar Universidad en el DAO");

		}

	}

	@SuppressWarnings("unchecked")
	public List<Universidad> list() {
		List<Universidad> listaUniversidades = new ArrayList<Universidad>();
		try {
			Query jpql = em.createQuery("from Universidad u");
			listaUniversidades = (List<Universidad>) jpql.getResultList();

		} catch (Exception e) {
			System.out.println("Error al listar Universidad en DAO");
		}

		return listaUniversidades;
	}

	@Transactional
	@Override
	public void delete(int id) {
		try {
			Universidad uni = em.find(Universidad.class, id);
			em.remove(uni);
		} catch (Exception e) {
			System.out.println("Error al eliminar en el DAO");
		}

	}

}
