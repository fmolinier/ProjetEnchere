<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Profil</title>
		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	</head>
	<%@ include file="./fragments/header.html" %>
	<body>
		<c:if test="${!empty erreur}">
			<div class="alert alert-danger" role="alert">
				<strong>Erreur!</strong>
				<p>${erreur}</p>
			</div>
		</c:if>	
		<h1 class="mt-md-2 text-center">Mon Profil</h1>
		<div class="text-center text-justify mt-md-2 d-flex justify-content-around">
			<form name="profil" action="<%=request.getContextPath()%>/modifier" method="post">
				<div class="mt-md-2 d-flex justify-content-around">
					<label for="pseudo">Pseudo : </label>
					<input type="text" name="pseudo" autofocus="autofocus" value="${pseudo }">
				</div>
				<div class="mt-md-2 d-flex justify-content-around">
					<label for="nom">Nom : </label>
					<input type="text" name="nom" value="${nom}">
				</div>
				<div class="mt-md-2 d-flex justify-content-around">
					<label for="prenom">Prenom : </label>
					<input type="text" name="prenom" value="${prenom }">
				</div>
				<div class="mt-md-2 d-flex justify-content-around">
					<label for="email">E-mail : </label>
					<input type="text" name="email" value="${email }">
				</div>
				<div class="mt-md-2 d-flex justify-content-around">
					<label for="telephone">Téléphone : </label>
					<input type="text" name="telephone" value="${telephone }">
				</div>
				<div class="mt-md-2 d-flex justify-content-around">
					<label for="rue">Rue : </label>
					<input type="text" name="rue" value="${rue }">
				</div>
					<div class="mt-md-2 d-flex justify-content-around">
					<label for="codepostal">Code Postal : </label>
				<input type="text" name="codepostal" value="${codepostal }">
				</div>
				<div class="mt-md-2 d-flex justify-content-around">
					<label for="ville">Ville : </label>
					<input type="text" name="ville" value="${ville }">
				</div>
				<input type="hidden" name="motdepasse" value="${motdepasse }">
				<div class= " mt-md-2 p-3 border border-dark">
					<h3>Changement mot de passe</h3>
					<div class="mt-md-2 d-flex justify-content-around">
						<label for="nouveaumotdepasse">nouveau </label>
						<input type="password" name="nouveaumotdepasse" >
					</div>
					<div class="mt-md-2 d-flex justify-content-around">
						<label for="confirmation">Confirmation : </label>
						<input type="password" name="confirmation">
					</div>
				</div>
				<div class="mt-md-2 d-flex justify-content-around">
					<button class="mt-md-2 btn btn-outline-primary" type ="submit">Enregister</button>
					<a class="mt-md-2" href="<%=request.getContextPath()%>/supprimer"><button class="btn btn-outline-primary">supprimer</button></a>
				</div>
			</form>
		</div>
	</body>
</html>