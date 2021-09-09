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
	<body>
		<h1 class=" text-center mt-md-2">Detail vente</h1>
		<h3 class="text-center mt-md-2" id="nomArticle"><b>${nomArticle}</b></h3>
		<div class="mt-md-2 d-flex justify-content-around">
			<form  action="<%=request.getContextPath()%>/Encherir" method="post">
				<div class="mt-md-2 d-flex align-items-start">
					<input name="numero" name="numero" type="hidden" value="${numeroArticle}">
					<label for="description">Description : </label>
					<textarea name="description" disabled="disabled" style="font-weight: bold">${description}</textarea>
				</div>
				<div class="mt-md-2 justify-content-around">
					<p id="categorie">Categorie : <b>${categorie}</b></p>
				</div>
				<div class="mt-md-2 justify-content-around">
					<c:if test="${enchere != 0}">
						<p id="enchere">Meilleure offre : <b>${enchere}</b> par 						
							<a href='<%=request.getContextPath()%>/Profil?pseudo=${pseudoenchere}'><b>${pseudoenchere}</b></a>
						</p>
					</c:if>
				</div>
				<div class="mt-md-2 justify-content-around">
					<p id="prix">Mise à prix : <b>${prix}</b> </p>
				</div>
				<div class="mt-md-2 justify-content-around">
					<p id="fin">Fin de l'enchère : <b>${fin}</b></p>
				</div>
				<div class="mt-md-2 justify-content-around">
					<div class="card me-md-2" style="width: 25rem;">
						<div class="card-body border border-dark">
							<h3>Retrait</h3>
							<div class="mt-md-2 justify-content-around">
								<p id="rue">rue : <b>${rue}</b></p>
							</div>
							<div class="mt-md-2 justify-content-around">
								<p id="codepostal">Code postal : <b>${codepostal}</b></p>
							</div>
							<div class="mt-md-2 justify-content-around">
								<p id="ville">Ville : <b>${ville}</b></p>
							</div>
						</div>
					</div>
				</div>
				<div class="mt-md-2 justify-content-around">
					<p id="vendeur">						
						Vendeur : <a href='<%=request.getContextPath()%>/Profil?pseudo=${vendeur}'><b>${vendeur}</b></a>
					</p>
				</div>
				<div class="mt-md-2 justify-content-around">
					<c:if test="${!empty sessionScope.pseudo}">
						<label for="proposition">Ma proposition : </label>
						<c:choose>
							<c:when test="${ enchere <= 0 }">
								<input type="number" name="proposition" value="${prix}">
							</c:when>
							<c:when test="${ enchere > 0 }">
								<input type="number" name="proposition" value="${enchere}">
							</c:when>
						</c:choose>
						<input type="number" name="proposition" value="${enchere}">
						<button type="submit" class="btn btn-outline-primary">Enchérir</button>
					</c:if>
				</div>
			</form>
		</div>
	</body>
</html>