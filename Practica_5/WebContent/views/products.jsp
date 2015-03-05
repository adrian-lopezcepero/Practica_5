<%@page import="modelo.Logica"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>


<%
	Logica logica = new Logica();
	String cat = request.getParameter("cat");
%>
<%
	if (cat.isEmpty() || cat == null) {
		session.setAttribute("productos", logica.getProductos());
	}
	else if (!cat.isEmpty()) {
%>
<%
	int idCategoria = Integer.parseInt(cat);
		session.setAttribute("productos",
				logica.getProductos(idCategoria));
%>
<%
	}
%>


<section id="products">
	<section id="categories">
		<!-- 	Categorias -->
		<img alt="Imagen de fondo" src="img/blue-header.png">
		<nav>
			<ul>
				<li>
					<c:choose>
						<c:when test="${!empty param.cat && param.cat != null}">
							<a href="index.jsp">Todos</a>
						</c:when>
						<c:otherwise>
							<a class="categorySelected" style="color: yellow;" href="index.jsp">Todos</a>
						</c:otherwise>
					</c:choose>
				</li>
				<c:forEach items="${sessionScope.categorias}" var="categ">
					<li>
						<c:choose>
							<c:when test="${!empty param.cat && param.cat == categ.id}">
								<c:set scope="page" var="nombreCategoria"
									value="${categ.nombre}"></c:set>
								<a class="categorySelected" style="color: yellow;" href="">${categ.nombre}</a>
							</c:when>
							<c:otherwise>
								<a href="index.jsp?cat=${categ.id}">${categ.nombre}</a>
							</c:otherwise>
						</c:choose>
					</li>
				</c:forEach>
			</ul>
		</nav>
	</section>
	<section id="productsContainer">
		<c:forEach items="${sessionScope.productos}" var="prod">
			<div class="product">
				<div>
					<img alt="imagen de producto" src="${prod.imagen}">
					<a
						href="views/producto.jsp?cat=${prod.categoria.id}&pro=${prod.id}">${prod.nombre}</a>
					<br>
					<span class="price">${prod.precio} €</span>
					<form action="Pedidos" method="post">
						<input type="hidden" name="prod" value="${prod.id}">
						<input type="hidden" name="page" value="index.jsp">
						<input type="hidden" name="cant" value="1">
						<input type="submit" name="addCesta" value="Añadir a la Cesta" />
					</form>
				</div>
			</div>
		</c:forEach>
	</section>
</section>