package pe.edu.upc.intfaces;

import java.util.List;

import pe.edu.upc.entities.Arrendador;

public interface ArrendadorInterfaces {

	public void insert(Arrendador ar);

	public List<Arrendador> list();
	
	public void delete(int id);
	
	public void update(Arrendador ar);
	
	public List<Arrendador> findByNameArrend(Arrendador ar);

}
