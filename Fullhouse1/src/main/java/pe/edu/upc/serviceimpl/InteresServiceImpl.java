package pe.edu.upc.serviceimpls;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daointerfaces.IInteresDao;
import pe.edu.upc.entities.Interes;
import pe.edu.upc.serviceinterfaces.IInteresService;

@Named
public class InteresServiceImpl implements IInteresService {
	
	@Inject
	private IInteresDao iDao;

	@Override
	public void insert(Interes i) {
		iDao.insert(i);
	}

	@Override
	public List<Interes> list() {
		return iDao.list();
	}

	@Override
	public void delete(int id) {
		iDao.delete(id);
	}

	@Override
	public void update(Interes i) {
		iDao.update(i);
	}
	

}
