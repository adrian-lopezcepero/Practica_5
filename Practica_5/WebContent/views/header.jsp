<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<header>
	<h1>SMARTPHONE SHOP</h1>

	<section id="loginCartContainer">
		<c:import url="views/login.jsp"></c:import>
		<c:import url="views/cart.jsp"></c:import>
	</section>

	<div class="fotoramaBackground">
		<div class="fotorama" data-width="100%" data-ratio="800/600"
			data-fit="scaledown" data-transition="crossfade" data-autoplay="true"
			data-loop="true">
			<c:forEach items="${sessionScope.novedades}" var="prod" end="3">
				<img alt="imagen de producto" src="${prod.imagen}">
			</c:forEach>
		</div>
	</div>
</header>