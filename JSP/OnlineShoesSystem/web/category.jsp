<%@page import="java.util.Base64"%>
<%@page import="bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@include file="includes/head.jsp" %>
<link rel="stylesheet" rel="text/css" href="css/category.css">
<title>Home</title>
</head>
<body>
    <%@include file="includes/navigation.jsp" %>
    <div class="container">
        <div id="alert_placeholder_product_message"></div>
        <ul id="side_nav" class="nav flex-column">
            <%
                ArrayList<Category> categoryArrayList = (ArrayList<Category>) session.getAttribute("categoryShowCaseList");
                if(categoryArrayList != null){
            %>
                <% for(int i=0; i < categoryArrayList.size(); i++){%>
                    <li class="nav-item">
                        <button class="btn btn-outline-dark" onclick="GetProduct(<%=categoryArrayList.get(i).getId()%>)">
                            <% if(categoryArrayList.get(i).getImage().length() != 0){%>
                                <%
                                    byte[] imageBytes = categoryArrayList.get(i).getImage().getBytes(1, (int)categoryArrayList.get(i).getImage().length());
                                    String encodedImage = Base64.getEncoder().encodeToString(imageBytes);
                                    String image = "data:image/jpg;base64,".concat(encodedImage);
                                %>
                                <img src="<%=image%>" width="20"> 
                            <% }else{%>
                                <img src="img/categorydefault.png" width="20">
                            <% }%>
                            <%=categoryArrayList.get(i).getName()%>
                        </button>
                    </li>
                <% }%>
            <% }else{
                response.sendRedirect("category_servlet");
            }%>
        </ul>
        <div id="product_view" class="row">
        </div>
    </div>
<%@include file="includes/boostrapjs.jsp" %>
<%--<%@include file="includes/footer.jsp" %>--%>
<script src="js/product.js"></script>
<script src="js/cart.js"></script>
</body>
</html>