    <%@page import="EJB.Note"%>
<%@page import="java.util.ArrayList"%>
<%@page import="EJB.User"%>
<%@include file="includes/header.jsp" %>
    <% if(session.getAttribute("user_login") != null){%>
        <title>User</title>
    <% }else{%>
        <title>Admin</title>
    <% }%>
    <link rel="stylesheet" type="text/css" href="css/admin.css">
  </head>
    <%
        // disable the cache to page to disable any page content in the cache
        // clearing the cache
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // Http 1.1
        response.setHeader("Pragma", "no-cache"); // Http 1.0
        if(session.getAttribute("login_credentials") == null){
            response.sendRedirect("index.jsp");
        }
    %>
  <body>
    <%@include file="includes/navigation.jsp" %>
    <div class="container-fluid">
        <div class="container">
            <%
                User userObj = (User)session.getAttribute("login_credentials");
                if(userObj != null){
            %>
                <h1 class="display-4">TODO</h1>
                <h6>Welcome, <%=userObj.getName()%></h6>
                <form action="add_todo_servlet" method="get">
                    <div class="input-group">
                        <input class="form-control" id="todoinput" name="todoinput" type="text" placeholder="Add Todo Item">
                        <div class="input-group-append">
                            <input class="btn btn-outline-secondary" type="submit" value="Add Item">
                        </div>
                    </div>
                </form>
            <% }%>
            <br/>
            <%
                if(session.getAttribute("notelist") != null){
                    ArrayList<Note> arrayListNotes = (ArrayList<Note>)session.getAttribute("notelist");
            %>
                    <% for(int i = 0; i < arrayListNotes.size(); i++){%>
                    <div class="row">
                        <div class="col">
                            <h6> <%=arrayListNotes.get(i).getData()%></h6>
                        </div>
                        <div class="col col-lg-2">
                            <a class="btn btn-outline-danger" href="delete_todo?id=<%=arrayListNotes.get(i).getId()%>">Remove</a>
                        </div>
                    </div>
                    <% }%>
            <% }%>
        </div>
    </div>
    <%@include file="includes/bootstrapjs.jsp" %>
    <script src="js/admin.js"></script>
  </body>
</html>