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
			<p id="categorie">${categorie}</p>
			<br>
			<c:if test="${enchere != 0}">
				<label for="enchere">Meilleure offre : </label>
				<p id="enchere">${enchere}</p>
				<p id="pseudoenchere"> par 						
					<a href='#' onclick='document.getElementById("pseudoEnchereur").submit()'>${pseudoenchere}</a>
				</p>
			</c:if>
			<br>
			<label for="prix">Mise à prix : </label>
			<p id="prix">${prix}</p>
			<br>
			<label for="fin">Fin de l'enchère : </label>
			<p id="fin">${fin}</p>
			<br>
			<label for="retrait">Retrait : </label>
			<p id="retrait">${retrait}</p>
			<br>
			<label for="vendeur">Vendeur : </label>
			<p id="vendeur">						
				<a href='#' onclick='document.getElementById("pseudoVendeur").submit()'>${vendeur}</a>
			</p>
			<br>
			<c:if test="${!empty sessionScope.pseudo}">
				<label for="proposition">Ma proposition : </label>
				<input type="number" name="proposition">
				<input type="submit" value="Enchérir">
			</c:if>
		</form>
		<form id="pseudoEnchereur" action="<%=request.getContextPath()%>/Accueil">
			<input type="submit" value="Accueil"/>
		</form>
		<form id="pseudoEnchereur" action="<%=request.getContextPath()%>/Profil">
			<input type="hidden" name="pseudoEnchereur" value="${pseudoenchere}"/>
		</form>
		<form id="pseudoVendeur" action="<%=request.getContextPath()%>/Profil">
			<input type="hidden" name="pseudoVendeur" value="${vendeur}"/>
		</form>
	</body>
</html>