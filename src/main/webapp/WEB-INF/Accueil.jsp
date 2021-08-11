<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1"> 
		<title>Accueil</title>
		<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<header>
			<c:choose>
				<c:when test="${empty sessionScope.pseudo}">
					<div>
						<img alt="logo" src="">
						<a href="<%=request.getContextPath()%>/inscription">S'inscrire</a>
						<a href="<%=request.getContextPath()%>/connection">Se connecter</a>
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
				<h1>Liste des encheres</h1>
			</div>
		</header>
		<main>
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
			<c:forEach var="article" items="${liste}">
				<form action="<%=request.getContextPath()%>/Detail" method="post">
					<div class="border border-info">
						<input id="numero" name="numero" type="hidden" value="${article.noArticle }">
						<p id="nom">${article.nomArticle}</p>
						<label for="prix">Prix : </label>
   						<p id="prix">${article.miseAPrix}</p>
						<label for="fin">Fin de l'enchére : </label>
						<p id="fin">${article.dateFin}</p>
						<label for="vender">Vendeur : </label>
						<label id="vender"> 						
							<a href='#' onclick='document.getElementById("pseudo").submit()'>${article.vendeur.pseudo}</a>
						</label>
						<br>
						<input type="submit" Value="Detail">
					</div>
				</form>
				<form id="pseudo" action="<%=request.getContextPath()%>/Profil">
					<input type="hidden" name="pseudoVendeur" value="${article.vendeur.pseudo}"/>
				</form>
			</c:forEach>
		</main>
	</body>
</html>