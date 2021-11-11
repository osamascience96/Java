        <%@include file="includes/header.jsp" %>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/index.css" />
    </head>
    <body>
        <%
            String resp = request.getParameter("response");
            if(resp != null){
                if(resp.compareTo("login_invalid") == 0){
            %>
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    <strong>Failed!</strong> Invalid Password.
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            <% }else if(resp.compareTo("user_not_exists") == 0){%>
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    <strong>Failed!</strong> User does not exists in our system.
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            <% }else if(resp.compareTo("login_valid") == 0){ %>
                <div class="alert alert-success alert-dismissible fade show" role="alert">
                    <strong>Success!</strong> Login Successful.
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
                <%
                    String type = request.getParameter("type");
                    if(type.compareTo("admin") == 0){
                        response.sendRedirect("admin_servlet?id=".concat(request.getParameter("id")));
                    }else if(type.compareTo("patient") == 0){
                        response.sendRedirect("PatientLogin?id=".concat(request.getParameter("id")));
                    }else if(type.compareTo("doctor") == 0){
                        // redirect to the doctor Login servlet 
                        response.sendRedirect("DoctorLogin?id=".concat(request.getParameter("id")));
                    }
                %>
            <% }%>
        <% }%>
        
        <%
            String created_user = request.getParameter("created_user");
            if(created_user != null){
        %>
            <div class="alert alert-primary alert-dismissible fade show" role="alert">
                <strong>User Created!</strong> User created of Id <%=created_user%>. Login to Continue!
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        <% }%>
        <div class="center">
            <h1>LOGIN</h1>
            <form action="Login" method="post">
                <div class="txt_field">
                        <input name="username" type="text" required />
                        <span></span>
                        <label>Username</label>
                </div>
                <div class="txt_field">
                        <input name="password" type="password" required />
                        <span></span>
                        <label>Password</label>
                </div>
                <div class="pass">Forgot Password?</div>
                <input type="submit" value="Login" />
                <div class="signup_link">
                    Not a member? <a href="register.jsp">Signup</a>
                </div>
            </form>
        </div>
<%@include file="includes/footer.jsp"%>
