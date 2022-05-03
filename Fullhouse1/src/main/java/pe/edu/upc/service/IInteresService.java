package pe.edu.upc.serviceinterfaces;

import java.util.List;

import pe.edu.upc.entities.Interes;

public interface IInteresService {
	public void insert(Interes i);
	public List<Interes> list();
	public void delete(int id);
	public void update(Interes i);
}
