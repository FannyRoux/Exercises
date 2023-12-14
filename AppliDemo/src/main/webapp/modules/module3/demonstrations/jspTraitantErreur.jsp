<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Une page gérant les erreurs survenues dans les JSP</title>
</head>
<body>
	<h1>Erreur :</h1>
	<p>
		(<%=exception%>)<%=exception.getMessage()%>
	</p>
	<a href="<%=request.getContextPath()%>/modules/module3/demonstration7html">Retour</a>

</body>
</html>