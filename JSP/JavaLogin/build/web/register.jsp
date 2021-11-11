<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <!-- css -->
    <link rel="stylesheet" href="css/register.css" >
    <link rel="stylesheet" href="css/navigation.css">
    <link rel="stylesheet" href="css/footer.css">
    
    <title>Registration</title>
  </head>
  <body>
    <%@include file="snippets/navigation.html" %>
    
    <% if(request.getParameter("write_response") != null){%>
        <% if(request.getParameter("write_response").compareTo("user_created") == 0){%>
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                <strong>Success!</strong> Data Created Successfully.
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
            </div>
        <% }else if(request.getParameter("write_response").compareTo("user_not_created") == 0){%>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <strong>Failed!</strong> Data could not be created due to some problem.
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
            </div>
        <% }else if(request.getParameter("write_response").compareTo("user_exists") == 0){%>
            <div class="alert alert-warning alert-dismissible fade show" role="alert">
                <strong>Stop!</strong> User already exists in the file.
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
            </div>
        <% }%>
    <% }%>
    
    <form action="register_user" method="POST">
        <div class="row">
            <div class="col form-group">
                <label for="first_name">Enter First Name:</label>
                <input id="first_name" class="form-control" type="text" name="first_name" placeholder="First Name" required>
            </div>
        </div>
        <div class="row">
            <div class="col form-group">
                <label for="last_name">Enter Last Name:</label>
                <input id="last_name" class="form-control" type="text" name="last_name" placeholder="Last Name" required>
            </div>
        </div>
        <div class="row">
            <div class="col form-group">
                <label for="email">Enter Email Address:</label>
                <input id="email" class="form-control" type="email" name="email" placeholder="Email Address" required>
            </div>
        </div>
        <div class="row">
            <div class="col form-group">
                <label for="password">Enter Password:</label>
                <input id="password" class="form-control" type="password" name="password" placeholder="Password" required>
            </div>
        </div>
        <div class="row">
            <input type="submit" name="submit" value="Register" class="col btn btn-primary">
        </div>
      </form>
    
      <h5 id="redir_login">
          <a href="index.jsp">Already a member. Login to our System.</a>
      </h5>
    <%@include file="snippets/footer.html" %>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>