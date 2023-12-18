package edu.pe.vallegrande.maestro2.db.service.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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


public class CrudBienService implements CrudServiceSpec<bienes> {

	@Override
	public List<bienes> get(bienes bean) {
		String detail = "%" + bean.getDetail() + "%";
		String code = "%" + bean.getCode() + "%";
		List<bienes> lista = new ArrayList<>();
		Connection cn = null;
		try {
			cn = AccesoDB.getConnection();
			String sql = "SELECT " +
				    "c.id_contabilidad, " +
				    "a.id_date, " +
				    "d.id_depre, " +
				    "c.code, " +
				    "c.detail, " +
				    "c.value_book, " +
				    "c.amount, " +
				    "c.porcentaje, " +
				    "a.date_admi, " +
				    "d.depre_admi, " +
				    "((c.value_book * c.porcentaje) / 100) AS depreciacion_anual, " +
				    "((c.value_book * c.porcentaje / 100) / 12) AS depreciacion_mensual, " +
				    "((c.value_book * c.porcentaje) / 100) AS depreciacion_acumulada, " +
				    "c.status " +
				    "FROM contabilidad c " +
				    "JOIN date_admision a ON c.id_date = a.id_date " +
				    "JOIN date_depreciaton d ON c.id_depre = d.id_depre " +
				    "WHERE c.status = 'ALTA' AND c.detail LIKE ? AND c.code LIKE ?";
			PreparedStatement pstm = cn.prepareStatement(sql);
			pstm.setString(1, detail);
			pstm.setString(2, code);
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				bienes rec = new bienes();
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
	public List<bienes> getInactiveSearch(bienes bean) {
		String detail = "%" + bean.getDetail() + "%";
		String code = "%" + bean.getCode() + "%";
		List<bienes> lista = new ArrayList<>();
		Connection cn = null;
		try {
			cn = AccesoDB.getConnection();
			String sql = "SELECT " + "c.id_contabilidad, " + "a.id_date, " + "d.id_depre, " + "c.code, " + "c.detail, "
					+ "c.value_book, " + "c.amount, " + "c.porcentaje, " + "a.date_admi, " + "d.depre_admi, "
					+ "((c.value_book * porcentaje) / 100) AS depreciacion_anual, "
					+ "((c.value_book * porcentaje / 100) / 12) AS depreciacion_mensual, "
					+ "((c.value_book * c.porcentaje) / 100) AS depreciacion_acumulada, " + "c.status "
					+ "FROM contabilidad c " + "JOIN date_admision a ON c.id_date = a.id_date "
					+ "JOIN date_depreciaton d ON c.id_depre = d.id_depre "
					+ "WHERE c.status = 'BAJA' AND c.detail LIKE ? AND c.code LIKE ?";

			PreparedStatement pstm = cn.prepareStatement(sql);
			pstm.setString(1, detail);
			pstm.setString(2, code);
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				bienes rec = new bienes();
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
	public bienes update(bienes bean) {
		Connection cn = null;
		PreparedStatement contPstm = null;
		PreparedStatement admiPstm = null;
		PreparedStatement deprePstm = null;

		try {
			cn = AccesoDB.getConnection();
			cn.setAutoCommit(false);

			// Actualizar registro en la tabla contabilidad
			String contaSql = "UPDATE contabilidad SET detail=?, value_book=?, porcentaje=? WHERE id_contabilidad=?";
			contPstm = cn.prepareStatement(contaSql);
			contPstm.setString(1, bean.getDetail());
			contPstm.setDouble(2, bean.getValue_book());
			contPstm.setDouble(3, bean.getPorcentaje());
			contPstm.setInt(4, bean.getId_contabilidad());
			contPstm.executeUpdate();

			// Actualizar registro en la tabla date_admision
			String admiSql = "UPDATE date_admision SET date_admi=? WHERE id_date=?";
			admiPstm = cn.prepareStatement(admiSql);
			// Convertir LocalDate a java.sql.Date
			java.sql.Date sqladmi = (bean.getdate_admi() != null) ? java.sql.Date.valueOf(bean.getdate_admi()) : null;
			admiPstm.setDate(1, sqladmi);
			admiPstm.setInt(2, bean.getId_date());
			admiPstm.executeUpdate();

			// Actualizar registro en la depre_admision
			String depreSql = "UPDATE date_depreciaton SET depre_admi=? WHERE id_depre=?";
			deprePstm = cn.prepareStatement(depreSql);
			// Convertir LocalDate a java.sql.Date
			java.sql.Date sqldepre = (bean.getdepre_admi() != null) ? java.sql.Date.valueOf(bean.getdepre_admi())
					: null;
			deprePstm.setDate(1, sqldepre);
			deprePstm.setInt(2, bean.getId_depre());
			deprePstm.executeUpdate();

			// Confirmar la transacción
			cn.commit();
		} catch (SQLException e) {
			try {
				if (cn != null) {
					cn.rollback();
					cn.setAutoCommit(true);
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
				// Manejar la excepción de rollback según sea necesario
			}

			throw new RuntimeException("Error en el proceso de actualización: " + e.getMessage(), e);
		} finally {
			closeResources(contPstm, null);
			closeResources(admiPstm, null);
			closeResources(deprePstm, null);
			closeConnection(cn);
		}

		return bean;
	}

	@Override
	public bienes insertSale(bienes bean) throws SQLException {
		Connection cn = null;
		String sql = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Integer id = 0;

		try {
			cn = AccesoDB.getConnection();
			cn.setAutoCommit(false);

			// Insertar registro en date_admision
			sql = "INSERT INTO date_admision(date_admi) VALUES(?)";
			try (PreparedStatement aPstm = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				java.sql.Date sqla = (bean.getdate_admi() != null) ? java.sql.Date.valueOf(bean.getdate_admi()) : null;
				aPstm.setDate(1, sqla);
				aPstm.executeUpdate();
				try (ResultSet aRs = aPstm.getGeneratedKeys()) {
					if (aRs.next()) {
						id = aRs.getInt(1);
						bean.setId_date(id);
					} else {
						throw new RuntimeException("No se pudo obtener el ID de la tabla date_admision");
					}
				}
			}

			// Insertar registro en date_depreciaton
			sql = "INSERT INTO date_depreciaton(depre_admi) VALUES(?)";
			try (PreparedStatement dPstm = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				java.sql.Date sqld = (bean.getdepre_admi() != null) ? java.sql.Date.valueOf(bean.getdepre_admi())
						: null;

				dPstm.setDate(1, sqld);
				dPstm.executeUpdate();

				try (ResultSet dRs = dPstm.getGeneratedKeys()) {
					if (dRs.next()) {
						id = dRs.getInt(1);
						bean.setId_depre(id);
					} else {
						throw new RuntimeException("No se pudo obtener el ID de la tabla date_depreciaton");
					}
				}
			}

			// Insertar registro en contabilidad
			sql = "INSERT INTO contabilidad(code, detail, value_book, porcentaje, id_date, id_depre) VALUES(?,?,?,?,?,?)";
			try (PreparedStatement bienPstm = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				bienPstm.setString(1, bean.getCode());
				bienPstm.setString(2, bean.getDetail());
				bienPstm.setDouble(3, bean.getValue_book());
				bienPstm.setDouble(4, bean.getPorcentaje());
				bienPstm.setInt(5, bean.getId_date());
				bienPstm.setInt(6, bean.getId_depre());
				bienPstm.executeUpdate();

				try (ResultSet bienRs = bienPstm.getGeneratedKeys()) {
					if (bienRs.next()) {
						id = bienRs.getInt(1);
						bean.setId_contabilidad(id);
					} else {
						throw new RuntimeException("No se pudo obtener el ID de la tabla contabilidad");
					}
				}
			}

			cn.commit();
		} catch (SQLException e) {
			try {
				if (cn != null) {
					cn.rollback();
				}
			} catch (SQLException e2) {
				// Manejar la excepción de rollback según sea necesario
			}

			throw new RuntimeException("Error en el proceso: " + e.getMessage(), e);
		} finally {
			closeResources(pstm, rs);
			closeConnection(cn);
		}

		return bean;
	}

	private void closeResources(PreparedStatement pstm, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstm != null) {
				pstm.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void closeConnection(Connection cn) {
		try {
			if (cn != null) {
				cn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<bienes> getAll() {
		List<bienes> lista = new ArrayList<>();
		Connection cn = null;
		bienes rec = null;
		try {
			cn = AccesoDB.getConnection();
			String sql = "SELECT " + "c.id_contabilidad, " + "a.id_date, " + "d.id_depre, " + "c.code, " + "c.detail, "
					+ "c.value_book, " + "c.amount, " + "c.porcentaje, " + "a.date_admi, " + "d.depre_admi, "
					+ "((c.value_book * c.porcentaje) / 100) AS depreciacion_anual, "
					+ "((c.value_book * c.porcentaje / 100) / 12) AS depreciacion_mensual, "
					+ "((c.value_book * c.porcentaje) / 100) AS depreciacion_acumulada, " + "c.status "
					+ "FROM contabilidad c " + "JOIN date_admision a ON c.id_date = a.id_date "
					+ "JOIN date_depreciaton d ON c.id_depre = d.id_depre " + "WHERE c.status = 'ALTA'";

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
					+ "((c.value_book * c.porcentaje) / 100) AS depreciacion_acumulada, " + "c.status "
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
	public void delete(Integer id) {
		Connection cn = null;
		try {
			cn = AccesoDB.getConnection();
			String sql = "UPDATE contabilidad SET status = 'BAJA' WHERE id_contabilidad = ?";
			PreparedStatement pstm = cn.prepareStatement(sql);
			pstm.setInt(1, id);

			int affectedRows = pstm.executeUpdate();

			if (affectedRows <= 0) {
				// Puedes lanzar una excepción o manejar de alguna manera si no se actualiza
				// ninguna fila
				throw new RuntimeException("No se pudo encontrar el bien con ID: " + id);
			}

		} catch (SQLException e) {
			// Manejo de excepciones de SQL
			throw new RuntimeException("Error al eliminar lógicamente el bien", e);
		} finally {
			try {
				if (cn != null) {
					cn.close();
				}
			} catch (SQLException e) {
				// Manejo de excepciones de cierre de conexión
				e.printStackTrace();
			}
		}
	}

	@Override
	public void restore(Integer id) {
		Connection cn = null;
		try {
			cn = AccesoDB.getConnection();
			String sql = "UPDATE contabilidad SET status = 'ALTA' WHERE id_contabilidad = ?";
			PreparedStatement pstm = cn.prepareStatement(sql);
			pstm.setInt(1, id);

			int affectedRows = pstm.executeUpdate();

			if (affectedRows <= 0) {
				// Puedes lanzar una excepción o manejar de alguna manera si no se actualiza
				// ninguna fila
				throw new RuntimeException("No se pudo encontrar el bien con ID: " + id);
			}

		} catch (SQLException e) {
			// Manejo de excepciones de SQL
			throw new RuntimeException("Error al eliminar lógicamente el bien", e);
		} finally {
			try {
				if (cn != null) {
					cn.close();
				}
			} catch (SQLException e) {
				// Manejo de excepciones de cierre de conexión
				e.printStackTrace();
			}
		}
	}

	@Override
	public String getCSVData() {
		List<bienes> registros = getAll();
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
		List<bienes> bienes = getAll(); // Obtener los bienes
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
		List<bienes> bienes = getAll();

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

}
