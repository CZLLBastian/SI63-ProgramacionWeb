package pe.edu.upc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Arrendador;
import pe.edu.upc.entities.Distrito;
import pe.edu.upc.entities.Room;
import pe.edu.upc.serviceinterfaces.ArrendadorService;
import pe.edu.upc.serviceinterfaces.IDistritoService;
import pe.edu.upc.serviceinterfaces.IRoomService;


@Named
@RequestScoped
public class RoomController {

	@Inject
	private IRoomService rService;
	
	@Inject
	private IDistritoService dService;
	
	@Inject
	private ArrendadorService aService;
	
	private Room r;
	List<Room> listahabitacion;
	List<Arrendador> listaArrendador;
	List<Distrito> listaDistrito;
	
	
	@PostConstruct
	public void init() {
		this.listahabitacion = new ArrayList<Room>();
		this.listaArrendador = new ArrayList<Arrendador>();
		this.listaDistrito = new ArrayList<Distrito>()
;		this.r = new Room();
		this.list();
		this.listArrendador();
		this.listDistrito();
	}
	
	public String newRoom() {

		this.setR(new Room());
		return "habitacion.xhtml";
	}

	public void insertR() {
		try {
			rService.insertR(r);

		} catch (Exception e) {
			System.out.println("Error al insertar en el controller habitacion");
		}
	}

	public void list() {
		try {
			listahabitacion = rService.list();
		} catch (Exception e) {
			System.out.println("Error al listar en controller habitacion");
		}
	}
	
	public void listArrendador() {
		try {
			listaArrendador = aService.list();
		} catch (Exception e) {
			System.out.println("Error al listar arrendador en el controlador");
		}
	}
	
	public void listDistrito() {
		try {
			listaDistrito = dService.list();
		} catch (Exception e) {
			System.out.println("Error al listar distrito en el controlador");
		}
	}
	public void deleteR(Room rom) {
		try {
			rService.deleteR(rom.getIdRoom());
			this.list();
		} catch (Exception e) {
			System.out.println("Error al eliminar en elcontroller habitacion");
		}
	}
	
	public String preUpdateR(Room r) {
		this.setR(r);
		return "modificarR.xhtml";
	}
	
	public void updateR() {
		try {
			rService.updateR (this.r);
			this.list();
		}catch (Exception e) {
			System.out.println("Error al modificar en el controlador");	
		}
	}
	
	public void findByNameRoom() {
		try {
			listahabitacion = rService.findByNameRoom(this.getR());
		}catch (Exception e) {
			System.out.println("Error al buscar en el controlador");
		}
	}

	public IRoomService getrService() {
		return rService;
	}

	public void setrService(IRoomService rService) {
		this.rService = rService;
	}

	public IDistritoService getdService() {
		return dService;
	}

	public void setdService(IDistritoService dService) {
		this.dService = dService;
	}

	public ArrendadorService getaService() {
		return aService;
	}

	public void setaService(ArrendadorService aService) {
		this.aService = aService;
	}

	public Room getR() {
		return r;
	}

	public void setR(Room r) {
		this.r = r;
	}

	public List<Room> getListahabitacion() {
		return listahabitacion;
	}

	public void setListahabitacion(List<Room> listahabitacion) {
		this.listahabitacion = listahabitacion;
	}

	public List<Arrendador> getListaArrendador() {
		return listaArrendador;
	}

	public void setListaArrendador(List<Arrendador> listaArrendador) {
		this.listaArrendador = listaArrendador;
	}

	public List<Distrito> getListaDistrito() {
		return listaDistrito;
	}

	public void setListaDistrito(List<Distrito> listaDistrito) {
		this.listaDistrito = listaDistrito;
	}

}
