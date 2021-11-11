<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <a class="navbar-brand" href="index.jsp"><img src="<%=request.getContextPath()%>/img/navbaricon.png" width="30" height="30"> Home</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
    <% if(session.getAttribute("is_login_user") != null){%>
      <li class="nav-item">
        <a class="nav-link" href="user_servlet">Explore</a>
      </li>
    <% }%>
    </ul>
    <div class="form-inline my-2 my-lg-0">
      <% if(session.getAttribute("user_session") != null){%>
        <a href="logout_servlet" class="btn btn-outline-danger">Logout</a>
      <% }else{%>  
        <button class="btn btn-outline-light my-2 my-sm-0" data-toggle="modal" data-target="#login_modal">Login</button>
      <% }%>
    </div>
  </div>
</nav>