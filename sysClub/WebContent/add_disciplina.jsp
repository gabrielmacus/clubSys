<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nueva Disciplina</title>
</head>
<body>

<h3>Agregar Disciplina</h3>

<form action="adddisciplina" method="post">
<input type="text" name="nombre" placeholder="NOMBRE">
<input type="time" name="hora_ini" placeholder="HORA INICIO">
<input type="time" name="hora_fin" placeholder="HORA FIN">
<input type="text" name="fecha_ini" placeholder="FECHA DE INICIO">
<input type="text" name="fecha_fin" placeholder="FECHA FINALIZACION">
<input type="text" name="importe" placeholder="VALOR DE CUOTA">
<input type="text" name="porcentaje" placeholder="PORCENTAJE AL PROFESOR">
<input type="submit" value="Aceptar">
</form>
</body>
</html></html>