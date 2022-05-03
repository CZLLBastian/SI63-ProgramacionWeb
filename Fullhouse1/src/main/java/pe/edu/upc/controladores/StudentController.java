package pe.edu.upc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Student;
import pe.edu.upc.entities.Universidad;
import pe.edu.upc.serviceinterfaces.IStudentService;
import pe.edu.upc.serviceinterfaces.IUniversidadService;
@Named
@RequestScoped
public class StudentController {
	@Inject
	private IStudentService sService;
	
	@Inject
	private IUniversidadService uService;
	
	private Student s;
	List<Student> listaEstudiantes;
	List<Universidad> listaUniversidad;
	
	@PostConstruct
	public void init() {
		this.listaEstudiantes = new ArrayList<Student>();
		this.listaUniversidad = new ArrayList<Universidad>();
		this.s = new Student();
		this.list();
		this.listUniversidad();
	}

	public String newStudent() {
		this.setS(new Student());
		return "estudiante.xhtml";
	}
	
	public void insert() {
		try {
			sService.insert(s);
		} catch (Exception e) {
			System.out.println("Error al insertar en el controller"+e.getMessage());
		}
	}
	
	public void list() {
		try {
			listaEstudiantes = sService.list();
		} catch (Exception e) {
			System.out.println("Error al listar en el controller");
		}
	}
	
	public void listUniversidad() {
		try {
			listaUniversidad = uService.list();
		} catch (Exception e) {
			System.out.println("Error al listar universidad en el controlador");
		}
	}
	
	public String preUpdate(Student s) {
		this.setS(s);
		return "modificacion.xhtml";
	}
	
	public void update() {
		try {
			sService.update(this.s);
		} catch (Exception e) {
			System.out.println("Error al modificar en el controller");
		}
	}
	
	public void findByNameStudent() {
		try {
			listaEstudiantes=sService.findByNameStudent(this.getS());
		} catch (Exception e) {
			System.out.println("Error al buscar vacuna en el controlador");
		}
	}
	
	public void delete(Student s) {
		try {
			sService.delete(s.getIdStudent());
			this.list();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controlador de persona " + e.getMessage());
		}
	}
	//Getters & setters
	public Student getS() {
		return s;
	}

	public void setS(Student s) {
		this.s = s;
	}
	
	public List<Student> getListaEstudiantes() {
		return listaEstudiantes;
	}
	public void setListaEstudiantes(List<Student> listaEstudiantes) {
		this.listaEstudiantes = listaEstudiantes;
	}

	public List<Universidad> getListaUniversidad() {
		return listaUniversidad;
	}

	public void setListaUniversidad(List<Universidad> listaUniversidad) {
		this.listaUniversidad = listaUniversidad;
	}

}