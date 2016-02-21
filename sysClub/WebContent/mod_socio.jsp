<%@page import="sysClub.entidades.Socio"%>
<%@page import="sysClub.entidades.Categoria"%>
<%@page import="java.util.List"%>
<%@page import="sysClub.DAOs.CategoriaDAO"%>
<%@page import="sysClub.DAOs.SocioDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    SocioDAO socioDao= new SocioDAO();
    long dni = Long.parseLong(request.getParameter("dni"));
   Socio socio = socioDao.returnSocio(dni);
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<form name="m" method="post" action="modsocio" >
      <input type="text" placeholder="Nombre" name="nombre" value=<%out.write(socio.getNombre()); %>>
      
      <input type="text" placeholder="Apellido" name="apellido" value=<%out.write(socio.getApellido()); %>>
     
      <input type="text" placeholder="Direccion" name="direccion" value=<%out.write(socio.getDireccion()); %>>
      
      <input type="text" placeholder="Telefonos (separados por coma)" name="telefonos" value=<%out.write(socio.getTelefonos()); %>>
      
      <input type="text" placeholder="DNI" name="dni" value=<%out.write(socio.getDni().toString()); %>>
      <select name="categoria">
      <%
      CategoriaDAO categoriaDao =new CategoriaDAO();
     List<Categoria> categorias= categoriaDao.getListaCat();
     
     if(categorias.size()>0)
     {
      for(Categoria c:categorias)
      {
    	  if(socio.getCategoria().getId_categoria()==c.getId_categoria())
    	  {
    	  out.println("<option selected>"+c.getNombre()+"</option>");
    	  }
    	  else
    		  {
    		  out.println("<option >"+c.getNombre()+"</option>");
    	  }
      }
     }
     else
    	 {
    	 out.println("<option disable>Ninguna categoria disponible</option>");
     }
    
      %>
      </select>
      <input type="submit" value="Aceptar">
 </form>
		
</body>
</html>