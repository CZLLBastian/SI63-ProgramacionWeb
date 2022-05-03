package pe.edu.upc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Aviso;
import pe.edu.upc.entities.Interes;
import pe.edu.upc.entities.Student;
import pe.edu.upc.serviceinterfaces.AvisoService;
import pe.edu.upc.serviceinterfaces.IInteresService;
import pe.edu.upc.serviceinterfaces.IStudentService;

@Named
@RequestScoped
public class InteresController {

	@Inject
	private IInteresService iService;

	@Inject
	private IStudentService sService;

	@Inject
	private AvisoService aService;

	private Interes i;
	List<Interes> listaInteres;
	List<Student> listaEstudiantes;
	List<Aviso> listaAviso;

	@PostConstruct
	public void init() {
		this.listaEstudiantes = new ArrayList<Student>();
		this.listaInteres = new ArrayList<Interes>();
		this.listaAviso = new ArrayList<Aviso>();
		this.i = new Interes();
		this.list();
		this.listStudent();
		this.listAviso();
	}

	public void insert() {
		try {
			iService.insert(i);
		} catch (Exception e) {
			System.out.println("Error al insertar interes en el controller" + e.getMessage());
		}
	}

	public void list() {
		try {
			listaInteres = iService.list();
		} catch (Exception e) {
			System.out.println("Error al listar en el controller interes");
		}
	}

	public void listStudent() {
		try {
			listaEstudiantes = sService.list();
		} catch (Exception e) {
			System.out.println("Error al listar estudiantes en el controlador de interes");
		}
	}

	public void listAviso() {
		try {
			listaAviso = aService.list();
		} catch (Exception e) {
			System.out.println("Error al listar aviso en el controlador de interes");
		}
	}

	public String preUpdate(Interes i) {
		this.setI(i);
		return "modificacion3.xhtml";
	}

	public void update() {
		try {
			iService.update(this.i);
		} catch (Exception e) {
			System.out.println("Error al modificar en el controller interes");
		}
	}

	public void delete(Interes i) {
		try {
			iService.delete(i.getIdInteres());
			this.list();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controlador de interes " + e.getMessage());
		}
	}

	public IInteresService getiService() {
		return iService;
	}

	public void setiService(IInteresService iService) {
		this.iService = iService;
	}

	public IStudentService getsService() {
		return sService;
	}

	public void setsService(IStudentService sService) {
		this.sService = sService;
	}

	public AvisoService getaService() {
		return aService;
	}

	public void setaService(AvisoService aService) {
		this.aService = aService;
	}

	public Interes getI() {
		return i;
	}

	public void setI(Interes i) {
		this.i = i;
	}

	public List<Interes> getListaInteres() {
		return listaInteres;
	}

	public void setListaInteres(List<Interes> listaInteres) {
		this.listaInteres = listaInteres;
	}

	public List<Student> getListaEstudiantes() {
		return listaEstudiantes;
	}

	public void setListaEstudiantes(List<Student> listaEstudiantes) {
		this.listaEstudiantes = listaEstudiantes;
	}

	public List<Aviso> getListaAviso() {
		return listaAviso;
	}

	public void setListaAviso(List<Aviso> listaAviso) {
		this.listaAviso = listaAviso;
	}

}
