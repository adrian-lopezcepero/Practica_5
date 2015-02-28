<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<header>
	<h1>MÁS QUE MÓVILES</h1>
	
	<section id="newProdcuts">Prodcutos nuevos</section>

	<section id="loginCartContainer">
		<c:import url="views/login.jsp"></c:import>
		<c:import url="views/cart.jsp"></c:import>
	</section>


</header>