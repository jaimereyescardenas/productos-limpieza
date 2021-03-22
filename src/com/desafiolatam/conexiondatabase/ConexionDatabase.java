package com.desafiolatam.conexiondatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDatabase {
	
	private static final String DRIVER = "oracle.jdbc.oracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME = "desafiolatam";
	private static final String PASSWORD = "desafiolatam";
	
	private static Connection conexion = null;
	
	private static void crearConexion() {
		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection obtenerConexion() {
		
		if (conexion == null) {
			crearConexion();
		}
		return conexion;
		
	}

}
