package edu.pe.vallegrande.maestro2.prueba;

import java.util.List;

import edu.pe.vallegrande.maestro2.db.service.imple.CrudBienService;
import edu.pe.vallegrande.maestro2.model.bienes;


public class Prueba_Listar {
	
	public static void main(String[] args) {
		try {
			CrudBienService service = new CrudBienService();
			List<bienes> lista = service.getAll();

			System.out.println("Registros con status = 'A':");
			for (bienes rec : lista) {
				if (rec.getStatus().equals("ALTA")) {
					System.out.println(rec.getId_contabilidad() + " - " + rec.getId_date() + " - " + rec.getId_depre() + " - " + rec.getCode() + " - " +  rec.getDetail() + " - " + rec.getValue_book() + " - " + rec.getAmount() + " - " + rec.getPorcentaje() + " - " + rec.getdate_admi() + " - " + rec.getdepre_admi() + " - " + rec.getDepreciacion_anual() + " - " + rec.getDepreciacion_mensual() + " - " + rec.getDepreciacion_acumulada() + " - " + rec.getStatus());
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
