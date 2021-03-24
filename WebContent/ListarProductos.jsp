<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Lista de productos</title>
</head>
<body>
	<div>
		<h1>Lista de productos</h1>
		<table>
			<thead>
				<tr>
					<th>Id</th>
					<th>Nombre</th>
					<th>Descripción</th>
					<th>Precio</th>
					<th>Categoria</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${productos.size() == 0}">
					<td colspan="6">No hay productos que mostrar</td>
				</c:if>
				<c:forEach items="${productos}" var="producto">
					<tr>
						<td><c:out value="${producto.getProducto().getId()}" /></td>
						<td><c:out value="${producto.getProducto().getNombre()}" /></td>
						<td><c:out value="${producto.getProducto().getDescripcion()}" /></td>
						<td><c:out value="${producto.getProducto().getPrecio()}" /></td>
						<td><c:out value="${producto.getCategoria().getNombre()}" /></td>
						<td>
							<a href="ModificarProducto?id=${producto.getProducto().getId()}">Editar</a>&nbsp;
							<a href="EliminarProducto?id=${producto.getProducto().getId()}">Eliminar</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="${pageContext.request.contextPath}">Volver</a>
	</div>
</body>
</html>