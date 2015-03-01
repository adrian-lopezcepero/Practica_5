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
			<c:when test="${!sessionScope.isSameSession }">
				<span>Ya estás logeado en otra sesión</span>
				<button id="logOut" name="logOut" type="submit">Log out</button>
			</c:when>
			<c:otherwise>
				<c:choose>
					<c:when test="${sessionScope.isLogin }">

						<c:choose>
							<c:when test="${sessionScope.isAdmin }">
								<span>Bienvenido ${usuarioBean.alias }</span>
								<c:url var="admin" value="Users">
									<c:param name="getAllUsers">true</c:param>
								</c:url>
								<a href="${admin }">Administrar usuarios</a>
								<c:url var="product" value="Products">
									<c:param name="getAllProducts">true</c:param>
								</c:url>
								<a href="${admin }">Administrar usuarios</a>
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