package pe.edu.upc.serviceimpls;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daointerfaces.IStudentDao;
import pe.edu.upc.entities.Student;
import pe.edu.upc.serviceinterfaces.IStudentService;

@Named
public class StudentServiceImpl implements IStudentService {
	
	@Inject
	private IStudentDao sDao;

	@Override
	public void insert(Student s) {
		sDao.insert(s);
	}

	@Override
	public List<Student> list() {
		return sDao.list();
	}

}
