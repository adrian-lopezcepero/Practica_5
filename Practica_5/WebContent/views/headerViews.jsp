<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<section id="webContainer">
<header>
	<h1>SMARTPHONE SHOP</h1>

	<section id="loginCartContainer">
		<section id="home">
			<c:url var="index" scope="session" value="/index.jsp"></c:url>
			<a href="${index }">
				<img alt="Image de home"
					src="${pageContext.request.contextPath }/img/home.png">
			</a>
		</section>
		<c:import url="login.jsp"></c:import>
	</section>

</header>