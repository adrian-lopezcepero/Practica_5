<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<section id="cartContainer">
	<form action="Carrito">
		<img alt="imagen de carrito" src="img/shopping_cart.png">
		<span id="productAmount">0</span>
		<button id="pay" name="pay" type="submit">Pay</button>
	</form>
</section>