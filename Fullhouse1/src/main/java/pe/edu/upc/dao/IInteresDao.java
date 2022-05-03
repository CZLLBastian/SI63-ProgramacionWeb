package pe.edu.upc.daointerfaces;

import java.util.List;

import pe.edu.upc.entities.Interes;

public interface IInteresDao {
	public void insert(Interes i);
	public List<Interes> list();
	public void update(Interes i);
	public void delete(int id);
}
