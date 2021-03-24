<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Eliminar producto</title>
</head>
<body>
	<h1>Eliminar producto</h1>
	<p>¿Estás seguro de que quieres eliminar el producto?</p>
	<form action="EliminarProducto" method="POST">
		<input type="hidden" name="id" value="${id}" />
		<button type="submit">Sí</button>
		<a href="${pageContext.request.contextPath}">No</a>
	</form>
	<a href="${pageContext.request.contextPath}">Volver</a>
</body>
</html>