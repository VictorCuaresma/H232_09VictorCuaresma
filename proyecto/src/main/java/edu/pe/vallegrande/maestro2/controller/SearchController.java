package edu.pe.vallegrande.maestro2.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.pe.vallegrande.maestro2.db.service.imple.CrudBienService;
import edu.pe.vallegrande.maestro2.model.bienes;


@WebServlet({ "/SearchBien", "/SearchBienInactive" })
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		switch (path) {
		case "/SearchBien":
			searchBien(request, response);
			break;
		case "/SearchBienInactive":
			searchBienInactive(request, response);
			break;	
		}
	}

	private void searchBienInactive(HttpServletRequest request, HttpServletResponse response) {
		try {

			String detail = request.getParameter("detail");
			String code = request.getParameter("code");
			
			bienes bean = new bienes();
			bean.setDetail(detail);
			bean.setCode(code);

			CrudBienService Service = new CrudBienService();
			List<bienes> lista = Service.getInactiveSearch(bean);

			request.setAttribute("bienes", lista);

			request.getRequestDispatcher("Inactivos.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void searchBien(HttpServletRequest request, HttpServletResponse response) {
		try {

			String detail = request.getParameter("detail");
			String code = request.getParameter("code");

			bienes bean = new bienes();
			bean.setDetail(detail);
			bean.setCode(code);

			CrudBienService clientService = new CrudBienService();
			List<bienes> lista = clientService.get(bean);

			request.setAttribute("bienes", lista);

			request.getRequestDispatcher("crudBien.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
