<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ page errorPage="../errors.jsp"%>


<!DOCTYPE html>
<html>

<c:import url="head.jsp"></c:import>
<c:import url="headerViews.jsp"></c:import>

<body>
	<section id="adminUser">
		<h3>AÑADIR/MODIFICAR USUARIO</h3>
		<section>
			<form action="../Users" method="get">
				<label for="name">Nombre:</label>
				<input type="text" id="name" name="name"
					value="${usuarioModificar.nombre }" />
				<br>
				<label for="surname">Apellidos:</label>
				<input type="text" id="surname" name="surname"
					value="${usuarioModificar.apellidos }" />
				<br>
				<label for="address">Dirección:</label>
				<input type="text" id="address" name="address"
					value="${usuarioModificar.direccion }" />
				<br>
				<label for="alias">Alias:</label>
				<input type="text" id="alias" name="alias"
					value="${usuarioModificar.alias }" />
				<br>
				<label for="password">Clave:</label>
				<input type="text" id="password" name="password"
					value="${usuarioModificar.clave }" />
				<br>
				<label for="email">Email:</label>
				<input type="email" id="email" name="email"
					value="${usuarioModificar.email }" />
				<br>
				<c:choose>
					<c:when test="${usuarioModificar != null }">
						<button id="sendModify" name="sendModify" type="submit">Enviar</button>
					</c:when>
					<c:otherwise>
						<button id="sendNew" name="sendNew" type="submit">Enviar</button>
					</c:otherwise>
				</c:choose>
			</form>
		</section>
	</section>
	<c:import url="footer.jsp"></c:import>

</body>
</html>