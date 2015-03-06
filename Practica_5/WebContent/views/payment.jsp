<%@page import="model.beans.PedidoBean"%>
<%@page import="model.beans.ProductoBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Logic"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ page errorPage="../errors.jsp"%>

<!DOCTYPE html>
<html>
<c:import url="head.jsp"></c:import>
<c:import url="header.jsp"></c:import>

<body>

	<section class="fotoramaBackground">Compra realizada
		correctamente. Se ha enviado un email al administrador del portal</section>
	<c:import url="footer.jsp"></c:import>
</body>
</html>