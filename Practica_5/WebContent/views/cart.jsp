<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<section id="cartContainer">
	<form action="${pageContext.request.contextPath}/Pedidos" method="post">
		<img alt="imagen de carrito"
			src="${pageContext.request.contextPath }/img/shopping_cart.png">
		<span id="productAmount">${param.cesta}</span>
		<!-- 	Ver Cesta (boton) -->
		<input type="hidden" name="page" value="index.jsp">
		<button type="submit" name="verCesta">Pagar</button>
	</form>

	<!-- verCesta=false (cesta vacía) -->
	<c:if test="${!empty param.verCesta}">
		<div class="cestaVacia">No hay productos</div>
	</c:if>
</section>