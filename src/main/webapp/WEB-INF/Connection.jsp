<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Connection</title>
		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<div class="text-center">
			<form action="<%=request.getContextPath()%>/connection" method="post">
				<label for="identifiant">Identifiant : </label>
				<input type="text" name="identifiant" id="identifiant" autofocus="autofocus">
				<br>
				<label for="motdepasse">Mot de passe : </label>
				<input type="password" name="motdepasse" id="motdepasse" >
				<input type="submit" value="connection">
			</form>
			<a href="<%=request.getContextPath()%>/inscription" ><button>Inscription</button></a>
			<c:if test="${alert != null}">
				<p class="alert alert-warning" role="alert">${alert}</p>
			</c:if>
		</div>
	</body>
</html>