package edu.pe.vallegrande.maestro2.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.pe.vallegrande.maestro2.db.service.imple.CrudBienService;
import edu.pe.vallegrande.maestro2.model.bienes;

@WebServlet({ "/InsertBien" })
public class InsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		switch (path) {
		case "/InsertBien":
			try {
				insertBien(request, response);
			} catch (IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
	}

	private void insertBien(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException, SQLException {
	    String code = request.getParameter("code");
	    String detail = request.getParameter("detail");
	    Double value_book = Double.parseDouble(request.getParameter("value_book"));
	    Double porcentaje = Double.parseDouble(request.getParameter("porcentaje"));
	    
	    String admiString = request.getParameter("date_admi");
	    LocalDate localadmi = LocalDate.parse(admiString);
	    
	    String depreString = request.getParameter("depre_admi");
	    LocalDate depreadmi = LocalDate.parse(depreString);
	    
	    // Configurar el objeto client con LocalDate
	    bienes newBien = new bienes();
	    newBien.setCode(code);
	    newBien.setDetail(detail);
	    newBien.setValue_book(value_book);
	    newBien.setPorcentaje(porcentaje);

	    // Configurar el campo date_admi utilizando el método setDate_admi(LocalDate)
	    newBien.setdate_admi(localadmi);
	    
	 // Configurar el campo depre_admi utilizando el método setDepre_admi(LocalDate)
	    newBien.setdepre_admi(depreadmi);

	    CrudBienService service = new CrudBienService();
	    service.insertSale(newBien);

	    request.getSession().setAttribute("registroCreado", true);

	    response.sendRedirect("Listar");
	}
}