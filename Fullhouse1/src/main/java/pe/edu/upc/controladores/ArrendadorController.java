package pe.edu.upc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Arrendador;
import pe.edu.upc.serviceintfaces.ArrendadorService;

@Named
@RequestScoped
public class ArrendadorController {
	@Inject
	private ArrendadorService Aservice;

	// atributos
	private Arrendador ar;
	private List<Arrendador> listaarrendador;

	// inicializar
	@PostConstruct
	public void init() {
		this.listaarrendador = new ArrayList<Arrendador>();
		this.ar = new Arrendador();
		this.list();
	}

	// metodos a atender por peticiones

	public String newArrendador() {
		this.setAr(new Arrendador());
		return "arrendador.xhtml";
	}

	public void insert() {
		try {
			Aservice.insert(ar);
		} catch (Exception e) {
			System.out.println("Error al insertar en el controlador");
		}
	}

	public void list() {
		try {
			listaarrendador = Aservice.list();
		} catch (Exception e) {
			System.out.println("Error al listar en el controlador");
		}

	}

	// getters and setters
	public Arrendador getAr() {
		return ar;
	}

	public void setAr(Arrendador ar) {
		this.ar = ar;
	}

	public List<Arrendador> getListaarrendador() {
		return listaarrendador;
	}

	public void setListaarrendador(List<Arrendador> listaarrendador) {
		this.listaarrendador = listaarrendador;
	}

}
