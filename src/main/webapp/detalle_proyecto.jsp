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
			<h6>Para el proyecto ${proyectos.titulo}</h6>
			<h5>Le corresponde esta lista de Tareas</h5>

			<table
				class="responsive-table highlight light-green lighten-5 z-depth-3">
				<thead>
					<tr>
						<th>Código</th>
						<th>Título</th>
						<th>Responsable</th>
						<th>Fecha de Inicio</th>
					</tr>
				</thead>

				<c:forEach var="tareas" items="${listaTareasMostrar}"
					varStatus="counter">

					<tr>
						<td>${tareas.codigo}</td>
						<td>${tareas.tarea}</td>
						<td>${tareas.uid}</td>
						<td>${tareas.fechainicio}</td>
					</tr>

				</c:forEach>


				</tbody>
			</table>
		</div>
	</section>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>