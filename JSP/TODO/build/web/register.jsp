    <%@include file="includes/header.jsp" %>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="css/register.css">
  </head>
  <body>
    <%@include file="includes/navigation.jsp" %>
    <div class="container-fluid">
        <div class="container">
            <h2 class="text-center">Register</h2>
            <div class="register_form mx-auto">
                <img id="login_img" src="img/todoapplogo.png" class="mx-auto" width="200" height="200">
                <div class="form-group">
                    <input type="text" id="fullname" class="form-control" placeholder="Full Name">
                </div>
                <div class="form-group">
                    <input type="text" id="email" class="form-control" placeholder="Email">
                </div>
                <div class="form-group">
                    <input type="text" id="username" class="form-control" placeholder="Username">
                </div>
                <div class="form-group">
                    <input type="password" id="password" class="form-control" placeholder="Password">
                </div>
                <div class="form-group">
                    <input type="password" id="confirmpassword" class="form-control" placeholder="Password">
                </div>
                <div class="form-group">
                    <button class="btn btn-secondary btn-block" onclick="register()">Register</button>
                </div>
            </div>
            <br/>
            <div id="alert_register_message"></div>
        </div>
    </div>
    <%@include file="includes/bootstrapjs.jsp" %>
    <script src="js/register.js"></script>
  </body>
</html>