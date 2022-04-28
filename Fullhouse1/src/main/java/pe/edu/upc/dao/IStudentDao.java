package pe.edu.upc.daointerfaces;

import java.util.List;

import pe.edu.upc.entities.Student;

public interface IStudentDao {
	public void insert(Student s);
	public List<Student> list();
}
