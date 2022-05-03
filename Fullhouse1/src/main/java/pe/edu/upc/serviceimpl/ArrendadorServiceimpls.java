package pe.edu.upc.serviceimpls;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Arrendador;
import pe.edu.upc.intfaces.ArrendadorInterfaces;
import pe.edu.upc.serviceintfaces.ArrendadorService;

@Named
public class ArrendadorServiceimpls implements ArrendadorService {
	@Inject
	private ArrendadorInterfaces ArInt;

	public void insert(Arrendador ar) {
		ArInt.insert(ar);

	}

	public List<Arrendador> list() {
		// TODO Auto-generated method stub
		return ArInt.list();
	}

	
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		ArInt.delete(id);
	}

	@Override
	public void update(Arrendador ar) {
		// TODO Auto-generated method stub
		ArInt.update(ar);
		
	}

	@Override
	public List<Arrendador> findByNameArrend(Arrendador ar) {
		// TODO Auto-generated method stub
		return ArInt.findByNameArrend(ar);
	}
	
	

}
