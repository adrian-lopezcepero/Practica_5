<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<section id="products">
	<aside id="categories">
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
	</aside>
	<section id="productsContainer">
			<c:forEach items="${sessionScope.novedades}" var="prod">
				<div class="product">
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
	</section>
</section>