<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Addition Result</title>
<style type="text/css">
	h1{
		color: white;
	}
	#result{
		color: blue;
	}
</style>
</head>
<body bgcolor="cyan">
	<!-- Adding the scriptlet -->
	<%
		// getting the numbers from the implict request object that 
		// is of the object type of the form method either GET/pOST
		int i = Integer.parseInt(request.getParameter("num1"));
		int j = Integer.parseInt(request.getParameter("num2"));
		
		
	%>
	
	<h1>The of adding 2 nums are: <span id="result"><%= i+j %></span></h1>
	
	
</body>
</html>