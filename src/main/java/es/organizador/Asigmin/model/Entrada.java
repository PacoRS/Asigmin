package es.organizador.Asigmin.model;

import java.sql.Date;

public class Entrada {
	private int id;
	private String titulo;
	private Date fechaCreacion;
	private boolean recordatorio;
	private String contenido;
	private Date fechaRecordatorio;
	private boolean estado;

	public Entrada() {
		super();
	}

	public Entrada(int id, String titulo, Date fechaCreacion, boolean recordatorio, String contenido,
			Date fechaRecordatorio, boolean estado) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.fechaCreacion = fechaCreacion;
		this.recordatorio = recordatorio;
		this.contenido = contenido;
		this.fechaRecordatorio = fechaRecordatorio;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public boolean isRecordatorio() {
		return recordatorio;
	}

	public void setRecordatorio(boolean recordatorio) {
		this.recordatorio = recordatorio;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Date getFechaRecordatorio() {
		return fechaRecordatorio;
	}

	public void setFechaRecordatorio(Date fechaRecordatorio) {
		this.fechaRecordatorio = fechaRecordatorio;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Entrada [id=" + id + ", titulo=" + titulo + ", fechaCreacion=" + fechaCreacion + ", recordatorio="
				+ recordatorio + ", contenido=" + contenido + ", fechaRecordatorio=" + fechaRecordatorio + ", estado="
				+ estado + "]";
	}

}
