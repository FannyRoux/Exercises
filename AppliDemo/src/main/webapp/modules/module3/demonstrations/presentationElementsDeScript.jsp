<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%!// déclarations
	private int nbAppel;

	private int getNbAppel() {
		return this.nbAppel;
	}

	private void setNbAppel(int nbAppel) {
		this.nbAppel = nbAppel;
	}%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Présentation des éléments de script</title>
</head>
<body>
	<%
		//scriptlets
		this.setNbAppel(this.getNbAppel()+1);
	%>
	
	Nombre d'appel de la JSP :
	<input type="text" value="<%=this.getNbAppel()%>"/>
	<a href ="presentationElementsDeScript.jsp"> Actualiser</a>
	<a href ="demonstration4.html">Retour</a>
	
</body>
</html>