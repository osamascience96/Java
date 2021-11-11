<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <link rel="stylesheet" type="text/css" href="css/navigation.css">
    <link rel="stylesheet" type="text/css" href="css/footer.css">
    
    <title><%=session.getAttribute("login") == null ? "Login" : "Home"%></title>
  </head>
  <body>
    <%@include file="includes/navigation.jsp" %>
    
    <%
        if(request.getParameter("error") != null){
            String error_type = request.getParameter("error");
    %>
        <% if(error_type.compareToIgnoreCase("email-error") == 0){%>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <strong>Email Error!</strong> The format of the email is incorrect.
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
            </div>
        <% }else if(error_type.compareToIgnoreCase("password_error") == 0){%>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <strong>Password Error!</strong> The Password should be greater than 8 characters.
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
            </div>
        <% }else if(error_type.compareToIgnoreCase("login-credentials") == 0){%>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <strong>Wrong Credentials!</strong> Email or password is incorrect.
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
            </div>
        <% }%>
    <%  }%>
    
    <% if(session.getAttribute("login") == null){%>
        <div class="container">
            <form action="login_servlet" method="POST">
                <div class="form-group">
                    <h4 class="text-center">Login to System</h4>
                </div>
                <div class="form-group">
                    <input class="form-control" type="email" name="email" placeholder="Enter Email Address" required>
                </div>
                <div class="form-group">
                    <input class="form-control" type="password" name="password" placeholder="Enter Password" required>
                </div>
                <div class="form-group">
                    <input type="submit" name="submit" class="form-control btn btn-primary" value="Log In">
                </div>
            </form>
        </div>
    <% }else{ %>
        <% 
            boolean is_login = (Boolean) session.getAttribute("login");
        %>
        <% if(is_login){%>
            <div class="container" style="height:700px!important; overflow: scroll; ">
                <div id="card-view" class="row">
                    <div class="card" style="width: 16rem;">
                        <img class="card-img-top" height="200px" src="img/employees.jpg" alt="Card image cap">
                        <div class="card-body">
                          <h5 class="card-title">Employee</h5>
                          <p class="card-text">Company Employee and their assets and information. Manage the employees and the data.</p>
                          <button class="btn btn-outline-primary btn-block" onclick="redirect('employee')">Action</button>
                        </div>
                    </div>
                    <div class="card" style="width: 16rem;">
                        <img class="card-img-top" height="200px" src="img/teams.jpg" alt="Card image cap">
                        <div class="card-body">
                          <h5 class="card-title">Teams</h5>
                          <p class="card-text">Company Teams and their assets and information. Manage the Teams and the data.</p>
                          <button class="btn btn-outline-primary btn-block" onclick="redirect('teams')">Action</button>
                        </div>
                    </div>
                    <div class="card" style="width: 16rem;">
                        <img class="card-img-top" height="200px" src="img/tasks.jpg" alt="Card image cap">
                        <div class="card-body">
                          <h5 class="card-title">Tasks</h5>
                          <p class="card-text">Company Tasks and their assets and information. Manage the Tasks and the data.</p>
                          <button class="btn btn-outline-primary btn-block" onclick="redirect('tasks')">Action</button>
                        </div>
                    </div>
                    <div class="card" style="width: 16rem;">
                        <img class="card-img-top" height="200px" src="img/jobs.jpg" alt="Card image cap">
                        <div class="card-body">
                          <h5 class="card-title">Jobs</h5>
                          <p class="card-text">Company Jobs and their assets and information. Manage the Jobs and the data.</p>
                          <button class="btn btn-outline-primary btn-block" onclick="redirect('jobs')">Action</button>
                        </div>
                    </div>
                </div>
            </div>
        <% }%>
    <% }%>
    
    <%@include file="includes/footer.html" %>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    
    <!-- script for the toggle-->
    <script>
        $(document).ready(function(){
           $('[data-toggle="tooltip"]').tooltip(); 
        });
    </script>
    <script type="text/javascript" src="javascript/home.js"></script>
  </body>
</html>