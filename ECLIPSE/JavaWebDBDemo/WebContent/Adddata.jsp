<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Data</title>
<style>
	html, body{
		background-color: pink;
		font-family: sans-serif;
	}
	h2{
		background-color: purple;
		width: 50%;
		text-align: center;
		padding: 10px;	
		margin: auto;
		position: relative;
		top: 40px;
		color: white;
		border: 2px solid white;
		border-radius: 5px;
	}
	form{
		background-color: purple;
		width: 40%;
		margin: 100px auto 100px auto;
		padding: 10px;
		border: 4px solid pink;
		border-radius: 10px;
	}
	form:hover{
		border-color: white;
		transition: 0.20s ease-out;
	}
	input {
		width: 90%;
		margin: 10px;
		padding: 10px;
		font-weight: bold;
		font-size: 20px;
		border: 3px solid purple;
		border-radius: 10px;
	}
	input:hover {
		border-color: white;
		transition: 0.20s ease-in;
	}
	
	.insert-submit{
		margin-left: 20px;
		background-color: white;
		cursor: pointer;
	}
}
</style>
</head>
<body>
	<h2>Add a new Data</h2>
	<form action="insert_data" method="POST">
		<input type="text" name="name" placeholder="Enter her Name" required><br>
		<input type="number" name="age" placeholder="Enter her Age" required><br>
		<input type="number" name="love_status" placeholder="How much you love her in %" required><br>
		<input type="text" name="img_link" placeholder="Give her Image link" required><br>
		<input type="text" name="country_name" placeholder="Where she lives" required><br>
		<input class="insert-submit" type="submit" name="submit" value="Submit Data">
	</form>
</body>
</html>