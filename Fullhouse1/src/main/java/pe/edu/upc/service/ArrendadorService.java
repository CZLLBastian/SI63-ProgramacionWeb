package pe.edu.upc.serviceintfaces;

import java.util.List;

import pe.edu.upc.entities.Arrendador;

public interface ArrendadorService {

	public void insert(Arrendador ar);

	public List<Arrendador> list();

}
