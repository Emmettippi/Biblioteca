<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h1>LOGIN</h1>
	<form action="/Biblioteca/">
		<label><b>Username</b></label> <input type="text"
			placeholder="Enter Username" name="username"> <label><b>Password</b></label>
		<input type="password" placeholder="Enter Password" name="password">
		<a href="/Biblioteca/registrazione">sign in</a>
		<button type="submit">Login</button>
	</form>


</body>
</html>