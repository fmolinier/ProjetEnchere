<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Inscription</title>
		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	</head>
	<%@ include file="./fragments/header.html" %>
	<body>
		<h1 class="text-center">Inscription</h1>
		<div class="mt-md-2 d-flex justify-content-around">
			<form name="inscription" action="<%=request.getContextPath()%>/inscription" method="post">
				<div class="mt-md-2 justify-content-around">
					<label for="pseudo">Pseudo : </label>
					<input type="text" name="pseudo" autofocus="autofocus">
				</div>
				<div class="mt-md-2 justify-content-around">
					<label for="nom">Nom : </label>
					<input type="text" name="nom" >
				</div>
				<div class="mt-md-2 justify-content-around">
					<label for="prenom">Prenom : </label>
					<input type="text" name="prenom">
				</div>
				<div class="mt-md-2 justify-content-around">
					<label for="email">E-mail : </label>
					<input type="text" name="email">
				</div>
				<div class="mt-md-2 justify-content-around">
					<label for="telephone">Téléphone : </label>
					<input type="text" name="telephone">
				</div>
				<div class="mt-md-2 justify-content-around">
					<label for="rue">Rue : </label>
					<input type="text" name="rue">
				</div>
				<div class="mt-md-2 justify-content-around">
					<label for="codepostal">Code Postal : </label>
					<input type="text" name="codepostal">
				</div>
				<div class="mt-md-2 justify-content-around">
					<label for="ville">Ville : </label>
					<input type="text" name="ville">
				</div>
				<div class="mt-md-2 justify-content-around">
					<label for="motdepasse">Mot de passe : </label>
					<input type="password" name="motdepasse">
				</div>
				<div class="mt-md-2 justify-content-around">
					<label for="confirmation">Confirmation : </label>
					<input type="password" name="confirmation">
				</div>
				<input class="mt-md-2" type ="submit" value="Enregister">
				<a class="mt-md-2" href="<%=request.getContextPath()%>/Accueil"><button>Anuller</button></a>
			</form>
		</div>
		<c:if test="${alert != null}">
			<p class="alert alert-warning" role="alert">${alert}</p>
		</c:if>
	</body>
</html>