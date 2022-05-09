package es.organizador.Asigmin.model;

import javafx.beans.property.SimpleStringProperty;

public class Asignatura {
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
	public String toString() {
		return "Asignatura [id=" + id + ", nombre=" + nombre + "]";
	}
}
