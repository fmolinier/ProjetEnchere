<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Connexion</title>
		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	</head>
	<%@ include file="./fragments/header.html" %>
	<body>
		<div class="text-center mt-md-2">
			<h1>Connexion</h1>
			<form action="<%=request.getContextPath()%>/connection" method="post">
				<div class="mt-md-2 justify-content-around">
					<label for="identifiant">Identifiant : </label>
					<input type="text" name="identifiant" id="identifiant" autofocus="autofocus">
				</div>
				<div class="mt-md-2 justify-content-around">
					<label class=" mt-md-2" for="motdepasse">Mot de passe : </label>
					<input type="password" name="motdepasse" id="motdepasse" >
				</div>
				<button class="mt-md-2 btn btn-outline-primary" type="submit" class="btn btn-outline-primary">Connexion</button>
				<a href="<%=request.getContextPath()%>/inscription" ><button class="mt-md-2 btn btn-outline-primary">Inscription</button></a>
			</form>
			<c:if test="${alert != null}">
				<p class="alert alert-warning" role="alert">${alert}</p>
			</c:if>
		</div>
	</body>
</html>