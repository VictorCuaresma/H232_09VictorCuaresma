package edu.pe.vallegrande.maestro2.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import edu.pe.vallegrande.maestro2.db.service.imple.CrudBienService;


@WebServlet("/ExportarDatos")
public class DatosController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // Obtener el tipo de exportación deseado (CSV o XLS) desde el parámetro de la solicitud
        String exportType = request.getParameter("exportType");

        // Establecer el tipo de contenido de la respuesta
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=productos." + exportType);

     // Obtener el flujo de salida de la respuesta
        OutputStream out = response.getOutputStream();

        try {
            // Lógica para exportar datos según el tipo seleccionado
            if ("csv".equalsIgnoreCase(exportType)) {
                // Exportar a CSV
                exportCSV(out);
            } else if ("xls".equalsIgnoreCase(exportType)) {
                // Exportar a XLS
                exportXLS(out);
            } else if ("pdf".equalsIgnoreCase(exportType)) {
                // Exportar a PDF
                exportPDF(out);
            } else {
                response.getWriter().println("Tipo de exportación no válido.");
            }
        } finally {
            out.flush();
            out.close();
        }
    }

    private void exportPDF(OutputStream out) throws IOException {
        // Obtener el documento PDF utilizando tu lógica específica
        Document document = new Document();

        try {
            // Crear un escritor PDF
            PdfWriter writer = PdfWriter.getInstance(document, out);
            document.open();
            document.add(new Paragraph("Informe de Bienes del Area de Contabilidad"));

            // Agrega el contenido real del informe
            new CrudBienService().getPDFData(document);

            document.close();
            
            writer.close();
        } catch (DocumentException e) {
            e.printStackTrace();
            // Manejar errores de iText o IOException
        }
    }

    private void exportCSV(OutputStream out) {
    	
        try {
            String csvData = new CrudBienService().getCSVData();
            out.write(csvData.getBytes());
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }

    private void exportXLS(OutputStream out) {
        try {
            HSSFWorkbook workbook = new CrudBienService().getXLSData();
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }
}
