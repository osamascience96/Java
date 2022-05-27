<%@page import="com.models.Record"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%! private Record record; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Data</title>
<style type="text/css">
	html, body{
		margin: 0;
		padding: 0;
		scroll-behaviour: smooth;
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
	form {
		background-color: purple;
		width: 50%;
		margin: auto;
		position: relative;
		top: 50px;
		padding: 10px;
		overflow: hidden;
		border: 2px solid white;
		border-radius: 3px;
	}
	form:hover{
		border: 2px solid #E52EEE;
		transition: 0.1s ease-in-out;
	}
	input{
		margin: 10px;
		width: 80%;
		position: relative;
		left: 40px;
		padding: 10px;
		font-weight: bold;
	}
	input:hover{
		border: 2px solid black;
		border-radius: 5px;
		transition: 0.1s ease-in;
		cursor: pointer;
	}
	.submit-btn{
		border: 3px solid white;
		background-color: silver;
	}
	
	.submit-btn:hover {
		background-color: #B00BEE;
		border-style: solid;
		border-color: #E52EEE;
		color: white;
		transition: 0.1s ease-in-out;
	}
	
</style>
</head>
<body>
	<%
		record = (Record) request.getAttribute("record");
	%>
	<!-- heading -->
	<h2>Edit Record Attributes</h2>
	<form action="UpdateRecordServlet" method="POST">
		<input type="hidden" name="id" value="<%=record.getID()%>">
		<input type="text" name="name" placeholder="Enter Name" value="<%=record.getName()%>"><br>
		<input type="number" name="age" placeholder="Enter Age" value="<%=record.getAge()%>"><br>
		<input type="number" name="love_status" placeholder="Enter Love Status" value="<%=record.getLoveStatus()%>"><br>
		<input type="text" name="img_link" placeholder="Enter the Image Link" value="<%=record.getImageLink()%>"><br>
		<input type="text" name="country" placeholder="Enter Country" value="<%=record.getCountry()%>"><br>
		<input class="submit-btn" type="submit" name="submit" value="Edit Record" >
	</form>
</body>
</html>