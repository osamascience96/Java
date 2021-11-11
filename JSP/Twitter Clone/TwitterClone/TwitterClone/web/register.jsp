<%@include file="includes/header.jsp" %>
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="css/register.css">
  </head>
  <body>
    <%@include file="includes/navigation.jsp" %>
    <div class="container">
        <h1 class="display-4 text-white">Register</h1>
        <form action="register_servlet" method="POST">
            <div class="form-group">
                <label for="username">Enter Username</label>
                <input class="form-control" type="text" name="username" id="username" placeholder="Username" required> 
            </div>
            <div class="form-group">
                <label for="email">Enter Email</label>
                <input class="form-control" type="email" name="email" id="email" placeholder="Email" required> 
            </div>
            <div class="form-group">
                <label for="password">Enter Password</label>
                <input class="form-control" type="password" name="password" id="password" placeholder="Password" required> 
            </div>
            <input type="submit" class="btn btn-primary btn-block" value="Register">
        </form>
        <%
            String respond = request.getParameter("response");
            if(respond != null){
        %>
            <%
                String alertType = "";
                String alertTitle = "";
                String alertMessage = "";
                
                if(respond.compareTo("username_error") == 0){
                    alertType = "danger";
                    alertTitle = "Error!";
                    alertMessage = "Username must be of 7 characters.";
                }else if(respond.compareTo("password_error") == 0){
                    alertType = "danger";
                    alertTitle = "Error!";
                    alertMessage = "Password must be of 7 characters.";
                }else if(respond.compareTo("user_exists") == 0){
                    alertType = "danger";
                    alertTitle = "Error!";
                    alertMessage = "User already exists";
                }else if(respond.compareTo("registration_success") == 0){
                    alertType = "primary";
                    alertTitle = "Success!";
                    alertMessage = "Twitter Registration Successful";
                }
            %>
            <div class="alert alert-<%=alertType%> alert-dismissible fade show" role="alert">
                <strong><%=alertTitle%></strong> <%=alertMessage%>
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
            </div>
        <% }%>
        <a href="index.jsp" class="text-white">Login to our System</a>
    </div>
    <%@include file="includes/footer.jsp" %>
  </body>
</html>