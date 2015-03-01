<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MQM</title>
</head>
<body>
	<form action="../Users" method="get">
		<label for="name">Nombre:</label>
		<input type="text" id="name" name="name" />
		<br>
		<label for="surname">Apellidos:</label>
		<input type="text" id="surname" name="surname" />
		<br>
		<label for="address">Dirección:</label>
		<input type="text" id="address" name="address" />
		<br>
		<label for="alias">Alias:</label>
		<input type="text" id="alias" name="alias" />
		<br>
		<label for="password">Clave:</label>
		<input type="text" id="password" name="password" />
		<br>
		<label for="email">Email:</label>
		<input type="email" id="email" name="email" />
		<br>
		<button id="sendNew" name="sendNew" type="submit">Enviar</button>
	</form>
</body>
</html>