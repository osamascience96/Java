<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/navigation.css">
        <link rel="stylesheet" type="text/css" href="css/index.css">
        <link rel="stylesheet" type="text/css" href="css/toast.css">
        <link rel="stylesheet" type="text/css" href="css/login.css">
        <title>Home</title>
    </head>
    <body>
        <%@include file="includes/navigation.jsp" %>
        
        <div class="container">
          <div class="top"></div>
          <div class="bottom"></div>
          <div class="center">
            <h2>Please Sign In</h2>
            <form action="login_servlet" method="POST">
                <input type="text" placeholder="Username or Email" name="credentials_1" required>
                <input type="password" placeholder="password" name="password" required>
                <input type="submit" value="Login">
                <a href="register.jsp" style="color: white; margin-left: 50px;">Register Account</a>
            </form>
            <div id="snackbar"></div>
            <script type="text/javascript" src="js/toast.js"></script>
            <%
                if(request.getParameter("response") != null){
            %>
            <%
                String respond = request.getParameter("response");
                
                String message = "";
                if(respond.compareTo("user_credentials_error") == 0){
                    message = "Invalid Credentials";
                }
            %>
            <script>
                generate_toast('<%=message%>');
            </script>
            <%
                }
            %>
          </div>
        </div>
    </body>
</html>
