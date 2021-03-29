<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Modificar producto</title>
</head>
<body>
	<h1>Modificar producto</h1>
	<form action="ModificarProducto" method="POST">
		<input type="hidden" name="id" value="${producto.getId()}" />
		<div>
			<label for="nombre">Nombre</label>
			<input type="text" name="nombre" value="${producto.getNombre()}" />
		</div>
		<div>
			<label for="descripcion">Descripción</label>
			<textarea name="descripcion">${producto.getDescripcion()}</textarea>
		</div>
		<div>
			<label for="precio">Precio</label>
			<input type="number" name="precio" value="${producto.getPrecio()}" />
		</div>
		<div>
			<label for="categoria">Categoría</label>
			<select name="categoria">
				<c:forEach items="${categorias}" var="cat">
					<option value="${cat.getId()}" 
					  ${producto.getIdCategoria() == cat.getId() ? "selected" : ""}>
						${cat.getNombre()}
					</option>
				</c:forEach>
			</select>
		</div>
		<div>
			<button type="submit">Enviar</button>
		</div>
	</form>
	<a href="${pageContext.request.contextPath}">Volver</a>
</body>
</html>