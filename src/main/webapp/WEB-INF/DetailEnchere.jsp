<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Detail</title>
		<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<h1>Detail vente</h1>
		<h3 id="nomArticle">${nomArticle}</h3>
		<form action="<%=request.getContextPath()%>/Encherir" method="post">
			<input id="numero" name="numero" type="hidden" value="${numeroArticle}">
			<label for="description">Description : </label>
			<textarea id="description" disabled>>${description}</textarea>
			<label for="categorie">Categorie : </label>
			<label id="categorie">${categorie}</label>
			<label for="enchere">Meilleure offre : </label>
			<label id="enchere">${enchere}</label>
			<label id="pseudoenchere"> par ${pseudoenchere}</label>
			<label for="prix">Mise à prix : </label>
			<label id="prix">${prix}</label>
			<label for="fin">Fin de l'enchère : </label>
			<label id="fin">${fin}</label>
			<label for="retrait">Retrait : </label>
			<label id="retrait">${retrait}</label>
			<label for="vendeur">Vendeur : </label>
			<label id="vendeur">${vendeur}</label>
			<label for="proposition">Ma proposition : </label>
			<input type="number" id="proposition">
			<input type="submit" value="Enchérir">
		</form>
	</body>
</html>