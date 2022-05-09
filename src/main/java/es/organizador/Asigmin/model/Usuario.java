package es.organizador.Asigmin.model;

public class Usuario {
	private int id;
	private String nombre;
	private String dni;

	public Usuario() {
		super();
	}

	public Usuario(int id, String nombre, String dni) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.dni = dni;
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", dni=" + dni + "]";
	}

}
