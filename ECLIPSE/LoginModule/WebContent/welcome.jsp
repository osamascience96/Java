<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
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
		padding: 10px;
		margin: auto;
		position: relative;
		top: 10px;
		border-radius: 10px;
		text-align: center;
	}
	.video{
		background-color: white;
		width: 60%;
		text-align: center;
		margin: auto;
		padding: 10px;
		position: relative;
		top: 100px;
		border-radius: 10px;
	}
	.video > iframe{
		border-radius: 10px;
		width: 100%;
	}
	.logoutbtn{
		width: 50%;
		margin: auto;
		padding: 10px;
		position: relative;
		top: 300px;
		text-align: center;
	}
	.logoutbtn > a{
		text-decoration: none;
		background-color: white;
		padding: 25px;
		border: 2px solid black;
		color: black;
		border-radius: 10px;
		font-weight: bold;
	}
	.logoutbtn > a:hover{
		color: green;
		border-color: green;
		transition: 0.25s ease-out;
	}
</style>
</head>
<body>
	<%
		// disabling the cache to save any of the content 
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // Http 1.1
		response.setHeader("Pragma", "no-cache"); // Http 1.0
	%>
	<%
		// check if the session is set
		if(session.getAttribute("username") == null){
			response.sendRedirect("login.jsp");
		}
	%>
	
	<h1>Welcome, Brother <%=session.getAttribute("username")%></h1>
	<!-- embedding the video -->
	<div class="video">
		<iframe width="560" height="315" src="https://www.youtube.com/embed/wiccMCIVkSY" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
	</div>
	<div class="logoutbtn">
		<a href="LogoutServlet">LogOut</a>
	</div>
</body>
</html>