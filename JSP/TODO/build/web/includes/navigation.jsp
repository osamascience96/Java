<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <span class="navbar-brand" >
      <img src="<%=request.getContextPath()%>/img/todoapplogo.png" width="35" height="35" class="d-inline-block align-top" alt="">
    TODO App
  </span>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <ul class="navbar-nav mr-auto">
            <% if(session.getAttribute("login_credentials") == null){ %>
                <li class="nav-item active">
                    <a class="nav-link" href="register.jsp">Register <span class="sr-only">(current)</span></a>
                </li>
            <% }else if(session.getAttribute("login_credentials") != null){%>
                <li class="nav-item active">
                    <a class="nav-link" href="admin">TODO <span class="sr-only">(current)</span></a>
                </li>
            <% }
            
            if(session.getAttribute("admin_login") != null){%>
                <li class="nav-item active">
                    <a class="nav-link" href="user_servlet">Users <span class="sr-only">(current)</span></a>
                </li>
            <% }%>

        <% if(session.getAttribute("login_credentials") == null){ %>
            <li class="nav-item active">
                <a class="nav-link" href="index.jsp">Login <span class="sr-only">(current)</span></a>
            </li>
        <% }else{%>
            <li class="nav-item active">
                <a class="nav-link" href="logout">Logout <span class="sr-only">(current)</span></a>
            </li>
        <% }%>
      </ul>
    </form>
  </div>
</nav>