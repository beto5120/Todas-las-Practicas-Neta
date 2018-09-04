<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Hola desde JSP!!
<% for(int i = 0; i < 10; i++){ %>
	Index del contador <%=1 %> <br/>
	
<%} %>
<%List<String> cabeceras = new ArrayList<String>();
   cabeceras.add("Nombre");
   cabeceras.add("Apellido");
   cabeceras.add("Fecha de nacimiento");

%>

 <table>
  <thead>
   <tr>
     <% for (String s : cabeceras){%>
    	 <td><%=s %></td>
     <% } %>
     
   </tr>
  </thead>
  <tbody>
   <tr>
    <td></td>
   </tr>
  
  </tbody>
 </table>

</body>
</html>