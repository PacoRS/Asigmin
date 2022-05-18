package es.organizador.Asigmin.model;

import java.util.Objects;

import es.organizador.Asigmin.interfaces.IAsignatura;

public class Asignatura implements IAsignatura {
	private int id;
	private String nombre;

	public Asignatura() {
		super();
	}

	public Asignatura(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	

	public Asignatura(String nombre) {
		super();
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asignatura other = (Asignatura) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Asignatura [id=" + id + ", nombre=" + nombre + "]";
	}

}
