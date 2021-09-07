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
		<h1 class="text-center">Profil</h1>
		<div class="text-center text-justify card-body ">
			
			<div>
				<p id="pseudo">Pseudo : <strong>${pseudo}</strong></p>
			</div>
			<div>
				<p id="nom">Nom : <strong>${nom}</strong></p>
			</div>
			<div>
				<p id="prenom">Prenom :<strong> ${prenom}</strong></p>
			</div>
			<div>
				<p id="email">E-mail : <strong>${email}</strong></p>
			</div>
			<div>
				<p id="telephone">Téléphone : <strong>${telephone}</strong></p>
			</div>
			<div>
				<p id="rue">Rue : <strong>${rue}</strong></p>
			</div>
			<div>
				<p id="codepostal">Code Postal : <strong>${codepostal}</strong></p>
			</div>
			<div>
				<p id="ville">Ville : <strong>${ville}</strong></p>
			</div>
		</div>	
	</body>
</html>