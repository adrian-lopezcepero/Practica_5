<%@ page import="modelo.beans.PedidoBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ page errorPage="../errors.jsp"%>


<%
	PedidoBean pedido = (PedidoBean) session.getAttribute("pedido");
%>

<!DOCTYPE html>
<html>
<c:import url="head.jsp"></c:import>
<c:import url="header.jsp"></c:import>
<body>
	<section id="selectedProducts">
		<h2>PRODUCTOS SELECCIONADOS</h2>
		<div class="table">
			<table>
				<thead>
					<tr>
						<th></th>
						<th>Producto</th>
						<th>Precio Ud</th>
						<th>Cantidad</th>
						<th>Subtotal</th>
					</tr>
				</thead>
				<c:forEach items="${sessionScope.pedido.lineasPedido}" var="linea">
					<tr>
						<td>
							<img alt="imagen de producto"
								src="${pageContext.request.contextPath}/${linea.producto.imagen}" />
						</td>
						<td>${linea.producto.nombre}</td>
						<td>
							<fmt:formatNumber maxFractionDigits="2" minFractionDigits="2">${linea.producto.precio}</fmt:formatNumber>
							€
						</td>
						<td>${linea.cantidad}</td>
						<td>
							<fmt:formatNumber maxFractionDigits="2" minFractionDigits="2">${linea.producto.precio * linea.cantidad}</fmt:formatNumber>
							€
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>

		<div id="total">
			<form action="${pageContext.request.contextPath}/Orders"
				method="post">
				<span>
					TOTAL:
					<fmt:formatNumber maxFractionDigits="2" minFractionDigits="2">
					${sessionScope.pedido.importe}
				</fmt:formatNumber>
					€
				</span>
				<!-- 				Debes estar logeado para poder comprar -->
				<c:choose>
					<%-- 					<c:when test="${applicationScope.isLogin != null}"> --%>

					<c:when test="${sessionScope.usuario}">
						<button type="submit" name="pay">Comprar</button>
					</c:when>
					<c:otherwise>
						<div>Debes estar logeado para poder realizar la compra.</div>
					</c:otherwise>
				</c:choose>
			</form>
		</div>
	</section>
	<c:import url="footer.jsp"></c:import>
</body>
</html>