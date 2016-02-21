<%@page import="sysClub.entidades.Categoria"%>
<%@page import="java.util.List"%>
<%@page import="sysClub.DAOs.CategoriaDAO"%>
<%@page import="sysClub.DAOs.SocioDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<form  method="post" action="addsocio" >
      <input type="text" placeholder="Nombre" name="nombre">
      
      <input type="text" placeholder="Apellido" name="apellido">
     
      <input type="text" placeholder="Direccion" name="direccion">
      
      <input type="text" placeholder="Telefonos (separados por coma)" name="telefonos">
      
      <input type="text" placeholder="DNI" name="dni">
      
      <select name="categoria">
      <%
      CategoriaDAO categoriaDao =new CategoriaDAO();
     List<Categoria> categorias= categoriaDao.getListaCat();
     
     if(categorias.size()>0)
     { out.println("<option  selected>Seleccione una categoria</option>");
      for(int i=0;i<categorias.size();i++)
      {
    	  out.println("<option>"+categorias.get(i).getNombre()+"</option>");
      }
     }
     else
    	 {
    	 out.println("<option disable>Ninguna categoria disponible</option>");
     }
      %>
      </select>
      <input type="submit" value="Aceptar">
      <input type="submit" value="Cancelar">
 </form>
		
</body>
</html>