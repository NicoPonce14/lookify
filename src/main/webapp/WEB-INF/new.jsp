<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Lookify</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-ms-12">
			<h2>Registra una nueva Cancion</h2>
				<form:form action="/songs/new" method="post"
					modelAttribute="cancion">
					<div class="row mb-3">
						<form:errors class="text-danger" path="titulo"></form:errors>
						<form:errors class="text-danger" path="artista"></form:errors>
						<form:errors class="text-danger" path="clasificacion"></form:errors>
					</div>

					<div class="form-outline mb-4">
						<form:input path="titulo" type="text" id="titulo"
							class="form-control" />
						<form:label path="titulo" class="form-label" for="titulo">Title</form:label>
					</div>


					<div class="form-outline mb-4">
						<form:input path="artista" type="text" id="artista"
							class="form-control" />
						<form:label path="artista" class="form-label" for="artista">Artist</form:label>
					</div>


					<div class="form-outline mb-4">
						<form:input path="clasificacion" type="number" id="clasificacion"
							class="form-control" />
						<form:label path="clasificacion" class="form-label"
							for="clasificacion">Clasificacion</form:label>
					</div>

					<!-- Submit button -->
					<button type="submit" class="btn btn-primary btn-block mb-4">Submit</button>
				</form:form>
				<a href="/dashboard">Dashboard</a> 
			</div>
		</div>
	</div>
</body>
</html>