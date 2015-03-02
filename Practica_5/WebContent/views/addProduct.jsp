<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MQM</title>
</head>
<body>
	${productoModificar }
	<form action="../Products" method="multipart/form-data">
		<label for="name">Nombre:</label>
		<input type="text" id="name" name="name"
			value="${productoModificar.nombre }" />
		<br>
		<label for="description">Descripción:</label>
		<input type="text" id="description" name="description"
			value="${productoModificar.descripcion }" />
		<br>
		<label for="precio">Precio:</label>
		<input type="text" id="precio" name="precio"
			value="${productoModificar.precio }" />
		<br>
		<label for="image">Imagen:</label>
		<input type="file" id="image" name="image"
			value="${productoModificar.imagen }" />
		<br>
		<label for="category">Categoría:</label>
		<input type="text" id="category" name="category"
			value="${productoModificar.cateforia.nombre }" />
		<br>
		<c:choose>
			<c:when test="${productoModificar != null }">
				<button id="sendModify" name="sendModify" type="submit">Enviar</button>
			</c:when>
			<c:otherwise>
				<button id="sendNew" name="sendNew" type="submit">Enviar</button>
			</c:otherwise>
		</c:choose>
	</form>
</body>
</html>