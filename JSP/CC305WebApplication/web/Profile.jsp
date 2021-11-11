<%@page import="Bean.User"%>
<%@include file="includes/bootstrapheader.jsp" %>
    <body>
        <div class="container">
            <%
                User userObj = (User) session.getAttribute("user_session");
            %>
            <%
                if(userObj != null){
            %>
                <div class="card border-success mb-3">
                    <div class="card-header bg-transparent border-success"><%=userObj.getId()%></div>
                    <div class="card-body text-success">
                      <h5 class="card-title"><%=userObj.getUsername()%></h5>
                      <p class="card-text">This is the Profile of the User</p>
                    </div>
                    <div class="card-footer bg-transparent border-success">Record Created at: <%=userObj.getCreated_at()%></div>
                </div>
                <a href="Logout" class="btn btn-outline-danger btn-block">Logout of the Profile</a>
            <% }else{
                response.sendRedirect("page3.jsp");
            }%>
        </div>
        <%@include file="includes/jsbootstrap.jsp" %>
    </body>
</html>
