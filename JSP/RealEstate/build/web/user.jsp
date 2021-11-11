<%@page import="Bean.Product"%>
<%@page import="java.util.ArrayList"%>
<%@include file="includes/header.jsp" %>
    <link rel="stylesheet" href="css/user.css" >
    <title>User</title>
  </head>
  <body>
    <%
        // disable the cache to page to disable any page content in the cache
        // clearing the cache
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // Http 1.1
        response.setHeader("Pragma", "no-cache"); // Http 1.0
        if(session.getAttribute("is_login_user") == null){
            response.sendRedirect("index.jsp");
        }
    %>
    <%@include file="includes/navigation.jsp" %>
    <div class="container">
        <%
            ArrayList<Product> arrayListproducts = (ArrayList<Product>) session.getAttribute("is_login_user");
            if(arrayListproducts != null){
                if(arrayListproducts.size() > 0){
        %>
            <input class="form-control" id="input" type="text" placeholder="Search Property">
            <table class="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Location</th>
                        <th>Image</th>
                        <th>Creation Date/Time</th>
                    </tr>
                </thead>
                <tbody id="bodyTable">
                    <% for(int i=0; i < arrayListproducts.size(); i++){%>
                        <tr>
                            <td><%=arrayListproducts.get(i).getId()%></td>
                            <td><%=arrayListproducts.get(i).getPropertyName()%></td>
                            <td>$<%=arrayListproducts.get(i).getPrice()%></td>
                            <td><%=arrayListproducts.get(i).getLocation()%></td>
                            <td><img width="100" src="img/cardlandscape.jpg"></td>
                            <td><%=arrayListproducts.get(i).getDate()%></td>
                        </tr>
                    <% }%>
                </tbody>
            </table>
            <% }else{%>
                <h4>No Data Available</h4>
            <% }%>
        <% }%>
    </div>
    <%@include file="modal/login.jsp" %>                      
    <%@include file="includes/bootstrapJs.jsp" %>
    <script src="js/home.js"></script>
    <script src="js/search.js"></script>
  </body>
</html>