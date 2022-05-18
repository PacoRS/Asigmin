package es.organizador.Asigmin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import es.organizador.Asigmin.model.Asignatura;
import es.organizador.Asigmin.modelDAO.AsignaturaDAO;
import es.organizador.Asigmin.utils.Utils;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class PrimaryController {
	@FXML
	private TextField idTF;
	@FXML
	private TextField nombreTF;
	@FXML
	private TableView<Asignatura> tableAsig;
	@FXML
	private TableColumn<Asignatura, String> columAsig;

	private ObservableList<Asignatura> observAsig;
	private List<Asignatura> listAsig;
	public static int aa;

	/**
	 * Constructor donde inicialisamos la lista y se la pasamos a la ObservableList
	 */
	public PrimaryController() {
		listAsig = new ArrayList<>();
		observAsig = FXCollections.observableArrayList(listAsig);
	}

	/**
	 * Metodo para añadir una asignatura tanto a nuestra observable list como a
	 * nuestra base de datos
	 * 
	 * @throws IOException
	 */
	@FXML
	private void addAsignatura() throws IOException {
		AsignaturaDAO asig = new AsignaturaDAO();
		Asignatura a = this.tableAsig.getSelectionModel().getSelectedItem();

		try {
			String nombre2 = nombreTF.getText();
			asig.creaAsignatura(new Asignatura(nombre2));
			this.observAsig.add(new Asignatura(asig.idParaLaLista(AsignaturaDAO.name2), nombre2));
			this.idTF.setText("");
			this.nombreTF.setText("");
		} catch (Exception e) {
			Utils.alertAdd("Error", null, "Formato incorrecto");
		}

	}

	/**
	 * Metodo que elimina una asignatura por id de la asignatura
	 * 
	 * @throws IOException
	 */
	@FXML
	private void deleteAsignatura() throws IOException {
		AsignaturaDAO asig = new AsignaturaDAO();
		Asignatura a = this.tableAsig.getSelectionModel().getSelectedItem();
		if (a == null) {
			Utils.alertAdd("Error", null, "Debes seleccionar una asignatura");
		} else {
			try {
				int id2 = Integer.parseInt(idTF.getText());
				String nombre2 = nombreTF.getText();
				asig.borraAsignatura(new Asignatura(id2, nombre2));
				this.observAsig.remove(new Asignatura(id2, nombre2));
				this.idTF.setText("");
				this.nombreTF.setText("");
			} catch (Exception e) {
				Utils.alertAdd("Error", null, "Formato incorrecto");
			}
		}

	}

	/**
	 * Metodo que nos permite cambiar la información del elemento seleccionado en la
	 * tabla y en nuestra base de datos
	 * 
	 * @throws IOException
	 */
	@FXML
	private void modificarAsignatura() throws IOException {
		AsignaturaDAO asig = new AsignaturaDAO();
		Asignatura a = this.tableAsig.getSelectionModel().getSelectedItem();
		if (a == null) {
			Utils.alertAdd("Error", null, "Debes seleccionar una asignatura");
		} else {
			try {
				int aux2 = a.getId();
				int id2 = Integer.parseInt(idTF.getText());
				String nombre2 = nombreTF.getText();

				Asignatura aux = new Asignatura(id2, nombre2);
				a.setNombre(aux.getNombre());
				asig.modificaAsignatura(a, aux2);

				this.tableAsig.refresh();
			} catch (NumberFormatException e) {
				Utils.alertAdd("Error", null, "Formato incorrecto");

			}

		}
	}

	/**
	 * Metodo que llama a configura tabla y recoge todo lo que tenemos en la lista y
	 * lo añade a la tabla
	 */
	@FXML
	protected void initialize() {
		AsignaturaDAO as = new AsignaturaDAO();
		this.configuraTabla();
		observAsig = FXCollections.observableArrayList(as.getall());
		tableAsig.setItems(observAsig);
	}

	/**
	 * Configura las columnas del tableView para mostrar el nombre de las
	 * asignaturas
	 */
	private void configuraTabla() {
		columAsig.setCellValueFactory(Asignatura -> {
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(Asignatura.getValue().getNombre());
			return ssp;
		});

	}

	/**
	 * Este metodo setea los elementos de javafx que tenemos en nuestra inertface y
	 * les pasa los datos de nuestra tabla al clicar
	 * 
	 * @param event recibe una accion con el raton en la tabla
	 */
	@FXML
	protected void seleccionar(MouseEvent event) {
		Asignatura a = this.tableAsig.getSelectionModel().getSelectedItem();
		if (a != null) {
			this.idTF.setText(a.getId() + "");
			this.nombreTF.setText(a.getNombre());
			this.aa = a.getId();
		}
	}

	/**
	 * Cambia de escena a la secundaria
	 * 
	 * @throws IOException
	 */
	@FXML
	private void switchToSecondary() throws IOException {
		Asignatura a = this.tableAsig.getSelectionModel().getSelectedItem();
		if (a != null) {
			App.setRoot("secondary");
		}

	}

}
