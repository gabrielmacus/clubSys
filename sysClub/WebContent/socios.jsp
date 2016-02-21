<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="sysClub.entidades.Socio, java.util.List, sysClub.DAOs.SocioDAO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div align="center" id="main-menu">
	

		<h3>Listado de socios</h3>

		<a href="add_socio.jsp">Nuevo Socio</a>
		

		<table style="width: 80%; border: solid; table-layout: auto;">
			<tr>
				<td>Nro Socio</td>
				<td>Nombre</td>
				<td>Apellido</td>
				<td>Categoria</td>
			</tr>
			<%
		/*List<Socio> socios = (List<Socio>)session.getAttribute("lista");
			if (socios == null) { socios = new SocioDAO().getListaSocio();
			session.setAttribute("lista", socios); } */
			List<Socio> socios = new SocioDAO().getListaSocio();
			for(Socio s:socios) {
			out.write("<tr>");
			out.write("<td>"+s.getNombre()+"</td>");
			out.write("<td>"+s.getDireccion()+"</td>");
			out.write("<td>"+s.getTelefonos()+"</td>");

			out.write("<td>"+s.getCategoria().getNombre()+"</td>");
			out.write("<td><a href='mod_socio.jsp?dni="+s.getDni()+"'>Editar</a></td>");
			out.write("</tr>");
		}
			%> 
		</table>



	</div>
</body>
</html>