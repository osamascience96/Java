<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>First Page</title>
  </head>
  <%
      // set the cookie
      Cookie[] cooke = request.getCookies();
      String visited = "false";
      
      if(cooke != null){
          for(int i=0; i < cooke.length; i++){
              if(cooke[i].getName().equals("visited")){
                  visited = cooke[i].getValue();
              }
          }
      }else{
        Cookie firstPagevisit = new Cookie("visited", "true");
        //setting the expiry date after 10 sec
        firstPagevisit.setMaxAge(10);
        // Add both bookies in the response 
        response.addCookie(firstPagevisit);
        
        visited = "true";
      }
      
      session.setAttribute("visited_session", visited);
  %>
  <body>
      <div class="container">
        <h1>First Page</h1>
        <p>Disclaimer: You cannot visit Page 2 before Page 1</p>
        <a type="button" class="btn btn-primary btn-block" style="color:white; font-weight: bold;" href="secondpage.jsp">Visit Page 2</a>
      </div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>