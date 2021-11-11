<%@include file="includes/header.jsp" %>
<title>Home</title>
<link rel="stylesheet" href="css/home.css">
</head>
<body>
    <%@include file="includes/navigation.jsp" %>
    <div class="container text-white">
        <div class="row">
            <div class="col">
                <h5>Welcome to Nebula, A galaxy of PC Parts</h5>
            </div>
            <div class="col">
                <img src="img/main.png" width="200px">
            </div>
            <div class="col">
                <%
                    String respond = request.getParameter("response");
                    if(respond != null){
                %>
                    <%
                        String message = "";
                        String alertType = "";
                        String alertTitle = "";
                        if(respond.compareTo("insert_success") == 0){
                            alertType = "success";
                            alertTitle = "User Created!";
                            message = "Registered Successfully";
                        }else if(respond.compareTo("user_exists") == 0){
                            alertType = "danger";
                            alertTitle = "Failed!";
                            message = "Username or email already exists";
                        }
                    %>
                    <div class="alert alert-<%=alertType%> alert-dismissible fade show" role="alert">
                        <strong><%=alertTitle%></strong> <%=message%>
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                          <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                <% }%>
                <form action="register_controller" method="POST" class="bg-white">
                    <h6 class="text-dark">Sign Up and get access to out latest products</h6>
                    <div class="form-group">
                        <input type="text" name="username" class="form-control" id="username" placeholder="Enter Username" required>
                    </div>
                    <div class="form-group">
                        <input type="email" name="email" class="form-control" id="email" placeholder="Enter Email" required>
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" class="form-control" id="password" placeholder="Enter Password" required>
                    </div>
                    <input type="submit" class="btn btn-dark" value="Sign Up">
                </form>
            </div>
        </div>
    </div>
                
    <%@include file="modal/login.jsp" %>
    <%@include file="includes/bootstrapJS.jsp" %>
    <script src="js/login.js"></script>
</body>
</html>