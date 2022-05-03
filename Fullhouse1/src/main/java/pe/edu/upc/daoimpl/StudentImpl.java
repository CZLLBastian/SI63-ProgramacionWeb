package pe.edu.upc.daoimpls;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerfaces.IStudentDao;
import pe.edu.upc.entities.Student;

public class StudentImpl  implements IStudentDao {
	
	@PersistenceContext(unitName = "FullHouse")
	private EntityManager em;
	
	@Override
	@Transactional
	public void insert(Student s) {
		try {
			em.persist(s);
		} catch (Exception e) {
			System.out.println("Error al insertar estudiante en el DAO"+e.getMessage());
		}	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> list() {
		List<Student> listaEstudiantes = new ArrayList<Student>();
		try {
			Query jpql = em.createQuery("from Student s");
			listaEstudiantes = (List<Student>) jpql.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar estudiante en DAO "+ e.getCause());
		}
		return listaEstudiantes;
	}
	
	@Transactional
	@Override
	public void update(Student s) {
		try {
			em.merge(s);
		} catch (Exception e) {
			System.out.println("Error al actualizar");
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> findByNameStudent(Student s) {
		List<Student> lista=new ArrayList<Student>();
		try {
			Query q=em.createQuery("from Student s where s.nombreStudent like ?1");
			q.setParameter(1,"%"+s.getNombreStudent()+"%");
			lista=(List<Student>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al buscar en el dao");
		}
		return lista;
	}
	
	@Transactional
	@Override
	public void delete(int id) {
		try {
			Student stu = em.find(Student.class, id);
			em.remove(stu);
		} catch (Exception e) {
			System.out.println("Error al eliminar en el DAO " + e.getMessage());
		}
		
	}

}
