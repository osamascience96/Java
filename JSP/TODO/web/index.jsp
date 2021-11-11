    <%@include file="includes/header.jsp" %>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="css/home.css">
  </head>
  <body>
    <%@include file="includes/navigation.jsp" %>
    <div class="container-fluid">
        <div class="container">
            <h2 class="text-center">Login</h2>
            <div class="login_form mx-auto">
                <img id="login_img" src="img/todoapplogo.png" class="mx-auto" width="200" height="200">
                <div class="form-group">
                    <input type="text" id="email" class="form-control" placeholder="Enter Email">
                </div>
                <div class="form-group">
                    <input type="password" id="password" class="form-control" placeholder="Enter Password">
                </div>
                <div class="form-group">
                    <button class="btn btn-secondary btn-block" onclick="login()">Login</button>
                </div>
            </div>
            <br/>
            <div id="login_alert_message"></div>
        </div>
    </div>
    <%@include file="includes/bootstrapjs.jsp" %>
    <script src="js/login.js"></script>
  </body>
</html>