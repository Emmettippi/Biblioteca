<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>${libro.titolo}</h1>
	<p>id: ${libro.id}</p>
	<p>isbn: ${libro.isbn}</p>
	<p>autori: ${libro.autori}</p>
	<p>note : ${libro.note}</p>
	<p>stato : ${libro.stato}</p>
	<a href="./prenota?id=${libro.id}">prenota</a>
</body>
</html>