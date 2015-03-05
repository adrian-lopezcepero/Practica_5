<%@page import="modelo.beans.CategoriaBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Logica"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>

<c:import url="head.jsp"></c:import>
<c:import url="headerViews.jsp"></c:import>

<body>
	<section id="adminUser">
		<h3>AÑADIR/MODIFICAR USUARIO</h3>
		<section>
			<form action="../UploadFile" method="post"
				enctype="multipart/form-data">
				<label for="name">Nombre:</label>
				<input type="text" id="name" name="name"
					value="${productoModificar.nombre }" />
				<br>
				<label for="description">Descripción:</label>
				<input type="text" id="description" name="description"
					value="${productoModificar.descripcion }" />
				<br>
				<label for="precio">Precio:</label>
				<input type="number" step="any" id="precio" name="precio"
					value="${productoModificar.precio }" />
				<br>
				<label for="image">Imagen:</label>
				<input type="file" id="image" name="image"
					value="${productoModificar.imagen }"
					title="${productoModificar.imagen }" />
				<br>
				<%
					Logica logica = new Logica();
					// 			ArrayList<CategoriaBean> categorias = logica.getCategorias();
					ArrayList<CategoriaBean> categorias = new ArrayList<CategoriaBean>();
					categorias.add(new CategoriaBean(1, "Android"));
					categorias.add(new CategoriaBean(2, "Windows Phone"));
					categorias.add(new CategoriaBean(3, "Iphone"));

					pageContext.setAttribute("categorias", categorias);
				%>
				<label>Categoría:</label>
				<select name="category">
					<optgroup label="Categoría">
						<c:forEach var="category" items="${categorias }">
							<c:set var="isSelected"></c:set>
							<c:if test="${category.id == productoModificar.categoria.id}">
								<c:set var="isSelected">selected="selected"</c:set>
							</c:if>
							<option value="${category.id }" ${isSelected }>${category.nombre }</option>
						</c:forEach>
					</optgroup>
				</select>
				<br>
				<c:choose>
					<c:when test="${productoModificar != null }">
						<button id="sendModify" name="sendModify" type="submit">Enviar</button>
					</c:when>
					<c:otherwise>
						<button id="sendNew" name="sendNew" type="submit">Enviar</button>
					</c:otherwise>
				</c:choose>
			</form>
		</section>
	</section>
	<c:import url="footer.jsp"></c:import>

</body>
</html>