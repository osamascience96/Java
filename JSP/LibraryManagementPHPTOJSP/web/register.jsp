<!DOCTYPE html>
<html lang="en">
<head>
    <title>Library Management System</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="assets/css/login.css">
    <link rel="stylesheet" href="assets/css/gradients.css">
    <link rel="stylesheet" href="assets/css/bootstrap.css">
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap.js"></script>
</head>

<body>
    <div class="login-group absolute-center night-fade-gradient" style="height: auto; margin-top: 50px;margin-bottom: 50px;">
        <div class="d-flex flex-column">
            <h5 class="text-center">Register</h5>
            <div id="error_div">
                <% if(request.getParameter("message") != null){%>
                    <br><br>
                    <ul style="color: red; font-weight: bold;">
                        <li><%=request.getParameter("message")%></li>
                    </ul>
                <% }%>
            </div>
            </br></br>
            <form id="register_form" action="register_servlet" method="post">
                <div class="form-group">
                    <input id="name"t name="name" type="text" class="form-control" placeholder="Member Name"/>
                </div>
                <div class="form-group">
                    <input id="username" name="username" type="text" class="form-control" placeholder="Username" />
                </div>
                <div class="form-group">
                    <input id="password" name="password" type="password" class="form-control" placeholder="Password"/>
                </div>
                <div class="form-group">
                    <input id="confirm_password" name="confirm_password" type="password" class="form-control" placeholder="Confirm password"/>
                </div>
                <br><br>
                <input type="submit" class="btn btn-light btn-block" value="Register" onclick="event.preventDefault(); register();" /><br/>
                <a href="index.jsp" class="btn btn-light btn-block">Login</a><br/>
            </form>
        </div>
    </div>
    <script src="JS/register.js"></script>
</body>
</html>