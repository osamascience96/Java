<%@page import="java.util.Base64"%>
<%@page import="Bean.Product"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>My Ecommece</title>
    <link rel="stylesheet" href="css/styles.css" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  </head>

  <body>
    <header>
        <%@include file="includes/navigation.jsp" %>
    </header>

    <div class="container">
      <div class="about-us">
        <%
            float averageRating = (float)(session.getAttribute("average_rating") != null ? session.getAttribute("average_rating") : 0);
        %>
        <h3 class="about">About us</h3>
        <h4 class="about">The Average Rating of our Services: &#9733;<%=averageRating%></h4>
        <p>
          Lorem ipsum dolor sit, amet consectetur adipisicing elit. Voluptatem
          et, quam, provident, corporis temporibus aperiam accusantium
          reiciendis repudiandae perferendis nam voluptates. Accusamus possimus
          nostrum officiis earum rerum, itaque rem quo. Lorem ipsum dolor sit
          amet consectetur adipisicing elit. Ducimus dolor repellat aperiam
          voluptate nemo itaque eius perferendis, impedit ad, earum eligendi!
          Quo iure sint inventore tempora labore, maiores ipsa optio? Lorem
          ipsum dolor, sit amet consectetur adipisicing elit. Commodi officia
          aliquid consequuntur omnis sunt corporis fugiat? Nemo commodi
          voluptates, quaerat nesciunt numquam possimus. Nisi consequuntur rerum
          cupiditate, nobis facere cumque.
        </p>
      </div>
      <div class="products">
        <%
            ArrayList<Product> arrayListProducts = (ArrayList<Product>) session.getAttribute("product_list");
        %>
        <%
            if(arrayListProducts != null){
        %>
            <% if(arrayListProducts.size() > 0){%>
                <% for(int i=0; i < arrayListProducts.size(); i++){%>
                    <div class="box">
                        <a href="product_servlet?solo_prod=true&id=<%=arrayListProducts.get(i).getId()%>">
                        <%
                            byte[] imageBytes = arrayListProducts.get(i).getImage().getBytes(1, (int)arrayListProducts.get(i).getImage().length());
                            String encodedImage = Base64.getEncoder().encodeToString(imageBytes);
                            String image = "data:image/jpg;base64,".concat(encodedImage);
                        %>
                        <img src="<%=image%>" class="productImg" style="width:250px; height: 250px!important; border-radius: 15px;"/>
                      </a>
                      <div class="info">
                        <div class="model" style="display: flex"><%=arrayListProducts.get(i).getName()%></div>
                        <div class="price" style="display: flex">$<%=arrayListProducts.get(i).getPrice()%></div>
                      </div>
                    </div>
                <% }%>
            <% }else{%>
                <h3>No Products Available</h3>
            <% }%>
        <% }else{%>
            <%
                response.sendRedirect("product_servlet");
            %>
        <% }%>
      </div>
    </div>
    <footer>
      <p>Made by Omer Faruk Celik</p>
    </footer>
      <script>
          <% if(request.getParameter("response") != null){%>
            <% if(request.getParameter("response").compareTo("insert_success") == 0){%>
                alert("Order Created Successfully");
            <% }%>
          <% }%>
      </script>
  </body>
</html>
