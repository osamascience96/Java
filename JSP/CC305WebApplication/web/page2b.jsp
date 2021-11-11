<%@include file="includes/header.jsp" %>
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="css/page2.css">
    </head>
    <body>
        <%
            if(request.getParameter("login") != null){
        %>
            <%
                String respond = "";
                
                // set the credentials according to your own.
                String username = "osamahu96";
                String password = "saphire54321";
                
                String is_login = request.getParameter("login");
                if(is_login.compareTo("true") == 0){
                    if(request.getParameter("username").compareTo(username) == 0 && request.getParameter("password").compareTo(password) == 0){
                        respond = "Login Successful";
                    }else{
                        respond = "Invalid Credentials";
                    }
            %>
            <h2><%=respond%></h2>
            <% }%>
        <% }else{%>
            <form id="loginform" action="#" method="post">
                <h2>Login System</h2>
                <label>Username:</label> <input type="text" id="username" name="username" required> <br>
                <label>Password:</label> <input type="password" id="password" name="password" required> <br>
                <input type="hidden" name="login" value="true">
                <input type="submit" name="submit" value="Login">
            </form>
        <% }%>
    </body>
</html>
