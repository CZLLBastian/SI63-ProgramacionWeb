package pe.edu.upc.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entidades.Room;
import pe.edu.upc.service.IRoomService;

@Named
@RequestScoped
public class RoomController {

	@Inject
	private IRoomService rService;
	
	private Room r;
	List<Room> listahabitacion;
	
	@PostConstruct
	public void init() {
		this.listahabitacion = new ArrayList<Room>();
		this.r = new Room();
		this.list();
	}
	
	public String newRoom() {

		this.setR(new Room());
		return "habitacion.xhtml";
	}

	public void insert() {
		try {
			rService.insert(r);

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

	public void delete(Room rom) {
		try {
			rService.delete(rom.getIdRoom());
			this.list();
		} catch (Exception e) {
			System.out.println("Error al eliminar en elcontroller habitacion");
		}
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
	
	
	
	
	


}
