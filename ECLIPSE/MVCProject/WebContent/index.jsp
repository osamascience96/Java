<!doctype html>
<%@page import="bean.StatePair"%>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Home</title>
    <style>
    	.container{
    		margin-top: 10px!important;
    	}
    </style>
  </head>
  <body>
  	<div class="container">
  		<% if(request.getParameter("response") != null){ %>
  			<% String respond = request.getParameter("response"); %>
  			<% 
  				String alertType = "";
  				String alertTitle = "";
  				String alertMessage = "";
  				
  				if(respond.compareTo("state_found") == 0) {
  					alertType = "success";
  					alertTitle = "State Found!";
  					alertMessage = "Your State Found Successfully.";
  				}else if(respond.compareTo("no_states") == 0){
  					alertType = "danger";
  					alertTitle = "State Not Found!";
  					alertMessage = "Your State was not found.";
  				}
			%>
			<div class="alert alert-<%=alertType%> alert-dismissible fade show" role="alert">
			  <strong><%=alertTitle%></strong> <%=alertMessage%>
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
			</div>
  		<% } %>
  		<form action="state_controller_servlet" method="post">
  			<% 
  				StatePair statePair = (StatePair) session.getAttribute("state_session");
  			%>
  			<div class="form-group">
  				<label>Enter US State</label>
  				<input type="text" value="<%=statePair != null ? statePair.getStateName() : ""%>" name="state" id="state" class="form-control" placeholder="US State" required>
  			</div>
  			<button type="submit" class="btn btn-outline-success btn-block">Get Abbreviation</button>
  		</form>
  		<h4 class="text-center"><%= statePair != null ? statePair.getStateAbbreviation() : "" %></h4>
  	</div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>