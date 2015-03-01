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



	<form action="../Users" method="get">
		<button id="add" name="add" type="submit"
			formnovalidate="formnovalidate">Añadir usuario</button>
		<button id="modify" name="modify" type="submit">Modificar
			usuario</button>
		<button id="remove" name="remove" type="submit">Añadir
			usuario</button>
		<button id="view" name="view" type="submit">Ver usuario</button>

		<div id="table">
			<table>
				<tr>
					<th></th>
					<th>NOMBRE</th>
					<th>APELLIDOS</th>
					<th>EMAIL</th>
					<th>ALIAS</th>
					<th>CLAVE</th>
					<th>DIRECCIÓN</th>
				</tr>

				<c:forEach var="usuario" items="${sessionScope.allUsers }">
					<tr>
						<td>
							<input type="radio" name="userSelected" value="${usuario.id }"
								id="${usuario.id }">
						</td>
						<td>${usuario.nombre }</td>
						<td>${usuario.apellidos }</td>
						<td>${usuario.email }</td>
						<td>${usuario.alias }</td>
						<td>${usuario.clave }</td>
						<td>${usuario.direccion }</td>
					</tr>

				</c:forEach>

			</table>
		</div>
	</form>
</body>
</html>