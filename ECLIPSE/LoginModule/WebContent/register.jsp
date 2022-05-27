<%@page import="com.database.Connect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<style type="text/css">
	html, body{
		margin: 0;
		padding: 0;
		width: 100%;
		height: 100%;
		background-color: #a1a1a1;
		font-family: sans-serif;
	}
	
	h3{
		background-color: white;
		width: 50%;
		padding: 20px;
		margin: 100px auto 100px auto;
		position: relative;
		top: 50px;
		text-align: center;
		font-size: 20px;
		border: 2px solid black;
		border-radius: 5px;
	}
	
	form{
		background-color: white;
		width: 60%;
		margin: auto;
		padding: 20px;
		position: relative;
		top: 50px;
		border: 2px solid black;
		border-radius: 5px;
	}
	
	form > label{
		font-weight: bold;
	}
	
	form > input{
		width: 90%;
		margin: 10px;
		padding: 5px;
		font-size: 20px;
		border: 1px solid white;
		border-radius: 5px;
	}
	
	form > input:hover{
		border-color: black;
		transition: 0.20s ease-in;
	}
	input[type="submit"]{
		font-weight: bold;
		cursor: pointer;
		border: 2px solid white;
		border-radius: 5px;
	}
	input[type="submit"]:hover{
		border-color: black;
	}
</style>
</head>
<body>
	<h3>Registration Form</h3>
	<form action="RegisterDataServlet" method="POST">
		<label for="name">Name: </label><input type="text" name="name" placeholder="Enter Name" required> <br>
		<label for="name">Username: </label><input type="text" name="username" placeholder="Enter Username" required> <br>
		<label for="name">Password: </label><input type="password" name="password" placeholder="Enter Password" required> <br>
		<input type="submit" value="Register">
	</form>
</body>
</html>