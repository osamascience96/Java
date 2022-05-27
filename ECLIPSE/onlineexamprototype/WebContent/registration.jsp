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
    	img {width:100%;}
    	
    	.row{
    		margin-top: 30px;
    	}
    	
    	.alert{
    		margin-top: 20px;
    	}
    </style>
  </head>
  <body>
	<%@include file="includes/navigation.jsp" %>
	<div class="container">
		<%
			if(request.getParameter("response") != null){
		%>
			<%
				String respond = request.getParameter("response");
				if(respond.compareTo("user_inserted") == 0){
			%>
				<div class="alert alert-success alert-dismissible fade show" role="alert">
				  <strong>Successful!</strong> User Registered Successfully.
				  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
				    <span aria-hidden="true">&times;</span>
				  </button>
				</div>
			<% }else if(respond.compareTo("user_exsts") == 0){ %>
				<div class="alert alert-danger alert-dismissible fade show" role="alert">
				  <strong>Failed!</strong> User Already Exists.
				  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
				    <span aria-hidden="true">&times;</span>
				  </button>
				</div>
			<% } %>
		<% } %>
		<div class="row">
            <div class="col-md-4 py-5 bg-info text-white text-center ">
                <div class=" ">
                    <div class="card-body">
                        <img src="img/registration_bg.svg" style="width:30%">
                        <h2 class="py-3">Registration</h2>
                        <p>Register in to our system to give examination</p>
                    </div>
                </div>
            </div>
            <div class="col-md-8 py-5 border">
                <h4 class="pb-4">Please fill with your details</h4>
                <form action="Register" method="POST">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                          <input id="username" name="username" placeholder="Username" class="form-control" type="text" required>
                        </div>
                        <div class="form-group col-md-6">
                          <input type="email" class="form-control" id="email" name="email" placeholder="Email" required>
                        </div>
                      </div>
                    <div class="form-row">
                        <div class="form-group col">
                          <input type="password" class="form-control" id="password" name="password" placeholder="Password" required>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group">
                            <div class="form-group">
                                <div class="form-check">
                                  <input class="form-check-input" type="checkbox" value="" id="invalidCheck2" required>
                                  <label class="form-check-label" for="invalidCheck2">
                                    <small>By clicking Submit, you agree to our Terms & Conditions, Visitor Agreement and Privacy Policy.</small>
                                  </label>
                                </div>
                              </div>
                    
                          </div>
                    </div>
                    <div class="form-row">
                        <button type="submit" class="btn btn-danger">Submit</button>
                    </div>
                </form>
            </div>
        </div>
	</div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <%@include file="modal/login.jsp" %>
    <%@include file="modal/logout.jsp" %>
    <script src="js/home.js"></script>
  </body>
</html>