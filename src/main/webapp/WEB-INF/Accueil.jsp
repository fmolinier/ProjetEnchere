<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1"> 
		<title>Accueil</title>
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
				<input type="submit" Value="Rechercher">
			</form>
			<c:forEach var="c" items="${liste}">
				<div>
					<label>${c.nomArticle}</label>
				</div>
			</c:forEach>
		</main>
	</body>
</html>