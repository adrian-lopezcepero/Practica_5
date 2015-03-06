<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ page errorPage="../errors.jsp"%>



<%-- ${sessionScope.usuario } ${sessionScope.admin} --%>
<%-- ${applicationScope.isLogin } ${sessionScope.sameSession } --%>

<section id="loginContainer">
	<form action="${pageContext.request.contextPath}/Login" method="post">
		<c:choose>
			<c:when
				test="${!sessionScope.sameSession &&  applicationScope.isLogin != null }">
				<span>Ya hay un usuario logeado en otra sesión.</span>
			</c:when>
			<c:when test="${sessionScope.usuario }">
				<c:choose>
					<c:when test="${sessionScope.sameSession }">
						<c:choose>
							<c:when test="${sessionScope.admin}">
								<span>Bienvenido ${applicationScope.isLogin.nombre }</span>
								<c:url var="admin" value="/Users">
									<c:param name="getAllUsers">true</c:param>
								</c:url>
								<a href="${admin }">Administrar usuarios</a>
								<c:url var="products" value="/Products">
									<c:param name="getAllProducts">true</c:param>
								</c:url>
								<a href="${products }">Administrar productos</a>
							</c:when>
							<c:otherwise>
								<span>Bienvenido ${applicationScope.isLogin.nombre }</span>
							</c:otherwise>
						</c:choose>
						<button id="logOut" name="logOut" type="submit">Logout</button>
					</c:when>
				</c:choose>

			</c:when>
			<c:when test="${sessionScope.usuario == null }">
				<div>
					<label for="user">User</label>
					<input type="text" id="user" name="alias" />
				</div>
				<div>
					<label for="password">Password</label>
					<input type="password" id="password" name="clave" />
				</div>
				<button id="login" name="login" type="submit">Login</button>
			</c:when>
			<c:when test="${sessionScope.usuario == false }">
				<div>
					<label for="user">User</label>
					<input type="text" id="user" name="alias" />
				</div>
				<div>
					<label for="password">Password</label>
					<input type="password" id="password" name="clave" />
				</div>
				<button id="login" name="login" type="submit">Login</button>
				<span id="incorrectUser">Usuario o clave incorrectos</span>
			</c:when>
		</c:choose>
	</form>
</section>