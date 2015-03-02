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
<title>MQM</title>

<link type="text/css" rel="stylesheet" href="main.css" />

</head>
<body>

	<section id="webContainer">

		<c:import url="views/header.jsp"></c:import>

		<c:import url="views/products.jsp"></c:import>

		<c:import url="views/footer.jsp"></c:import>

		<!-- 	Ver Cesta (boton) -->
		<form action="Pedidos" method="post">
			<input type="hidden" name="page" value="index.jsp">
			<c:choose>
				<c:when test="${!empty param.cesta}">
					<input type="submit" name="verCesta"
						value="Ver Cesta (${param.cesta})" />
				</c:when>
				<c:otherwise>
					<input type="submit" name="verCesta" value="Ver Cesta" />
				</c:otherwise>
			</c:choose>
		</form>

		<!-- verCesta=false (cesta vacía) -->
		<c:if test="${!empty param.verCesta}">
			<div class="cestaVacia">No hay ningún producto añadido a la
				cesta</div>
		</c:if>

		<!-- 	Categorias -->
		<nav>
			<ul>
				<c:forEach items="${sessionScope.categorias}" var="cat">
					<li>
						<a href="views/categoria.jsp?cat=${cat.id}">${cat.nombre}</a>
					</li>
				</c:forEach>
			</ul>
		</nav>



		<!-- 	Productos: ultimas novedades -->
		<div>
			Novedades
			<c:forEach items="${sessionScope.novedades}" var="prod">
				<div>
					<img alt="imagen de producto" src="${prod.imagen}">
					<a
						href="views/producto.jsp?cat=${prod.categoria.id}&pro=${prod.id}">${prod.nombre}</a>
					<span>${prod.precio} €</span>
					<form action="Pedidos" method="post">
						<input type="hidden" name="prod" value="${prod.id}">
						<input type="hidden" name="page" value="index.jsp">
						<input type="hidden" name="cant" value="1">
						<input type="submit" name="addCesta" value="Añadir a la Cesta" />
					</form>
				</div>
			</c:forEach>
		</div>

		<%-- ${sessionScope.novedades} --%>

	</section>
</body>
</html>