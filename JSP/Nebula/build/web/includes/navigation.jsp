<%@page import="Bean.User"%>
<%@page import="Helper.CartHelper"%>
<%@page import="Bean.Product"%>
<%@page import="java.util.ArrayList"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="index.jsp"><img src="<%=request.getContextPath()%>/img/icon.png" width="30" height="30"> Home</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="category_controller">Products</a>
      </li>
    </ul>
    <div class="form-inline my-2 my-lg-0">
        <%
            int cartCount = 0;
            User userObj = (User) session.getAttribute("user_session");
            if(userObj != null){
                ArrayList<Bean.Cart> cartArrayList = (ArrayList<Bean.Cart>) application.getAttribute("cart_list");
                if(cartArrayList != null){
                    int index = CartHelper.GetUserIdIndex(cartArrayList, userObj.getId());
                    if(index != -1){
                        ArrayList<Product> productList = cartArrayList.get(index).getArrayListProducts();
                        for(int i=0; i < productList.size(); i++){
                            cartCount += productList.get(i).getQuantity();
                        }
                    }
                }
            }
        %>
        <a href="checkout.jsp" class="btn btn-outline-success my-2 my-sm-0"><i class="fa fa-shopping-cart" aria-hidden="true"></i> <span id="cart_count"><%=cartCount%></span></a>  
      &nbsp;
      &nbsp;
      <%
          if(session.getAttribute("is_login") != null){
              boolean isLogin = (Boolean) session.getAttribute("is_login");
              if(isLogin){
      %>
                <a href="logout_servlet" class="btn btn-outline-danger my-2 my-sm-0">Logout</a>
        <% }%>
      <% }else{%>
        <button class="btn btn-outline-info my-2 my-sm-0" onclick="$('#login_modal').modal('show')">Login</button>
      <% }%>
    </div>
  </div>
</nav>