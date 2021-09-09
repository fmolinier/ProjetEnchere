<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Nouvelle Enchere</title>
		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	</head>
	<header>
		<nav class="navbar navbar-expand-lg navbar-light bg-info">
				<a class="navbar-brand" href="<%=request.getContextPath()%>/Accueil"> 
					<img src="/image/logo.svg" class="img-responsive" alt="logo">
				</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
					<div class="navbar-nav">
						<a class="nav-link ms-md-2 text-dark" href="<%=request.getContextPath()%>/NouvelleEnchere">Vendre un article</a>
						<form id="monpseudo" action="<%=request.getContextPath()%>/MonProfil">
							<input type="hidden" name="pseudoUtilisateur" value="${sessionScope.pseudo}" />
						</form>
						<a class="nav-link ms-md-2 text-dark" href='#' onclick='document.getElementById("monpseudo").submit()'>Mon profil</a> 
						<a class="nav-link ms-md-2 text-dark" href="<%=request.getContextPath()%>/Deconnection">Deconnexion</a>
					</div>
				</div>
			</nav>
	</header>
	<body>
		<h1 class="text-center">Nouvelle Enchere</h1>
		<div class="mt-md-2 d-flex justify-content-around">
			<form action="<%=request.getContextPath()%>/NouvelleEnchere" method="post">
				<div class="mt-md-2 justify-content-around">
					<label for="nom">nom : </label> 
					<input name="nom" type="text"> 
				</div>
				<div class="mt-md-2 d-flex align-items-start">
					<label for="description">description : </label>
					<textarea class="mt-md-2" name="description" rows="5" cols="33"></textarea>
				</div>
				<div class="mt-md-2 justify-content-around">
					<label for="categorie">catégorie : </label> 
					<select name="categorie">
						<option value="">--choisiessez une option--</option>
						<option value="Informatique">Informatique</option>
						<option value="Ameublement">Ameublement</option>
						<option value="Vêtement">Vêtement</option>
						<option value="Sport & loisir">Sport/Loisir</option>
					</select>
				</div>
				<div class="mt-md-2 justify-content-around">
					<label for="prix">Mise à prix : </label> 
					<input name="prix" type="text">
				</div>
				<div class="mt-md-2 justify-content-around">
					<label for="debut">Date debut : </label> 
					<input type="date" name="debut">
				</div>
				<div class="mt-md-2 justify-content-around">
					<label for="fin">Date fin : </label> 
					<input type="date" name="fin">
				</div>
				<div class="mt-md-2 justify-content-around">
					<div class="card me-md-2" style="width: 25rem;">
						<div class="card-body border border-dark">
							<h2>Retrait</h2>
							<div class="mt-md-2 justify-content-around">
								<label for="rue">Rue : </label> 
								<input name="rue" type="text"> 
							</div>
							<div class="mt-md-2 justify-content-around">
								<label for="codepostal">Code Postal : </label>
								<input name="codepostal" type="text"> 
							</div>
							<div class="mt-md-2 justify-content-around">
								<label for="ville">Ville : </label> 
								<input name="ville" type="text">
							</div>
						</div>
					</div>
				</div>
				<button class="mt-md-2 btn btn-outline-primary" type="submit">Enregistrer</button>
				<a class="mt-md-2" href="Accueil.jsp"><button class="btn btn-outline-primary" >Anuller</button></a>
			</form>
		</div>
	</body>
</html>