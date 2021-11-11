<%@page import="bean.User"%>
<%@page import="bean.Inventory"%>
<%@page import="java.util.ArrayList"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="index.jsp">Home</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="product_controller">Products</a>
      </li>
      <%
          User userObj = (User)session.getAttribute("userObj");
          String role = null;
          if(userObj != null){
              role = userObj.getRole();
          }
          
          if(role != null){
      %>
            <%if(role.compareTo("manager") == 0){%>
                <li class="nav-item">
                    <a class="nav-link" href="management_controller">Inventory Management</a>
                </li>
                <% }else if(role.compareTo("admin") == 0){%>
                    <li class="nav-item">
                        <a class="nav-link" href="management_controller">Inventory Management</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="admin_controller">Customer Management</a>
                    </li>
                <% }%>
      <% }%>
    </ul>
    <div class="form-inline my-2 my-lg-0">
        <%
            boolean isLogin = (Boolean)(session.getAttribute("is_login") != null ? session.getAttribute("is_login") : false);
            if(!isLogin){
        %>
            <button class="btn btn-outline-secondary mr-sm-2" data-toggle="modal" data-target="#login_modal"><i class="fa fa-shopping-cart" aria-hidden="true"></i></button>
            <button class="btn btn-outline-primary mr-sm-2" data-toggle="modal" data-target="#register_modal">Register</button>
            <button class="btn btn-outline-success my-2 my-sm-0" data-toggle="modal" data-target="#login_modal">Login</button>
        <% }else{%>
            <a class="btn btn-outline-primary mr-sm-2" href="user_controller"><i class="fa fa-user" aria-hidden="true"></i></a>
            <%
                int cart_count = 0;
                ArrayList<Inventory> inventoryCartArrayList = (ArrayList<Inventory>) session.getAttribute("inventoryList");
                if(inventoryCartArrayList != null){   
                    cart_count = inventoryCartArrayList.size();
                }
            %>
            <button class="btn btn-outline-dark mr-sm-2" data-toggle="modal" data-target="#checkout_modal"><i class="fa fa-shopping-cart" aria-hidden="true"></i> <span id="cart_count"><%=cart_count%></span></button>
            <a class="btn btn-outline-danger my-2 my-sm-0" href="logout_controller">Logout</a>
        <% }%>
    </div>
  </div>
</nav>