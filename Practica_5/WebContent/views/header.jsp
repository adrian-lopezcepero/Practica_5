<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<header>
	<h1>MÁS QUE MÓVILES</h1>

	<section id="newProdcuts">
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

		<%-- ${sessionScope.novedades} --%>
	</section>

	<section id="loginCartContainer">
		<c:import url="views/login.jsp"></c:import>
		<c:import url="views/cart.jsp"></c:import>
	</section>
</header>