<%@page import="com.webproject.demo.model.Alien"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Aliens</title>
</head>
<body>
	<% ArrayList<Alien> arrayListAliens = (ArrayList<Alien>) request.getAttribute("alienList"); %>
	<% if(arrayListAliens != null){ %>
		<% if(arrayListAliens.size() > 0){ %>
			<% for(int i=0; i < arrayListAliens.size(); i++){ %>
				<h3><%=arrayListAliens.get(i).getAid() %>==> <%=arrayListAliens.get(i).getAname() %> ==> <%=arrayListAliens.get(i).getTech() %></h3>
			<% } %>
		<% }else{ %>
			<h4>No Aliens Available Right Now.</h4>
		<% } %>
	<% }else{ %>
		<% response.sendRedirect("/"); %>
	<% } %>
</body>
</html>