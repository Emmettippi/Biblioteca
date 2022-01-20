<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrazione</title>
</head>
<body>
	<form action="/Biblioteca/registrazione" Method="POST">
		<p>Inserisci Nome</p>
		<input type="text" name="nome">
		<p>Inserisci Cognome</p>
		<input type="text" name="cognome">
		<p>Inserisci Username</p>
		<input type="text" name="username">
		<p>Inserisci Email</p>
		<input type="email" name="email">
		<p>Inserisci Password</p>
		<input type="password" name="password"> <input type="submit"
			value="crea">
	</form>


</body>
</html>