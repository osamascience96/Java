<%@include file="includes/header.jsp" %>
<title>Admin</title>
<link rel="stylesheet" href="css/admin.css">
</head>
<body>
    <%
        // disable the cache to page to disable any page content in the cache
        // clearing the cache
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // Http 1.1
        response.setHeader("Pragma", "no-cache"); // Http 1.0
        if(session.getAttribute("is_login") == null){
            response.sendRedirect("index.jsp");
        }
    %>
    <%@include file="includes/navigation.jsp" %>
    <div class="container text-white">
        <div class="row text-dark">
            <!-- Categoty -->
            <div class="col">
                <div class="card" style="width: 18rem;">
                    <img class="card-img-top" height="250px" src="img/category.jpg" alt="Card image cap">
                    <div class="card-body">
                      <p class="card-text">Adding the category for the Products</p>
                      <button class="btn btn-primary btn-block" onclick="$('#add_categories_modal').modal('show')">Add Category</button>
                    </div>
                </div>
            </div>
            <!-- Products -->
            <div class="col">
                <div class="card" style="width: 18rem;">
                    <img class="card-img-top" height="250px" src="img/products.jpg" alt="Card image cap">
                    <div class="card-body">
                      <p class="card-text">Adding the Products to add in category.</p>
                      <button class="btn btn-primary btn-block" onclick="$('#add_product_modal').modal('show')">Add Product</button>
                    </div>
                </div>
            </div>
            <!-- Orders -->
            <div class="col">
                <div class="card" style="width: 18rem;">
                    <img class="card-img-top" height="250px" src="img/orders.jpg" alt="Card image cap">
                    <div class="card-body">
                      <p class="card-text">Check-in orders of the users to deliever to them.</p>
                      <a href="order_controller" class="btn btn-primary btn-block">Check Orders</a>
                    </div>
                </div>
            </div>
        </div>
        <%
            String respond = request.getParameter("response");
            if(respond != null){
        %>
            <%
                String message = "";
                String alertType = "";
                String alertTitle = "";
                if(respond.compareTo("category_exists") == 0){
                    alertType = "danger";
                    alertTitle = "Category Exists!";
                    message = "This Category Already Exists in the System";
                }else if(respond.compareTo("category_inserted") == 0){
                    alertType = "success";
                    alertTitle = "Category Inserted!";
                    message = "The Category is added to the database Successfully";
                }else if(respond.compareTo("product_exists") == 0){
                    alertType = "danger";
                    alertTitle = "Product Exists!";
                    message = "The Product is added to the database successfully";
                }else if(respond.compareTo("product_insert_success") == 0){
                    alertType = "success";
                    alertTitle = "Product Inserted!";
                    message = "The Product is added to the database successfully";
                }
            %>
            <div class="alert alert-<%=alertType%> alert-dismissible fade show" role="alert">
                <strong><%=alertTitle%></strong> <%=message%>
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
            </div>
        <% }%>
    </div>
    <%@include file="modal/categories.jsp" %>
    <%@include file="modal/products.jsp" %>
    <%@include file="includes/bootstrapJS.jsp" %>
    <script src="js/admin.js"></script>
</body>
</html>