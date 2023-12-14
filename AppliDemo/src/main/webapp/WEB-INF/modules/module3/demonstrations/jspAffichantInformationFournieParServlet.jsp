<%@ page language="java" 
		 contentType="text/html; charset=UTF-8"
   		 pageEncoding="UTF-8"%>
   		 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Une JSP affichant l'information fournie par la Servlet</title>
</head>
<body>
	<%
		String uneVariable = (String) request.getAttribute("uneCle");
	%>
	
	L'information fournie par la Servlet est : <%=uneVariable%>
	<p>
	<a href="<%=request.getContextPath()%>/modules/module3/demonstration6.html">Retour</a>
	</p>
</body>
</html>