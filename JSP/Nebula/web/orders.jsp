<%@page import="Bean.Order"%>
<%@page import="Bean.Cart"%>
<%@page import="Bean.User"%>
<%@page import="java.util.Base64"%>
<%@page import="Bean.Product"%>
<%@page import="java.util.ArrayList"%>
<%@include file="includes/header.jsp" %>
<title>Checkout</title>
<link rel="stylesheet" href="css/orders.css">
</head>
<body>
    <%@include file="includes/navigation.jsp" %>
    <div class="container text-white">
        <%
            // disable the cache to page to disable any page content in the cache
            // clearing the cache
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // Http 1.1
            response.setHeader("Pragma", "no-cache"); // Http 1.0
            if(session.getAttribute("is_login") == null){
                response.sendRedirect("index.jsp");
            }
        %>
        <%
            if(session.getAttribute("order_list") != null){
        %>
            <%
                ArrayList<Order> arrayListOrders = (ArrayList<Order>) session.getAttribute("order_list");
            %>
            <table class="table table-hover">
                <thead>
                  <tr>
                    <th scope="col">Username</th>
                    <th scope="col">Email</th>
                    <th scope="col">Order Price</th>
                  </tr>
                </thead>
                <tbody>
                  <% for(int i=0; i < arrayListOrders.size(); i++){%>
                    <tr>
                      <th scope="row"><%=arrayListOrders.get(i).getUser().getUsername()%></th>
                      <td><%=arrayListOrders.get(i).getUser().getEmail()%></td>
                      <td>$<%=arrayListOrders.get(i).getTotalPrice()%></td>
                    </tr>
                  <% }%>
                </tbody>
            </table>
        <% }else{%>
            <h4>No Orders Shown</h4>
        <% }%>
    <%@include file="includes/bootstrapJS.jsp" %>
</body>
</html>