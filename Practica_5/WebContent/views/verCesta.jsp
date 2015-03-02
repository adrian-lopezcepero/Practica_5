<%@ page import="modelo.beans.PedidoBean"%>
<%-- <%@ page import="modelo.beans.ProductoBean"%> --%>
<%-- <%@ page import="java.util.ArrayList"%> --%>
<%-- <%@ page import="modelo.Logica"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	PedidoBean pedido = (PedidoBean) session.getAttribute("pedido");
%>

<!DOCTYPE html>
<html>
<head>
	<title>verCesta.jsp</title>
</head>

<body>
	
	Cesta de la compra
	
	<table>
		<tr>
	    	<th></th>
	    	<th>Producto</th>
	    	<th>Precio Ud</th>
	    	<th>Cantidad</th>
	    	<th>Subtotal</th>
	  	</tr>
		<c:forEach items="${sessionScope.pedido.lineasPedido}" var="linea">
			<tr>
			    <td><img alt="imagen de producto" src="${linea.producto.imagen}"/></td>
			    <td>${linea.producto.nombre}</td>
			    <td>${linea.producto.precio} €</td>
			    <td>${linea.cantidad}</td>
			    <td>${linea.producto.precio * linea.cantidad} €</td>
			</tr>
		</c:forEach>
	</table>
	
	<div id="total">
		Total ${sessionScope.pedido.importe} €
		<form action="Pedidos" method="post">
			<input type="submit" name="comprar" value="Comprar"/>			
		</form>
	</div>

	
	
	
	
	
</body>
</html>