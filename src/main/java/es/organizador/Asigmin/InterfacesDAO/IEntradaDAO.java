package es.organizador.Asigmin.InterfacesDAO;

import java.util.List;

import es.organizador.Asigmin.model.Entrada;

public interface IEntradaDAO {
	public boolean creaEntrada(Entrada en) ;
	public boolean borraEntrada(Entrada en) ;
	public boolean modificaEntrada(Entrada en, int id) ;
	public int idParaLaLista(String a) ;
	public List<Entrada> getall() ;
}
