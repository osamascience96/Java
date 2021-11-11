<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Cookie[] cookies = request.getCookies();
    if(cookies != null){
        if(cookies.length > 1){
            response.sendRedirect("login");
        }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        <title>Home</title>
        
        <style>
            .login{
                background-color: #e1e1e1;
                width: 90%;
                padding: 10px;
                margin: 100px auto 100px auto;
                border-radius: 10px;
            }
            
            form{
                width: 100%;
            }
            
            form > input{
                width: 100%;
                margin-top: 10px;
            }
            
            form > input[type="submit"]{
                width: 70%;
                margin-left: 120px;
                padding: 10px;
            }
        </style>
    </head>
    <body>
        
        <div class="login">
            <form action="login" method="POST">
                <input type="text" name="username" placeholder="Enter Username" required> <br>
                <input type="password" name="password" placeholder="Enter Password" required> <br>
                <input class="btn-primary" type="submit" value="Login">
            </form>
        </div>
        
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
