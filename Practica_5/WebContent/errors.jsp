
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page isErrorPage="true" session="true"%>

<html>
<c:import url="views/head.jsp"></c:import>
<body>
	<section id="webContainer">
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

				<h1>Opps...</h1>
				<table>
					<tr valign="top">
						<td width="40%">
							<b>Error:</b>
						</td>
						<td>${pageContext.exception}</td>
					</tr>
					<tr valign="top">
						<td>
							<b>URI:</b>
						</td>
						<td>${pageContext.errorData.requestURI}</td>
					</tr>
					<tr valign="top">
						<td>
							<b>Status code:</b>
						</td>
						<td>${pageContext.errorData.statusCode}</td>
					</tr>
					<tr valign="top">
						<td>
							<b>Stack trace:</b>
						</td>
						<td>
							<c:forEach var="trace"
								items="${pageContext.exception.stackTrace}">
								<p>${trace}</p>
							</c:forEach>
						</td>
					</tr>
				</table>
			</div>
		</header>
		<c:import url="views/footer.jsp"></c:import>
</body>
</html>