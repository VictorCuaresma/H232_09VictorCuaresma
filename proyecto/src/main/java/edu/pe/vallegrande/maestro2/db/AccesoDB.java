package edu.pe.vallegrande.maestro2.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccesoDB{
	
	private AccesoDB() {
		
	}
	public static Connection getConnection()throws SQLException {
		Connection cn = null;
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String urlDB = "jdbc:sqlserver://localhost:1433;databaseName=dbDigital;encrypt=true;TrustServerCertificate=True;";
		String user = "sa";
		String pass = "manuel";
		try {
			//Paso1: Cargar el driver a memoria
			Class.forName(driver).getDeclaredConstructor().newInstance();
			// Paso2: Obtener el objeto Connection 
			cn = DriverManager.getConnection(urlDB, user, pass);
		}catch(SQLException e) {
			throw e;
		}catch (ClassNotFoundException e) {
			throw new SQLException("No se encontro el driver de la base de datos.");
		}catch (Exception e) {
			throw new SQLException("No se puede establecer la conexión con la BD.");
		}
		return cn;
		
	}
}
