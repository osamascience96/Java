<%
    boolean login_generated_key = false;
    
    HttpSession httpSession = request.getSession();
    if(httpSession.getAttribute("login_generated_key") != null){
        login_generated_key = true;
    }
%>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <a class="navbar-brand" href="index.jsp">
      <img src="<%=request.getContextPath()%>/img/navicon.png" width="30" height="30" class="d-inline-block align-top">
      Home</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <%
            if(!login_generated_key){
        %>
            <a class="nav-link" href="register.jsp">Register <span class="sr-only">(current)</span></a>
        <%
            }
        %>
      </li>
    </ul>
    <%
        if(login_generated_key){
    %>
        <%
            if(httpSession.getAttribute("login_approved") == null){
        %>
            <div class="form-inline my-2 my-lg-0">
              <button class="btn btn-outline-light my-2 my-sm-0" data-toggle="modal" data-target="#loginModel">Login</button>
            </div>
        <% }else{%>
            <div class="form-inline my-2 my-lg-0">
                <a class="btn btn-outline-light my-2 my-sm-0" href="Logout">Logout</a>
            </div>
        <% }%>
    <%
        }
    %>
  </div>
</nav>