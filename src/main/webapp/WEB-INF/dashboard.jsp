<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lookify</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container ">

		<nav class="navbar navbar-expand-lg bg-light">
			<div class="container-fluid">
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo01"
					aria-controls="navbarTogglerDemo01" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarTogglerDemo01">

					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="songs/new">Add new</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Top
								Songs</a></li>

					</ul>
					<form class="d-flex" role="search">
						<input class="form-control me-2" type="search"
							placeholder="Search" aria-label="Search">
						<button class="btn btn-outline-success" type="submit">Search
						</button>
					</form>
				</div>
			</div>
		</nav>


		<div class="row">
			<div class="col-sm-12">
				<table class="table table-success table-striped">
					<thead>
						<tr>
							<th scope="col">Name</th>
							<th scope="col">Rating</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="canc" items="${canc}">
							<tr>

								<td><a href='/songs/${canc.id }'><c:out
											value="${canc.titulo }"></c:out></a></td>
								<td><c:out value="${canc.clasificacion }"></c:out></td>
								<td><a href='/delete/${canc.id }'>delete</a></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>