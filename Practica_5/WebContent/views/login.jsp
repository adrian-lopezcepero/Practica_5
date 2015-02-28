<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>



<jsp:useBean id="user" class="modelo.beans.UsuarioBean" scope="session"></jsp:useBean>
<section id="loginContainer">
	<form action="Login">
		<div>
			<label for="user">User</label>
			<input type="text" id="user" name="alias" />
		</div>
		<div>
			<label for="password">Password</label>
			<input type="text" id="password" name="clave" />
		</div>
		<button id="login" name="login" type="submit">Login</button>
	</form>
</section>