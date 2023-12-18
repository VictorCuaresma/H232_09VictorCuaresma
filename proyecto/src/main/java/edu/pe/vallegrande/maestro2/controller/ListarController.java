package edu.pe.vallegrande.maestro2.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.pe.vallegrande.maestro2.db.service.imple.CrudBienService;
import edu.pe.vallegrande.maestro2.model.bienes;


@WebServlet({ "/Listar","/Inactivos"})
public class ListarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		switch (path) {
		case "/Listar":
			listar(request, response);
			break;
		case "/Inactivos":
			Inactivos(request, response);
			break;
		}
	}

	private void Inactivos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Variables
	    String destino;

	    // Proceso de listado de productos inactivos
	    CrudBienService service = new CrudBienService();
	    List<bienes> bienes = service.getInactive();

	    // Establece la lista de productos inactivos como un atributo en la solicitud
	    request.setAttribute("bienes", bienes);

	    // Aquí puedes definir la página JSP de destino (por ejemplo, "productosInactivos.jsp")
	    destino = "Inactivos.jsp";

	    // Redirección a la página JSP de destino
	    RequestDispatcher rd = request.getRequestDispatcher(destino);
	    rd.forward(request, response);
	}




	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Variables
		String destino;

		// Proceso de listado
		CrudBienService service = new CrudBienService();
		List<bienes> bienes = service.getAll();

		// Establece la lista de productos como un atributo en la solicitud
		request.setAttribute("bienes", bienes);

		// Aquí puedes definir la página JSP de destino
		destino = "crudBien.jsp";

		// Redirección a la página JSP de destino
		RequestDispatcher rd = request.getRequestDispatcher(destino);
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
