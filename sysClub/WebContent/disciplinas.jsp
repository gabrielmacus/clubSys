<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="sysClub.DAOs.DisciplinaDAO"%>
<%@page import="java.util.Dictionary"%>
<%@page import="sysClub.entidades.Disciplina"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="sysClub.entidades.Socio, java.util.List, sysClub.DAOs.SocioDAO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Disciplinas - sysClub</title>
</head>
<body>

	<div align="center" id="main-menu">
		<h3>Listado de disciplinas</h3>

		<a href="add_disciplina.jsp">Nueva Disciplina</a>
		

		<table style="width: 80%; border: solid; table-layout: auto;">
			<tr>
				<td>Nombre</td>
				<td>Hora inicio</td>
				<td>Hora fin</td>
				<td>Fecha inicio</td>
				<td>Fecha fin</td>
				<td>Importe</td>
				<td>Porcentaje al profesor</td>
			</tr>
			<%
		/*List<Socio> socios = (List<Socio>)session.getAttribute("lista");
			if (socios == null) { socios = new SocioDAO().getListaSocio();
			session.setAttribute("lista", socios); } */
			SimpleDateFormat sdfFecha = new SimpleDateFormat("dd-MM-YY");
			SimpleDateFormat sdfHora = new SimpleDateFormat("hh:mm");
			List<Disciplina> disciplinas =new DisciplinaDAO().getDisciplinas();
			for(Disciplina d: disciplinas) {
			out.write("<tr>");
			out.write("<td>"+d.getNombre()+"</td>");
			out.write("<td>"+sdfHora.format(d.getHoraInicio())+"</td>");
			out.write("<td>"+sdfHora.format(d.getHoraFin())+"</td>");

			out.write("<td>"+sdfFecha.format( d.getFechaInicio())+"</td>");

			out.write("<td>"+sdfFecha.format( d.getFechaFinal())+"</td>");

			out.write("<td>"+d.getImporte()+"</td>");

			out.write("<td>"+d.getPorcentajeAlProfesor()+"</td>");
			out.write("<td><a href='mod_disciplina.jsp?id="+d.getId_disciplina()+"'>Editar</a></td>");
			out.write("</tr>");
		}
			%> 
		</table>



	</div>
</body>
</html>