<%@page import="java.util.Base64"%>
<%@page import="Bean.Product"%>
<!DOCTYPE html>
<html>
  <head>
    <title>My Ecommece</title>
    <link rel="stylesheet" href="css/styles.css" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  </head>

  <body>
    <header>
      <%@include file="includes/navigation.jsp" %>
    </header>

    <div class="container-product-detail">
      <%
          Product product = (Product) session.getAttribute("product");
          if(product != null){
      %>
        <%
            byte[] imageBytes = product.getImage().getBytes(1, (int)product.getImage().length());
            String encodedImage = Base64.getEncoder().encodeToString(imageBytes);
            String image = "data:image/jpg;base64,".concat(encodedImage);
        %>
        <div class="left">
          <img
            src="<%=image%>"
            class="product-detail-img"
            style="width: 300px; height: 300px!important;"
          />
          <div class="mini">
            <img
              src="<%=image%>"
              class="product-detail-img"
              width="20%"
            />
            <img
              src="<%=image%>"
              class="product-detail-img"
              width="20%"
            />
            <img
              src="<%=image%>"
              class="product-detail-img"
              width="20%"
            />
            <img
              src="<%=image%>"
              class="product-detail-img"
              width="20%"
            />
          </div>
        </div>
        <div class="right" style="margin-left: 10px;">
            <h4><%=product.getName()%></h4>
            <p><%=product.getDescription()%></p>
            <h2>$<%=product.getPrice()%></h2>
        </div>

          <br>
          <br>

          <button class="submitbutton" onclick="AddCart(<%=product.getId()%>)">Add to Cart</button>
        <% }else{
            response.sendRedirect("product_servlet");
        }%>  
        <script src="js/main.js"></script>
        <script src="js/cart.js"></script>
      </body>
</html>
