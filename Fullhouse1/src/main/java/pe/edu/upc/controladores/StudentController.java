package pe.edu.upc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Student;
import pe.edu.upc.serviceinterfaces.IStudentService;
@Named
@RequestScoped
public class StudentController {
	@Inject
	private IStudentService sService;
	
	private Student s;
	private List<Student> listaEstudiantes;
	
	@PostConstruct
	public void init() {
		this.listaEstudiantes = new ArrayList<Student>();
		this.s = new Student();
		this.list();
	}

	public String newStudent() {
		this.setS(new Student());
		return "estudiante.xhtml";
	}
	
	public void insert() {
		try {
			sService.insert(s);
		} catch (Exception e) {
			System.out.println("Error al insertar en el controller"+e.getStackTrace());
		}
	}
	
	public void list() {
		try {
			listaEstudiantes = sService.list();
		} catch (Exception e) {
			System.out.println("Error al insertar en el controller");
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

}