package es.organizador.Asigmin;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;

import es.organizador.Asigmin.model.Asignatura;
import es.organizador.Asigmin.model.Entrada;
import es.organizador.Asigmin.modelDAO.AsignaturaDAO;
import es.organizador.Asigmin.modelDAO.EntradaDAO;
import es.organizador.Asigmin.utils.Utils;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class SecondaryController {
	@FXML
	private TextField idTF;
	@FXML
	private TextField tituloTF;
	@FXML
	private CheckBox recordatorioCB;
	@FXML
	private CheckBox estadoCB;
	@FXML
	private DatePicker frecordatorioDP;
	@FXML
	private DatePicker fcreacionDP;
	@FXML
	private TextArea contenidoTA;
	@FXML
	private TableView<Entrada> tableEntradas;
	@FXML
	private TableColumn<Entrada, String> columEntradas;

	private ObservableList<Entrada> observEntradas;
	private List<Entrada> listEntradas;

	/**
	 * Constructor donde inicialisamos la lista y se la pasamos a la ObservableList
	 */
	public SecondaryController() {
		listEntradas = new ArrayList<>();
		observEntradas = FXCollections.observableArrayList(listEntradas);
	}

	/**
	 * Metodo que elimina una entrada por id de la entrada
	 * 
	 * @throws IOException
	 */
	@FXML
	private void addEntrada() throws IOException {

		DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("uuu-MM-dd")
				.parseDefaulting(ChronoField.HOUR_OF_DAY, 0).parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
				.parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0).toFormatter();

		EntradaDAO ent = new EntradaDAO();
		Entrada e = this.tableEntradas.getSelectionModel().getSelectedItem();

		try {
			String titulo2 = tituloTF.getText();
			LocalDateTime fechaCreacion2 = LocalDateTime.parse(this.fcreacionDP.getValue().toString(), formatter);
			LocalDateTime fechaRecordaorio2 = LocalDateTime.parse(this.frecordatorioDP.getValue().toString(),
					formatter);
			Boolean recordatorio2 = conviertecheckboxBoolean(recordatorioCB);
			Boolean estado2 = conviertecheckboxBoolean(estadoCB);
			String contenido2 = contenidoTA.getText();
			ent.creaEntrada(new Entrada(titulo2, fechaCreacion2, recordatorio2, contenido2, fechaRecordaorio2, estado2,
					PrimaryController.aa));
			this.observEntradas.add(new Entrada(ent.idParaLaLista(EntradaDAO.name), titulo2, fechaCreacion2,
					recordatorio2, contenido2, fechaRecordaorio2, estado2, PrimaryController.aa));

			this.idTF.setText("");
			this.tituloTF.setText("");
			this.recordatorioCB.setText("");
			this.estadoCB.setText("");
			this.frecordatorioDP.setValue(null);
			this.fcreacionDP.setValue(null);
			this.contenidoTA.setText("");
		} catch (Exception e2) {
			Utils.alertAdd("Error", null, "Formato incorrecto");
		}
	}

	/**
	 * Metodo que elimina una entrada esta recoge la informacion al clicar en la
	 * tabla
	 * 
	 * @throws IOException
	 */
	@FXML
	private void deleteEntrada() throws IOException {
		DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("uuu-MM-dd")
				.parseDefaulting(ChronoField.HOUR_OF_DAY, 0).parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
				.parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0).toFormatter();

		EntradaDAO ent = new EntradaDAO();
		Entrada e = this.tableEntradas.getSelectionModel().getSelectedItem();

		if (e == null) {
			Utils.alertAdd("Error", null, "Debes seleccionar una entrada");
		} else {
			try {
				int id2 = Integer.parseInt(idTF.getText());
				String titulo2 = tituloTF.getText();
				LocalDateTime fechaCreacion2 = LocalDateTime.parse(this.fcreacionDP.getValue().toString(), formatter);
				LocalDateTime fechaRecordaorio2 = LocalDateTime.parse(this.frecordatorioDP.getValue().toString(),
						formatter);
				Boolean recordatorio2 = conviertecheckboxBoolean(recordatorioCB);
				Boolean estado2 = conviertecheckboxBoolean(estadoCB);
				String contenido2 = contenidoTA.getText();
				ent.borraEntrada(new Entrada(id2, titulo2, fechaCreacion2, recordatorio2, contenido2, fechaRecordaorio2,
						estado2, PrimaryController.aa));
				this.observEntradas.remove(new Entrada(id2, titulo2, fechaCreacion2, recordatorio2, contenido2,
						fechaRecordaorio2, estado2, PrimaryController.aa));

			} catch (Exception e2) {
				Utils.alertAdd("Error", null, "Formato incorrecto");
			}
		}

	}

	/**
	 * Metodo que nos permite cambiar la información del elemento seleccionado en la
	 * tabla y en la base de datos
	 * 
	 * @throws IOException
	 */
	@FXML
	private void modificarEntrada() throws IOException {
		EntradaDAO asig = new EntradaDAO();
		Entrada e = this.tableEntradas.getSelectionModel().getSelectedItem();
		if (e == null) {
			Utils.alertAdd("Error", null, "Debes seleccionar una entrada");
		} else {
			try {
				int aux2 = e.getId();
				System.out.println(aux2);
				DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("uuu-MM-dd")
						.parseDefaulting(ChronoField.HOUR_OF_DAY, 0).parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
						.parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0).toFormatter();

				EntradaDAO ent = new EntradaDAO();
				int id2 = Integer.parseInt(idTF.getText());
				String titulo2 = tituloTF.getText();
				LocalDateTime fechaCreacion2 = LocalDateTime.parse(this.fcreacionDP.getValue().toString(), formatter);
				LocalDateTime fechaRecordaorio2 = LocalDateTime.parse(this.frecordatorioDP.getValue().toString(),
						formatter);
				Boolean recordatorio2 = conviertecheckboxBoolean(recordatorioCB);
				Boolean estado2 = conviertecheckboxBoolean(estadoCB);
				String contenido2 = contenidoTA.getText();

				Entrada aux = new Entrada(id2, titulo2, fechaCreacion2, recordatorio2, contenido2, fechaRecordaorio2,
						estado2, PrimaryController.aa);

				e.setTitulo(aux.getTitulo());
				e.setFechaCreacion(aux.getFechaCreacion());
				e.setFechaRecordatorio(aux.getFechaRecordatorio());
				e.setRecordatorio(aux.isRecordatorio());
				e.setEstado(aux.isEstado());
				e.setContenido(aux.getContenido());
				asig.modificaEntrada(e, aux2);

				this.tableEntradas.refresh();

			} catch (NumberFormatException a) {

				Utils.alertAdd("Error", null, "Formato incorrecto");
			}

		}
	}

	/**
	 * Este metodo llama a los metodos necesarios para rellenar la tabla
	 */
	@FXML
	protected void initialize() throws IOException {
		
		LocalDateTime lc = LocalDateTime.now();
		
		EntradaDAO as = new EntradaDAO();
		// TODO Auto-generated method stub
		this.configuraTabla();
		observEntradas = FXCollections.observableArrayList(as.getall());
		tableEntradas.setItems(observEntradas);
		for (Entrada entrada : observEntradas) {
			if (entrada.isRecordatorio() == true && entrada.getFechaRecordatorio().equals(lc)) {
				Utils.alertAdd("Error", null, "Hoy es el dia de tu recordatorio de la entrada --> "+entrada.getTitulo());
				
			}
		}
	}

	/**
	 * Define y setea las columnas que hay en nuestra tabla
	 */
	private void configuraTabla() {
		// TODO Auto-generated method stub

		columEntradas.setCellValueFactory(Entrada -> {
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(Entrada.getValue().getTitulo());
			return ssp;
		});

	}

	/**
	 * Metodo que no permite recoger la información de una entrada al clicar en la
	 * tabla donde solo aparece el nombre y esta mostrarla en los elementos de
	 * javafx
	 * 
	 * @param event
	 */
	@FXML
	protected void seleccionar(MouseEvent event) {
		Entrada a = this.tableEntradas.getSelectionModel().getSelectedItem();
		if (a != null) {
			this.idTF.setText(a.getId() + "");
			this.recordatorioCB.setSelected(a.isRecordatorio());
			this.tituloTF.setText(a.getTitulo());
			this.frecordatorioDP.setValue(a.getFechaRecordatorio().toLocalDate());
			this.fcreacionDP.setValue(a.getFechaCreacion().toLocalDate());
			this.estadoCB.setSelected(a.isEstado());
			this.contenidoTA.setText(a.getTitulo());

		}
	}

	/**
	 * Este metodo devuelve true o false en función de la información recibida del
	 * CheckBox
	 * 
	 * @param ch
	 * @return true si el CheckBox esta seleccionado ,false si el CheckBox esta
	 *         deseleccionado
	 */
	@FXML
	private boolean conviertecheckboxBoolean(CheckBox ch) {
		boolean valid = false;
		if (ch.isSelected()) {
			valid = true;
		} else {
			valid = false;
		}
		return valid;
	}

	/**
	 * Metodo que permite volver a la escena primaria
	 * 
	 * @throws IOException
	 */
	@FXML
	private void volver() throws IOException {
		App.setRoot("primary");
	}
}
