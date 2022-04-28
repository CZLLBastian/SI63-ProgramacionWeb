package pe.edu.upc.daoimpls;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pe.edu.upc.daointerfaces.IStudentDao;
import pe.edu.upc.entities.Student;

public class StudentImpl  implements IStudentDao {
	
@PersistenceContext(unitName = "FullHouse")
	private EntityManager em;
	
	@Override
	public void insert(Student s) {
		try {
			em.persist(s);
		} catch (Exception e) {
			System.out.println("Error al insertar estudiante en el DAO");
		}	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> list() {
		List<Student> listaEstudiantes = new ArrayList<Student>();
		try {
			Query jpql = em.createQuery("from student s");
			listaEstudiantes = (List<Student>) jpql.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar estudiante en DAO");
		}
		return listaEstudiantes;
	}
	
}
