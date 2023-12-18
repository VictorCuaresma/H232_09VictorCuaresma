package edu.pe.vallegrande.maestro2.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.pe.vallegrande.maestro2.db.service.imple.CrudBienService;
import edu.pe.vallegrande.maestro2.model.bienes;

@WebServlet("/UpdateBien")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			int id_contabilidad = Integer.parseInt(request.getParameter("id_contabilidad"));
			int id_date = Integer.parseInt(request.getParameter("id_date"));
			int id_depre = Integer.parseInt(request.getParameter("id_depre"));
			String detail = request.getParameter("detail");
			Double value_book = Double.parseDouble(request.getParameter("value_book"));
		    Double porcentaje = Double.parseDouble(request.getParameter("porcentaje"));
			String dateString = request.getParameter("date_admi");
			String depreString = request.getParameter("depre_admi");
			// Validar que los parámetros no sean nulos
			if (detail != null && value_book != null && porcentaje != null && dateString != null
					&& depreString != null) {
				// Convertir la cadena de date_admi y depre_admi a un objeto LocalDate
				LocalDate admi = null;
				LocalDate depre = null;
				try {
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					admi = LocalDate.parse(dateString, formatter);
				} catch (DateTimeParseException e) {
					// Manejar la excepción de análisis de fecha
					e.getMessage(); 
				}
				try {
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					depre = LocalDate.parse(depreString, formatter);
				} catch (DateTimeParseException e) {
					// Manejar la excepción de análisis de fecha
					e.getMessage(); 
				}

				if (admi != null && depre != null) {
					bienes updated = new bienes();
					updated.setId_contabilidad(id_contabilidad);
					updated.setId_date(id_date);
					updated.setId_depre(id_depre);
					updated.setDetail(detail);
					updated.setValue_book(value_book);
					updated.setPorcentaje(porcentaje);
					updated.setdate_admi(admi);
					updated.setdepre_admi(depre);

					CrudBienService Service = new CrudBienService();
					Service.update(updated);

					request.getSession().setAttribute("registroEditado", true);

					response.sendRedirect("Listar");
				} else {
					// Manejar el caso en que la fecha de cumpleaños es nula
					response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Fecha no válida");
				}
			} else {
				// Manejar el caso en que alguno de los parámetros es nulo
				response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Parámetros incompletos o nulos");
			}
		} catch (NumberFormatException e) {
			// Manejar el caso en que la conversión a entero falla
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Error al convertir a entero");
		} catch (RuntimeException e) {
			// Manejar otras excepciones
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al actualizar el bien");
		}
	}
}
