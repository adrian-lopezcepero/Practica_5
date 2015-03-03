<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<section id="cartContainer">
	<form action="Pedidos" method="post">
		<img alt="imagen de carrito" src="img/shopping_cart.png">
		<span id="productAmount">0</span>
		<!-- 	Ver Cesta (boton) -->
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
</section>