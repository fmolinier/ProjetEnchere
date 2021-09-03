<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Detail</title>
		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	</head>
	<%@ include file="./fragments/header.html" %>
	<body class="text-center">
		<h1 class="mt-md-2">Detail vente</h1>
		<div><h3 id="nomArticle">${nomArticle}</h3></div>
		
		<form  action="<%=request.getContextPath()%>/Encherir" method="post">
		
			<input name="numero" name="numero" type="hidden" value="${numeroArticle}">
			<label for="description">Description : </label>
			
			<textarea name="description" disabled="disabled">${description}</textarea>
			<p id="categorie">Categorie : ${categorie}</p>
			
			<c:if test="${enchere != 0}">
				<p id="enchere">Meilleure offre : ${enchere} par 						
					<a href='#' onclick='document.getElementById("pseudoEnchereur").submit()'>${pseudoenchere}</a>
				</p>
			</c:if>
			
			<p id="prix">Mise à prix : ${prix} </p>
			<p id="fin">Fin de l'enchère : ${fin}</p>
			
			<div>
				<h3>Retrait</h3>
				<p id="rue">rue : ${rue}</p>
				<p id="codepostal">Code postal : ${codepostal}</p>
				<p id="ville">Ville : ${ville}</p>
			</div>
			
			<p id="vendeur">						
				Vendeur : <a href='#' onclick='document.getElementById("pseudoVendeur").submit()<%=request.getContextPath()%>/Profil'>${vendeur}</a>
			</p>
			
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