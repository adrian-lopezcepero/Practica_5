<%@page import="modelo.beans.ProductoBean"%>
<%@page import="modelo.Logica"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	Logica logica = new Logica();
	int id = Integer.parseInt(request.getParameter("pro"));
	// 	ProductoBean producto = logica.setProducto(id);
	session.setAttribute("producto", logica.setProducto(id));
%>



<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>

<body>

	<!-- Categorias -->
	<nav>
		<ul>
			<c:forEach items="${sessionScope.categorias}" var="categ">
				<li>
					<c:choose>
						<c:when test="${!empty param.cat && param.cat == categ.id}">
							<a class="elegido" style="color: yellow;" href="">${categ.nombre}</a>
						</c:when>
						<c:otherwise>
							<a href="categoria.jsp?cat=${categ.id}">${categ.nombre}</a>
						</c:otherwise>
					</c:choose>
				</li>
			</c:forEach>
		</ul>
	</nav>

	<!-- Producto elegido -->
	<div>
		${sessionScope.producto.nombre}
		<br>
		<img alt="imagen de producto" src="${sessionScope.producto.imagen}">
		<span>${sessionScope.producto.precio} €</span>
		<form action="../Pedidos" method="post">
			<input type="hidden" name="prod" value="${sessionScope.producto.id}">
			<input type="hidden" name="page"
				value="views/producto.jsp?cat=${sessionScope.producto.categoria.id}&pro=${sessionScope.producto.id}">
			<label>Cantidad: </label>
			<input type="number" name="cant" value="1" min="1">
			<br>
			<input type="submit" name="addCesta" value="Añadir a la Cesta" />
		</form>
		<br>
		Descripción:
		<br>
		${sessionScope.producto.descripcion}

	</div>


</body>
</html>