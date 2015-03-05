<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>


<!DOCTYPE html>

<html>

<c:import url="head.jsp"></c:import>
<c:import url="headerViews.jsp"></c:import>

<body>
	<section id="adminUser">
		<form action="${pageContext.request.contextPath}/Users" method="get">
			<div class="buttonContainer">
				<button id="add" name="add" type="submit"
					formnovalidate="formnovalidate">Añadir usuario</button>
				<button id="modify" name="modify" type="submit">Modificar
					usuario</button>
				<button id="remove" name="remove" type="submit">Borrar
					usuario</button>
			</div>

			<div class="table">
				<table>
					<thead>
						<tr>
							<th></th>
							<th>NOMBRE</th>
							<th>APELLIDOS</th>
							<th>EMAIL</th>
							<th>ALIAS</th>
							<th>CLAVE</th>
							<th>DIRECCIÓN</th>
						</tr>
					</thead>
					<c:forEach var="usuario" items="${sessionScope.allUsers }"
						varStatus="status">
						<tr>
							<td>
								<input type="radio" name="userSelected"
									value="${status.count - 1}" required="required"
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
	</section>

	<c:import url="footer.jsp"></c:import>
</body>
</html>
