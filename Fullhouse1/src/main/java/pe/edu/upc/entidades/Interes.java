package pe.edu.upc.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Interes")
public class Interes {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idInteres;

	@ManyToOne
	@JoinColumn(name = "student", nullable = false)
	private Student student;

	@ManyToOne
	@JoinColumn(name = "aviso", nullable = false)
	private Aviso aviso;

	public Interes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Interes(int idInteres, Student student, Aviso aviso) {
		super();
		this.idInteres = idInteres;
		this.student = student;
		this.aviso = aviso;
	}

	public int getIdInteres() {
		return idInteres;
	}

	public void setIdInteres(int idInteres) {
		this.idInteres = idInteres;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Aviso getAviso() {
		return aviso;
	}

	public void setAviso(Aviso aviso) {
		this.aviso = aviso;
	}

	@Override
	public int hashCode() {
		return Objects.hash(aviso, idInteres, student);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Interes other = (Interes) obj;
		return Objects.equals(aviso, other.aviso) && idInteres == other.idInteres
				&& Objects.equals(student, other.student);
	}

}
