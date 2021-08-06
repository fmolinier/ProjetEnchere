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
			<input name="numero" name="numero" type="hidden" value="${numeroArticle}">
			<label for="description">Description : </label>
			<textarea name="description" disabled="disabled">${description}</textarea>
			<br>
			<label for="categorie">Categorie : </label>
			<label id="categorie">${categorie}</label>
			<br>
			<label for="enchere">Meilleure offre : </label>
			<label id="enchere">${enchere}</label>
			<label id="pseudoenchere"> par 						
				<a href='#' onclick='document.getElementById("pseudoEnchereur").submit()'>${pseudoenchere}</a>
			</label>
			<br>
			<label for="prix">Mise à prix : </label>
			<label id="prix">${prix}</label>
			<br>
			<label for="fin">Fin de l'enchère : </label>
			<label id="fin">${fin}</label>
			<br>
			<label for="retrait">Retrait : </label>
			<label id="retrait">${retrait}</label>
			<br>
			<label for="vendeur">Vendeur : </label>
			<label name="vendeur">						
				<a href='#' onclick='document.getElementById("pseudoVendeur").submit()'>${vendeur}</a>
			</label>
			<br>
			<c:if test="${!empty sessionScope.pseudo}">
				<label for="proposition">Ma proposition : </label>
				<input type="number" name="proposition">
				<input type="submit" value="Enchérir">
			</c:if>
		</form>
		<form id="pseudoEnchereur" action="<%=request.getContextPath()%>/Profil">
			<input type="hidden" name="pseudoEnchereur" value="${pseudoenchere}"/>
		</form>
		<form id="pseudoVendeur" action="<%=request.getContextPath()%>/Profil">
			<input type="hidden" name="pseudoVendeur" value="${vendeur}"/>
		</form>
	</body>
</html>