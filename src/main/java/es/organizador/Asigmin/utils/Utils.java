package es.organizador.Asigmin.utils;

import java.io.IOException;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Utils {

/**
 * Metodo qeu muestra un mensage de alerta sobre algun error
 * @param titulo nombre de la alerta
 * @param header cabezera de la alerta
 * @param content informacion que muestra la alerta
 * @throws IOException
 */
	public static void alertAdd(String titulo, String header, String content) throws IOException {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(titulo);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.show();
		Stage s = (Stage) alert.getDialogPane().getScene().getWindow();
		s.toFront();
	}

}
