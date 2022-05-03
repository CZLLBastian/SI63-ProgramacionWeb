package pe.edu.upc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Distrito;
import pe.edu.upc.serviceinterfaces.IDistritoService;

@Named
@RequestScoped
public class DistritoController {
	@Inject

	private IDistritoService dService;

//atributos para las peticiones
	private Distrito d;
	private List<Distrito> listaDistritos;

//inicializar
	@PostConstruct
	public void init() {
		this.listaDistritos = new ArrayList<Distrito>();
		this.d = new Distrito();
		this.list();
	}

	public String newDistrito() {
		this.setD(new Distrito());
		return "distrito.xhtml";
	}

	public void insert() {
		try {
			dService.insert(d);

		} catch (Exception e) {
			System.out.println("Error al insertar en el service" + e.getStackTrace());
		}

	}

	public void list() {
		try {
			listaDistritos = dService.list();
		} catch (Exception e) {
			System.out.println("Error al listar en el controller");
		}
	}

	public void delete(Distrito di) {
		try {
			dService.delete(di.getIdDistrito());
			this.list();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controlador de persona");
		}
	}

	// getters and setters
	public Distrito getD() {
		return d;
	}

	public void setD(Distrito d) {
		this.d = d;
	}

	public List<Distrito> getListaDistritos() {
		return listaDistritos;
	}

	public void setListaDistritos(List<Distrito> listaDistritos) {
		this.listaDistritos = listaDistritos;
	}

}
