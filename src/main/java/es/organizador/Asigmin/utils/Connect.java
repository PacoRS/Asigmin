package es.organizador.Asigmin.utils;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlTransient;

public class Connect {
	   protected String server;
	    protected String database;
	    protected String username;
	    protected String password;

	    @XmlTransient
	    private static Connection con;
	    @XmlTransient
	    private String file = "conexion.xml";
	    @XmlTransient
	    private static Connect _instance;

	    private Connect() {
	    	//cargamos los datos de la conexion del xml
	    	DatosConexion dc=load();
	    	//Establecemos la conexion
	        try {
	            	          
	            con = DriverManager.getConnection(dc.getServer()+"/"+dc.getDatabase(),dc.getUsername(), dc.getPassword());
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            con=null;
	            System.out.println("connect");
	        }
	    }

	    public static Connection getConnect() {
	        if(_instance==null) {
	            _instance = new Connect();
	        }
	        return con;
	    }

	    public void loadFile() {
	        JAXBContext c;
	        try {
	            c=JAXBContext.newInstance(Connect.class);
	            Unmarshaller m = c.createUnmarshaller();
	            Connect newR= (Connect) m.unmarshal (new File(file));
	            _instance=newR;
	        } catch (Exception e) {
	            // TODO: handle exception
	        }
	    }
	    
	    public DatosConexion load() {
	        DatosConexion DatosCon=new DatosConexion();
	        JAXBContext c;
	        try {
	            c=JAXBContext.newInstance(DatosConexion.class);
	            Unmarshaller m = c.createUnmarshaller();
	            DatosConexion newR= (DatosConexion) m.unmarshal (new File(file));
	            DatosCon=newR;
	        } catch (Exception e) {
	            // TODO: handle exception
	        	System.out.println("load");
	        }
	        return DatosCon;
	    }
}
