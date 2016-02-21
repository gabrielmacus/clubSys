<%@page import="sysClub.entidades.Categoria"%>
<%@page import="sysClub.DAOs.CategoriaDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center" id="main-menu">
		<h1>Sys Club</h1>
		<h2>Gestión</h2>

		<a href="profesores.html"><button>Profesores</button></a> 
		<a href="disciplinas.jsp"><button>Disciplinas</button></a> 
			<a href="socios.jsp"><button>Socios</button></a>
				<a href="addcategoria.jsp"><button>Nueva Categoria</button></a>
			
			
			<%
			CategoriaDAO catDAO=new CategoriaDAO();
			if(catDAO.getListaCat().isEmpty()){
				Categoria cat1= new Categoria("ACTIVO", "Mayores de 18 años", 140d);
				Categoria cat2= new Categoria("DAMAS", "Mayores de 18 años", 120d);
				Categoria cat3= new Categoria("NIÑOS", "Hasta 13 años", 90d);
				Categoria cat4= new Categoria("CADETE", "Entre 14 y 17 años", 110d);
				
				catDAO.AddCategoria(cat1);
				catDAO.AddCategoria(cat2);
				catDAO.AddCategoria(cat3);
				catDAO.AddCategoria(cat4);
				
			}
		
			
			
			%>




	</div>

</body>
</html>