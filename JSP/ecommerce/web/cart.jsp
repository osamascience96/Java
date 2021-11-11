<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Base64"%>
<%@page import="Bean.Product"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Cart</title>
    <link rel="stylesheet" href="css/styles.css" />
    <link rel="stylesheet" href="css/cart.css" />
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
        <div class="container">
            <div class="table">
                <div class="table-header">
                        <div class="header__item"><a id="name" class="filter__link" href="#">Id</a></div>
                        <div class="header__item"><a id="wins" class="filter__link filter__link--number" href="#">Name</a></div>
                        <div class="header__item"><a id="draws" class="filter__link filter__link--number" href="#">Price</a></div>
                        <div class="header__item"><a id="draws" class="filter__link filter__link--number" href="#">Image</a></div>
                        <div class="header__item"><a id="draws" class="filter__link filter__link--number" href="#">Date Time</a></div>
                </div>
                <div class="table-content">
                    <%
                        double totalPrice = 0;
                    %>
                    <% for(int i=0; i < arrayListProducts.size(); i++){%>
                        <div class="table-row">		
                            <div class="table-data"><%=arrayListProducts.get(i).getId()%></div>
                            <div class="table-data"><%=arrayListProducts.get(i).getName()%></div>
                            <div class="table-data">$<%=arrayListProducts.get(i).getPrice()%></div>
                            <%
                                totalPrice += arrayListProducts.get(i).getPrice();
                            %>
                            <%
                                byte[] imageBytes = arrayListProducts.get(i).getImage().getBytes(1, (int)arrayListProducts.get(i).getImage().length());
                                String encodedImage = Base64.getEncoder().encodeToString(imageBytes);
                                String image = "data:image/jpg;base64,".concat(encodedImage);
                            %>
                            <div class="table-data"><img src="<%=image%>" style="width:100px; height: 100px!important; border-radius: 15px;"></div>
                            <div class="table-data"><%=arrayListProducts.get(i).getCreated_at()%></div>
                        </div>
                    <% }%>
                </div>
                <h5 style="margin: 8px;">Total Price: $<%=totalPrice%></h5>
                <button class="submitbutton" onclick="window.location.replace('checkout.jsp')">Checkout Order</button>
            </div>
        </div>
    <% }else{
        response.sendRedirect("product_servlet");
    }%>
    </body>
</html>
