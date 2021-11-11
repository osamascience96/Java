<%@page import="POJO.Log"%>
<%@page import="java.util.ArrayList"%>
<%@include file="includes/header.jsp" %>
<link rel="stylesheet" type="text/css" href="css/home.css">
</head>
  <%
        // disable the cache to page to disable any page content in the cache
        // clearing the cache
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // Http 1.1
        response.setHeader("Pragma", "no-cache"); // Http 1.0
        if(session.getAttribute("username") == null){
            response.sendRedirect("index.jsp");
        }
    %>
  <body>
    <%@include file="includes/navigation.jsp" %>
    <%
        if(session.getAttribute("username") != null){
    %>
        <div class="container">
            <div class="table-responsive" style="margin: 10px;">
                <table class="table text-white">
                    <caption>List of users</caption>
                    <thead>
                      <tr>
                        <th scope="col">Access time</th>
                        <th scope="col">Authentication</th>
                        <th scope="col">Username</th>
                        <th scope="col">IP Address</th>
                        <th scope="col">Browser</th>
                        <th scope="col">Milliseconds</th>
                      </tr>
                    </thead>
                    <tbody>
                        <%
                            ArrayList<Log> logArrayList = (ArrayList<Log>) application.getAttribute("loggerList");
                        %>
                        <%
                            if(logArrayList != null){
                        %>
                            <%
                                for(int i=0; i < logArrayList.size(); i++){
                            %>
                            <tr>
                                <td><%=logArrayList.get(i).GetAccessTime()%></td>
                                <td><%=logArrayList.get(i).GetAuthenticationType()%></td>
                                <td><%=logArrayList.get(i).GetUsername()%></td>
                                <td><%=logArrayList.get(i).GetUserIpAddress()%></td>
                                <td><%=logArrayList.get(i).GetBrowser()%></td>
                                <td><%=logArrayList.get(i).GetMilliseconds()%></td>
                            </tr>
                            <% }%>
                        <% }%>
                    </tbody>
                </table>
            </div>
            <div class="row">
                <a style="margin-right: 10px;" href="track_servlet?allow=true" class="col btn btn-primary">Show User Tracking Status</a>
                <a href="track_servlet?allow=false" class="col btn btn-primary">Off User Tracking Status</a>
            </div>
        </div>
    <% }%>
<%@include file="modals/login.jsp" %>
<%@include file="includes/footer.jsp" %>