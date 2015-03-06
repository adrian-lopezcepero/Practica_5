<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<header>
	<h1>SMARTPHONE SHOP</h1>

	<section id="loginCartContainer">
		<section id="home">
			<c:url var="index" scope="session" value="/index.jsp">
				<c:param name="cesta" value="${ fn:length(sessionScope.cesta) }"></c:param>
			</c:url>
			<a href="${index }">
				<img alt="Image de home"
					src="${pageContext.request.contextPath }/img/home.png">
			</a>
		</section>
		<c:import url="/views/login.jsp"></c:import>
		<c:import url="/views/cart.jsp"></c:import>
	</section>

	<div class="fotoramaBackground">
		<div class="fotorama" data-width="100%" data-ratio="800/600"
			data-fit="scaledown" data-transition="crossfade" data-autoplay="true"
			data-loop="true">
			<c:forEach items="${sessionScope.novedades}" var="prod" end="3">
				<img alt="imagen de producto"
					src=" ${pageContext.request.contextPath}/${prod.imagen}">
			</c:forEach>
		</div>
	</div>
</header>