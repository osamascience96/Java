<%@page import="bean.Order"%>
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
             // check if the cart is set 
             if(session.getAttribute("cart_list") != null){
         %>
            <%
                ArrayList<Order> orderArrayList = (ArrayList<Order>)session.getAttribute("cart_list");
            %>
            <%
                double totalPrice = 0;
                for(int i=0; i < orderArrayList.size(); i++){
                    totalPrice += orderArrayList.get(i).getPrice();
                }
            %>
            <form action="checkout_servlet" method="POST">
                <div class="card text-center" style="margin-top: 10px;">
                    <div class="card-header">Please Checkout to Continue</div>
                    <div class="card-body">
                      <h5 class="card-title">Your Total Bill: $<%=totalPrice%></h5>
                      <div class="form-group">
                          <input type="text" class="form-control" name="username" placeholder="Enter Name" required>
                      </div>
                      <div class="form-group">
                          <input type="number" class="form-control" name="phone" placeholder="Enter Contact" required>
                      </div>
                      <div class="form-group">
                          <input type="text" class="form-control" name="address" placeholder="Enter Address" required>
                      </div>
                      <div class="input-group mb-3">
                        <div class="input-group-prepend">
                          <label class="input-group-text" for="inputGroupSelect01">Payment</label>
                        </div>
                        <select class="custom-select" id="inputGroupSelect01">
                          <option selected>Cash on Delivery</option>
                          <option>Credit Card</option>
                        </select>
                      </div>
                    </div>
                      <div class="card-footer text-muted"><button class="btn btn-outline-success btn-block" type="submit">Checkout</button></div>
                </div>
            </form>
         <% }else{%>
         <div class="alert alert-info text-center" rolw="alert" style="margin-top: 10px;">
             <h6>No Item Selected.</h6>
         </div>
         <% }%>
      </div>
    <%@include file="modal/cart_modal.jsp" %>
    <%@include file="modal/messge.jsp" %>
    <script type="text/javascript" src="js/home.js"></script>
<%@include file="includes/footer.jsp" %>