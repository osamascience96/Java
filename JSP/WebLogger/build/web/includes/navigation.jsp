<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <h5 class="text-white">Weblog</h5>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
    </ul>
    <div class="form-inline my-2 my-lg-0">
        <%
            if(session.getAttribute("username") != null){
        %>
            <h6 class="mr-sm-2 text-white"><%=session.getAttribute("username")%></h6>
            <a class="btn btn-outline-danger my-2 my-sm-0" href="logout_servlet">Logout</a>
        <%}else{%>
            <button class="btn btn-outline-primary my-2 my-sm-0" onclick="$('#login_form').modal('show')">Login</button>
        <%}%>
    </div>
  </div>
</nav>