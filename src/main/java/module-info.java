module es.organizador.Asigmin {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.xml.bind;
	requires java.sql;
	requires transitive java.desktop;
	requires javafx.graphics;
	requires javafx.base;

	opens es.organizador.Asigmin to javafx.fxml, java.xml.bind;
	opens es.organizador.Asigmin.utils to java.xml.bind;

	exports es.organizador.Asigmin;
}
