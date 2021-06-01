<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<h4>Insert Record</h4>
	<form action="addAlien">
		<input type="number" name="aid" placeholder="Alien Id" required> <br>
		<input type="text" name="aname" placeholder="Alien Name" required> <br>
		<input type="text" name="tech" placeholder="Alien Tech" required> <br>
		<input type="submit">
	</form>
	
	<h4>Find By Alien Id</h4>
	<form action="getAlien">
		<input type="number" name="aid" placeholder="Alien Id" required> <br>
		<input type="submit">
	</form>
	
	<h4>Delete By Alien Id</h4>
	<form action="deleteAlien">
		<input type="number" name="aid" placeholder="Alien Id" required> <br>
		<input type="submit">
	</form>
	
	<a href="showallaliens">Show All Aliens</a>
</body>
</html>