<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-type" content="text/html" charset="UTF-8">
<title>Choix du joueur</title>
</head>
<body>
	<h1>Jeu du Chifoumi</h1>

	<div>
		<h2>Veuillez choisir votre coup !</h2>
	</div>

	<form action="/TPChifoumi/chifoumi" method="post">
		<div>
			<p>
				<input type="submit" value="Caillou" name="userChoice">
			</p>
			<p>
				<input type="submit" value="Papier" name="userChoice">
			</p>
			<p>
				<input type="submit" value="Ciseaux" name="userChoice">
			</p>
		</div>
	</form>
</body>
</html>