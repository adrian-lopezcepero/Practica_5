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

<c:import url="head.jsp"></c:import>
<c:import url="header.jsp"></c:import>

<body>
	<div id="productContainer">

		<div class="product">

			<h2>${sessionScope.producto.nombre}</h2>
			<br>
			<img alt="imagen de producto"
				src="${pageContext.request.contextPath }/${sessionScope.producto.imagen}">
			<div>${sessionScope.producto.precio}€</div>
			<form action="${pageContext.request.contextPath}/Orders" method="post">
				<input type="hidden" name="prod" value="${sessionScope.producto.id}">
				<input type="hidden" name="page"
					value="views/product.jsp?cat=${sessionScope.producto.categoria.id}&pro=${sessionScope.producto.id}">
				<div>
					<label>Cantidad: </label>
					<input type="number" name="cant" value="1" min="1" style="max-width:50px;">
					<input type="submit" name="addCesta" value="Añadir producto" />
				</div>
			</form>
			<br>
			<div id="description">
				<h4>DESCRIPCIÓN:</h4>
				<br>
				<div>${sessionScope.producto.descripcion}</div>
			</div>

		</div>

	</div>
</body>

<c:import url="footer.jsp"></c:import>

</html>