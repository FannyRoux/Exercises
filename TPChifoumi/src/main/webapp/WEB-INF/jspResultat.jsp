<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String resultatPartie = (String) request.getAttribute("résultat");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Résultat de la partie</title>
</head>
<body>
	<h1>Résultat de la partie</h1>


	<p>
		<%
		out.write(resultatPartie);
		%>
	</p>

	<p>
	<a href="chifoumi"> Rejouer</a>
		
	</p>

</body>
</html>