<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <!-- css -->
    <link rel="stylesheet" href="css/index.css" >
    <link rel="stylesheet" href="css/navigation.css">
    <link rel="stylesheet" href="css/footer.css">
    
    <title>Home</title>
  </head>
  <body>
      <%@include file="snippets/navigation.html" %>
      <% if(request.getParameter("response") != null){%>
        <% if(request.getParameter("response").compareTo("user_not_exists") == 0){%>
            <div class="alert alert-warning alert-dismissible fade show" role="alert">
                <strong>Stop!</strong> User data not found.
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
            </div>
        <% }else if(request.getParameter("response").compareTo("user_login_validation_failed") == 0){%>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <strong>Failed!</strong> User Login Failed.
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
            </div>
        <% }%>
      <% }%>
      <form action="login_servlet" method="POST">
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
            <input type="submit" name="submit" value="Login In" class="col btn btn-primary">
        </div>
      </form>
      
      <h5 id="redir_register">
          <a href="register.jsp">Not a Member. Register to our System.</a>
      </h5>
      
      <%@include file="snippets/footer.html" %>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>