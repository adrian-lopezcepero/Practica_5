<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MQN</title>
</head>
<body>



	<form action="../Products" method="get">
		<button id="add" name="add" type="submit"
			formnovalidate="formnovalidate">Añadir producto</button>
		<button id="modify" name="modify" type="submit">Modificar
			producto</button>
		<button id="remove" name="remove" type="submit">Borrar
			producto</button>

		<div id="table">
			<table>
				<tr>
					<th></th>
					<th>NOMBRE</th>
					<th>DESCRIPCIÓN</th>
					<th>PRECIO</th>
					<th>IMAGEN</th>
					<th>CATEGORÍA</th>
				</tr>

				<c:forEach var="producto" items="${sessionScope.allProducts }" varStatus="status">
					<tr>
						<td>
							<input type="radio" name="productSelected"
								value="${status.count - 1}" required="required"
								id="${producto.id }">
						</td>
						<td>${producto.nombre }</td>
						<td>${producto.descripcion }</td>
						<td>${producto.precio }</td>
						<td>${producto.imagen }</td>
						<td>${producto.categoria.nombre }</td>
					</tr>

				</c:forEach>

			</table>
		</div>
	</form>
</body>
</html>