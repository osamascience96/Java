<%@page import="EJB.Note"%>
<%@page import="java.util.ArrayList"%>
<%@page import="EJB.User"%>
<%@include file="includes/header.jsp" %>
    <title>Users</title>
    <link rel="stylesheet" type="text/css" href="css/users.css">
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
            <h1 class="display-4">Users</h1>
            <h6>Manage Users</h6>
            <%
                ArrayList<User> usersArrayList = (ArrayList<User>) session.getAttribute("users_list");
                if(usersArrayList != null){
            %>
                <div class="manager_users">
                    <% for(int i=0; i < usersArrayList.size(); i++){%>
                        <div id="users_info" class="form-group">
                            <h5><%=usersArrayList.get(i).getName()%> <span class="text-secondary">@<%=usersArrayList.get(i).getUsername()%></span></h5>
                            <p><%=usersArrayList.get(i).getEmail()%></p>
                        </div>
                        <div id="users_interactive_option">
                            <a href="edit_servlet?id=<%=usersArrayList.get(i).getId()%>" class="btn btn-outline-primary">Edit ></a>
                            <% if(usersArrayList.get(i).getApprovd() == 1){%>
                                <a href="update_user_status?user_id=<%=usersArrayList.get(i).getId()%>&status=0" class="btn btn-outline-danger">Suspend</a>
                            <% }else{%>
                            <a href="update_user_status?user_id=<%=usersArrayList.get(i).getId()%>&status=1" class="btn btn-outline-success">Activate</a>
                            <% }%>
                        </div>
                        <hr>
                    <% }%>
                </div>
            <% }%>
        </div>
    </div>
    <%@include file="includes/bootstrapjs.jsp" %>
    <script src="js/admin.js"></script>
  </body>
</html>