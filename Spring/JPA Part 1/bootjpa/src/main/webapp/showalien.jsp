<%@page import="com.webproject.demo.model.Alien"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alien</title>
</head>
<body>
	<%
		Alien alien = (Alien) request.getAttribute("alien");
	%>
	
	<%= alien.getAid() %>
	<%= alien.getAname() %>
	<%= alien.getTech() %>
</body>
</html>