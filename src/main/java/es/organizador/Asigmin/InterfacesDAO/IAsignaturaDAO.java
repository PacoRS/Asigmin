package es.organizador.Asigmin.InterfacesDAO;

import java.util.List;

import es.organizador.Asigmin.model.Asignatura;

public interface IAsignaturaDAO {
	public boolean creaAsignatura(Asignatura as) ;
	public boolean borraAsignatura(Asignatura as) ;
	public boolean modificaAsignatura(Asignatura as, int id) ;
	public int idParaLaLista(String a) ;
	public List<Asignatura> getall() ;
}
