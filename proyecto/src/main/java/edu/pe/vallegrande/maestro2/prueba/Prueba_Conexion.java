package edu.pe.vallegrande.maestro2.prueba;

import java.sql.Connection;
import java.sql.SQLException;

import edu.pe.vallegrande.maestro2.db.AccesoDB;

public class Prueba_Conexion {
	
	public static void main(String[] args) {
		try {
			Connection cn = AccesoDB.getConnection();
			System.out.println("Conexión Exitosa");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
}
