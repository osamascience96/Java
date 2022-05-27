<!doctype html>
<%@page import="bean.Course"%>
<%@page import="bean.User"%>
<%@page import="java.util.ArrayList"%>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Coruses</title>
  </head>
  <body>
    <div class="container">
    	
    	<%
    		ArrayList<Course> courseArrayList = (ArrayList<Course>) session.getAttribute("course_list");
    		User userObj = (User) session.getAttribute("userObj");
    	%>
    	<h2>Welcome: <%=userObj.getName()%></h2>
    	<%
    		if(courseArrayList != null){
    	%>
    		<%
    			for(int i=0; i < courseArrayList.size(); i++){
    		%>
    			<div class="card border-primary mb-3">
				  <div class="card-header"><%=courseArrayList.get(i).getId()%></div>
				  <div class="card-body text-primary">
				    <h5 class="card-title"><%=courseArrayList.get(i).getName()%></h5>
				    <p class="card-text">The Grades are: <%=courseArrayList.get(i).getGrades()%></p>
				  </div>
				</div>
    		<% }%>
    	<% }%>
    	<a href="Logout" class="btn btn-outline-primary btn-block">Logout</a>
    </div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>