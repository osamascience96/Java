<%@include file="includes/bootstrapheader.jsp" %>
    <body>
        <div class="container">
            <h2>Login Page</h2>
            <form action="login_servlet" method="post">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" id="username" class="form-control" name="username" placeholder="Enter Username" required>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" id="password" class="form-control" name="password" placeholder="Enter Password" required>
                </div>
                <input type="submit" class="btn btn-outline-success" value="Login" >
                <a class="btn btn-outline-primary" href="Registeration.jsp">Register to System</a>
            </form>
            <%
                if(request.getParameter("response") != null){
            %>
                <%
                    String respond = request.getParameter("response");
                %>
                <%
                    if(respond.compareTo("wrong_credentials") == 0){
                %>
                    <div class="alert alert-danger" role="alert">Wrong Credentials Entered</div>
                <% }%>
            <% }%>
        </div>
        <%@include file="includes/jsbootstrap.jsp" %>
    </body>
</html>
