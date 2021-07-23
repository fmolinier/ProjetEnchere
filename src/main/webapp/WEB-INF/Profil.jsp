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
				<p>${erreur}</>
			</div>
		</c:if>
		<c:if test="${empty session}">
			<label for="pseudo">Pseudo</label>
			<input type="text" id="pseudo">
			<label for="nom">Nom</label>
			<input type="text" id="nom">
			<label for="prenom">Prenom</label>
			<input type="text" id="prenom">
			<label for="email">E-mail</label>
			<input type="text" id="email">
			<label for="telephone">Téléphone</label>
			<input type="text" id="telephone">
			<label for="rue">Rue</label>
			<input type="text" id="rue">
			<label for="codepostal">Code Postal</label>
			<input type="text" id="codepostal">
			<label for="ville">Ville</label>
			<input type="text" id="ville">
		</c:if>
		<c:if test="${!empty session}">	
			<form name="profil" action="<%=request.getContextPath()%>/modifier" method="post">
				<label for="pseudo">Pseudo</label>
				<input type="text" id="pseudo" autofocus="autofocus">
				<label for="nom">Nom</label>
				<input type="text" id="nom">
				<label for="prenom">Prenom</label>
				<input type="text" id="prenom">
				<label for="email">E-mail</label>
				<input type="text" id="email">
				<label for="telephone">Téléphone</label>
				<input type="text" id="telephone">
				<label for="rue">Rue</label>
				<input type="text" id="rue">
				<label for="codepostal">Code Postal</label>
				<input type="text" id="codepostal">
				<label for="ville">Ville</label>
				<input type="text" id="ville">
				<label for="motdepasse">Mot de passe</label>
				<input type="password" id="motdepasse">
				<label for="confirmation">Confirmation</label>
				<input type="password" id="confirmation">
				<input type ="submit" value="Enregister">
			</form>
			<form name="profil" action="<%=request.getContextPath()%>/supprimer" method="post">
				<input type ="submit" value="Supprimer">
			</form>
		</c:if>
	</body>
</html>