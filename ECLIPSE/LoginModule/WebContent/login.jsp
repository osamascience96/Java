<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
<style type="text/css">
	html, body{
		margin: 0;
		padding: 0;
		background-color: #a1a1a1;
		font-family: sans-serif;
	}
	h1{
		background-color: white;
		width: 60%;
		text-align: center;
		margin: auto;
		padding: 10px;
		position: relative;
		top: 20px;
		border-radius: 10px;
	}
	form{
		background-color: white;
		width: 50%;
		text-align: center;
		position: relative;
		top: 100px;
		margin: auto;
		padding: 20px;
		border-radius: 10px;
		font-weight: bold;
		font-size: 15px;
	}
	input{
		padding: 10px;
		margin: 10px;
		width: 70%;
		font-weight: bold;
		font-size: 15px;
		border: 2px solid black;
		border-radius: 5px;
	}
	input:hover{
		border-color: #add8e6;
		transition: 0.25s ease-out;
	}
	#login:hover{
		border-color: #add8e6;
		transition: 0.25s ease-out;
		cursor: pointer;
	}
</style>
</head>
<body>
	<h1>Login Form</h1>
	<form action="LogindataServlet" method="POST">
		Username: <input type="text" name="username" placeholder="Enter Username" required> <br>
		Password: <input type="password" name="password" placeholder="Enter Password" required> <br>
		<input id="login" type="submit" value="Login">
	</form>
</body>
</html>