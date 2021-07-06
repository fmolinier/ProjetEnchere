<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Nouvelle Enchere</title>
	</head>
	<body>
		<h1>Nouvelle Enchere</h1>
		<form action="">
			<label for="nom">nom</label> <input id="nom" type="text"> <label
				for="description">description</label>
			<textarea id="description" rows="5" cols="33"></textarea>
			<label for="categorie">catégorie</label> <select id="categorie">
				<option value="">--choisiessez une option--</option>
				<option value="1">Informatique</option>
				<option value="2">Ameublement</option>
				<option value="3">Vêtement</option>
				<option value="4">Sport/Loisir</option>
			</select> <label for="prix">Mise à prix</label> <input id="prix" type="text">
			<label for="debut">Mise à prix</label> <input type="date" id="debut">
			<label for="fin">Mise à prix</label> <input type="date" id="fin">
			<div>
				<h2>Retrait</h2>
				<label for="rue">Rue</label> 
				<input id="rue" type="text"> 
				<label for="codepostal">Code Postal</label>
				<input id="codepostal" type="text"> 
				<label for="ville">Ville</label> 
				<input id="ville" type="text">
			</div>
			<input type="submit" value="Enregistrer">
		</form>
		<a href="Accueil.jsp"><button>Anuller</button></a>
	</body>
</html>