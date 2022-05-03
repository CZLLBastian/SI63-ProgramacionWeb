package pe.edu.upc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Universidad;
import pe.edu.upc.serviceinterfaces.IUniversidadService;

@Named
@RequestScoped
public class UniversidadController {
	@Inject
	private IUniversidadService uService;

	private Universidad u;
	private List<Universidad> listaUniversidades;

	// inicializar
	@PostConstruct
	public void init() {
		this.listaUniversidades = new ArrayList<Universidad>();
		this.u = new Universidad();
		this.list();

	}

	public String newUniversidad() {

		this.setU(new Universidad());
		return "universidad.xhtml";

	}

	public void insert() {
		try {
			uService.insert(u);

		} catch (Exception e) {
			System.out.println("Error al insertar en el service" + e.getStackTrace());
		}
	}

	public void list() {
		try {
			listaUniversidades = uService.list();
		} catch (Exception e) {
			System.out.println("Error al listar en el controller");
		}
	}

	public void delete(Universidad un) {
		try {
			uService.delete(un.getIdUniversidad());
			this.list();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controlador");
		}
	}

	public Universidad getU() {
		return u;
	}

	public void setU(Universidad u) {
		this.u = u;
	}

	public List<Universidad> getListaUniversidades() {
		return listaUniversidades;
	}

	public void setListaUniversidades(List<Universidad> listaUniversidades) {
		this.listaUniversidades = listaUniversidades;
	}

}
