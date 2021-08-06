<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Profil</title>
		<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<c:if test="${!empty erreur}">
			<div class="alert alert-danger" role="alert">
				<strong>Erreur!</strong>
				<p>${erreur}</p>
			</div>
		</c:if>
		<c:if test="${empty sessionScope.pseudo}">
			<label for="pseudo">Pseudo : </label>
			<label id="pseudo">${pseudo}</label>
			<br>
			<label for="nom">Nom : </label>
			<label id="nom">${nom}</label>
			<br>
			<label for="prenom">Prenom : </label>
			<label id="prenom" >${prenom}</label>
			<br>
			<label for="email">E-mail : </label>
			<label id="email" >${email}</label>
			<br>
			<label for="telephone">Téléphone : </label>
			<label id="telephone">${telephone}</label>
			<br>
			<label for="rue">Rue : </label>
			<label id="rue">${rue}</label>
			<br>
			<label for="codepostal">Code Postal : </label>
			<label id="codepostal">${codepostal}</label>
			<br>
			<label for="ville">Ville : </label>
			<label id="ville">${ville}</label>
		</c:if>
		<c:if test="${!empty sessionScope.pseudo}">	
			<form name="profil" action="<%=request.getContextPath()%>/modifier" method="post">
				<label for="pseudo">Pseudo</label>
				<input type="text" name="pseudo" autofocus="autofocus" value="${pseudo }">
				<br>
				<label for="nom">Nom</label>
				<input type="text" name="nom" value="${nom}">
				<br>
				<label for="prenom">Prenom</label>
				<input type="text" name="prenom" value="${prenom }">
				<br>
				<label for="email">E-mail</label>
				<input type="text" name="email" value="${email }">
				<br>
				<label for="telephone">Téléphone</label>
				<input type="text" name="telephone" value="${telephone }">
				<br>
				<label for="rue">Rue</label>
				<input type="text" name="rue" value="${rue }">
				<br>
				<label for="codepostal">Code Postal</label>
				<input type="text" name="codepostal" value="${codepostal }">
				<br>
				<label for="ville">Ville</label>
				<input type="text" name="ville" value="${ville }">
				<br>
				<input type="hidden" name="motdepasse" value="${motdepasse }">
				<label for="nouveaumotdepasse">nouveau mot de passe</label>
				<input type="password" name="nouveaumotdepasse" >
				<br>
				<label for="confirmation">Confirmation</label>
				<input type="password" name="confirmation">
				<br>
				<input type ="submit" value="Enregister">
			</form>
			<form name="profil" action="<%=request.getContextPath()%>/supprimer" method="post">
				<input type ="submit" value="Supprimer">
			</form>
		</c:if>
	</body>
</html>