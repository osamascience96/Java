<%@page import="bean.User"%>
<%@page import="bean.Inventory"%>
<%@page import="java.util.ArrayList"%>
<%@include file="includes/head.jsp" %>
<link rel="stylesheet" href="css/profile.css">
<title>Home</title>
</head>
<body>
    <%@include file="includes/navigation.jsp" %>
    <div class="container">
        <h4>User Profile</h4>
        <form action="user_controller" method="POST">
            <%
                User userprofileObj = (User)session.getAttribute("userObj");
            %>
            <% if(userObj != null){%>
            <div class="form-group">
                <label for="profile_username">Enter Username</label>
                <input type="text" id="profile_username" class="form-control" name="profile_username" value="<%=userprofileObj.getUsername()%>" placeholder="Username" required>
            </div>
            <div class="form-group">
                <label for="profile_email">Enter Email</label>
                <input type="email" id="profile_email" class="form-control" name="profile_email" value="<%=userprofileObj.getEmail()%>" placeholder="Email" required>
            </div>
            <div class="form-group">
                <label for="profile_password">Enter Password</label>
                <input type="password" id="profile_password" class="form-control" name="profile_password" value="<%=userprofileObj.getPassword()%>" placeholder="Password" required>
            </div>
            <input type="submit" class="btn btn-outline-success btn-block" value="Update Profile">
            <% }else{
                response.sendRedirect("index.jsp");
            }%>
        </form>
    </div>
<%@include file="includes/boostrapJS.jsp" %>
</body>
</html>