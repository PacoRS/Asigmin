package es.organizador.Asigmin.model;


import java.time.LocalDateTime;
import java.util.Objects;

import es.organizador.Asigmin.interfaces.IEntrada;

public class Entrada implements IEntrada{
	private int id;
	private String titulo;
	private LocalDateTime fechaCreacion;
	private boolean recordatorio;
	private String contenido;
	private LocalDateTime fechaRecordatorio;
	private boolean estado;
	private int id_asignatura;

	public Entrada() {
		super();
	}

	public Entrada(int id, String titulo, LocalDateTime fechaCreacion, boolean recordatorio, String contenido,
			LocalDateTime fechaRecordatorio, boolean estado, int id_asignatura) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.fechaCreacion = fechaCreacion;
		this.recordatorio = recordatorio;
		this.contenido = contenido;
		this.fechaRecordatorio = fechaRecordatorio;
		this.estado = estado;
		this.id_asignatura = id_asignatura;
	}
	

	public Entrada(String titulo, LocalDateTime fechaCreacion, boolean recordatorio, String contenido,
			LocalDateTime fechaRecordatorio, boolean estado, int id_asignatura) {
		super();
		this.titulo = titulo;
		this.fechaCreacion = fechaCreacion;
		this.recordatorio = recordatorio;
		this.contenido = contenido;
		this.fechaRecordatorio = fechaRecordatorio;
		this.estado = estado;
		this.id_asignatura = id_asignatura;
	}

	public Entrada(int id, String titulo, LocalDateTime fechaCreacion, boolean recordatorio, String contenido,
			LocalDateTime fechaRecordatorio, boolean estado) {
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

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
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

	public LocalDateTime getFechaRecordatorio() {
		return fechaRecordatorio;
	}

	public void setFechaRecordatorio(LocalDateTime fechaRecordatorio) {
		this.fechaRecordatorio = fechaRecordatorio;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public int getId_asignatura() {
		return id_asignatura;
	}

	public void setId_asignatura(int id_asignatura) {
		this.id_asignatura = id_asignatura;
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
		Entrada other = (Entrada) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Entrada [id=" + id + ", titulo=" + titulo + ", fechaCreacion=" + fechaCreacion + ", recordatorio="
				+ recordatorio + ", contenido=" + contenido + ", fechaRecordatorio=" + fechaRecordatorio + ", estado="
				+ estado + ", id_asignatura=" + id_asignatura + "]";
	}

}
