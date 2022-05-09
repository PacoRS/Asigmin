package es.organizador.Asigmin;

import java.io.IOException;
import java.util.List;

import javax.swing.text.TabableView;

import es.organizador.Asigmin.model.Asignatura;
import es.organizador.Asigmin.modelDAO.AsignaturaDAO;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PrimaryController {
	@FXML
	private TextField id;
	@FXML
	private TextField nombre;

	private ObservableList<Asignatura> asignaturas2;
	@FXML
	private TableView<Asignatura> asignaturas;
	@FXML
	private TableColumn<Asignatura, String> nombreAsignatura;
	
//	List<Asignatura> asig;

	@FXML
	private void addAsignatura() throws IOException {
		AsignaturaDAO asig = new AsignaturaDAO();
		int id2 = Integer.parseInt(id.getText());
		String nombre2 = nombre.getText();
		asig.creaAsignatura(new Asignatura(id2, nombre2));
	}

	@FXML
	private void deleteAsignatura() throws IOException {
		AsignaturaDAO asig = new AsignaturaDAO();
		int id2 = Integer.parseInt(id.getText());
		String nombre2 = nombre.getText();
		asig.borraAsignatura(new Asignatura(id2, nombre2));
	}
	

	@FXML
	protected void initialize() {
		AsignaturaDAO as=new AsignaturaDAO();
		// TODO Auto-generated method stub
		this.configuraTabla();
		List<Asignatura> todasMisAsignaturas = (List<Asignatura>) as.getall();
		asignaturas2=FXCollections.observableArrayList(todasMisAsignaturas);
		asignaturas.setItems(FXCollections.observableArrayList(asignaturas2));
	}
	
	private void configuraTabla() {
		// TODO Auto-generated method stub
		
		nombreAsignatura.setCellValueFactory(Asignatura ->{
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(Asignatura.getValue().getNombre());
			return ssp;
		});
		
		
	}
}
