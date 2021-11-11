<%@page import="Bean.Cart"%>
<%@page import="Bean.User"%>
<%@page import="java.util.Base64"%>
<%@page import="Bean.Product"%>
<%@page import="java.util.ArrayList"%>
<%@include file="includes/header.jsp" %>
<title>Checkout</title>
<link rel="stylesheet" href="css/checkout.css">
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
            User userobject = (User) session.getAttribute("user_session");
            if(application.getAttribute("cart_list") != null){
                ArrayList<Product> arrayListProducts = (ArrayList<Product>) ((ArrayList<Cart>)application.getAttribute("cart_list")).get(CartHelper.GetUserIdIndex(((ArrayList<Cart>)application.getAttribute("cart_list")), userobject.getId())).getArrayListProducts();
                if(arrayListProducts != null){ 
            %>
                    <table class="table table-hover">
                        <thead>
                          <tr>
                            <th scope="col">ID.</th>
                            <th scope="col">Name</th>
                            <th scope="col">Price</th>
                            <th scope="col">Quantity</th>
                            <th scope="col">Image</th>
                          </tr>
                        </thead>
                        <% for(int i=0; i < arrayListProducts.size(); i++){%>
                            <tr>
                                <td scope="row"><%=arrayListProducts.get(i).getId()%></td>
                                <td><%=arrayListProducts.get(i).getName()%></td>
                                <td>$<%=arrayListProducts.get(i).getPrice()%></td>
                                <td>x<%=arrayListProducts.get(i).getQuantity()%></td>
                                <% if(arrayListProducts.get(i).getImage().length() != 0){ %>
                                    <%
                                        byte[] imageBytes = arrayListProducts.get(i).getImage().getBytes(1, (int)arrayListProducts.get(i).getImage().length());
                                        String encodedImage = Base64.getEncoder().encodeToString(imageBytes);
                                        String image = "data:image/jpg;base64,".concat(encodedImage);
                                    %>
                                    <td><img width="100px" src="<%=image%>" alt="category_image"></td>
                                <% }else{%>
                                    <td><img width="100px" src="img/no-image.png" alt="category_image"></td>
                                <% }%>
                            </tr>
                        <% }%>
                    </table>
                    <a href="checkout_servlet" class="btn btn-outline-info btn-block">Confirm Order</a>
            <% }else{%>
                <h4 id="noproducts" class="text-center">No Sub Products Available</h4>
            <% } 
        }else{%>
            <h4>No Item Selected</h4>
        <% }%>
    </div>
    
    <%@include file="modal/login.jsp" %>
    <%@include file="includes/bootstrapJS.jsp" %>
    <script src="js/cart.js"></script>
    <script src="js/login.js"></script>
</body>
</html>