    <%@page import="EJB.User"%>
<%@page import="java.util.ArrayList"%>
<%@include file="includes/header.jsp" %>
    <title>Edit = Admin</title>
    <link rel="stylesheet" type="text/css" href="css/edituser.css">
  </head>
    <%
        // disable the cache to page to disable any page content in the cache
        // clearing the cache
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // Http 1.1
        response.setHeader("Pragma", "no-cache"); // Http 1.0
        if(session.getAttribute("admin_login") == null){
            response.sendRedirect("index.jsp");
        }
    %>
  <body>
    <%@include file="includes/navigation.jsp" %>
    <div class="container-fluid">
        <div class="container">
            <%
                User userObj = (User)session.getAttribute("edit_user");
                if(userObj != null){
            %>
                <h2 class="text-center">Edit User</h2>
                <h5 class="text-center">@<%=userObj.getName()%></h5>
                <div class="edit_form mx-auto">
                    <img id="login_img" src="img/todoapplogo.png" class="mx-auto" width="200" height="200">
                    <input type="hidden" id="id" value="<%=userObj.getId()%>">
                    <div class="form-group">
                        <input type="text" id="name" class="form-control" placeholder="Name" value="<%=userObj.getName()%>">
                    </div>
                    <div class="form-group">
                        <input type="text" id="email" class="form-control" placeholder="Email" value="<%=userObj.getEmail()%>"">
                    </div>
                    <div class="form-group">
                        <input type="text" id="username" class="form-control" placeholder="Username" value="<%=userObj.getUsername()%>"">
                    </div>
                    <div class="form-group">
                        <input type="password" id="password" class="form-control" placeholder="Password" value="<%=userObj.getPassword()%>">
                    </div>
                    <div class="form-group">
                        <button class="btn btn-secondary btn-block" onclick="update_user()">Update</button>
                    </div>
                </div>
                <br>
                <div id="editor_user_alert"></div>
            <% }%>
        </div>
    </div>
    <%@include file="includes/bootstrapjs.jsp" %>
    <script src="js/admin.js"></script>
  </body>
</html>