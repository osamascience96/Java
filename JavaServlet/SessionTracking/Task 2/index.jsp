<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Session Tracking</title>
    <style>
        form{
            margin: 20px auto 20px auto;
        }
    </style>
  </head>
  <%
    boolean visitor = false;
    
    if(session.getAttribute("visitor") != null){
        visitor = (boolean) session.getAttribute("visitor");
    }
  %>
  <body>
      <div class="container">
          <form action="servlet" method="POST">
              <div class="form-group">
                  <%
                      String firstname = "";
                      if(visitor){
                          firstname = (String) session.getAttribute("firstname");
                      }
                  %>
                  <label for="first_name">Enter First Name:</label>
                  <input id="first_name" class="form-control" type="text" name="firstname" placeholder="First Name" value="<%=firstname%>">
              </div>
              <div class="form-group">
                  <%
                      String lastname = "";
                      if(visitor){
                          lastname = (String) session.getAttribute("lastname");
                      }
                  %>
                  <label for="last_name">Enter Last Name:</label>
                  <input id="last_name" class="form-control" type="text" name="lastname" placeholder="Last Name" value="<%=lastname%>">
              </div>
              <div class="form-group">
                  <%
                      String emailaddress = "";
                      if(visitor){
                          emailaddress = (String) session.getAttribute("emailaddress");
                      }
                  %>
                  <label for="email_address">Enter Last Name:</label>
                  <input id="email_address" class="form-control" type="email" name="emailaddress" placeholder="Email Address" value="<%=emailaddress%>">
              </div>
              <div class="form-group">
                  <input type="submit" value="Submit" class="btn btn-primary btn-block form-control">
              </div>
          </form>
      </div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>