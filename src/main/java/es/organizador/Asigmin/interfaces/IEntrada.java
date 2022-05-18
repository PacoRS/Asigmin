package es.organizador.Asigmin.interfaces;

import java.time.LocalDateTime;

public interface IEntrada {
	int id = 0;
	String titulo = "";
	LocalDateTime fechaCreacion = null;
	boolean recordatorio = false;
	String contenido = "";
	LocalDateTime fechaRecordatorio = null;
	boolean estado = false;
	int id_asignatura = 0;
}
