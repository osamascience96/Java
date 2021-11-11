<%@page import="java.util.Random"%>
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
    <div class="login-group absolute-center night-fade-gradient">
        <h5 class="text-center">Welcome</h5>
        </br>
        <form action = "" method = "post">
            <div id="error_div"></div>
            <div class="form-group">
                <input name="username" type="text" class="form-control" id="name_input" required placeholder="Login" >
            </div>
            <div class="form-group">
                <input name="password" type="password" class="form-control" id="password_input" required placeholder="Password">
            </div>
            <div class="form-group row">
                <div class="form-group col-md-6">
                    <input name="captcha" class="form-control" id="inputCaptcha" required maxlength="5" placeholder="Captcha">
                </div>
                <label class="form-group col-md-6 col-form-label captcha" for="inputCaptcha">
                    <%
                        HttpSession httpSession = request.getSession();
                        int min = 10000;
                        int max = 99999;
                        Random random = new Random();
                        int randNum = random.nextInt((max+1) - min) + min;
                    %>
                    <%=randNum%>
                </label>
                <input type="hidden" name="captcha_holder" id="captcha_holder" value="<%=randNum%>">
            </div>
            <input type="submit" class="btn btn-light btn-block" onclick="event.preventDefault(); login();" value="Login"/><br />
            <a href="register.jsp" class="btn btn-light btn-block">Register</a><br />
        </form>
    </div>
</body>
<script src="JS/login.js"></script>
</html>