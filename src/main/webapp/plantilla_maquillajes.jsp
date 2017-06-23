<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="head.jsp"></jsp:include>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<section class="container">
		<div class="section">
			<h6>Hola ${usuario.nombre}</h6>
			<h5>Aquí está la lista de Proyectos:</h5>

					<table class="responsive-table highlight  light-green lighten-5">
						<thead>
							<tr>
								<th>Código</th>
								<th>Marca</th>
								<th>Tipo</th>
								<th>Precio</th>
							</tr>
						</thead>

						<c:forEach var="maq" items="${listaMaquillajesAMostrar}" varStatus="counter">
							<tr>
								<td>${maq.codigo}</td>
								<td>${maq.marca}</td>
								<td>${maq.tipo}</td>
								<td>${maq.precio}€</td>
							</tr>

						</c:forEach>


						</tbody>
					</table>
		</div>
	</section>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>