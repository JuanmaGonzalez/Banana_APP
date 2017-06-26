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

			<table
				class="responsive-table highlight  light-green lighten-5 z-depth-3">
				<thead>
					<tr>
						<th>Código</th>
						<th>Título</th>
						<th>Fecha de Inicio</th>
						<th>Estado</th>
						<th>Detalle</th>
					</tr>
				</thead>

				<c:forEach var="proy" items="${listaProyectosMostrar}"
					varStatus="counter">

					<tr>
						<td>${proy.codigo}</td>
						<td>${proy.titulo}</td>
						<td>${proy.fechainicio}</td>
						<td>${proy.estado}</td>
						<td><a href="detalle_proyecto.jsp"
							class="waves-effect waves-light btn"><i
								class="material-icons">list</i></a></td>
					</tr>

				</c:forEach>

				</tbody>
			</table>
		</div>
	</section>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>