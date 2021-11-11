<%@page import="bean.Product"%>
<%@page import="java.util.Base64"%>
<%@page import="bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@include file="includes/head.jsp" %>
<link rel="stylesheet" rel="text/css" href="css/product.css">
<title>Home</title>
</head>
<body>
    <%@include file="includes/navigation.jsp" %>
    <div class="container">
        <%
            ArrayList<Product> arrayListProducts = (ArrayList<Product>)session.getAttribute("product_list_customer");
        %>
        <%
            if(arrayListProducts != null){
        %>
            <div class="row">
                <% for(int i=0; i < arrayListProducts.size(); i++){%>
                    <div class="col">
                        <div class="card text-center" style="width: 18rem;">
                            <div class="card-header">Product Id: <%=arrayListProducts.get(i).getId()%></div>
                            <% if(arrayListProducts.get(i).getImage().length() != 0){%>
                                <%
                                    byte[] imageBytes = arrayListProducts.get(i).getImage().getBytes(1, (int)arrayListProducts.get(i).getImage().length());
                                    String encodedImage = Base64.getEncoder().encodeToString(imageBytes);
                                    String image = "data:image/jpg;base64,".concat(encodedImage);
                                %>
                                <img class="card-img-top" height="290" src="<%=image%>" alt="Card image cap">
                            <% }else{%>
                                <img class="card-img-top" height="290" src="img/defaultproduct.jpg" alt="Card image cap">
                            <% }%>
                            <div class="card-body">
                              <h5 class="card-title"><%=arrayListProducts.get(i).getName()%></h5>
                              <p class="card-text"><%=arrayListProducts.get(i).getDescription()%></p>
                              <p class="card-text text-primary">$<%=arrayListProducts.get(i).getPrice()%></p>
                              <% if(session.getAttribute("is_login") != null){ %>
                              <button type="button" class="btn btn-outline-primary btn-block" onclick="cart(<%=arrayListProducts.get(i).getId()%>)">Add to Cart</button>
                              <% }else{%>
                                <button type="button" class="btn btn-outline-secondary btn-block" data-toggle="modal" data-target="#login_modal">Add to Cart</button>
                              <% }%>
                            </div>
                            <div class="card-footer text-muted"><%=arrayListProducts.get(i).getCreated_at()%></div>
                        </div>
                    </div>
                <% }%>
            </div>
        <% }else{
            response.sendRedirect("product_servlet");
        }%>
    </div>
<%@include file="includes/boostrapjs.jsp" %>
<%@include file="includes/footer.jsp" %>
<script src="js/cart.js"></script>
</body>
</html>