package edu.pe.vallegrande.maestro2.prueba;

import edu.pe.vallegrande.maestro2.db.service.imple.CrudBienService;


public class Prueba_Delete {

	public static void main(String[] args) {
	    try {
	        CrudBienService service = new CrudBienService();

	        // Supongamos que deseas desactivar el registro con ID 1
	        Integer clientIdToDelete = 10;

	        // Llamar al método de eliminación lógica
	        service.delete(clientIdToDelete);

	        System.out.println("Registro desactivado con éxito.");
	    } catch (RuntimeException e) {
	        // Captura excepciones específicas para manejarlas de manera diferente si es necesario
	        e.printStackTrace();
	        System.err.println("Error al desactivar el registro: " + e.getMessage());
	    } catch (Exception e) {
	        // Manejo genérico de excepciones
	        e.printStackTrace();
	        System.err.println("Error inesperado: " + e.getMessage());
	    }
	}
}