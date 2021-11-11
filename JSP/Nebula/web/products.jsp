<%@page import="java.util.Base64"%>
<%@page import="Bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@include file="includes/header.jsp" %>
<title>Home-Product</title>
<link rel="stylesheet" href="css/product.css">
</head>
<body>
    <%@include file="includes/navigation.jsp" %>
    <div class="container text-white">
        <%
                    String respond = request.getParameter("response");
                    if(respond != null){
                %>
                    <%
                        String message = "";
                        String alertType = "";
                        String alertTitle = "";
                        if(respond.compareTo("order_placed") == 0){
                            alertType = "success";
                            alertTitle = "Order Created!";
                            message = "Your Order is placed Successfully";
                        }
                    %>
                    <div class="alert alert-<%=alertType%> alert-dismissible fade show" role="alert">
                        <strong><%=alertTitle%></strong> <%=message%>
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                          <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                <% }%>
        <%
            ArrayList<Category> arrayListCategory = (ArrayList<Category>) session.getAttribute("category_list_session");
            if(arrayListCategory != null){
        %>
            <div class="row">
                <% for(int i=0; i < arrayListCategory.size(); i++){%>
                    <div class="col">
                        <div class="card text-dark" style="width: 18rem;">
                            <div class="card-header text-center">
                                <h5 class="card-title"><%=arrayListCategory.get(i).getName()%></h5>
                            </div>
                            <% if(arrayListCategory.get(i).getImage().length() != 0){ %>
                                <%
                                    byte[] imageBytes = arrayListCategory.get(i).getImage().getBytes(1, (int)arrayListCategory.get(i).getImage().length());
                                    String encodedImage = Base64.getEncoder().encodeToString(imageBytes);
                                    String image = "data:image/jpg;base64,".concat(encodedImage);
                                %>
                                <img class="card-img-top" height="250px" src="<%=image%>" alt="category_image">
                            <% }else{%>
                                <img class="card-img-top" height="250px" src="img/no-image.png" alt="category_image">
                            <% }%>
                            <div class="card-body">
                              <p class="card-text"><%=arrayListCategory.get(i).getDescription()%></p>
                              <a href="product_controller?cid=<%=arrayListCategory.get(i).getId()%>" class="btn btn-outline-warning btn-block">See Products</a>
                            </div>
                        </div>
                    </div>
                <% }%>
            </div>
        <% }else{%>
            <h4 id="noproducts" class="text-center">No Products Available</h4>
        <% }%>
    </div>
    
    <%@include file="modal/login.jsp" %>
    <%@include file="includes/bootstrapJS.jsp" %>
    <script src="js/login.js"></script>
</body>
</html>