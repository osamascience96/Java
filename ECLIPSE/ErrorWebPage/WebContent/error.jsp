<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Generated</title>
</head>
<body bgcolor="red">
	<h2 style="color: white;">The Error is: <%= exception.getMessage() %></h2>
</body>
</html>