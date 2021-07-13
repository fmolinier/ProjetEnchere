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
					  <input type="radio" id="huey" name="drone" value="huey" checked>
					  <label for="huey">Huey</label>
					</div>
					<div>
					  <input type="radio" id="dewey" name="drone" value="dewey">
					  <label for="dewey">Dewey</label>
					</div>
					<div>
					  <input type="radio" id="louie" name="drone" value="louie">
					  <label for="louie">Louie</label>
					</div>
				</div>
				<div>
					<p>Mes ventes</p>
					<div>
					  <input type="radio" id="huey" name="drone" value="huey" checked>
					  <label for="huey">Huey</label>
					</div>
					<div>
					  <input type="radio" id="dewey" name="drone" value="dewey">
					  <label for="dewey">Dewey</label>
					</div>
					<div>
					  <input type="radio" id="louie" name="drone" value="louie">
					  <label for="louie">Louie</label>
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
						<c:if test="empty c.montantEnchere">
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