package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idStudent;
	
	@Column(name = "nombreStudent", nullable = false, length = 47)
	private String nombreStudent;
	@Column(name = "dniStudent", nullable = false)
	private int dniStudent;
	@Column(name = "edadStudent", nullable = false)
	private int edadStudent;
	@Column(name = "numStudent", nullable = false)
	private int numStudent;
	@Column(name = "correoStudent", nullable = false, length = 47)
	private String correoStudent;
	@Column(name = "userStudent", nullable = false, length = 47)
	private String userStudent;
	@Column(name = "passStudent", nullable = false, length = 47)
	private String passStudent;
	@Column(name = "idUniStudent", nullable = false)
	private int idUniStudent;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student(int idStudent, String nombreStudent, int dniStudent, int edadStudent, int numStudent,
			String correoStudent, String userStudent, String passStudent, int idUniStudent) {
		super();
		this.idStudent = idStudent;
		this.nombreStudent = nombreStudent;
		this.dniStudent = dniStudent;
		this.edadStudent = edadStudent;
		this.numStudent = numStudent;
		this.correoStudent = correoStudent;
		this.userStudent = userStudent;
		this.passStudent = passStudent;
		this.idUniStudent = idUniStudent;
	}
	public int getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}

	public String getNombreStudent() {
		return nombreStudent;
	}

	public void setNombreStudent(String nombreStudent) {
		this.nombreStudent = nombreStudent;
	}

	public int getDniStudent() {
		return dniStudent;
	}

	public void setDniStudent(int dniStudent) {
		this.dniStudent = dniStudent;
	}

	public int getEdadStudent() {
		return edadStudent;
	}

	public void setEdadStudent(int edadStudent) {
		this.edadStudent = edadStudent;
	}

	public int getNumStudent() {
		return numStudent;
	}

	public void setNumStudent(int numStudent) {
		this.numStudent = numStudent;
	}

	public String getCorreoStudent() {
		return correoStudent;
	}

	public void setCorreoStudent(String correoStudent) {
		this.correoStudent = correoStudent;
	}

	public String getUserStudent() {
		return userStudent;
	}

	public void setUserStudent(String userStudent) {
		this.userStudent = userStudent;
	}

	public String getPassStudent() {
		return passStudent;
	}

	public void setPassStudent(String passStudent) {
		this.passStudent = passStudent;
	}

	public int getIdUniStudent() {
		return idUniStudent;
	}

	public void setIdUniStudent(int idUniStudent) {
		this.idUniStudent = idUniStudent;
	}

}