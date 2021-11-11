<%@page import="bean.Product"%>
<%@page import="java.util.ArrayList"%>
<%@include file="includes/header.jsp" %>
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="css/home.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
  </head>
  <body>
      <%
        // disable the cache to page to disable any page content in the cache
        // clearing the cache
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // Http 1.1
        response.setHeader("Pragma", "no-cache"); // Http 1.0
        if(session.getAttribute("product_list") == null){
            response.sendRedirect("product_servlet");
        }
      %>
      <div class="container">
         <%
             if(request.getParameter("respond") != null){
                 String respond = request.getParameter("respond");
                 
                 String alertType = "";
                 String alertTitle = "";
                 String alertMessage = "";
                 
                 if(respond.compareTo("submit-order-success") == 0){
                     alertType = "success";
                     alertTitle = "Success";
                     alertMessage = "Order Submitted";
                 }else if(respond.compareTo("failed") == 0){
                     alertType = "danger";
                     alertTitle = "Failed";
                     alertMessage = "Something went wrong!";
                 }
         %>
            <div class="alert alert-<%=alertType%> alert-dismissible fade show" role="alert">
                <strong><%=alertTitle%>!</strong> <%=alertMessage%>
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
            </div>
         <% }%>
         <%
             ArrayList<Product> productArrayList = (ArrayList<Product>) session.getAttribute("product_list");
         %> 
         <% if(productArrayList != null){%>
            <div class="card">
                <table class="table table-hover shopping-cart-wrap">
                    <thead class="text-muted">
                        <tr>
                          <th scope="col">Product</th>
                          <th scope="col" width="120">Quantity</th>
                          <th scope="col" width="120">Price</th>
                          <th scope="col" width="200" class="text-right">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for(int i=0; i < productArrayList.size(); i++){%>
                            <script>
                                var product_modal_<%=productArrayList.get(i).getId()%> = {
                                    product_id: <%=productArrayList.get(i).getId()%>,
                                    price: <%=productArrayList.get(i).getPrice()%>,
                                }
                            </script>
                            <tr>
                                <td>
                                    <figure class="media">
                                        <div class="img-wrap"><img src="<%=request.getContextPath().toString()%>/img/<%=productArrayList.get(i).getImage()%>" class="img-thumbnail img-sm"></div>
                                        <figcaption class="media-body">
                                                <h6 class="title text-truncate"><%=productArrayList.get(i).getTypeName()%></h6>
                                        </figcaption>
                                    </figure> 
                                </td>
                                <td> 
                                    <div class="form-group">
                                        <input id="quantity_<%=productArrayList.get(i).getId()%>" type="number" class="form-control" placeholder="Ratio" name="quantity" />
                                    </div>
                                    <script>
                                        $("#quantity_<%=productArrayList.get(i).getId()%>").bind('input', function() { 
                                            product_modal_<%=productArrayList.get(i).getId()%>['quantity'] = $(this).val()
                                        });
                                    </script>
                                </td>
                                    <td> 
                                            <div class="price-wrap"> 
                                                    <var class="price">USD <%=productArrayList.get(i).getPrice()%></var>  
                                            </div> <!-- price-wrap .// -->
                                    </td>
                                    <td class="text-right"> 
                                        <button class="btn btn-outline-primary" data-toggle="tooltip" data-original-title="Save to Wishlist" onclick="open_cart_modal(product_modal_<%=productArrayList.get(i).getId()%>)"> <i class="fa fa-shopping-cart"></i></button> 
                                    </td>
                            </tr>
                        <% }%>
                    </tbody>
                </table>
            </div>
         <% }%>
         <a class="btn btn-outline-success btn-block" type="button" href="checkout.jsp">Checkout</a>
      </div>
    <%@include file="modal/cart_modal.jsp" %>
    <%@include file="modal/messge.jsp" %>
    <script type="text/javascript" src="js/home.js"></script>
<%@include file="includes/footer.jsp" %>