package es.organizador.Asigmin.modelDAO;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.organizador.Asigmin.InterfacesDAO.IAsignaturaDAO;
import es.organizador.Asigmin.model.Asignatura;
import es.organizador.Asigmin.model.Entrada;
import es.organizador.Asigmin.utils.Connect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AsignaturaDAO extends InformacionDAO implements IAsignaturaDAO{
	private Connection miConexion;
	public static String name2;

	public AsignaturaDAO() {
		this.miConexion = Connect.getConnect();
	}
/**
 * Metodo que recibe una asignatura y esta la añade a nuestra base de datos sql a traves de un consulta sql
 */
	public boolean creaAsignatura(Asignatura as) {

		boolean valid = false;
		String sql = "INSERT INTO asignatura (nombre) VALUES (?)";
		try {
			PreparedStatement sentencia = miConexion.prepareStatement(sql);

			sentencia.setString(1, as.getNombre());
			sentencia.executeUpdate();
			valid = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		name2 = as.getNombre();
		return valid;
	}
	/**
	 * Metodo que recibe una asignatura y esta elimina una asignatura de la base de datos sql a traves de un consulta sql.El metodo usa el id para eliminarlo
	 */
	public boolean borraAsignatura(Asignatura as) {
		int id;
		id = as.getId();

		boolean valid = false;
		String sql = "DELETE FROM asignatura WHERE asignatura.id = ?";
		try {
			PreparedStatement sentencia = miConexion.prepareStatement(sql);
			sentencia.setInt(1, as.getId());
			sentencia.executeUpdate();
			valid = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return valid;
	}
	/**
	 * Metodo que recibe una asignatura y un id esta modifica una asignatura
	 * existente de la asignatura seleccionada
	 */
	public boolean modificaAsignatura(Asignatura as, int id) {

		boolean valid = false;
		String sql = "UPDATE asignatura SET id = ?, nombre = ? WHERE asignatura.id = ?";
		try {
			PreparedStatement sentencia = miConexion.prepareStatement(sql);

			sentencia.setInt(1, as.getId());
			sentencia.setString(2, as.getNombre());
			sentencia.setInt(3, id);
			sentencia.executeUpdate();
			valid = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return valid;
	}
	/**
	 * Recibe el nombre de una asignatura y esta devuelve el id de esa asignatura 
	 */
	@Override
	public int idParaLaLista(String a) {
		int f = 0;
		Asignatura en = new Asignatura();
		List<Asignatura> listaEntrada = new ArrayList<>();
		getall();
		listaEntrada = getall();
		for (Asignatura asignatura : listaEntrada) {
			if (a.equals(asignatura.getNombre())) {
				en = asignatura;
				f = en.getId();
			}
		}

		return f;

	}

/**
 * Devuelve en una lista todas las asignaturas de nuestra base de datos	
 */
	public List<Asignatura> getall() {
		List<Asignatura> listaAsignaturas = new ArrayList<>();

		String sql = "SELECT id,nombre FROM asignatura";

		try {
			PreparedStatement sentencia = miConexion.prepareStatement(sql);

			ResultSet rs = sentencia.executeQuery();

			while (rs.next()) {
				Asignatura a = new Asignatura();
				a.setId(rs.getInt("id"));
				a.setNombre(rs.getString("nombre"));
				listaAsignaturas.add(a);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaAsignaturas;

	}

}
