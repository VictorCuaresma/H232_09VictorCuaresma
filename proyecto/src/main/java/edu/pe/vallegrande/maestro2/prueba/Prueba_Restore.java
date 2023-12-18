package edu.pe.vallegrande.maestro2.prueba;

import edu.pe.vallegrande.maestro2.db.service.imple.CrudBienService;


public class Prueba_Restore {

	public static void main(String[] args) {
	    try {
	        CrudBienService service = new CrudBienService();

	        // Supongamos que deseas restaurar el registro con ID 1
	        Integer clientIdToRestore = 3;

	        // Llamar al método de restauración
	        service.restore(clientIdToRestore);

	        System.out.println("Restauración de registro con éxito.");
	    } catch (RuntimeException e) {
	        // Captura excepciones específicas para manejarlas de manera diferente si es necesario
	        e.printStackTrace();
	        System.err.println("Error al restaurar el registro: " + e.getMessage());
	    } catch (Exception e) {
	        // Manejo genérico de excepciones
	        e.printStackTrace();
	        System.err.println("Error inesperado: " + e.getMessage());
	    }
	}

}