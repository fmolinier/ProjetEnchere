<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body><!-- ${pageContext.request.contextPath} -->
		<form action="<%=request.getContextPath()%>/connection" method="post">
			<label for="identifiant">Identifiant</label>
			<input type="text" id="identifiant" autofocus="autofocus">
			<label for="motdepasse">Identifiant</label>
			<input type="password" id="motdepasse" >
			<input type="submit" name="connection">
		</form>
		<a href="Inscription.jsp" ><button>Inscription</button></a>
		<c:if test="${alert !empty }">
			<p class="alert alert-warning" role="alert">${alert}</p>
		</c:if>
		
	</body>
</html>