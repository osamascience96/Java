<%@page import="com.webproject.demo.Alien"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<%
		Alien alien = (Alien) request.getAttribute("obj");
	%>
	Welcome <%= alien.getAid() %>
	Your Name is <%= alien.getAname() %>
	You speak <%= alien.getLang() %>
</body>
</html>