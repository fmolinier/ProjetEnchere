<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Inscription</title>
		<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<form name="inscription" action="<%=request.getContextPath()%>/inscription" method="post">
			<label for="pseudo">Pseudo</label>
			<input type="text" name="pseudo" autofocus="autofocus">
			<label for="nom">Nom</label>
			<input type="text" name="nom" >
			<label for="prenom">Prenom</label>
			<input type="text" name="prenom">
			<label for="email">E-mail</label>
			<input type="text" name="email">
			<label for="telephone">Téléphone</label>
			<input type="text" name="telephone">
			<label for="rue">Rue</label>
			<input type="text" name="rue">
			<label for="codepostal">Code Postal</label>
			<input type="text" name="codepostal">
			<label for="ville">Ville</label>
			<input type="text" name="ville">
			<label for="motdepasse">Mot de passe</label>
			<input type="password" name="motdepasse">
			<label for="confirmation">Confirmation</label>
			<input type="password" name="confirmation">
			<input type ="submit" value="Enregister">
		</form>
		<a href="<%=request.getContextPath()%>/Accueil"><button>Anuller</button></a>
		<c:if test="${alert != null}">
			<p class="alert alert-warning" role="alert">${alert}</p>
		</c:if>
	</body>
</html>