<%@page import="Bean.Product"%>
<%@page import="java.util.ArrayList"%>
<%@include file="includes/header.jsp" %>
    <link rel="stylesheet" href="css/admin.css" >
    <title>Admin</title>
  </head>
  <body>
    <%
        // disable the cache to page to disable any page content in the cache
        // clearing the cache
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // Http 1.1
        response.setHeader("Pragma", "no-cache"); // Http 1.0
        if(session.getAttribute("is_login_admin") == null){
            response.sendRedirect("index.jsp");
        }
    %>
    <%@include file="includes/navigation.jsp" %>
    <div class="container">
        <div class="nav flex-column nav-pills float-left" id="v-pills-tab" role="tablist" aria-orientation="vertical">
            <a class="nav-link active" id="v-pills-addproperty-tab" data-toggle="pill" href="#v-pills-addproperty" role="tab" aria-controls="v-pills-addproperty" aria-selected="true">Add Property</a>
            <a class="nav-link" id="v-pills-myproperty-tab" data-toggle="pill" href="#v-pills-myproperty" role="tab" aria-controls="v-pills-myproperty" aria-selected="false">My Properties</a>
        </div>
        <div class="tab-content" id="v-pills-tabContent">
            <div class="tab-pane fade show active" id="v-pills-addproperty" role="tabpanel" aria-labelledby="v-pills-addproperty-tab">
                <form action="admin_servlet" method="POST">
                    <div class="form-group">
                        <label for="property_name">Enter Property Name</label>
                        <input type="text" name="property_name" class="form-control" id="property_name" placeholder="Property Name" required>
                    </div>
                    <div class="form-group">
                        <label for="property_location">Enter Property Location</label>
                        <input type="text" name="property_location" class="form-control" id="property_location" placeholder="Property Location" required>
                    </div>
                    <div class="form-group">
                        <label for="property_price">Enter Property Price</label>
                        <input type="number" name="property_price" class="form-control" id="property_price" placeholder="Property Price" required>
                    </div>
                    <input type="submit" class="btn btn-outline-primary btn-block" value="Add Property">
                </form>
            </div>
            <div class="tab-pane fade" id="v-pills-myproperty" role="tabpanel" aria-labelledby="v-pills-myproperty-tab">
                <%
                    ArrayList<Product> productArrayList = (ArrayList<Product>) session.getAttribute("property_user_list");
                    if(productArrayList != null){
                    if(productArrayList.size() > 0){
                %>
                <div class="row">
                    <% for(int i=0; i < productArrayList.size(); i++){%>
                        <div class="col">
                            <div class="card" style="width: 18rem;">
                            <img class="card-img-top" src="img/cardlandscape.jpg" alt="Card image cap">
                            <div class="card-body">
                              <h6 class="card-title">Name: <%=productArrayList.get(i).getPropertyName()%></h6>
                              <p class="card-text">Location: <%=productArrayList.get(i).getLocation()%></p>
                              <p class="card-text text-primary">Price: $<%=productArrayList.get(i).getPrice()%></p>
                              <a href="admin_servlet?isdel=true&propertyid=<%=productArrayList.get(i).getId()%>" class="btn btn-outline-danger btn-block">Delete</a>
                            </div>
                            </div>
                        </div>
                    <% }%>
                </div>
                <% }else{%>
                    <h4>No Properties Added Yet</h4>
                <% }%>
                <% }%>
            </div>
        </div>
        <%
            if(request.getParameter("response") != null){
        %>
            <% String respond =  request.getParameter("response");%>
            <%
                if(respond.compareTo("property_added") == 0){
            %>
                <div class="alert alert-success alert-dismissible fade show" role="alert">
                    <strong>Success!</strong> Property Added Successfully.
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            <% }else if(respond.compareTo("delete_success") == 0){%>
                <div class="alert alert-info alert-dismissible fade show" role="alert">
                    <strong>Success!</strong> Property Deleted Successfully.
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            <% }%>
        <% }%>
    </div>
    <%@include file="modal/login.jsp" %>                      
    <%@include file="includes/bootstrapJs.jsp" %>
    <script src="js/home.js"></script>
  </body>
</html>