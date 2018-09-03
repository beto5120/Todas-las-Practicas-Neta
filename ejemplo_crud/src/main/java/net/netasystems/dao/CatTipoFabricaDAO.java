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

public class CatTipoFabricaDAO { 
	
private Connection con;
	
	public CatTipoFabricaDAO() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(  
				"jdbc:oracle:thin:@198.23.75.98:1521:neta","EGLOBAL","egl0b4l");  
	}
	
	public void destroy() throws SQLException {
		con.close();
	}
	
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
	
	public void deleteRecord(CatTipoFabrica record) {
		
		Statement stmt = con.prepareStatement("DELETE FROM CAT_TIPO_FABRICA");
		int x = stmt.executeUpdate();
		
		stmt.close();
		con.close();
		
	}

}
