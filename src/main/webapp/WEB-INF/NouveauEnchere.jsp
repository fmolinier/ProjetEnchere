<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Nouvelle Enchere</title>
		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<h1>Nouvelle Enchere</h1>
		<form action="<%=request.getContextPath()%>/NouvelleEnchere" method="post">
			<label for="nom">nom</label> 
			<input name="nom" type="text"> 
			<br>
			<label for="description">description</label>
			<textarea name="description" rows="5" cols="33"></textarea>
			<br>
			<label for="categorie">catégorie</label> 
			<select name="categorie">
				<option value="">--choisiessez une option--</option>
				<option value="Informatique">Informatique</option>
				<option value="Ameublement">Ameublement</option>
				<option value="Vêtement">Vêtement</option>
				<option value="Sport & loisir">Sport/Loisir</option>
			</select> 
			<br>
			<label for="prix">Mise à prix</label> 
			<input name="prix" type="text">
			<br>
			<label for="debut">Date debut</label> 
			<input type="date" name="debut">
			<br>
			<label for="fin">Date fin</label> 
			<input type="date" name="fin">
			<br>
			<div>
				<h2>Retrait</h2>
				<br>
				<label for="rue">Rue</label> 
				<input name="rue" type="text"> 
				<br>
				<label for="codepostal">Code Postal</label>
				<input name="codepostal" type="text"> 
				<br>
				<label for="ville">Ville</label> 
				<input name="ville" type="text">
			</div>
			<br>
			<input type="submit" value="Enregistrer">
		</form>
		<a href="Accueil.jsp"><button>Anuller</button></a>
	</body>
</html>