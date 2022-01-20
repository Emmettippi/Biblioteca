<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Catalogo</title>
</head>
<body>
	<table>
		<tr>
			<th>ID</th>
			<th>TITOLO</th>
			<th>Categoria</th>
			<th>Dettaglio</th>
		</tr>
		<c:forEach items="${libri}" var="libro">
			<tr>
				<td>${libro.id}</td>
				<td>${libro.titolo}</td>
				<td>${libro.categoria}</td>
				<td><a href="./dettaglio?id=${libro.id}">Vai al dettaglio</a></td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>