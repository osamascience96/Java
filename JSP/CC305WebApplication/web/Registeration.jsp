<%@include file="includes/bootstrapheader.jsp" %>
    <body>
        <div class="container">
            <h2>Registration</h2>
            <form action="register_servlet" method="post">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" id="username" class="form-control" name="username" placeholder="Enter Username" required>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" id="password" class="form-control" name="password" placeholder="Enter Password" required>
                </div>
                <input type="submit" class="btn btn-outline-success" value="Register" >
                <a class="btn btn-outline-primary" href="page3.jsp">Login to System</a>
            </form> 
            <%
                if(request.getParameter("response") != null){
            %>
                <%
                    String respond = request.getParameter("response");
                %>
                <%
                    if(respond.compareTo("success") == 0){
                %>
                    <div class="alert alert-success" role="alert">user Registered Successfully</div>
                    <% }else if(respond.compareTo("user_exists") == 0){%>
                    <div class="alert alert-danger" role="alert">User Already Exists</div>
                <% }%>
            <% }%>
        </div>
        <%@include file="includes/jsbootstrap.jsp" %>
    </body>
</html>
