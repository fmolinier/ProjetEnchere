<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Liste</title>
		<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<%@ include file="./fragments/header.html" %>
		<main>
			<form action="<%=request.getContextPath()%>/recherche" method="get">
				<input type="search" id="recherche">
				<select id="categorie">
					<option value="tous">Toutes</option>
					<option value="Informatique">Informatique</option>
					<option value="Ameublement">Ameublement</option>
					<option value="Vêtement">Vêtement</option>
					<option value="Sport & loisir">Sport/Loisir</option>
				</select>
				<div>
					<p>Achats</p>
					<div>
					  <input type="radio" name="AchatsVente" value="ouvertes" checked>
					  <label for="ouvertes">enchères ouvertes</label>
					</div>
					<div>
					  <input type="radio" name="AchatsVente" value="enchereencours">
					  <label for="enchereencours">mes enchères en cours</label>
					</div>
					<div>
					  <input type="radio" name="AchatsVente" value="remporter">
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
					  <input type="radio" name="AchatsVente" value="débuter">
					  <label for="débuter">ventes non débutées</label>
					</div>
					<div>
					  <input type="radio" name="AchatsVente" value="terminer">
					  <label for="terminer">ventes terminèes</label>
					</div>
				</div>
				<input type="submit" Value="Rechercher">
			</form>
			<c:forEach var="c" items="${liste}">
				<form action="<%=request.getContextPath()%>/detail" method="get">
					<div><!-- TODO bordure div -->
						<p id="nom">${c.nomArticle}</p>
						<label for="prix">Prix : </label>
						<c:if test="${!empty c.montantEnchere }">
							<p id="prix">${c.montantEnchere}</p>
						</c:if>
						<c:if test="${empty c.montantEnchere}">
							<p id="prix">${c.miseAPrix}</p>
						</c:if>
						<label for="fin">Fin de l'enchére : </label>
						<p id="fin">${c.dateFin}</p>
						<label for="vender">Vendeur : </label>
						<p id="vender">${c.pseudo}</p>
						<input type="submit" Value="Detail">
					</div>
				</form>
			</c:forEach>
		</main>
	</body>
</html>