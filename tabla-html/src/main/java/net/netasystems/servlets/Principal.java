package net.netasystems.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.netasystems.domain.CatTipoFabrica;
import net.netasystems.service.CatTipoFabricaService;

/**
 * @author NetaSystems / Jose Alberto Fuentes Loredo
 *
 */


/**
 * Servlet implementation class Principal
 */

public class Principal extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Principal() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * Se crea la tabla en HTML
		 */
		response.getWriter().append("<html><body><h1>");
		response.getWriter().append("¡Tabla de Alberto!"+"</br>");
		response.getWriter().append("</h1>");
		response.getWriter().append("<div><table>");
		response.getWriter().append("<tr "+"id="+ "main"+">");
		response.getWriter().append("<th>"+ "ID" +"</th>");
		response.getWriter().append("<th>"+ "NOMBRE" +"</th>");
		response.getWriter().append("<th>"+ "ESTATUS" +"</th>");
		response.getWriter().append("<th>"+ "FECHA DE MODIFICACION" +"</th>");
		response.getWriter().append("<th>"+ "ID USUARIO" +"</th>");
		response.getWriter().append("</tr>");
		
		/*
		 * Se mandan a llamar los datos de la BD
		 */
		System.out.println("Iniciando programa de conexion a base de datos!");
		CatTipoFabricaService service = null;
		try {
			 service = new CatTipoFabricaService();
			 List<CatTipoFabrica> lista = service.getAllRecords();
			 for(CatTipoFabrica c : lista) {
				 System.out.println(c);
				 response.getWriter().append("<tr>");
				 response.getWriter().append("<td>"+c.getIdCatTipoFabrica() +"</td>");
				 response.getWriter().append("<td>"+c.getNombre() +"</td>");
				 response.getWriter().append("<td>"+c.getStatus() +"</td>");
				 response.getWriter().append("<td>"+c.getFechaModificacion() +"</td>");
				 response.getWriter().append("<td>"+c.getIdUsuario() +"</td>");
				 response.getWriter().append("</tr>");
			 }
		} catch (Exception e) {
			System.out.println("Ha caido en excepcion con mensaje: "+e.getMessage());
		} finally {
			try {
				service.close();
			} catch (SQLException e) {
				System.out.println("No se pueden cerrar los recursos: "+e.getMessage());
			}
		}
		
		/*
		 * Se pone estilo a la tabla
		 */
		response.getWriter().append("</table></div></body>");
		
		response.getWriter().append("<style>");
		
		response.getWriter().append("h1"+"{"
		+"background-color:#D8D8D8;"
		+"text-align: center;"
				+"}");
		
		response.getWriter().append("div"+"{"
		+"margin: 150px auto;"
		+"width: 600px;"
		+"text-align: center;"
		+"border: 1px solid #000;"
				+"}");
		response.getWriter().append("table"+"{"
		+"background-color:#FFFFFF;"
		+"text-align: center;"
		+"border-collapse: collapse;"
		+"border: 1px solid #000;"
		+"width: 100%;"
				+"}");
		
		response.getWriter().append("#main"+"{"
				+"background-color:#FFFFFF;"
				+"border: 1px solid #000;"
						+"}");
		
		response.getWriter().append("th,td"+"{"
				+"padding: 20px;"
				+"border: 1px solid #000;"				
						+"}");
	
		response.getWriter().append("tr:nth-child(even)"+"{"
				+"background-color:#ddd;"
				+"}");
		
		response.getWriter().append("</stile></html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

