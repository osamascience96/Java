<%@page import="bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@include file="includes/head.jsp" %>
<link rel="stylesheet" rel="text/css" href="css/admin.css">
<title>Admin</title>
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
    <div class="container">
        <% if(request.getParameter("response") != null){%>
            <% 
                String respond = request.getParameter("response");
                String alertType = "";
                String alertMessage = "";
            %>
            <%
                if(respond.compareTo("category_inserted") == 0){
                    alertType = "success";
                    alertMessage = "The Category is Created Successfully";
                }else if(respond.compareTo("already_exists") == 0){
                    alertType = "danger";
                    alertMessage = "The Category you are trying to creating already exists";
                }else if(respond.compareTo("product_inserted_successfully") == 0){
                    alertType = "success";
                    alertMessage = "Product Created Successfully";
                }else if(respond.compareTo("product_already_exists") == 0){
                    alertType = "danger";
                    alertMessage = "Product Already Exists";
                }else if(respond.compareTo("categoryid_not_set") == 0){
                    alertType = "warning";
                    alertMessage = "Product cannot be added without Category Id";
                }
            %>
            <div class="alert alert-<%=alertType%>" role="alert">
                <%=alertMessage%>
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        <% }%>
        <div id="navpills" class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
            <a class="nav-link active" id="v-pills-home-tab" data-toggle="pill" href="#v-pills-home" role="tab" aria-controls="v-pills-home" aria-selected="true">Add Category</a>
            <a class="nav-link" id="v-pills-profile-tab" data-toggle="pill" href="#v-pills-profile" role="tab" aria-controls="v-pills-profile" aria-selected="false">Add Product</a>
        </div>
        <div id="nav-content" class="tab-content" id="v-pills-tabContent">
            <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab">
                <form action="category_servlet" method="post" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="category_name">Enter Category Name:</label>
                        <input type="text" id="category_name" name="category_name" class="form-control" placeholder="Category Name" required>
                    </div>
                    <div class="form-group">
                        <label for="category_description">Enter Category Description:</label>
                        <textarea id="category_description" name="category_description" class="form-control" rows="10" cols="10" placeholder="Category Description" required></textarea>
                    </div>
                    <div class="form-group">
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                              <span class="input-group-text">Upload</span>
                            </div>
                            <div class="custom-file">
                              <input type="file" class="custom-file-input" id="category_image" name="category_image">
                              <label class="custom-file-label" for="category_image">Upload Category Image</label>
                            </div>
                        </div>
                    </div>
                    <input type="submit" class="btn btn-dark btn-block" value="Add Category">
                </form>
            </div>
            <div class="tab-pane fade" id="v-pills-profile" role="tabpanel" aria-labelledby="v-pills-profile-tab">
                <form action="product_servlet" method="post" enctype="multipart/form-data">
                    
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                          <label class="input-group-text" for="inputGroupSelect01">Select Category</label>
                        </div>
                        <%
                            ArrayList<Category> categoryArrayList = (ArrayList<Category>)session.getAttribute("categoryList");
                            if(categoryArrayList != null){
                        %>
                            <% if(categoryArrayList.size() > 0){%>
                                <select class="custom-select" id="inputGroupSelect01" name="categoryIdSelect" required>
                                    <% for(int i=0; i < categoryArrayList.size(); i++){%>
                                        <option value="<%=categoryArrayList.get(i).getId()%>"><%=categoryArrayList.get(i).getName()%></option>
                                    <% }%>
                                </select>
                            <% }else{%>
                                <h6 class="text-center" style="margin-top: 15px; margin-left: 15px;">No Category Created Yet.</h6>
                            <% }%>
                        <% }%>
                    </div>
                    <div class="form-group">
                        <label for="product_name">Enter Product Name:</label>
                        <input type="text" id="product_name" name="product_name" class="form-control" placeholder="Product Name" required>
                    </div>
                    <div class="form-group">
                        <label for="product_description">Enter Product Description:</label>
                        <textarea id="product_description" name="product_description" class="form-control" rows="10" cols="10" placeholder="Product Description" required></textarea>
                    </div>
                    <div class="form-group">
                        <label for="product_price">Enter Product Price:</label>
                        <input type="number" id="product_price" name="product_price" class="form-control" placeholder="Product Price" required>
                    </div>
                    <div class="form-group">
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                              <span class="input-group-text">Upload</span>
                            </div>
                            <div class="custom-file">
                              <input type="file" class="custom-file-input" id="product_image" name="product_image">
                              <label class="custom-file-label" for="product_image">Upload Product Image</label>
                            </div>
                        </div>
                    </div>
                    <input type="submit" class="btn btn-dark btn-block" value="Add Product">
                </form>
            </div>
        </div>
    </div>
<%@include file="includes/boostrapjs.jsp" %>
<%@include file="includes/footer.jsp" %>
</body>
</html>