<%@include file="includes/head.jsp" %>
<link rel="stylesheet" rel="text/css" href="css/register.css">
<title>Register</title>
</head>
<body>
    <%@include file="includes/navigation.jsp" %>
    <div class="container">
        <%
            String respond = request.getParameter("response");
            if(respond != null){
        %>
            <%
                String alertType = "";
                String alertMessage = "";
                
                if(respond.compareTo("user_exists") == 0){
                    alertType = "danger";
                    alertMessage = "User already exists in database";
                }else if(respond.compareTo("record_inserted") == 0){
                    alertType = "success";
                    alertMessage = "Account Created Successfully";
                }
            %>
            <div class="alert alert-<%=alertType%>" role="alert"><%=alertMessage%></div>
        <% }%>
        <form id="register_form" action="register_servlet" method="POST">
            <div id="alert_placeholder"></div>
            <div class="row">
                <div class="col form-group">
                    <label for="registration_name">Enter Name</label>
                    <input type="text" class="form-control" name="name" id="registration_name" placeholder="Name" required>
                </div>
                &nbsp;
                <div class="col form-group">
                    <label for="registration_username">Enter Username</label>
                    <input type="text" class="form-control" name="username" id="registration_username" placeholder="Username" required>
                </div>
            </div>
            <div class="row">
                <div class="col form-group">
                    <label for="registration_email">Enter Email</label>
                    <input type="email" class="form-control" name="email" id="registration_email" placeholder="Email" required>
                </div>
            </div>
            <div class="row">
                <div class="col form-group">
                    <label for="registration_password">Enter Password</label>
                    <input type="password" class="form-control" name="password" id="registration_password" placeholder="Password" required>
                </div>
            </div>
            <button class="btn btn-outline-success btn-block" onclick="event.preventDefault(); register();">Register</button>
        </form>
    </div>
<%@include file="includes/boostrapjs.jsp" %>
<%@include file="includes/footer.jsp" %>
<script src="js/register.js" type="text/javascript"></script>
</body>
</html>