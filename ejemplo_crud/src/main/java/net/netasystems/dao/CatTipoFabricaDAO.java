package net.netasystems.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.netasystems.domain.CatTipoFabrica;

/**
 * @author NetaSystems / Jose Alberto Fuentes Loredo
 *
 *En esta clase se hace la conexion a la BD y se realizan los SELECT, UPDATE, INSERT y DELETE
 */
public class CatTipoFabricaDAO { 
	
/**
 * Declaracion de variable privada
 */
private Connection con;
	
	/**
	 * Conexion para la BD
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public CatTipoFabricaDAO() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(  
				"jdbc:oracle:thin:@198.23.75.98:1521:neta","EGLOBAL","egl0b4l");  
	}
	
	public void destroy() throws SQLException {
		con.close();
	}
	
	/**
	 * Se realiza un SELECT en la BD 
	 * @return Retorna la informacion solicitada
	 * @throws SQLException
	 */
	public List<CatTipoFabrica> getAllRecords() throws SQLException{
		List<CatTipoFabrica> lista = new ArrayList<CatTipoFabrica>();
		String sql = "select IDCATTIPOFABRICA, NOMBRE, ESTATUS, FECHAMODIFICACION, IDUSUARIO from CAT_TIPO_FABRICA";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			long idCatTipoFabrica = rs.getLong("IDCATTIPOFABRICA");
			String nombre = rs.getString("NOMBRE");
			String estatusString = rs.getString("ESTATUS");
			Date fechaModificacion = rs.getDate("FECHAMODIFICACION");
			Long idUsuario = rs.getLong("IDUSUARIO");
			//Arreglando el char de estatus
			Character status = null;
			if(estatusString != null && !estatusString.isEmpty()) {
				char est = estatusString.charAt(0);
				status = est;
			}
			CatTipoFabrica registro = new CatTipoFabrica(idCatTipoFabrica, nombre, status, fechaModificacion, idUsuario);
			lista.add(registro);
		}
		rs.close();
		stmt.close();
		return lista;
	}
	
	/**
	 * Se realiza un UPDATE en la BD
	 * 
	 * @param record
	 * @return
	 * @throws SQLException
	 */
	public String updateRecord(CatTipoFabrica record) throws SQLException {
		
		String sqlupd = "UPDATE CAT_TIPO_FABRICA SET NOMBRE = ? WHERE NOMBRE= ?";
		PreparedStatement pstmupd;
			pstmupd = con.prepareStatement(sqlupd);
			pstmupd.setString(1, record.getNombre());
			pstmupd.setString(2, record.getNombre());
			pstmupd.executeUpdate(); 
			
			pstmupd.close();
			return sqlupd;
	}
	
	/**
	 * Se realiza un INSERT en la BD
	 * 
	 * @param record
	 * @throws SQLException
	 */
	public void addRecord(CatTipoFabrica record) throws SQLException {
		
		String sqladd = "INSERT INTO CAT_TIPO_FABRICA (IDCATTIPOFABRICA, NOMBRE, ESTATUS, FECHAMODIFICACION, IDUSUARIO) VALUES (?,?,?,?,?)";
		PreparedStatement pstmadd;
		
			pstmadd = con.prepareStatement(sqladd);
			pstmadd.setLong(1,record.getIdCatTipoFabrica());
			pstmadd.setString(2, record.getNombre());
			pstmadd.setString(3, record.getStatus()+"");
			pstmadd.setDate(4, (java.sql.Date) record.getFechaModificacion());
			pstmadd.setLong(5, record.getIdUsuario());
			pstmadd.executeUpdate();
		
			pstmadd.close();	
	}
	
	/**
	 * Se realiza un DELETE en la BD
	 * 
	 * @param record
	 */
	public void deleteRecord(CatTipoFabrica record) {
		
		Statement stmt = con.prepareStatement("DELETE FROM CAT_TIPO_FABRICA");
		int x = stmt.executeUpdate();
		
		stmt.close();
		con.close();
		
	}

}
