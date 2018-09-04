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
 */
public class CatTipoFabricaDAO { 
	
/**
 * Se crea una variable para realizar la conexion a la BD
 */
private Connection con;
	/*
	 * Se realiza la conexion a la BD
	 */
	public CatTipoFabricaDAO() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(  
				"jdbc:oracle:thin:@198.23.75.98:1521:neta","EGLOBAL","egl0b4l");  
	}
	
	public void destroy() throws SQLException {
		con.close();
	}
	/*
	 * Se realiza el SELECT 
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

}
