<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Base64"%>
<%@page import="Bean.Product"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Checkout</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/styles.css" />
    <link rel="stylesheet" href="css/checkout.css" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  </head>

  <body>
    <header>
      <%@include file="includes/navigation.jsp" %>
    </header>
    <%
        ArrayList<Product> arrayListProducts = (ArrayList<Product>) session.getAttribute("productCartArrayList");
        if(arrayListProducts != null){
    %>
        <form action="checkout_servlet" name="purchaseForm" id="purchaseForm"
          method="POST"
        >
          <input
            type="text"
            id="fname"
            name="firstname"
            placeholder="Full name"
          />

          <input
            type="text"
            id="address"
            name="address"
            placeholder="Shipping Address"
          />

          <input
            type="text"
            id="phone"
            name="phone"
            placeholder="Phone Number"
          />

          <input type="text" id="email" name="email" placeholder="Email" />

          <input type="text" id="cc" name="cc" placeholder="Credit Card" />
          
          <div class="rate">
            <input type="radio" id="star5" name="rate" value="5" />
            <label for="star5" title="text">5 stars</label>
            <input type="radio" id="star4" name="rate" value="4" />
            <label for="star4" title="text">4 stars</label>
            <input type="radio" id="star3" name="rate" value="3" />
            <label for="star3" title="text">3 stars</label>
            <input type="radio" id="star2" name="rate" value="2" />
            <label for="star2" title="text">2 stars</label>
            <input type="radio" id="star1" name="rate" value="1" />
            <label for="star1" title="text">1 star</label>
          </div>

          <br />

          <button class="submitbutton" onclick="event.preventDefault(); return validateForm()" type="submit">Submit</button>
        </form>
    <% }else{
        response.sendRedirect("product_servlet");
    }%>
    <script src="js/main.js"></script>
    </body>
</html>
