<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Register</title>
    <style>
    	.container{
    		margin-top: 10px;
    	}
    </style>
  </head>
  <body>
    <div class="container">
    	<% if(request.getParameter("response") != null){ %>
    		<%
    			String resp = request.getParameter("response");
    			String alertType = "";
    			String alertTitle = "";
    			String alertMessage = "";
    			
    			if(resp.compareTo("success") == 0){
    				alertType = "success";
    				alertTitle = "Success";
    				alertMessage = "User added to the System successfully";
    			}else if(resp.compareTo("already_exists") == 0){
    				alertType = "danger";
    				alertTitle = "Failed";
    				alertMessage = "User already exists in System.";
    			}
    		%>
    		<div class="alert alert-<%=alertType%> alert-dismissible fade show" role="alert">
			  <strong><%=alertTitle%>!</strong> <%=alertMessage%>.
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
			</div>
    	<% }%> 
    	<form action="Registration" method="post">
    		<div class="form-group">
    			<label for="username">Enter Username</label>
    			<input id="username" class="form-control" type="text" name="username" placeholder="Username" required>
    		</div>
    		<div class="form-group">
    			<label for="password">Enter Password</label>
    			<input id="password" class="form-control" type="password" name="password" placeholder="Password" required>
    		</div>
    		<button type="submit" class="btn btn-outline-primary btn-block">Register</button>
    	</form>
    	<a href="index.jsp">Already a member. Login to Continue.</a>
    </div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>