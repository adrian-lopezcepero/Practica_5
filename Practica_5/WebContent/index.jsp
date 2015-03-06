<%@page import="modelo.Logica"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<%
	if (session.getAttribute("categorias") == null) {
		Logica logica = new Logica();
		session.setAttribute("categorias", logica.getCategorias());
	}
	if (session.getAttribute("novedades") == null) {
		Logica logica = new Logica();
		session.setAttribute("novedades", logica.getNovedades(8));
	}
%>

<!DOCTYPE html">
<html>
<c:import url="views/head.jsp"></c:import>
<body>

	<section id="webContainer">

		<c:import url="views/header.jsp"></c:import>

		<c:import url="views/products.jsp?cat=${param.cat}&pro=${prod.id}"></c:import>

		<c:import url="views/footer.jsp"></c:import>

	</section>
</body>
</html>