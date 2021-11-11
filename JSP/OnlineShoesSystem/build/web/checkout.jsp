<%@page import="bean.Product"%>
<%@page import="java.util.Base64"%>
<%@page import="bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@include file="includes/head.jsp" %>
<link rel="stylesheet" rel="text/css" href="css/checkout.css">
<title>Home</title>
</head>
<body>
    <%@include file="includes/navigation.jsp" %>
    <div class="container">
        <div id="alert_checkout_placeholder"></div>
        <%
            ArrayList<bean.Product> arrayListProducts = (ArrayList<bean.Product>)session.getAttribute("cart_product_arraylist");
        %>
        <% if(arrayListProducts != null){%>
            <div class="table-responsive-xl">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Name</th>
                            <th scope="col">Price</th>
                            <th scope="col">Image</th>
                            <th scope="col">Date/Time</th>
                        </tr>
                        <tbody>
                            <% double totalPrice = 0;%>
                            <% for(int i=0; i < arrayListProducts.size(); i++){%>
                                <tr>
                                    <th scope="row"><%=arrayListProducts.get(i).getId()%></th>
                                    <td><%=arrayListProducts.get(i).getName()%></td>
                                    <td class="text-info">$<%=arrayListProducts.get(i).getPrice()%></td>
                                    <%
                                        totalPrice += arrayListProducts.get(i).getPrice();
                                    %>
                                    <% if(arrayListProducts.get(i).getImage().length() != 0){%>
                                        <%
                                            byte[] imageBytes = arrayListProducts.get(i).getImage().getBytes(1, (int)arrayListProducts.get(i).getImage().length());
                                            String encodedImage = Base64.getEncoder().encodeToString(imageBytes);
                                            String image = "data:image/jpg;base64,".concat(encodedImage);
                                        %>
                                        <td><img src="<%=image%>" width="80"></td>
                                    <% }else{%>
                                        <td><img src="img/defaultproduct.jpg" width="80"></td>
                                    <% }%>
                                    <td><%=arrayListProducts.get(i).getCreated_at()%></td>
                                </tr>
                            <% }%>
                        </tbody>
                    </thead>
                </table>
                <h5 id="price_label" class="text-primary float-left">Total Price: $<%=totalPrice%></h5>
                <button id="checkout-btn" class="btn btn-outline-success float-right" onclick="checkout()">Checkout Order</button>
            </div>
        <% }else{ %>
            <h4 class="text-danger mx-auto">No Product Added to Cart</h4>
        <% }%>
    </div>
<%@include file="includes/boostrapjs.jsp" %>
<%--<%@include file="includes/footer.jsp" %>--%>
<script src="js/checkout.js"></script>
</body>
</html>