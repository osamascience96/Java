<%@page import="Bean.User"%>
<%@page import="java.util.Base64"%>
<%@page import="Bean.Product"%>
<%@page import="java.util.ArrayList"%>
<%@include file="includes/header.jsp" %>
<title>Home-Product</title>
<link rel="stylesheet" href="css/product.css">
</head>
<body>
    <%@include file="includes/navigation.jsp" %>
    <div class="container text-white">
        <%
            ArrayList<Product> arrayListSubProducts = (ArrayList<Product>) session.getAttribute("sub_product_list");
            if(arrayListSubProducts != null){
                User userobj = (User) session.getAttribute("user_session");
        %>
            <div class="row">
                <% for(int i=0; i < arrayListSubProducts.size(); i++){%>
                    <div class="col">
                        <div class="card text-dark" style="width: 18rem;">
                            <div class="card-header text-center">
                                <h5 class="card-title"><%=arrayListSubProducts.get(i).getName()%></h5>
                            </div>
                            <% if(arrayListSubProducts.get(i).getImage().length() != 0){ %>
                                <%
                                    byte[] imageBytes = arrayListSubProducts.get(i).getImage().getBytes(1, (int)arrayListSubProducts.get(i).getImage().length());
                                    String encodedImage = Base64.getEncoder().encodeToString(imageBytes);
                                    String image = "data:image/jpg;base64,".concat(encodedImage);
                                %>
                                <img class="card-img-top" height="250px" src="<%=image%>" alt="category_image">
                            <% }else{%>
                                <img class="card-img-top" height="250px" src="img/no-image.png" alt="category_image">
                            <% }%>
                            <div class="card-body">
                              <p class="card-text"><%=arrayListSubProducts.get(i).getDescription()%></p>
                              <h6 class="text-info">$<%=arrayListSubProducts.get(i).getPrice()%></h6>
                              <%
                                  if(session.getAttribute("is_login") != null){
                              %>
                              <button class="btn btn-outline-primary btn-block" onclick="addtocart(<%=userobj.getId()%>, <%=arrayListSubProducts.get(i).getId()%>)">Add to Cart</button>
                              <% }else{%>
                                <button class="btn btn-outline-dark btn-block" onclick="$('#login_modal').modal('show')">Login to Add Cart</button>
                              <% }%>
                            </div>
                        </div>
                    </div>
                <% }%>
                <% if(arrayListSubProducts.size() == 0){%>
                    <h4 id="noproducts" class="text-center">No Sub Products Added to the Category</h4>
                <% }%>
            </div>
        <% }else{%>
            <h4 id="noproducts" class="text-center">No Sub Products Available</h4>
        <% }%>
    </div>
    
    <%@include file="modal/login.jsp" %>
    <%@include file="includes/bootstrapJS.jsp" %>
    <script src="js/cart.js"></script>
    <script src="js/login.js"></script>
</body>
</html>