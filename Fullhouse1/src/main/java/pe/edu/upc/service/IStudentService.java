package pe.edu.upc.serviceinterfaces;

import java.util.List;

import pe.edu.upc.entities.Student;

public interface IStudentService {
	public void insert(Student s);
	public List<Student> list();
	public void delete(int id);
	public List<Student> findByNameStudent(Student s);
	public void update(Student s);
}
