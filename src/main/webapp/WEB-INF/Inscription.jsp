<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Inscription</title>
		<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<form name="inscription" action="<%=request.getContextPath()%>/inscription" method="post">
			<label for="pseudo">Pseudo</label>
			<input type="text" id="pseudo">
			<label for="nom">Nom</label>
			<input type="text" id="nom" autofocus="autofocus">
			<label for="prenom">Prenom</label>
			<input type="text" id="prenom">
			<label for="email">E-mail</label>
			<input type="text" id="email">
			<label for="telephone">Téléphone</label>
			<input type="text" id="telephone">
			<label for="rue">Rue</label>
			<input type="text" id="rue">
			<label for="codepostal">Code Postal</label>
			<input type="text" id="codepostal">
			<label for="ville">Ville</label>
			<input type="text" id="ville">
			<label for="motdepasse">Mot de passe</label>
			<input type="password" id="motdepasse">
			<label for="confirmation">Confirmation</label>
			<input type="password" id="confirmation">
			<input type ="submit" value="Enregister">
		</form>
		<!-- EREUR deja pseudo -->
		<a href="<%=request.getContextPath()%>/Accueil"><button>Anuller</button></a>
	</body>
</html>