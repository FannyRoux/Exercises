<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Présentation des principaux objets disponibles</title>
</head>
<body>
	<h1>Request</h1>
	<p><%=request.getContextPath() %></p>
	
	<h1>Response</h1>
	<p><%=response.getStatus()%></p>
	
	<h1>Out</h1>
	<p><% out.print("Bonjour"); %></p>
	
	<a href="<%=request.getContextPath()%>/modules/module3/demonstration5.html">Retour</a>
</body>
</html>