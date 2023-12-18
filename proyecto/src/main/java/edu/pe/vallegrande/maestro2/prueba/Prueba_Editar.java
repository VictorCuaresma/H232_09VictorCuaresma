package edu.pe.vallegrande.maestro2.prueba;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import edu.pe.vallegrande.maestro2.db.service.imple.CrudBienService;
import edu.pe.vallegrande.maestro2.model.bienes;

public class Prueba_Editar {

	public static void main(String[] args) {
	    try {
	        // Datos del bien a actualizar (excepto el ID)
	        bienes updateBienes = new bienes();
	        updateBienes.setId_contabilidad(3); // Configura el ID del bien que deseas actualizar
	        updateBienes.setId_date(3); // Configura el ID de la fecha de admisión que deseas actualizar
	        updateBienes.setId_depre(3); // Configura el ID de la depreciación que deseas actualizar
	        updateBienes.setCode("EQ-003");
	        updateBienes.setDetail("PC Gamer");
	        updateBienes.setValue_book(2000.0);
	        updateBienes.setPorcentaje(0.25); // Configura el nuevo porcentaje

	        // Configura la nueva fecha de admisión
	        try {
	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	            LocalDate newDateAdmission = LocalDate.parse("2023-08-20", formatter);
	            updateBienes.setdate_admi(newDateAdmission);
	        } catch (DateTimeParseException e) {
	            e.printStackTrace();
	        }

	        // Configura la nueva fecha de depreciación
	        try {
	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	            LocalDate newDepreciationDate = LocalDate.parse("2023-12-31", formatter);
	            updateBienes.setdepre_admi(newDepreciationDate);
	        } catch (DateTimeParseException e) {
	            e.printStackTrace();
	        }

	        // Servicio para actualizar el bien
	        CrudBienService service = new CrudBienService();

	        // Actualizar el bien
	        bienes updatedBienes = service.update(updateBienes);

	        if (updatedBienes != null) {
	            System.out.println("Bien actualizado con ID de contabilidad: " + updatedBienes.getId_contabilidad());
	        } else {
	            System.out.println("No se pudo actualizar el bien.");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.err.println("Error: " + e.getMessage());
	    }
	}
}