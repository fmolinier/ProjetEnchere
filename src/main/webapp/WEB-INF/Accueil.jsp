<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1"> 
		<title>Accueil</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.css" >
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	</head>
	<%@ include file="./fragments/header.html" %>
	<body>
		<main>
			<div class="mt-md-2">
				<h1 class="text-center">Liste des enchères</h1>
			</div>
			<div class="ms-md-2">
				<form action="<%=request.getContextPath()%>/recherche" method="post">
					<input type="search" name="recherche">
					<select name="categorie">
						<option value="tous">Toutes</option>
						<option value="Informatique">Informatique</option>
						<option value="Ameublement">Ameublement</option>
						<option value="Vêtement">Vêtement</option>
						<option value="Sport & loisir">Sport/Loisir</option>
					</select>
					<c:if test="${!empty sessionScope.pseudo}">
						<div class="d-flex ms-md-2 mt-md-2">
							<div class="me-md-2">
								<p class="ms-md-2 mt-md-2">Achats</p>
								<div >
								  <input type="radio" name="AchatsVente" value="enchereOuverte" checked>
								  <label for="ouvertes">enchères ouvertes</label>
								</div>
								<div>
								  <input type="radio" name="AchatsVente" value="enchereEnCours">
								  <label for="enchereencours">mes enchères en cours</label>
								</div>
								<div>
								  <input type="radio" name="AchatsVente" value="enchereremporter">
								  <label for="remporter">mes enchères remportées</label>
								</div>
							</div>
							<div class="me-md-2">
								<p class="ms-md-2 mt-md-2">Mes ventes</p>
								<div>
								  <input type="radio" name="AchatsVente" value="ventesencours">
								  <label for="ventesencours">mes ventes en cours</label>
								</div>
								<div>
								  <input type="radio" name="AchatsVente" value="venteNonDebute">
								  <label for="débuter">ventes non débutées</label>
								</div>
								<div>
								  <input type="radio" name="AchatsVente" value="venteTerminer">
								  <label for="terminer">ventes terminèes</label>
								</div>
							</div>
						</div>
					</c:if>
					<input class="mt-md-2" type="submit" Value="Rechercher">
				</form>
			</div>
			<br>
			<div class="d-flex ms-md-2">
				<c:forEach var="article" items="${liste}">
					<div class="card me-md-2" style="width: 18rem;">
						<div class="card-body border border-dark">
							<form action="<%=request.getContextPath()%>/Detail" method="post">
								<input id="numero" name="numero" type="hidden" value="${article.noArticle }">
								<h4 class="card-title" id="nom">${article.nomArticle}</h4>
								<p id="prix">Prix : ${article.miseAPrix}</p>
								<p id="fin">Fin de l'enchère : ${article.dateFin}</p>
								<p id="vendeur">Vendeur : <a href="<%=request.getContextPath()%>/Profil?pseudo=${article.vendeur.pseudo}">${article.vendeur.pseudo}</a></p>
								<br>
								<input type="submit" Value="Detail">
							</form>
						</div>
					</div>
				</c:forEach>
			</div>
		</main>
	</body>
</html>