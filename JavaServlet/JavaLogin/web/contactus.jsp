<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    
    <!-- css -->
    <link rel="stylesheet" href="css/contactus.css" >
    <link rel="stylesheet" href="css/navigation.css">
    <link rel="stylesheet" href="css/footer.css">
    
    <title>Contact Us</title>
  </head>
  <body>
      <%@include file="snippets/navigation.html" %>
      <% if(request.getParameter("response") != null){%>
        <% if(request.getParameter("response").compareTo("true") == 0){ %>
          <div class="alert alert-success alert-dismissible fade show" role="alert">
              <strong>Success!</strong> Query Submitted Successfully.
              <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
          </div>
        <% }else{%>
          <div class="alert alert-danger alert-dismissible fade show" role="alert">
              <strong>Failed!</strong> Query could not be submitted due to some problem
              <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
          </div>
        <% }%>
      <% }%>
      <form action="queryservlet" method="POST">
          <div class="form-group">
              <input class="form-control" type="text" name="name" placeholder="Enter your Name" required>
          </div>
          <div class="form-group">
              <input class="form-control" type="email" name="email" placeholder="Enter your Email" required>
          </div>
          <div class="form-group">
              <textarea class="form-control" name="message" placeholder="Enter your Message" rows="15" cols="10" required></textarea>
          </div>
          <div class="form-group">
              <input class="form-control btn btn-primary" type="submit" name="submit" value="Submit Message">
          </div>
      </form>
      <%@include file="snippets/footer.html" %>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>