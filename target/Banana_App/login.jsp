<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html>

<html lang="en">
<jsp:include page="head.jsp"></jsp:include>

<c:set var="errorclass" value='${mierror?"has-error":""}' />

<body>
	
	<jsp:include page="header.jsp"></jsp:include>
	
	<section class="container">
	<div class="section">
		<h5>Formulario de login</h5>
		<!-- esto es un comentario -->
		<c:if test="${not empty mierror}">
			<div class="card-panel">
	      		<span class="red-text text-darken-2">${mierror}</span>
	    	</div>			
		</c:if>
		<form action="login" method="POST">
			<input type="email" name="email" class="${errorclass}" placeholder="Email" value="juana@e.es"> 
			<input
				type="password" name="password" class="${errorclass}" placeholder="Contraseña" value="juanason_1">
			<button class="btn waves-effect waves-light" type="submit" name="action">Enviar</button>
		</form>
	<div>
	</section>

	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>