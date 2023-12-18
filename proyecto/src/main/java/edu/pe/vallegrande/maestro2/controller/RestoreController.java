package edu.pe.vallegrande.maestro2.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.pe.vallegrande.maestro2.db.service.imple.CrudBienService;

@WebServlet({ "/Restore" })
public class RestoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recuperar el ID del cliente a restaurar de los parámetros de la URL
        String bienIdParam = request.getParameter("id");

        if (bienIdParam != null && !bienIdParam.isEmpty()) {
            try {
                // Convertir el parámetro a un Integer
                Integer bienId = Integer.parseInt(bienIdParam);

                // Crear una instancia de tu servicio
                CrudBienService service = new CrudBienService();

                // Llamar al método de eliminación lógica
                service.restore(bienId);

                // Redirigir a la página de listado o mostrar un mensaje de éxito
                response.sendRedirect(request.getContextPath() + "/Listar"); 

            } catch (NumberFormatException e) {
                // Manejar error si el parámetro no es un entero válido
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID no válido");
            } catch (RuntimeException e) {
                // Manejar errores específicos de tu servicio
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al restaurar ");
            }
        } else {
            // Manejar el caso en que el parámetro no está presente
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Se requiere el parámetro 'id'");
        }
    }
}
