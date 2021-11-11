<%@page import="bean.User"%>
<%@page import="java.util.ArrayList"%>
<%@include file="includes/head.jsp" %>
<link rel="stylesheet" href="css/manager.css">
<title>Home</title>
</head>
<body>
    <%@include file="includes/navigation.jsp" %>
    <% 
        ArrayList<User> usersArrayList = (ArrayList<User>) session.getAttribute("users_admin_list");
    %>
    <% if(usersArrayList != null){%>
    <div class="container">
        <div class="table table-bordered table-light table-responsive-lg">
            <table class="table">
                <caption>Users List</caption>
                <thead>
                    <th scope="col">ID</th>
                    <th scope="col">Username</th>
                    <th scope="col">Email</th>
                    <th scope="col">Role</th>
                    <th scope="col">Password</th>
                    <th scope="col">Actions</th>
                </thead>
                <tbody>
                    <% for(int i=0; i < usersArrayList.size(); i++){%>
                        <tr>
                            <th scope="row"><%=usersArrayList.get(i).getId()%></th>
                            <td><%=usersArrayList.get(i).getUsername()%></td>
                            <td><%=usersArrayList.get(i).getEmail()%></td>
                            <td><%=usersArrayList.get(i).getRole()%></td>
                            <td><%=usersArrayList.get(i).getPassword()%></td>
                            <td class="text-center align-middle">
                                <div class="btn-group align-top">
                                    <button class="btn btn-sm btn-outline-primary badge" type="button" onclick="open_user_modal(<%=usersArrayList.get(i).getId()%>, '<%=usersArrayList.get(i).getUsername()%>', '<%=usersArrayList.get(i).getEmail()%>', '<%=usersArrayList.get(i).getPassword()%>')">Edit</button>
                                    <a class="btn btn-sm btn-outline-danger badge" href="admin_controller?is_del=true&id=<%=usersArrayList.get(i).getId()%>"><i class="fa fa-trash"></i></a>
                                </div>
                            </td>
                        </tr>
                    <% }%>
                </tbody>
            </table>
        </div>
        <button class="btn btn-outline-info btn-block" data-toggle="modal" data-target="#add_user_modal">Add User</button>
    </div>
    <% }else{
        response.sendRedirect("index.jsp");
    }%>
<%@include file="includes/boostrapJS.jsp" %>
<script src="js/login.js" type="text/javascript"></script>
<%@include file="modals/adduser.jsp" %>
<%@include file="modals/edituser.jsp" %>
<script src="js/users.js"></script>
</body>
</html>