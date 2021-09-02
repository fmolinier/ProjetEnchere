<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1"> 
		<title>Accueil</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.css" >
	</head>
	<body>
		<header>
			<c:choose>
				<c:when test="${empty sessionScope.pseudo}">
					<div>
						<img alt="logo" src="">
						<a class="text-right" href="<%=request.getContextPath()%>/inscription">S'inscrire</a>
						<a class="text-right" href="<%=request.getContextPath()%>/connection">Se connecter</a>
					</div>
				</c:when>
				<c:when test="${!empty sessionScope.pseudo}">
					<div>
						<img alt="logo" src="">
						<a href="<%=request.getContextPath()%>/NouvelleEnchere">Vendre un article</a>
						<form id="monpseudo" action="<%=request.getContextPath()%>/MonProfil">
							<input type="hidden" name="pseudoUtilisateur" value="${sessionScope.pseudo}"/>
						</form>
						<a href='#' onclick='document.getElementById("monpseudo").submit()'>Mon profil</a>
						<a href="<%=request.getContextPath()%>/Deconnection">Deconnexion</a>
					</div>
				</c:when>
			</c:choose>
			<div>
				<h1 class="text-center">Liste des enchères</h1>
			</div>
		</header>
		<main>
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
						<div>
							<p>Achats</p>
							<div>
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
						<div>
							<p>Mes ventes</p>
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
					</c:if>
					<input type="submit" Value="Rechercher">
				</form>
			</div>
			<br>
			<div class="d-flex justify-content-between ms-md-2">
				<c:forEach var="article" items="${liste}">
					<form action="<%=request.getContextPath()%>/Detail" method="post">
						<div class="card me-md-2" style="width: 18rem;">
							<div class="card-body">
								<input id="numero" name="numero" type="hidden" value="${article.noArticle }">
								<h4 id="nom">${article.nomArticle}</h4>
								<p id="prix">Prix : ${article.miseAPrix}</p>
								<p id="fin">Fin de l'enchère : ${article.dateFin}</p>
								<p id="vender">Vendeur : <a href='#' onclick='document.getElementById("pseudo").submit()'>${article.vendeur.pseudo}</a></p>
								<br>
								<input type="submit" Value="Detail">
							</div>
						</div>
					</form>
					<form id="pseudo" action="<%=request.getContextPath()%>/Profil">
						<input type="hidden" name="pseudoVendeur" value="${article.vendeur.pseudo}"/>
					</form>
				</c:forEach>
			</div>
		</main>
	</body>
</html>