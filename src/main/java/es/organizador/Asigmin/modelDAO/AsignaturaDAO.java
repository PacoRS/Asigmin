package es.organizador.Asigmin.modelDAO;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.organizador.Asigmin.model.Asignatura;
import es.organizador.Asigmin.utils.Connect;
import javafx.collections.ObservableList;

public class AsignaturaDAO {
	private Connection miConexion;

	public AsignaturaDAO() {
		this.miConexion = Connect.getConnect();
	}

	public boolean creaAsignatura(Asignatura as) {

		boolean valid = false;
		String sql = "INSERT INTO asignatura (id, nombre,id_usuario) VALUES (?, ?,'1');";
		try {
			PreparedStatement sentencia = miConexion.prepareStatement(sql);

			sentencia.setInt(1, as.getId());
			sentencia.setString(2, as.getNombre());
			sentencia.executeUpdate();
			valid = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return valid;
	}

	public boolean borraAsignatura(Asignatura as) {
		int id;
		id = as.getId();

		boolean valid = false;
		String sql = "DELETE FROM asignatura WHERE asignatura.id = 1";
		try {
			PreparedStatement sentencia = miConexion.prepareStatement(sql);
			sentencia.executeUpdate();
			valid = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return valid;
	}

	public void actualizaAsignatura() {

	}	
	
	public List<Asignatura> getall() {
        List <Asignatura> listaAsignaturas = new ArrayList<>();

        String sql="SELECT nombre FROM asignatura";

        try {
            PreparedStatement  sentencia = miConexion.prepareStatement(sql);

            ResultSet rs = sentencia.executeQuery();

            while(rs.next()) {
                //rs.next();
                Asignatura a = new Asignatura();
             
                
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
