<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="head.jsp"></jsp:include>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	
	<section class="container">
	<div class="section">
		<h6>Hola ${usuario.nombre}</h2>
		<h5>Aquí está tu lista de maquillajes:</h1>
		<ul class="collection">
			<c:forEach var="maq"  items="${listaMaquillajesAMostrar}" varStatus="counter">
				<li class="collection-item">
					<span>${maq.codigo}</span> -
					<span>${maq.marca}</span> -
					<span>${maq.tipo}</span> -
					<span>${maq.precio}EUR</span>
				</li>
			</c:forEach>
		</ul>
	</div>
	</section>

	<jsp:include page="footer.jsp"></jsp:include>	
</body>
</html>