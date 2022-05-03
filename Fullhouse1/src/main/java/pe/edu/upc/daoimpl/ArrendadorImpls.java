package pe.edu.upc.impls;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.entities.Arrendador;
import pe.edu.upc.intfaces.ArrendadorInterfaces;

public class ArrendadorImpls implements ArrendadorInterfaces {
	@PersistenceContext(unitName = "FullHouse")
	private EntityManager em;

	@Transactional
	public void insert(Arrendador ar) {
		try {
			em.persist(ar);

		} catch (Exception e) {
			System.out.println("Error al insertar al arrendador en el implements");
		}

	}

	@SuppressWarnings("unchecked")
	public List<Arrendador> list() {
		List<Arrendador> listararrendador = new ArrayList<Arrendador>();
		try {
			Query jpql = em.createQuery("from Arrendador ar");
			listararrendador = (List<Arrendador>) jpql.getResultList();

		} catch (Exception e) {
			System.out.println("Error al listar al arrendador en el implements");
		}
		return listararrendador;
	}

	@Transactional
	@Override
	public void delete(int id) {
		try {
			Arrendador are = em.find(Arrendador.class, id);
			em.remove(are);
		} catch (Exception e) {
			System.out.println("Error al eliminar al arrendador en el implements");
		}

	}

	@Transactional
	@Override
	public void update(Arrendador ar) {
		try {
			em.merge(ar);
		} catch (Exception e) {
			System.out.println("Error al modificar al arrendador en el implements");
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Arrendador> findByNameArrend(Arrendador ar) {
		List<Arrendador> lista = new ArrayList<Arrendador>();
		try {
			Query q = em.createQuery("from Arrendador ar where ar.nomArrendador like ?1");
			q.setParameter(1, "%" + ar.getNomArrendador() + "%");
			lista = (List<Arrendador>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al buscar al arrendador en el implements");
		}
		return lista;
	}

}
