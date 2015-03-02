<%@page import="modelo.beans.ProductoBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Logica"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	Logica logica = new Logica();
	int idCategoria = Integer.parseInt(request.getParameter("cat"));
	session.setAttribute("productos", logica.getProductos(idCategoria));
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
					<c:set scope="page" var="nombreCategoria" value="${categ.nombre}"></c:set>
					<a class="elegido" style="color:yellow;" href="">${categ.nombre}</a>
				</c:when>
				<c:otherwise>
					<a href="categoria.jsp?cat=${categ.id}">${categ.nombre}</a>
				</c:otherwise>
			</c:choose>
			</li>
		</c:forEach>
		</ul>
	</nav>
	
	<!-- Productos por categoria -->
	<div>
		${pageScope.nombreCategoria}
		<br>
		<c:forEach items="${sessionScope.productos}" var="prod" >
			<div>
				<img alt="" src="../${prod.imagen}">
				<a href="producto.jsp?cat=${prod.categoria.id}&pro=${prod.id}">${prod.nombre}</a>
				<p>${prod.precio} €</p>
				<form action="../Pedidos" method="post">
					<input type="hidden" name="prod" value="${prod.id}">
					<input type="hidden" name="page" value="views/categoria.jsp?cat=${param.cat}">
					<input type="hidden" name="cant" value="1">
					<input type="submit" name="addCesta" value="Añadir a la Cesta"/>
				</form>
			</div>
		</c:forEach>
	</div>
	
		
</body>
</html>