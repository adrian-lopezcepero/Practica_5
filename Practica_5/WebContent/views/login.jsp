<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>



<jsp:useBean id="usuarioBean" class="modelo.beans.UsuarioBean"
	scope="session"></jsp:useBean>

<section id="loginContainer">
	<form action="Login" method="post">
		<c:if test="${!sessionScope.isLogin }">
			<div>
				<label for="user">User</label>
				<input type="text" id="user" name="alias" />
			</div>
			<div>
				<label for="password">Password</label>
				<input type="password" id="password" name="clave" />
			</div>
			<button id="login" name="login" type="submit">Login</button>
		</c:if>

		<c:choose>
			<c:when test="${sessionScope.isSameSession }">
				<span>Ya estás logeado en otra sesión</span>
			</c:when>
			<c:otherwise>
				<c:choose>
					<c:when test="${sessionScope.isLogin }">

						<c:choose>
							<c:when test="${sessionScope.isAdmin }">
								<span>Bienvenido ${usuarioBean.alias }</span>
								<a href="admin.jsp">Administrar</a>
							</c:when>
							<c:otherwise>
								<span>Bienvenido ${usuarioBean.alias }</span>
							</c:otherwise>
						</c:choose>
						<button id="logOut" name="logOut" type="submit">Log out</button>
					</c:when>
					<c:otherwise>
						<span>No estás registrado</span>
					</c:otherwise>
				</c:choose>
			</c:otherwise>
		</c:choose>
	</form>
</section>