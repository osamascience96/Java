<%@page import="bean.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.User"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="index.jsp">
      <img src="<%=request.getContextPath()%>/img/navicon.png" width="30" height="30" class="d-inline-block align-top" alt="">
      Home
  </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <%
          if(session.getAttribute("user_obj") != null){
      %>
        <%
            User userNavObj = (User)session.getAttribute("user_obj");
        %>
        <%
            if(userNavObj.getUsername().compareTo("admin") == 0){
        %>
            <li class="nav-item">
              <a class="nav-link" href="admin.jsp">Admin</a>
            </li>
        <% }else{%>
            <li class="nav-item">
                <a class="nav-link" href="category_servlet">Categories</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="product_servlet">Products</a>
            </li>
        <% }%>
      <% }else{%>
        <li class="nav-item">
          <a class="nav-link" href="register.jsp">Register</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="category_servlet">Categories</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="product_servlet">Products</a>
        </li>
      <% }%>
    </ul>
    <div class="form-inline my-2 my-lg-0">
      <%
          boolean is_login = (Boolean) (session.getAttribute("is_login") != null ? session.getAttribute("is_login") : false);
          if(is_login){
      %>
        <%
            int cart_count = 0;
            ArrayList<Product> productNavArrayList = (ArrayList<Product>) session.getAttribute("cart_product_arraylist");
            if(productNavArrayList != null){
                cart_count = productNavArrayList.size();
            }
        %>
        <a class="btn btn-outline-light mr-sm-2" href="checkout_servlet"><i class="fa fa-shopping-cart" aria-hidden="true"></i> <span id="cart_count"><%=cart_count%></span></a>
        <a href="logout_servlet" class="btn btn-outline-danger my-2 my-sm-0">Logout</a>
      <% }else{%>
        <button class="btn btn-outline-light mr-sm-2" data-toggle="modal" data-target="#login_modal"><i class="fa fa-shopping-cart" aria-hidden="true"></i></button>
        <button class="btn btn-outline-light my-2 my-sm-0" data-toggle="modal" data-target="#login_modal">Login</button>
      <% }%>
    </div>
  </div>
</nav>