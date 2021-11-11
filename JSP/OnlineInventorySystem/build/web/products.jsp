<%@page import="bean.Inventory"%>
<%@page import="java.util.ArrayList"%>
<%@include file="includes/head.jsp" %>
<link rel="stylesheet" href="css/products.css">
<title>Home</title>
</head>
<body>
    <%@include file="includes/navigation.jsp" %>
    <div class="container">
        <div class="row">
            <%
                ArrayList<Inventory> arrayListInventory = (ArrayList<Inventory>) session.getAttribute("productList");
                if(arrayListInventory != null){
            %>
                <% for(int i=0; i < arrayListInventory.size(); i++){%>
                    <div class="col">
                        <div class="card text-center" style="width: 18rem;">
                            <div class="card-header">
                              Product Id: <%=arrayListInventory.get(i).getId()%>
                            </div>
                            <img class="card-img-top" src="img/product.jpg" alt="Card image cap">
                            <div class="card-body">
                              <h5 class="card-title"><%=arrayListInventory.get(i).getName()%></h5>
                              <p class="card-text"><%=arrayListInventory.get(i).getDescription()%></p>
                              <p class="card-text text-success">$<%=arrayListInventory.get(i).getPrice()%></p>
                              <%
                                  boolean islogin = (Boolean) (session.getAttribute("is_login") != null ? session.getAttribute("is_login") : false);
                                  if(islogin){
                              %>
                                <button class="btn btn-outline-primary btn-block" onclick="addcart(<%=arrayListInventory.get(i).getId()%>, '<%=arrayListInventory.get(i).getName()%>', <%=arrayListInventory.get(i).getPrice()%>)">Add to Cart</button>
                              <% }else{%>
                                <button class="btn btn-outline-secondary btn-block" data-toggle="modal" data-target="#login_modal">Add to Cart</button>
                              <% }%>
                            </div>
                            <div class="card-footer text-muted">
                              <%=arrayListInventory.get(i).getCreated_at()%>
                            </div>
                        </div>
                    </div>
                <% }%>
            <% }else{
                response.sendRedirect("product_controller");
            }%>
        </div>
    </div>
<%@include file="includes/boostrapJS.jsp" %>
<script src="js/cart.js"></script>
</body>
</html>