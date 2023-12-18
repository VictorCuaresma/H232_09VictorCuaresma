package edu.pe.vallegrande.maestro2.db.service.spec;

import java.sql.SQLException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;

public interface CrudServiceSpec <T> {
	
	/**
	 * Consulta todos los registros de la tabla
	 * @return Retorna una lista de objetos
	 */
	List<T> getAll();
	
	/**
	 * Consulta todos los registros de la tabla
	 * @return Retorna una lista de objetos
	 */
	List<T> getInactive();
	
	/**
	 * Consulta registros en base a un filtro
	 * @param bean
	 * @return
	 */
	List<T> get (T bean);
	
	/**
	 * Consulta registros en base a un filtro
	 * @param bean
	 * @return
	 */
	List<T> getInactiveSearch (T bean);
			
	/**
	 * El método de modificación se utiliza para actualizar un registro existente en la BD
	 * @param bean
	 * @return
	 */
	T update (T bean );
	
	/**
	 * El método de eliminación se utiliza para borrar un registro de manera logica de la BD
	 * @param id
	 */
	void delete(Integer id);
	/**
	 * El método de restaurar se utiliza para volver activar un registro específico de la BD
	 * @param id
	 */
	void restore(Integer id);
	/**
     * Obtiene los datos necesarios para la exportación en formato CSV.
     * @return Una cadena que representa los datos en formato CSV.
     */
	String getCSVData();
    /**
     * Obtiene los datos necesarios para la exportación en formato XLS.
     * @return Un objeto HSSFWorkbook que representa los datos en formato XLS.
     */
	HSSFWorkbook getXLSData();
    /**
     * Obtiene los datos necesarios para la exportación en formato PDF.
     * @param document El objeto Document al cual agregar datos.
     * @throws DocumentException Si hay un error con el documento.
     */
	void getPDFData(Document document) throws DocumentException;
    /**
     * 
     * @param 
     * @throws 
     */
    T insertSale(T bean)throws SQLException;

	

	

}
