<%@include file="includes/header.jsp" %>
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="css/home.css">
  </head>
  <body>
    <%@include file="includes/navigation.jsp" %>
    <div class="container">
        <h1 class="display-4 text-white">Login</h1>
        <form action="login_servlet" method="POST">
            <div class="form-group">
                <label for="username">Enter Username</label>
                <input class="form-control" type="text" name="username" id="username" placeholder="Username" required> 
            </div>
            <div class="form-group">
                <label for="password">Enter Password</label>
                <input class="form-control" type="password" name="password" id="password" placeholder="Password" required> 
            </div>
            <input type="submit" class="btn btn-success btn-block" value="Login">
        </form>
        <%
            String respond = request.getParameter("response");
            if(respond != null){
        %>
            <%
                String alertType = "";
                String alertTitle = "";
                String alertMessage = "";
                
                if(respond.compareTo("wrong_credentials") == 0){
                    alertType = "danger";
                    alertTitle = "Error!";
                    alertMessage = "Username or Password is incorrect.";
                }
            %>
            <div class="alert alert-<%=alertType%> alert-dismissible fade show" role="alert">
                <strong><%=alertTitle%></strong> <%=alertMessage%>
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
            </div>
        <% }%>
        <a href="register.jsp" class="text-white">Not a Part of System? Register to our System.</a>
    </div>
    <%@include file="includes/footer.jsp" %>
  </body>
</html>