<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/navigation.css">
        <link rel="stylesheet" type="text/css" href="css/index.css">
        <link rel="stylesheet" type="text/css" href="css/toast.css">
        <link rel="stylesheet" type="text/css" href="css/register.css">
        <title>Home</title>
    </head>
    <body>
        <%@include file="includes/navigation.jsp" %>
        <form id="register_form" action="register_servlet" method="post" onclick="event.preventDefault();">
            <h2>Sign Up</h2>
            <p>
                <label for="fullname" class="floatLabel">Full Name</label>
                <input id="fullname" name="fullname" type="text" required>
                <span id="fullname_message" style="display: none;">Full Name must be of 7 characters</span>
                <span id="fullname_empty_message" style="display: none;">Full Name must not be empty</span>
            </p>
            <p>
                <label for="username" class="floatLabel">Username</label>
                <input id="username" name="username" type="text" required>
                <span id="user_name_message" style="display: none;">Username must be 8 characters at least</span>
                <span id="user_name_empty_message" style="display: none;">Username must not be empty</span>
            </p>
            <p>
                <label for="email" class="floatLabel">Email</label>
                <input id="email" name="email" type="text" required>
                <span id="email_message" style="display: none;">Invalid Email Address</span>
                <span id="email_empty_message" style="display: none;">Email Address must not be empty</span>
            </p>
            <p>
                <label for="password" class="floatLabel">Password</label>
                <input id="password" name="password" type="password" required>
                <span id="password_message" style="display: none;">Your passwords must be at least 8 characters</span>
                <span id="password_empty_message" style="display: none;">Password must not be empty</span>
            </p>
            <p>
                <input type="submit" value="Create My Account" onclick="register()">
            </p>
	</form>
        <div id="snackbar"></div>
        <script type="text/javascript" src="js/register.js"></script>
        <script type="text/javascript" src="js/toast.js"></script>
        <%
            if(request.getParameter("response") != null){
        %>
            <%
                String respond = request.getParameter("response");
                
                String message = "";
                if(respond.compareTo("user_insert_success") == 0){
                    message = "Registered Successfully";
                }else if(respond.compareTo("user_exists") == 0){
                    message = "User already exists";
                }
            %>
            <script>
                generate_toast('<%=message%>');
            </script>
        <%
            }
        %>
    </body>
</html>
