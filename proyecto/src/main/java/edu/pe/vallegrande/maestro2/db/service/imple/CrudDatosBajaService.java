package edu.pe.vallegrande.maestro2.db.service.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;

import edu.pe.vallegrande.maestro2.db.AccesoDB;
import edu.pe.vallegrande.maestro2.db.service.spec.CrudServiceSpec;
import edu.pe.vallegrande.maestro2.model.bienes;


public class CrudDatosBajaService implements CrudServiceSpec<bienes> {

	
	@Override
	public List<bienes> getInactive() {
		List<bienes> lista = new ArrayList<>();
		Connection cn = null;
		bienes rec = null;
		try {
			cn = AccesoDB.getConnection();
			String sql = "SELECT " + "c.id_contabilidad, " + "a.id_date, " + "d.id_depre, " + "c.code, " + "c.detail, "
					+ "c.value_book, " + "c.amount, " + "c.porcentaje, " + "a.date_admi, " + "d.depre_admi, "
					+ "((c.value_book * porcentaje) / 100) AS depreciacion_anual, "
					+ "((c.value_book * porcentaje / 100) / 12) AS depreciacion_mensual, "
					+ "SUM((c.value_book * c.porcentaje / 100)) OVER (PARTITION BY c.id_contabilidad ORDER BY a.date_admi) AS depreciacion_acumulada, " + "c.status "
					+ "FROM contabilidad c " + "JOIN date_admision a ON c.id_date = a.id_date "
					+ "JOIN date_depreciaton d ON c.id_depre = d.id_depre " + "WHERE c.status = 'BAJA'";

			PreparedStatement pstm = cn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				rec = new bienes();
				rec.setId_contabilidad(rs.getInt("id_contabilidad"));
				rec.setId_date(rs.getInt("id_date"));
				rec.setId_depre(rs.getInt("id_depre"));
				rec.setCode(rs.getString("code"));
				rec.setDetail(rs.getString("detail"));
				rec.setValue_book(rs.getDouble("value_book"));
				rec.setAmount(rs.getInt("amount"));
				rec.setPorcentaje(rs.getDouble("porcentaje"));
				java.sql.Date sqlDate = rs.getDate("depre_admi");
				if (sqlDate != null) {
					rec.setdepre_admi(sqlDate.toLocalDate());
				}
				java.sql.Date sqlDat = rs.getDate("date_admi");
				if (sqlDate != null) {
					rec.setdate_admi(sqlDat.toLocalDate());
				}
				rec.setDepreciacion_anual(rs.getDouble("depreciacion_anual"));
				rec.setDepreciacion_mensual(rs.getDouble("Depreciacion_mensual"));
				rec.setDepreciacion_acumulada(rs.getDouble("Depreciacion_acumulada"));
				rec.setStatus(rs.getString("status"));
				lista.add(rec);
			}
			rs.close();
			pstm.close();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} catch (Exception e) {
			throw new RuntimeException("Error en el proceso");
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return lista;
	}

	@Override
	public String getCSVData() {
		List<bienes> registros = getInactive();
		StringBuilder csvData = new StringBuilder();
		csvData.append("ID,IDadmi,IDdepre,Codigo,Detalles,Valor,Cantidad,Porcentaje,F.Admision,F.Depreciación,Anual,Mensual,Acumulada,Estado\n");

		for (bienes bienes : registros) {
			csvData.append(String.format("%d,%d,%d,%s,%s,%s,%d,%s,%s,%s,%s,%s,%s,%s\n", 
			bienes.getId_contabilidad(),
			bienes.getId_date(),
			bienes.getId_depre(), 
			bienes.getCode(), 
			bienes.getDetail(), 
			bienes.getValue_book(),
			bienes.getAmount(),
			bienes.getPorcentaje(),
			bienes.getdate_admi(),
			bienes.getdepre_admi(),
			bienes.getDepreciacion_anual(),
			bienes.getDepreciacion_mensual(),
			bienes.getDepreciacion_acumulada(),
			bienes.getStatus()));

		}

		return csvData.toString();
	}

