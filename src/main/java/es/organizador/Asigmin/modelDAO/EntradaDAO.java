package es.organizador.Asigmin.modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import es.organizador.Asigmin.PrimaryController;
import es.organizador.Asigmin.InterfacesDAO.IEntradaDAO;
import es.organizador.Asigmin.model.Asignatura;
import es.organizador.Asigmin.model.Entrada;
import es.organizador.Asigmin.utils.Connect;

public class EntradaDAO extends InformacionDAO implements IEntradaDAO{
	private Connection miConexion;

	public static String name;
	public static int idd;

	public EntradaDAO() {
		this.miConexion = Connect.getConnect();
	}
	/**
	 * Metodo que recibe una entrada y esta la añade a nuestra base de datos sql a traves de un consulta sql
	 */
	public boolean creaEntrada(Entrada en) {

		boolean valid = false;
		String sql1 = "INSERT INTO entrada (titulo, fecha_creacion, recordatorio, contenido, fecha_recordatorio, estado, id_asignatura) VALUES (?, ?, ?, ?, ?, ?, "
				+ PrimaryController.aa + ")";
		try {
			PreparedStatement sentencia = miConexion.prepareStatement(sql1);

			// sentencia.setInt(1, en.getId());
			sentencia.setString(1, en.getTitulo());
			sentencia.setObject(2, en.getFechaCreacion());
			sentencia.setBoolean(3, en.isRecordatorio());
			sentencia.setString(4, en.getContenido());
			sentencia.setObject(5, en.getFechaRecordatorio());
			sentencia.setBoolean(6, en.isEstado());
			sentencia.executeUpdate();
			valid = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		name = en.getTitulo();

		return valid;
	}
	/**
	 * Metodo que recibe una entrada y esta elimina una entrada de la base de datos sql a traves de un consulta sql.El metodo usa el id para eliminarlo
	 */
	public boolean borraEntrada(Entrada en) {
		int id;
		id = en.getId();

		boolean valid = false;
		String sql = "DELETE FROM entrada WHERE entrada.id = ?";
		try {
			PreparedStatement sentencia = miConexion.prepareStatement(sql);
			sentencia.setInt(1, en.getId());
			sentencia.executeUpdate();
			valid = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return valid;
	}
	/**
	 * Metodo que recibe una entrada y un id. Esta modifica una entrada
	 * existente de la entrada seleccionada
	 */
	public boolean modificaEntrada(Entrada en, int id) {

		boolean valid = false;
		String sql1 = "UPDATE entrada SET id = ?, titulo = ?, fecha_creacion = ?, recordatorio = ?, contenido = ?, fecha_recordatorio = ?, estado = ?, id_asignatura ="
				+ PrimaryController.aa + " WHERE entrada.id = ?";
		System.out.println(id);
		try {
			PreparedStatement sentencia = miConexion.prepareStatement(sql1);

			sentencia.setInt(1, en.getId());
			sentencia.setString(2, en.getTitulo());
			sentencia.setObject(3, en.getFechaCreacion());
			sentencia.setBoolean(4, en.isRecordatorio());
			sentencia.setString(5, en.getContenido());
			sentencia.setObject(6, en.getFechaRecordatorio());
			sentencia.setBoolean(7, en.isEstado());
			sentencia.setInt(8, id);
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
		Entrada en = new Entrada();
		List<Entrada> listaEntrada = new ArrayList<>();
		getall();
		listaEntrada = getall();
		for (Entrada entrada : listaEntrada) {
			if (a.equals(entrada.getTitulo())) {
				en = entrada;
				f = en.getId();
			}
		}

		return f;

	}

	/**
	 * Devuelve en una lista todas las entradas de nuestra base de datos	
	 */
	public List<Entrada> getall() {
		List<Entrada> listaEntrada = new ArrayList<>();

		String sql = "SELECT * FROM entrada";

		try {
			PreparedStatement sentencia = miConexion.prepareStatement(sql);

			ResultSet rs = sentencia.executeQuery();

			while (rs.next()) {

				Entrada a = new Entrada();
				a.setId(rs.getInt("id"));
				a.setTitulo(rs.getString("titulo"));
				a.setFechaCreacion(rs.getTimestamp("fecha_creacion").toLocalDateTime());
				a.setRecordatorio(rs.getBoolean("recordatorio"));
				a.setContenido(rs.getString("contenido"));
				a.setFechaRecordatorio(rs.getTimestamp("fecha_recordatorio").toLocalDateTime());
				a.setEstado(rs.getBoolean("estado"));
				a.setId_asignatura(rs.getInt("id_asignatura"));
				if (a.getId_asignatura() == PrimaryController.aa) {
					listaEntrada.add(a);
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaEntrada;

	}

}