	@Override
	public HSSFWorkbook getXLSData() {
		HSSFWorkbook workbook = new HSSFWorkbook(); // Inicializar el objeto HSSFWorkbook

		HSSFSheet sheet = workbook.createSheet("Bienes");

		// Crear encabezados
		HSSFRow headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("ID");
		headerRow.createCell(1).setCellValue("IDAdmi");
		headerRow.createCell(2).setCellValue("IDDepre");
		headerRow.createCell(3).setCellValue("Codigo");
		headerRow.createCell(4).setCellValue("Detalle");
		headerRow.createCell(5).setCellValue("Valor");
		headerRow.createCell(6).setCellValue("Cantidad");
		headerRow.createCell(7).setCellValue("Porcentaje");
		headerRow.createCell(8).setCellValue("Fecha_Admi");
		headerRow.createCell(9).setCellValue("Fecha_Depre");
		headerRow.createCell(10).setCellValue("D.Anual");
		headerRow.createCell(11).setCellValue("D.Mensual");
		headerRow.createCell(12).setCellValue("D.Acumulada");
		headerRow.createCell(13).setCellValue("Estado");

		// Llenar los datos
		int rowNum = 1;
		List<bienes> bienes = getInactive(); // Obtener los bienes
		for (bienes bien : bienes) {
			HSSFRow row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(bien.getId_contabilidad());
			row.createCell(1).setCellValue(bien.getId_date());
			row.createCell(2).setCellValue(bien.getId_depre());
			row.createCell(3).setCellValue(bien.getCode());
			row.createCell(4).setCellValue(bien.getDetail());
			row.createCell(5).setCellValue(bien.getValue_book());
			row.createCell(6).setCellValue(bien.getAmount());
			row.createCell(7).setCellValue(bien.getPorcentaje());
			row.createCell(8).setCellValue(bien.getdate_admi());
			row.createCell(9).setCellValue(bien.getdepre_admi());
			row.createCell(10).setCellValue(bien.getDepreciacion_anual());
			row.createCell(11).setCellValue(bien.getDepreciacion_mensual());
			row.createCell(12).setCellValue(bien.getDepreciacion_acumulada());
			row.createCell(13).setCellValue(bien.getStatus());
		}

		return workbook;
	}

	@Override
	public void getPDFData(Document document) throws DocumentException {
		// Obtener los datos para el informe (puedes usar tu lógica específica)
		List<bienes> bienes = getInactive();

		// Puedes personalizar el contenido según tus necesidades
		for (bienes bien : bienes) {
			// Agregar información de los bienes al documento
			document.add(new Paragraph("ID: " + bien.getId_contabilidad()));
			document.add(new Paragraph("IDAdmi: " + bien.getId_date()));
			document.add(new Paragraph("IDDepre: " + bien.getId_depre()));
			document.add(new Paragraph("Codigo: " + bien.getCode()));
			document.add(new Paragraph("Detalles: " + bien.getDetail()));
			document.add(new Paragraph("Valor: " + bien.getValue_book()));
			document.add(new Paragraph("Cantidad: " + bien.getAmount()));
			document.add(new Paragraph("Porcentaje: " + bien.getPorcentaje()));
			document.add(new Paragraph("F.Admi: " + bien.getdate_admi()));
			document.add(new Paragraph("F.Depre: " + bien.getdepre_admi()));
			document.add(new Paragraph("D.Anual: " + bien.getDepreciacion_anual()));
			document.add(new Paragraph("D.Mensual: " + bien.getDepreciacion_mensual()));
			document.add(new Paragraph("D.Acumulada: " + bien.getDepreciacion_acumulada()));
			document.add(new Paragraph("Estado: " + bien.getStatus()));
			document.add(new Paragraph("")); 
		}
	}

	@Override
	public List<bienes> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<bienes> get(bienes bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<bienes> getInactiveSearch(bienes bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public bienes update(bienes bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public bienes insertSale(bienes bean) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void restore(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
